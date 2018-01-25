package com.livgo.cloud.common.util.security.sha1;

/**
 * 将String进行SHA1加密。
 * 
 * @author xuepeng
 */
public interface SHA1Util {

	/**
	 * 对输入的字符串进行SHA1加密。
	 * 
	 * @param 要加密的字符串。
	 * @return 加密后的字符串。
	 */
	String encode(String code);

}
