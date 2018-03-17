package com.lrs.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lrs.bean.dto.UserDto;
import com.lrs.service.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	private LoginService serivce;
	
	@RequestMapping(value="/checkLogin/{loginKey}" ,method=RequestMethod.GET)
	public boolean checkLogin(@PathVariable String loginKey){
		return serivce.checkLogin(loginKey);
	}
	
	@RequestMapping(value="/toLogin/{code}" ,method=RequestMethod.GET)
	public Map<String,Object> login(@PathVariable String code){
		return serivce.login(code);
	}
	
	@RequestMapping(value="/register/{loginKey}" ,method=RequestMethod.POST)
	public boolean register(@PathVariable String loginKey,@RequestBody UserDto user){
		return serivce.register(loginKey, user);
	}
}
