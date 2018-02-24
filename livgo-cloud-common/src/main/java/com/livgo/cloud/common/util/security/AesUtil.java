package com.livgo.cloud.common.util.security;

import com.livgo.cloud.common.util.valid.ValidUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.SecureRandom;
import java.security.Security;

/**
 * AES加密
 * Created by doit on 16-4-18.
 */
public final class AesUtil {
    private final static Logger logger = LoggerFactory.getLogger(AesUtil.class);

    public final static String ALGORITHM = "AES";
    public final static String ENC = "UTF-8";
    public final static String DEFAULT_KEY = "1qaz@WSX3edc$RFV";  //16位 正式环境

    @SuppressWarnings("restriction")
    public static Key getKey(String keyStr) throws Exception {
        Security.addProvider(new com.sun.crypto.provider.SunJCE());
        return getKey(ValidUtil.isEmpty(keyStr) ? DEFAULT_KEY.getBytes(ENC) : keyStr.getBytes(ENC));
    }

    /**
     * 从指定字符串生成密钥，密钥所需的字节数组长度为16位 不足16位时后面补0，超出16位只取前16位
     *
     * @param arrBTmp 构成该字符串的字节数组
     * @return 生成的密钥
     * @throws Exception
     */
    private static Key getKey(byte[] arrBTmp) throws Exception {
        // 创建一个空的16位字节数组（默认值为0）
        byte[] arrB = new byte[16];
        // 将原始字节数组转换为16位
        for (int i = 0; i < arrBTmp.length && i < arrB.length; i++) {
            arrB[i] = arrBTmp[i];
        }
        // 生成密钥

        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(128, new SecureRandom(arrB));

        SecretKeySpec key = new SecretKeySpec(arrB, "AES");
        return key;
    }

    /**
     * 根据密匙进行AES加密
     *
     * @param keyStr 密匙
     * @param str    要加密的信息
     * @return String 加密后的信息
     */
    public static String encrypt1(String keyStr, String str) throws Exception {
        // 定义要生成的密文
        byte[] cipherByte = null;
        Key key = getKey(keyStr);
        // 得到加密/解密器
        Cipher c1 = Cipher.getInstance("AES");
        // 用指定的密钥和模式初始化Cipher对象
        // 参数:(ENCRYPT_MODE, DECRYPT_MODE, WRAP_MODE,UNWRAP_MODE)
        c1.init(Cipher.ENCRYPT_MODE, key);
        // 对要加密的内容进行编码处理,
        cipherByte = c1.doFinal(str.getBytes(ENC));

        // 返回密文的十六进制形式
        return byte2hex(cipherByte);
    }

    /**
     * 根据密匙进行AES解密
     *
     * @param keyStr 密匙
     * @param enStr  要解密的密文
     * @return String 返回解密后信息
     */
    public static String decrypt1(String keyStr, String enStr) throws Exception {
        Key key = getKey(keyStr);
        byte[] cipherByte = null;
        // 得到加密/解密器
        Cipher c1 = Cipher.getInstance("AES");
        // 用指定的密钥和模式初始化Cipher对象
        c1.init(Cipher.DECRYPT_MODE, key);
        // 对要解密的内容进行编码处理
        cipherByte = c1.doFinal(hex2byte(enStr));

        return new String(cipherByte, ENC);
    }

    /**
     * 将二进制转化为16进制字符串
     *
     * @param b 二进制字节数组
     * @return String
     */
    public static String byte2hex(byte[] b) {

        if (null == b) {
            return null;
        }

        StringBuffer hs = new StringBuffer("");
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = (Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1) {
                hs.append("0").append(stmp);
            } else {
                hs.append(stmp);
            }
        }
        return hs.toString().toUpperCase();
    }

    /**
     * 十六进制字符串转化为2进制
     *
     * @param hex
     * @return
     */
    public static byte[] hex2byte(String hex) throws Exception {
        if (null == hex || hex.length() % 2 != 0) {
            System.out.println("[ERROR]DESUtil:string to hex is null or invalid length!");
            throw new Exception();
        }
        char[] arr = hex.toCharArray();
        byte[] b = new byte[hex.length() / 2];
        for (int i = 0, j = 0, l = hex.length(); i < l; i++, j++) {
            String swap = "" + arr[i++] + arr[i];
            int byteint = Integer.parseInt(swap, 16) & 0xFF;
            b[j] = new Integer(byteint).byteValue();
        }
        return b;
    }

    public static String encrypt(String key, String str) throws Exception {
        if (ValidUtil.isEmpty(str)) return null;
        if (ValidUtil.isEmpty(key)) key = DEFAULT_KEY;
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key.getBytes("utf-8"), "AES"));
        byte[] bytes = cipher.doFinal(str.getBytes("utf-8"));
        return new BASE64Encoder().encode(bytes);
    }

    public static String decrypt(String key, String str) throws Exception {
        if (ValidUtil.isEmpty(str)) return null;
        if (ValidUtil.isEmpty(key)) key = DEFAULT_KEY;
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key.getBytes("utf-8"), "AES"));
        byte[] bytes = new BASE64Decoder().decodeBuffer(str);
        bytes = cipher.doFinal(bytes);
        return new String(bytes, "utf-8");
    }

//    /*
//     * 示例
//     */
//    public static void main(String[] args) {
//        String srcString = "eerr3434";
//        try {
//            //加密
//            String encryptedString1 = encrypt(null, srcString);
//            System.out.println(encryptedString1);
//            String encryptedString2 = encrypt1(null, srcString);
//            System.out.println(encryptedString2);
//            String decryptedString1 = decrypt(null,encryptedString1);
//            System.out.println(decryptedString1);
//            //解密
////            String decryptedString = decrypt(null,"P7M6JIu0akLHOjEbC/QmAgsWG8oHqy2MI2FbjfDV4o0XvvjV4kr0nvDxoQOoF/PmfutOyLTqeVwCBbDL5enj1UGs6PyLwIUPS99VWf8nXdMYziw0fq2qpvN0ZZW3jn0tYqLIjb4w51N6C/1dSuatlk7FebKByzicHAv6rqzUcN9yDy9nITdgOXdfVmQaLSUrQ0sPPiX1eJEUYC7xuOK1ZrImg5AXizXuehTdYcYz8CeYHLY3KMgqlM1nI0SizLDBiQntMeOuAj2gG2OcChEdwhaBPKip66e2Fn1IKsX0xzdNyhbE2OfGHkq0bhBmgiuSVosxVjxh57ZY15s7L11jFIFom8ioTdNUYCKTTD8s6Jj1w8vEZPERKopCNdSDZvCAvUZsiFyoTXbn5lzKcdvzhgx0hFih2E2xkiw=");
////            System.out.println(decryptedString);
//        } catch (Exception e) {
//            LogUtil.error(logger, e);
//        }
//    }
}
