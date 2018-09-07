/** 
 * Project Name		:	wechat-admin-platform 
 * File Name		:	EncryptUtil.java 
 * Package Name		:	com.airusheng.tech.wechat.admin.platform.common.utils.encrypt
 * Date				:	2018年8月19日下午3:40:31 
 * Copyright (c) 2018, Office_Alex@163.com All Rights Reserved. 
 * 
 */
package com.airusheng.tech.wechat.admin.platform.common.utils.encrypt;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

/** 
 * ClassName		:	EncryptUtil <br/> 
 * Function			:	加密解密. <br/> 
 * Date				:	2018年8月19日 下午3:40:31 <br/> 
 * @author			:	Alex Hu 
 * @version			:	1.0
 * @since			:	JDK 1.8
 * @see
 */
public class EncryptUtil {
	/**
	 * 加密
	 * @param text 明文
	 * @return     密文
	 */
	public static String encrypt(String text, String key) {
		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
		encryptor.setPassword(key);
		return encryptor.encrypt(text);
	}

	/**
	 * 解密
	 * @param ciphertext 密文
	 * @return           明文
	 */
	public static String decrypt(String ciphertext, String key) {
		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
		encryptor.setPassword(key);
		return encryptor.decrypt(ciphertext);
	}
}
