package com.lrs.service;

import java.util.Map;

import com.lrs.bean.dto.UserDto;

public interface LoginService {
	
	/**
	 * ��¼��ͨ��΢��code��ȡ�û���Ϣ��
	 * ����û�δע�ᣬ�����ע�ᣬ
	 * �����û���Ϣ��⣬
	 * ��¼״̬����redis
	 * ���ص�¼����
	 * @param code
	 * @return
	 */
	Map<String,Object> login(String code);
	
	/**
	 * ͨ����¼������֤��¼״̬
	 * @param loginKey
	 * @return
	 */
	boolean checkLogin(String loginKey);
	
	/**
	 * ע��
	 * @param user
	 * @return
	 */
	boolean register(String loginKey, UserDto user);
}
