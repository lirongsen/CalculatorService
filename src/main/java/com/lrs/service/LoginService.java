package com.lrs.service;

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
	String login(String code);
	
	/**
	 * ͨ����¼������֤��¼״̬
	 * @param loginKey
	 * @return
	 */
	boolean check(String loginKey);
}