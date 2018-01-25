package com.livgo.cloud.common.util.security;

import com.livgo.cloud.common.util.log.LogUtil;
import com.livgo.cloud.common.util.prop.PropUtil;
import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by gaocl on 2017-9-18.
 */
public final class MD5Util {

    private final static Logger logger = LoggerFactory.getLogger(PropUtil.class);

    private static String SLAT = "123456789012";

    // MD5实例
    public static MessageDigest MD5 = null;

    static {
        try {
            MD5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            LogUtil.error(logger, e);
        }
    }

    public static String encodeSlat(String password) {
        return encode(password, SLAT);
    }

    /**
     * 生成含有随机盐的密码
     *
     * @param password 明文密码
     * @param salt     盐值
     * @return
     */
    public static String encode(String password, String salt) {

        password = md5Hex(password + salt);
        char[] cs = new char[48];
        for (int i = 0; i < 48; i += 3) {
            cs[i] = password.charAt(i / 3 * 2);
            char c = salt.charAt(i / 3);
            cs[i + 1] = c;
            cs[i + 2] = password.charAt(i / 3 * 2 + 1);
        }
        return new String(cs);
    }

    /**
     * 校验密码是否正确
     *
     * @param password 明文密码
     * @param md5      加密加盐后的密码
     * @return
     */
    public static boolean verify(String password, String md5) {
        char[] cs1 = new char[32];
        char[] cs2 = new char[16];
        for (int i = 0; i < 48; i += 3) {
            cs1[i / 3 * 2] = md5.charAt(i);
            cs1[i / 3 * 2 + 1] = md5.charAt(i + 2);
            cs2[i / 3] = md5.charAt(i + 1);
        }
        String salt = new String(cs2);
        return md5Hex(password + salt).equals(new String(cs1));
    }

    /**
     * 获取十六进制字符串形式的MD5摘要
     */
    public static String md5Hex(String src) {
        try {
            byte[] bs = MD5.digest(src.getBytes());
            new HexBin();
            return new String(HexBin.encode(bs));
        } catch (Exception e) {
            LogUtil.error(logger, e);
            return null;
        }
    }


    /**
     * Logger for this class
     */
    private final static Logger LOG = LoggerFactory.getLogger(MD5Util.class);

    private static char hexs[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a',
            'b', 'c', 'd', 'e', 'f'};

    public final static String getMD5(String s) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            byte[] strTemp = s.getBytes();
            MD5.update(strTemp);
            byte[] md = MD5.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            return null;
        }
    }

    public static String encode(String source) {
        try {

            byte[] sbs = source.getBytes("UTF8");
            MD5.update(sbs);
            byte[] rbs = MD5.digest();
            int j = rbs.length;
            char result[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte b = rbs[i];
                result[k++] = hexs[b >>> 4 & 0xf];
                result[k++] = hexs[b & 0xf];
            }
            return new String(result);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            return null;
        }
    }

    /**
     * UTN加密串
     *
     * @param uname
     * @param password
     * @return
     */
    public static String getUTNMd5(String uname, String password) {
        return getMD5("NODECODE=21; USERCODE=" + uname + "; PASSWORD=" + password + ";").toUpperCase();
    }


    public static void main(String args[]) {


    }
}
