package com.livgo.cloud.common.util.security.hex;

/**
 * 将String进行Hex加密。
 * 
 * @author xuepeng
 */
public interface HexUtil {

	/**
	 * 对输入的字符串进行Hex加密。
	 * 
	 * @param code 要加密的字符串。
	 * @return 加密后的字符串。
	 */
	String encode(String code);

	/**
	 * 对输入的字符串进行Hex解密。
	 * 
	 * @param code 要解密的字符串。
	 * @return 解密后的字符串。
	 */
	String decode(String code);

}
