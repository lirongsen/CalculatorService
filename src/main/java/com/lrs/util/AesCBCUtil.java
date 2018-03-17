package com.lrs.util;

import java.security.AlgorithmParameters;
import java.security.Key;
import java.security.Security;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.log4j.Logger;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class AesCBCUtil {
	private static Logger logger = Logger.getLogger(AesCBCUtil.class);
	static {
		Security.addProvider(new BouncyCastleProvider());
	}
	/**
	 * 解密微信用户信息
	 * @param encryptedData
	 * @param session_key
	 * @param iv
	 * @return
	 * @throws Exception
	 */
    public static String decryptEncryptedData(String encryptedData, String session_key, String iv) {
        try {
        	byte[] contentByte = Base64.getDecoder().decode(encryptedData);
    		byte[] keyByte = Base64.getDecoder().decode(session_key);
    		byte[] ivByte = Base64.getDecoder().decode(iv);
    		AlgorithmParameters params = AlgorithmParameters.getInstance("AES");      
            params.init(new IvParameterSpec(ivByte)); 
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");    
            Key sKeySpec = new SecretKeySpec(keyByte, "AES");    
            cipher.init(Cipher.DECRYPT_MODE, sKeySpec, params);// 初始化     
            byte[] result = cipher.doFinal(contentByte);    
            return  new String(result, "UTF-8");
        } catch (Exception ex) {
        	logger.error("解密微信用户信息失败",ex);
            return null;
        }
    }
}
