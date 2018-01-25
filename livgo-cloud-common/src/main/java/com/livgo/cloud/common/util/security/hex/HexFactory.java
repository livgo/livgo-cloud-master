package com.livgo.cloud.common.util.security.hex;

/**
 * Hex加密类工厂。
 * 
 * @author xuepeng
 */
public class HexFactory {

	// Hex工厂对象
	private volatile static HexFactory factory;

	// 将构造函数私有化
	private HexFactory() {
	}

	/**
	 * 获得一个HexFactory的单例对象。
	 * 
	 * @return HexApache对象。
	 */
	public static HexFactory getInstance() {
		// 采用锁进行双重判断，确保对象是单例的
		if (factory == null) {
			synchronized (HexFactory.class) {
				if (factory == null) {
					factory = new HexFactory();
				}
			}
		}
		return factory;
	}

	/**
	 * 创建Apache提供的的Hex加密对象。
	 * 
	 * @return Hex加密对象。
	 */
	public HexUtil getHex() {
		return getHex(HexType.APACHE);
	}

	/**
	 * 创建指定类型的Hex加密对象。
	 * 
	 * @param type Hex加密的算法提供商。
	 * @return Hex加密对象。
	 */
	public HexUtil getHex(HexType type) {
		HexUtil hex = null;
		switch (type) {
		case APACHE:
		default:
			hex = HexApache.getInstance();
			break;
		}
		if (hex == null) {
			throw new NullPointerException("没有与输入的类型相匹配的Hex加密类。");
		}
		return hex;
	}

}
