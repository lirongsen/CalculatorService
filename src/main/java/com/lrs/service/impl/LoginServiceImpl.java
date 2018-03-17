package com.lrs.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.lrs.bean.dto.UserDto;
import com.lrs.business.LoginBusiness;
import com.lrs.service.LoginService;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginBusiness loginBusiness;

	@Override
	public Map<String,Object> login(String code) {
		if(StringUtils.isEmpty(code)) {
			return null;
		}
		return loginBusiness.login(code);
	}

	@Override
	public boolean checkLogin(String loginKey) {
		if(StringUtils.isEmpty(loginKey)) {
			return false;
		}
		return loginBusiness.checkLogin(loginKey);
	}

	@Override
	public boolean register(String loginKey, UserDto user) {
		if(user==null) {
			return false;
		}
		return loginBusiness.register(loginKey, user);
	}
	

}
