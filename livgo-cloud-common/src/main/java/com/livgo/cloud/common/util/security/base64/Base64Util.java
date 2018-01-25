package com.livgo.cloud.common.util.security.base64;

/**
 * 将String进行base64加密解密。
 * 
 * @author xuepeng
 */
public interface Base64Util {

	/**
	 * 对输入的字符串进行Base64加密。
	 * 
	 * @param 要加密的字符串。
	 * @return 加密后的字符串。
	 */
	String encode(String code);

	/**
	 * 对输入的字符串进行Base64解密。
	 * 
	 * @param 要解密的字符串。
	 * @return 解密后的字符串。
	 */
	String decode(String code);

}
