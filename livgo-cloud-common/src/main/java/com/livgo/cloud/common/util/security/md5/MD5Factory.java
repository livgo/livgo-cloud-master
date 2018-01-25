package com.livgo.cloud.common.util.security.md5;

/**
 * MD5加密类工厂。
 * 
 * @author xuepeng
 */
public class MD5Factory {

	// MD5工厂对象
	private volatile static MD5Factory factory;

	// 将构造函数私有化
	private MD5Factory() {
	}

	/**
	 * 获得一个MD5Factory的单例对象。
	 * 
	 * @return MD5Factory对象。
	 */
	public static MD5Factory getInstance() {
		// 采用锁进行双重判断，确保对象是单例的
		if (factory == null) {
			synchronized (MD5Factory.class) {
				if (factory == null) {
					factory = new MD5Factory();
				}
			}
		}
		return factory;
	}

	/**
	 * 创建Apache提供的MD5加密对象。
	 * 
	 * @return MD5加密对象。
	 */
	public MD5Util getMD5() {
		return this.getMD5(MD5Type.APACHE);
	}

	/**
	 * 创建指定类型的MD5加密对象。
	 * 
	 * @param MD5加密的算法提供商。
	 * @return MD5加密对象。
	 */
	public MD5Util getMD5(MD5Type type) {
		MD5Util md5 = null;
		switch (type) {
		case APACHE:
		default:
			md5 = MD5Apache.getInstance();
			break;
		}
		if (md5 == null) {
			throw new NullPointerException("没有与输入的类型相匹配的MD5加密类。");
		}
		return md5;
	}

}
