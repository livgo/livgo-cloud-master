/**
 * Copyright (c) 2012, YongLe. All rights reserved.
 * Created on Jul 11, 2012 3:10:59 PM
 * <p>
 * <p>
 * 正则表达式工具
 *
 * @author "JakeLiu"
 * @version V1.0.0
 * <p>
 * <p>
 * <p>
 * Modification History:
 * Date				Author			Version		Description
 * ---------------------------------------------------------------------
 * Jul 11, 2012		"JakeLiu"		1.0.0		正则表达式工具
 */
package com.livgo.cloud.common.util.lang;


import com.livgo.cloud.common.util.valid.ValidUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则工具类
 */
public final class RegexUtil {


    /**
     * Alphanumeric characters
     */
    public final static String REG_ALNUM = "\\p{Alnum}";
    /**
     * Alphabetic characters
     */
    public final static String REG_ALPHA = "\\p{Alpha}";
    /**
     * ASCII characters
     */
    public final static String REG_ASCII = "\\p{ASCII}";
    /**
     * Space and tab
     */
    public final static String REG_BLANK = "\\p{Blank}";
    /**
     * Control characters
     */
    public final static String REG_CNTRL = "\\p{Cntrl}";
    /**
     * Digits
     */
    public final static String REG_DIGITS = "\\p{Digit}";
    /**
     * SVisible characters (i.e. anything except spaces, control characters, etc.)
     */
    public final static String REG_GRAPH = "\\p{Graph}";
    /**
     * Lowercase letters
     */
    public final static String REG_LOWER = "\\p{Lower}";
    /**
     * Visible characters and spaces (i.e. anything except control characters, etc.)
     */
    public final static String REG_PRINT = "\\p{Print}";
    /**
     * Punctuation and symbols.
     */
    public final static String REG_PUNCT = "\\p{Punct}";
    /**
     * All whitespace characters, including line breaks
     */
    public final static String REG_SPACE = "\\p{Space}";
    /**
     * Uppercase letters
     */
    public final static String REG_UPPER = "\\p{Upper}";
    /**
     * Hexadecimal digits
     */
    public final static String REG_XDIGIT = "\\p{XDigit}";
    /**
     * 空白行
     */
    public final static String REG_SPACE_LINE = "\\n\\s*\\r";
    /**
     * 首尾空白字符
     */
    public final static String REG_SPACE_POINT = "^\\s*|\\s*$";
    /**
     * HTML
     */
    public final static String REG_HTML = "<(\\S*?)[^>]*>.*?</\\1>|<.*? />";
    /**
     * Email
     */
    public final static String REG_EMAIL = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
    /**
     * 国内固定电话
     */
    public final static String REG_FIXED_TELEPHONE = "\\d{3}-\\d{8}|\\d{4}-\\d{7}";
    /**
     * 邮政编码
     */
    public final static String REG_POSTALCODE = "[1-9]\\d{5}(?!\\d)";
    /**
     * 身份证编码
     */
    public final static String REG_IDENTIFICATION_CARD = "\\d{15}|\\d{18}";
    /**
     * URL地址
     */
    public final static String REG_URL = "^http://([w-]+.)+[w-]+(/[w-./?%&=]*)?$";
    /**
     * 移动电话
     */
    public final static String REG_MOBILE_TELEPHONE = "^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$";
    /**
     * 合法的名字（字母开头，允许5-16字节，允许字母数字下划线）
     */
    public final static String REG_LEGAL_ACCOUNT = "^[a-zA-Z][a-zA-Z0-9_]{4,15}$";
    /**
     * i地址
     */
    public final static String REG_IP = "((2[0-4]\\d|25[0-5]|[01]?\\d\\d?)\\.){3}(2[0-4]\\d|25[0-5]|[01]?\\d\\d?)";
    private static Pattern numericPattern = Pattern.compile("^[0-9\\-]+$");
    private static Pattern numericStringPattern = Pattern.compile("^[0-9\\-\\-]+$");
    private static Pattern floatNumericPattern = Pattern.compile("^[0-9\\-\\.]+$");
    private static Pattern abcPattern = Pattern.compile("^[a-z|A-Z]+$");


    /**
     * 编译传入正则表达式和字符串去匹配
     *
     * @param regex
     * @param str
     * @return
     */
    public static boolean match(String regex, String str) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }


    /**
     * 用指定表达式格式化字符串
     *
     * @param str   要格式化的字符串
     * @param regex 替换表达式
     * @param args  要填充的参数
     * @return
     */
    public static String matchReplace(String str, String regex, Object... args) {
        if (null == args || ValidUtil.isEmpty(args.toString()) || ValidUtil.isEmpty(str) || args.length <= 0) {
            return str;
        }
        for (Object s : args) {
            if (null != s) {
                str = str.replaceFirst(regex, s.toString());
            }
        }
        return str;
    }

    /**
     * 判断是否数字表示
     *
     * @param src 源字符串
     * @return 是否数字的标志
     */
    public final static boolean isNumeric(String src) {
        boolean return_value = false;
        if (src != null && src.length() > 0) {
            Matcher m = numericPattern.matcher(src);
            if (m.find()) {
                return_value = true;
            }
        }
        return return_value;
    }

    /**
     * 判断是否纯字母组合
     *
     * @param src 源字符串
     * @return 是否纯字母组合的标志
     */
    public final static boolean isABC(String src) {
        boolean return_value = false;
        if (src != null && src.length() > 0) {
            Matcher m = abcPattern.matcher(src);
            if (m.find()) {
                return_value = true;
            }
        }
        return return_value;
    }


    /**
     * 判断是否浮点数字表示
     *
     * @param src 源字符串
     * @return 是否数字的标志
     */
    public final static boolean isFloatNumeric(String src) {
        boolean return_value = false;
        if (src != null && src.length() > 0) {
            Matcher m = floatNumericPattern.matcher(src);
            if (m.find()) {
                return_value = true;
            }
        }
        return return_value;
    }

    /**
     * 判断字符串str是否符合正则表达式reg
     *
     * @param str 需要处理的字符串
     * @param reg 正则
     * @return 是否匹配
     */
    public final static boolean isMatche(String str, String reg) {
        Pattern pattern = Pattern.compile(reg);
        Matcher isNum = pattern.matcher(str);
        return isNum.matches();
    }

    /**
     * 获取符合reg正则表达式的字符串在String中出现的次数
     *
     * @param str 需要处理的字符串
     * @param reg 正则
     * @return 出现的次数
     */
    public final static int countSubStrReg(String str, String reg) {
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(str);
        int i = 0;
        while (m.find()) {
            i++;
        }
        return i;
    }


    /**
     * 判断是否是符合邮箱
     *
     * @param email 判断的字符串
     * @return 是否是符合的邮箱
     */
    public final static boolean isEmail(String email) {
        if (email == null || email.length() < 1 || email.length() > 256) {
            return false;
        }
        Pattern pattern = Pattern.compile(REG_EMAIL);
        return pattern.matcher(email).matches();
    }
}
