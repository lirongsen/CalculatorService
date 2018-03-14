package com.lrs.business;

import java.util.Map;

import com.lrs.bean.dto.UserDto;

public interface LoginBusiness {

	/**
	 * 登录，通过微信code获取用户信息，
	 * 如果用户未注册，则进行注册，
	 * 并把用户信息入库，
	 * 登录状态存入redis
	 * 返回登录令牌
	 * @param code
	 * @return
	 */
	Map<String,Object> login(String code);
	
	/**
	 * 通过登录令牌验证登录状态
	 * @param loginKey
	 * @return
	 */
	boolean checkLogin(String loginKey);
	
	boolean register(UserDto user);
	
}
