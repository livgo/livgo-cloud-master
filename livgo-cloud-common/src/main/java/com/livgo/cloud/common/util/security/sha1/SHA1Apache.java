package com.livgo.cloud.common.util.security.sha1;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 基于Apache的SHA1加密。
 * 
 * @author xuepeng
 */
class SHA1Apache implements SHA1Util {

	// 基于Apache的SHA1加密对象
	private volatile static SHA1Apache sha1;

	// 将构造函数私有化
	private SHA1Apache() {
	}

	/**
	 * 获得一个SHA1Apache的单例对象。
	 * 
	 * @return SHA1Apache对象。
	 */
	public static SHA1Apache getInstance() {
		// 采用锁进行双重判断，确保对象是单例的
		if (sha1 == null) {
			synchronized (SHA1Apache.class) {
				if (sha1 == null) {
					sha1 = new SHA1Apache();
				}
			}
		}
		return sha1;
	}

	/**
	 * 对输入的字符串进行SHA1加密。
	 * 
	 * @param 要加密的字符串。
	 * @return 加密后的字符串。
	 */
	@Override
	public String encode(String code) {
		if (code == null) {
			throw new NullPointerException("要加密的字符串不能为null。");
		}
		return DigestUtils.sha1Hex(code);
	}

}
