package com.lrs.bean.dto;

import java.io.Serializable;

import com.lrs.bean.po.User;

public class UserDto implements Serializable{

	private static final long serialVersionUID = 7438324352334180409L;
	
	private User userInfo;
	
	/**
	 * ������������Ϣ��ԭʼ�����ַ��������ڼ���ǩ��
	 */
	private String rawData;
	
	/**
	 * ʹ�� sha1( rawData + sessionkey ) �õ��ַ���������У���û���Ϣ
	 */
	private String signature;
	
	/**
	 * ���������������ڵ������û���Ϣ�ļ�������
	 */
	private String encryptedData;
	
	/**
	 * �����㷨�ĳ�ʼ����
	 */
	private String iv;

	public User getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(User userInfo) {
		this.userInfo = userInfo;
	}

	public String getRawData() {
		return rawData;
	}

	public void setRawData(String rawData) {
		this.rawData = rawData;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getEncryptedData() {
		return encryptedData;
	}

	public void setEncryptedData(String encryptedData) {
		this.encryptedData = encryptedData;
	}

	public String getIv() {
		return iv;
	}

	public void setIv(String iv) {
		this.iv = iv;
	}

}
