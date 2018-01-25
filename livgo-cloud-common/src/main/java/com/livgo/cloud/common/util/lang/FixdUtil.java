package com.livgo.cloud.common.util.lang;

/**
 * Description: Fix补位工具类
 * Author:     gaocl
 * Date:       2017/12/22
 * Version:    V1.0.0
 * Update:     更新说明
 */
public final class FixdUtil {

    private final static char FIXD_CHAR = '0';

    /**
     * 补零
     *
     * @param length
     * @return
     */
    public static String appendZero(int length) {
        return appendZero(length, FIXD_CHAR);
    }

    /**
     * 生成一个定长的纯0字符串
     *
     * @param length 字符串长度
     * @return 纯0字符串
     */
    public static String appendZero(int length, char ch) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            sb.append(ch);
        }
        return sb.toString();
    }

    /**
     * 根据数字生成一个定长的字符串，长度不够前面补0
     *
     * @param str       字符
     * @param fixdlenth 所需长度
     * @return 定长的字符串
     */
    public static String toFixdLengthString(String str, int fixdlenth) {
        StringBuffer sb = new StringBuffer();
        if (fixdlenth - str.length() >= 0) {
            sb.append(appendZero(fixdlenth - str.length()));
        }
        sb.append(str);
        return sb.toString();
    }

    /**
     * 根据数字生成一个定长的字符串，长度不够前面补ch
     *
     * @param str       字符
     * @param fixdlenth 所需长度
     * @param ch        补位字符
     * @return 定长的字符串
     */
    public static String toFixdLengthString(String str, int fixdlenth, char ch) {
        StringBuffer sb = new StringBuffer();
        if (fixdlenth - str.length() >= 0) {
            sb.append(appendZero(fixdlenth - str.length(), ch));
        }
        sb.append(str);
        return sb.toString();
    }

    /**
     * 根据数字生成一个定长的字符串，长度不够前面补0
     *
     * @param num       数字
     * @param fixdlenth 所需长度
     * @return 定长的字符串
     */
    public static String toFixdLengthString(long num, int fixdlenth) {
        StringBuffer sb = new StringBuffer();
        String strNum = String.valueOf(num);
        if (fixdlenth - strNum.length() >= 0) {
            sb.append(appendZero(fixdlenth - strNum.length()));
        }
        sb.append(strNum);
        return sb.toString();
    }

    /**
     * 根据数字生成一个定长的字符串，长度不够前面补ch
     *
     * @param num       数字
     * @param fixdlenth 所需长度
     * @param ch        补位字符
     * @return 定长的字符串
     */
    public static String toFixdLengthString(long num, int fixdlenth, char ch) {
        StringBuffer sb = new StringBuffer();
        String strNum = String.valueOf(num);
        if (fixdlenth - strNum.length() >= 0) {
            sb.append(appendZero(fixdlenth - strNum.length(), ch));
        }
        sb.append(strNum);
        return sb.toString();
    }


    /**
     * 根据数字生成一个定长的字符串，长度不够前面补0
     *
     * @param num       数字
     * @param fixdlenth 字符串长度
     * @return 定长的字符串
     */
    public static String toFixdLengthString(int num, int fixdlenth) {
        return toFixdLengthString((long) num, fixdlenth);
    }

    /**
     * 根据数字生成一个定长的字符串，长度不够前面补ch
     *
     * @param num       数字
     * @param fixdlenth 字符串长度
     * @param ch        补位字符
     * @return 定长的字符串
     */
    public static String toFixdLengthString(int num, int fixdlenth, char ch) {
        return toFixdLengthString((long) num, fixdlenth, ch);
    }


}
