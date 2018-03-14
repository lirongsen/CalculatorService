package com.lrs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.lrs.bean.po.Test;
import com.lrs.business.LoginBusiness;
import com.lrs.service.LoginService;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginBusiness loginBusiness;

	@Override
	public String login(String code) {
		if(StringUtils.isEmpty(code)) {
			return null;
		}
		return loginBusiness.login(code);
	}

	@Override
	public boolean check(String loginKey) {
		if(StringUtils.isEmpty(loginKey)) {
			return false;
		}
		return loginBusiness.check(loginKey);
	}
	

}
