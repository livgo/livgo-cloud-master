package com.livgo.cloud.common.util.security.base64;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * 基于JDK的Base64加密。
 * 
 * @author xuepeng
 */
class Base64Jdk implements Base64Util {

	// 基于Apache的Base64加密对象
	private volatile static Base64Jdk base64JDK;
	// 采用UTF-8编码
	private final static String UTF_8 = "UTF-8";

	// 将构造函数私有化
	private Base64Jdk() {
	}

	/**
	 * 获得一个Base64JDK的单例对象。
	 * 
	 * @return Base64JDK对象。
	 */
	public static Base64Jdk getInstance() {
		// 采用锁进行双重判断，确保对象是单例的
		if (base64JDK == null) {
			synchronized (Base64Jdk.class) {
				if (base64JDK == null) {
					base64JDK = new Base64Jdk();
				}
			}
		}
		return base64JDK;
	}

	/**
	 * 对输入的字符串进行Base64加密。
	 * 
	 * @param 要加密的字符串。
	 * @return 加密后的字符串。
	 */
	@Override
	public String encode(String code) {
		if (code == null) {
			throw new NullPointerException("要加密的字符串不能为null。");
		}
		try {
			return Base64.getEncoder().encodeToString(code.getBytes(UTF_8));
		} catch (UnsupportedEncodingException e) {
			throw new IllegalArgumentException("byte转码时发生了异常。");
		}
	}

	/**
	 * 对输入的字符串进行Base64解密。
	 * 
	 * @param 要解密的字符串。
	 * @return 解密后的字符串。
	 */
	@Override
	public String decode(String code) {
		if (code == null) {
			throw new NullPointerException("要加密的字符串不能为null。");
		}
		try {
			byte[] result = Base64.getDecoder().decode(code.getBytes(UTF_8));
			return new String(result, UTF_8);
		} catch (UnsupportedEncodingException e) {
			throw new IllegalArgumentException("byte转码时发生了异常。");
		}
	}

}
