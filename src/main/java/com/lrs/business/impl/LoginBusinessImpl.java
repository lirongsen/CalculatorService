package com.lrs.business.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.lrs.bean.dto.UserDto;
import com.lrs.bean.po.User;
import com.lrs.business.LoginBusiness;
import com.lrs.dao.UserMapper;
import com.lrs.util.AesCBCUtil;

@Repository
public class LoginBusinessImpl implements LoginBusiness {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private RedisTemplate<String,String> redisTemplate;
	
	@Autowired
	private UserMapper userMapper;
	
	@Value("${appID}")
	private String appID;
	
	@Value("${appSecret}")
	private String appSecret;
	
	@Value("${wx.voucherCheck.url}")
	private String wxVoucherCheckUrl;

	@Override
	public Map<String,Object> login(String code) {
		Map<String,Object> resultMap = new HashMap<>();
		//去微信获取用户id
		Map<String,String> uriVariables = new HashMap<>();
		uriVariables.put("appid", appID);
		uriVariables.put("secret", appSecret);
		uriVariables.put("js_code", code);
		ResponseEntity<String> result = restTemplate.getForEntity(wxVoucherCheckUrl, String.class, uriVariables);
		String body = result.getBody();
		@SuppressWarnings("unchecked")
		Map<String,String> map= JSON.parseObject(body, Map.class);
		String openId = map.get("openid");
		String sessionKey = map.get("session_key");
		if(StringUtils.isEmpty(openId)) {
			return resultMap;
		}
		
		//将微信用户id转换成本系统登录令牌存缓存
		String loginKey = UUID.randomUUID().toString().replace("-", "").toLowerCase();
		redisTemplate.opsForValue().set(loginKey, openId);
		redisTemplate.opsForValue().set("sessionKey-"+loginKey, sessionKey,10, TimeUnit.MINUTES);
		
		//查看用户是否注册
		User user = userMapper.selectByPrimaryKey(openId);
		boolean noRegistered = false;
		if(user==null) {
			noRegistered = true;
		}
		resultMap.put("loginKey", loginKey);
		resultMap.put("noRegistered", noRegistered);
		return resultMap;
	}

	@Override
	public boolean checkLogin(String loginKey) {
		String openId = redisTemplate.opsForValue().get(loginKey);
		if(StringUtils.isEmpty(openId)) {
			return false;
		}
		User user = userMapper.selectByPrimaryKey(openId);
		if(user==null) {
			return false;
		}
		return true;
	}

	@Override
	public boolean register(String loginKey, UserDto user) {
		String sessionKey = redisTemplate.opsForValue().get("sessionKey-"+loginKey);
		String jsonStr = AesCBCUtil.decryptEncryptedData(user.getEncryptedData(), sessionKey, user.getIv());
		if(StringUtils.isEmpty(jsonStr)) {
			return false;
		}
		User userPo = JSON.parseObject(jsonStr, User.class);
		userMapper.insert(userPo);
		return true;
	}
	
}
