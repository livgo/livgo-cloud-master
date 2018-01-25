package com.livgo.cloud.common.util.security.base64;

import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;

/**
 * 基于Apache的Base64加密。
 *
 * @author xuepeng
 */
class Base64Apache implements Base64Util {

    // 基于Apache的Base64加密对象
    private volatile static Base64Apache apacheBase64;
    // 采用UTF-8编码
    private final static String UTF_8 = "UTF-8";

    // 将构造函数私有化
    private Base64Apache() {
    }

    /**
     * 获得一个Base64Apache的单例对象。
     *
     * @return Base64Apache对象。
     */
    public static Base64Apache getInstance() {
        // 采用锁进行双重判断，确保对象是单例的
        if (apacheBase64 == null) {
            synchronized (Base64Apache.class) {
                if (apacheBase64 == null) {
                    apacheBase64 = new Base64Apache();
                }
            }
        }
        return apacheBase64;
    }

    /**
     * 对输入的字符串进行Base64加密。
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
            return new String(Base64.encodeBase64(code.getBytes(UTF_8)), UTF_8);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException("byte转码时发生了异常。");
        }
    }

    /**
     * 对输入的字符串进行Base64解密。
     *
     * @param code 要解密的字符串。
     * @return 解密后的字符串。
     */
    @Override
    public String decode(String code) {
        if (code == null) {
            throw new NullPointerException("要解密的字符串不能为null。");
        }
        try {
            return new String(Base64.decodeBase64(code.getBytes(UTF_8)), UTF_8);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException("byte转码时发生了异常。");
        }
    }

}
