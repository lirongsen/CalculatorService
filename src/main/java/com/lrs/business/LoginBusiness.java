package com.lrs.business;

public interface LoginBusiness {

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
