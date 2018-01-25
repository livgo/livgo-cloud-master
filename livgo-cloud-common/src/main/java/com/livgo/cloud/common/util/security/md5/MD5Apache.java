package com.livgo.cloud.common.util.security.md5;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 基于Apache的MD5加密。
 * 
 * @author xuepeng
 */
class MD5Apache implements MD5Util {

	// 基于Apache的MD5加密对象
	private volatile static MD5Apache md5;

	// 将构造函数私有化
	private MD5Apache() {
	}

	/**
	 * 获得一个MD5Apache的单例对象。
	 * 
	 * @return MD5Apache对象。
	 */
	public static MD5Apache getInstance() {
		// 采用锁进行双重判断，确保对象是单例的
		if (md5 == null) {
			synchronized (MD5Apache.class) {
				if (md5 == null) {
					md5 = new MD5Apache();
				}
			}
		}
		return md5;
	}

	/**
	 * 对输入的字符串进行MD5加密。
	 * 
	 * @param 要加密的字符串。
	 * @return 加密后的字符串。
	 */
	@Override
	public String encode(String code) {
		if (code == null) {
			throw new NullPointerException("要加密的字符串不能为null。");
		}
		return DigestUtils.md5Hex(code);
	}

}
