package com.lrs.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.lrs.business.LoginBusiness;
import com.lrs.util.RedisUtil;

@Repository
public class LoginBusinessImpl implements LoginBusiness {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private RedisUtil redisUtil;

	@Override
	public String login(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean check(String loginKey) {
		redisUtil.get(loginKey, String.class);
		return false;
	}
	
}
