package com.livgo.cloud.common.util.security.sha1;

/**
 * SHA1加密类工厂。
 * 
 * @author xuepeng
 */
public class SHA1Factory {

	// SHA1工厂对象
	private volatile static SHA1Factory factory;

	// 将构造函数私有化
	private SHA1Factory() {
	}

	/**
	 * 获得一个SHA1Factory的单例对象。
	 * 
	 * @return SHA1Factory对象。
	 */
	public static SHA1Factory getInstance() {
		// 采用锁进行双重判断，确保对象是单例的
		if (factory == null) {
			synchronized (SHA1Factory.class) {
				if (factory == null) {
					factory = new SHA1Factory();
				}
			}
		}
		return factory;
	}

	/**
	 * 创建Apache提供的SHA1加密对象。
	 * 
	 * @return SHA1加密对象。
	 */
	public SHA1Util getSHA1() {
		return this.getSHA1(SHA1Type.APACHE);
	}

	/**
	 * 创建指定类型的SHA1加密对象。
	 * 
	 * @param SHA1加密的算法提供商。
	 * @return SHA1加密对象。
	 */
	public SHA1Util getSHA1(SHA1Type type) {
		SHA1Util sha1 = null;
		switch (type) {
		case APACHE:
		default:
			sha1 = SHA1Apache.getInstance();
			break;
		}
		if (sha1 == null) {
			throw new NullPointerException("没有与输入的类型相匹配的SHA1加密类。");
		}
		return sha1;
	}

}
