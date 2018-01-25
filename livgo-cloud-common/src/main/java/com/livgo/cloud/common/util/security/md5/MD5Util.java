package com.livgo.cloud.common.util.security.md5;

/**
 * 将String进行MD5加密。
 * 
 * @author xuepeng
 */
public interface MD5Util {

	/**
	 * 对输入的字符串进行MD5加密。
	 * 
	 * @param 要加密的字符串。
	 * @return 加密后的字符串。
	 */
	String encode(String code);

}
