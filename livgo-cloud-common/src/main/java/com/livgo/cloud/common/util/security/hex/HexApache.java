package com.livgo.cloud.common.util.security.hex;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

import java.io.UnsupportedEncodingException;

/**
 * 基于Apache的Hex加密。
 * 
 * @author xuepeng
 */
class HexApache implements HexUtil {

	// 基于Apache的Hex加密对象
	private volatile static HexApache hexApache;
	// 采用UTF-8编码
	private final static String UTF_8 = "UTF-8";

	/**
	 * 获得一个HexApache的单例对象。
	 * 
	 * @return HexApache对象。
	 */
	public static HexApache getInstance() {
		// 采用锁进行双重判断，确保对象是单例的
		if (hexApache == null) {
			synchronized (HexApache.class) {
				if (hexApache == null) {
					hexApache = new HexApache();
				}
			}
		}
		return hexApache;
	}

	/**
	 * 对输入的字符串进行Hex加密。
	 * 
	 * @param code 要加密的字符串。
	 * @return 加密后的字符串。
	 */
	@Override
	public String encode(String code) {
		if (code == null) {
			throw new NullPointerException("要加密的字符串不能为null。");
		}
		try {
			return Hex.encodeHexString(code.getBytes(UTF_8));
		} catch (UnsupportedEncodingException e) {
			throw new IllegalArgumentException("byte转码时发生了异常。");
		}
	}

	/**
	 * 对输入的字符串进行Hex解密。
	 * 
	 * @param code 要解密的字符串。
	 * @return 解密后的字符串。
	 */
	@Override
	public String decode(String code) {
		if (code == null) {
			throw new NullPointerException("要解密的字符串不能为null。");
		}
		byte[] context = null;
		try {
			context = Hex.decodeHex(code.toCharArray());
		} catch (DecoderException e) {
			throw new IllegalArgumentException("解码失败，密文为：" + code);
		}
		String result = null;
		try {
			result = new String(context, UTF_8);
		} catch (UnsupportedEncodingException e) {
			throw new IllegalArgumentException("byte转码时发生了异常。");
		}
		return result;
	}

}
