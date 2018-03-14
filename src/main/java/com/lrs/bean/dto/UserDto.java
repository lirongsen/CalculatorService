package com.lrs.bean.dto;

import java.io.Serializable;

import com.lrs.bean.po.User;

public class UserDto implements Serializable{

	private static final long serialVersionUID = 7438324352334180409L;
	
	private User userInfo;
	
	/**
	 * 不包括敏感信息的原始数据字符串，用于计算签名
	 */
	private String rawData;
	
	/**
	 * 使用 sha1( rawData + sessionkey ) 得到字符串，用于校验用户信息
	 */
	private String signature;
	
	/**
	 * 包括敏感数据在内的完整用户信息的加密数据
	 */
	private String encryptedData;
	
	/**
	 * 加密算法的初始向量
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
