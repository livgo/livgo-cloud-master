package com.livgo.cloud.common.util.valid;

import com.livgo.cloud.common.util.lang.RegexUtil;
import com.livgo.cloud.common.util.log.LogUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.Collection;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Description:验证工具类
 * Author:     gaocl
 * Date:       2017/12/21
 * Version:    V1.0.0
 * Update:     更新说明
 */
public final class ValidUtil {
    private final static Logger logger = LoggerFactory.getLogger(ValidUtil.class);


    /**
     * 比较2个数值是否相等
     *
     * @param n1
     * @param n2
     * @return
     */
    public static boolean isEquals(Integer n1, Integer n2) {
        if (isEmpty(n1) || !n1.equals(n2)) {
            return false;
        }
        return true;
    }

    /**
     * 比较2个数值是否相等
     *
     * @param n1
     * @param n2
     * @return
     */
    public static boolean isEquals(Float n1, Float n2) {
        if (isEmpty(n1) || !n1.equals(n2)) {
            return false;
        }
        return true;
    }

    /**
     * 比较2个数值是否相等
     *
     * @param n1
     * @param n2
     * @return
     */
    public static boolean isEquals(Double n1, Double n2) {
        if (isEmpty(n1) || !n1.equals(n2)) {
            return false;
        }
        return true;
    }

    /**
     * 比较2个数值是否相等
     *
     * @param n1
     * @param n2
     * @return
     */
    public static boolean isEquals(Long n1, Long n2) {
        if (isEmpty(n1) || !n1.equals(n2)) {
            return false;
        }
        return true;
    }

    /**
     * 比较2个字符是否相等
     *
     * @param str1
     * @param str2
     * @return
     */
    public static boolean isEquals(String str1, String str2) {
        if (isEmpty(str1) || !str1.equals(str2)) {
            return false;
        }
        return true;
    }

    /**
     * 比较2个字符是否不相等
     *
     * @param str1
     * @param str2
     * @return
     */
    public static boolean isNotEquals(String str1, String str2) {
        return !isEquals(str1, str2);
    }

    /**
     * 比较2个数值是否不相等
     *
     * @param n1
     * @param n2
     * @return
     */
    public static boolean isNotEquals(Integer n1, Integer n2) {
        return !isEquals(n1, n2);
    }

    /**
     * 比较2个数值是否不相等
     *
     * @param n1
     * @param n2
     * @return
     */
    public static boolean isNotEquals(Float n1, Float n2) {
        return !isEquals(n1, n2);
    }

    /**
     * 比较2个数值是否不相等
     *
     * @param n1
     * @param n2
     * @return
     */
    public static boolean isNotEquals(Double n1, Double n2) {
        return !isEquals(n1, n2);
    }

    /**
     * 比较2个数值是否不相等
     *
     * @param n1
     * @param n2
     * @return
     */
    public static boolean isNotEquals(Long n1, Long n2) {
        return !isEquals(n1, n2);
    }

    /**
     * 是否为空
     *
     * @param obj
     * @return
     */
    public static boolean isEmpty(Object obj) {
        if (null == obj) {
            return true;
        } else {
            return false;
        }
    }

    public static <T> boolean isEmpty(Object... objs) {
        for (Object obj : objs) {
            if (isNotEmpty(obj)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 是否不为空
     *
     * @param obj
     * @return
     */
    public static boolean isNotEmpty(Object obj) {
        return !isEmpty(obj);
    }

    public static boolean isNotEmpty(Object... objs) {
        for (Object obj : objs) {
            if (isEmpty(obj)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 是否为空
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        if (str == null || "".equals(str.trim())) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isEmpty(String... strs) {
        for (String str : strs) {
            if (isNotEmpty(str)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 是否不为空
     *
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static boolean isNotEmpty(String... strs) {
        for (String str : strs) {
            if (isEmpty(str)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 是否为空
     *
     * @param coll
     * @return
     */
    public static boolean isEmpty(Collection<?> coll) {
        return coll == null || coll.size() <= 0;
    }

    public static boolean isEmpty(Collection<?>... colls) {
        for (Collection<?> coll : colls) {
            if (isNotEmpty(coll)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 是否不为空
     *
     * @param coll
     * @return
     */
    public static boolean isNotEmpty(Collection<?> coll) {
        return !isEmpty(coll);
    }

    public static boolean isNotEmpty(Collection<?>... colls) {
        for (Collection<?> coll : colls) {
            if (isEmpty(coll)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 是否为空
     *
     * @param map
     * @return
     */
    public static boolean isEmpty(Map<?, ?> map) {
        return map == null || map.size() <= 0;
    }

    public static boolean isEmpty(Map<?, ?>... maps) {
        for (Map<?, ?> map : maps) {
            if (isNotEmpty(map)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 是否不为空
     *
     * @param map
     * @return
     */
    public static boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }

    public static boolean isNotEmpty(Map<?, ?>... maps) {
        for (Map<?, ?> map : maps) {
            if (isEmpty(map)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 身份证校验
     *
     * @param str
     * @return
     */
    public static boolean isIdCard(String str) {
        str = str == null ? "" : str.trim();
        String result = null;
        try {
            result = new IDCard().IDCardValidate(str);
        } catch (ParseException e) {
            LogUtil.error(logger, e);
        }
        return "".equals(result) ? true : false;
    }

    /**
     * 用户名是否正确
     *
     * @param uname
     * @return
     */
    public static boolean isRightUname(String uname) {
        if (isEmpty(uname)) {
            return false;
        }
        String regExp = "^(?=.*[0-9])(?=.*[a-zA-Z]).{6,20}$"; //字母+数字6-20位
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(uname.trim());
        return m.matches();
    }


    /**
     * 密码验证
     *
     * @param pwd
     * @return
     */
    public static boolean isRightPwd(String pwd) {
        if (isEmpty(pwd)) {
            return false;
        }
        // 类似 aB34567!
        //要求密码长度6-18位，1个数字，1个大写字母和一些小写字母, 包含至少1个特殊字符，
//        String regExp ="(?=^.{6,11}$)(?=(?:.*?\\d){1})(?=.*[a-z])(?=(?:.*?[A-Z]){1})(?=(?:.*?[!@#$%*()_+^&}{:;?.]){1})(?!.*\\s)[0-9a-zA-Z!@#$%*()_+^&]*$"; //字母+数字+特殊字符
//        String regExp ="^(?!(?:[^a-zA-Z]+|\\D|[a-zA-Z0-9])$).{6,11}$"; //字母+数字
        String regExp = "^(?=.*[0-9])(?=.*[a-zA-Z]).{6,20}$"; //字母+数字,要求密码长度6-20位
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(pwd.trim());
        return m.matches();
    }

    /**
     * 密码是否健壮
     * 必选包含数字、大写字母、小写字母、特殊字符，长度在6到20位
     *
     * @param password
     * @return
     */
    public final static boolean isSecurityPwd(String password) {
        String regExp = "^(?=.*?[0-9])(?=.*?[a-z])(?=.*?[A-Z])(?=.*?[@!#$%^&*()_+\\.\\-\\?<>'\"|=]+).{6,20}$";
        return RegexUtil.isMatche(password, regExp);
    }

    /**
     * 手机号验证
     *
     * @param mobile 移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188
     *               联通：130、131、132、152、155、156、185、186 电信：133、153、180、189、（1349卫通）
     * @return
     */
    public static boolean isMobile(String mobile) {
        boolean flag = false;
        try {
            // String regExp = "^((177)|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
            // String regExp = "/^1[3|4|5|6|7|8][0-9]\\d{8}$/";//16是声讯号
            String regExp = "^1[3|4|5|7|8][0-9]\\d{8}$";// 147
            Pattern p = Pattern.compile(regExp);
            mobile = mobile.replaceAll(" ", "");
            Matcher m = p.matcher(mobile.trim());
            return m.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    /**
     * 验证邮箱地址是否正确
     *
     * @param email
     * @return
     */
    public static boolean isEmail(String email) {
        boolean flag = false;
        try {
            String check = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(email);
            flag = matcher.matches();
        } catch (Exception e) {
            flag = false;
        }

        return flag;
    }


    /**
     * 是否有特殊字符
     *
     * @param str
     * @return
     */
    public static boolean isIllegalSymbol(String str) {
        String regEx = "[`~!@#$%^&*()+=|{}':;',//[//].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        if (m.find())
            return true;
        return false;
    }

    /**
     * 是否为指定来源
     *
     * @param referer 真实来源, header里取出即可
     * @param domains 允许来源,ip+port/域名，例如10.10.10.10:8080/www.xxx.com
     * @return
     */
    public static boolean isReferer(String referer, String domains) {
        if (ValidUtil.isNotEmpty(referer) || ValidUtil.isNotEmpty(domains)) {
            return false;
        }
        referer = referer.substring(referer.indexOf("/") + 2);
        referer = referer.substring(0, referer.indexOf("/"));
        if (referer.contains("localhost") || referer.contains("127.0.0.1")) {
            referer = "localhost";
        }
        if (domains.contains(referer)) {
            return true;
        }
        return false;
    }

    /**
     * 判断某值是否在指定值中间
     *
     * @param n   判断值
     * @param min 最小值
     * @param max 最大值
     * @return
     */
    public static boolean isBetween(Integer n, Integer min, Integer max) {
        if (n >= min && n <= max) {
            return true;
        }
        return false;
    }

    /**
     * 判断某值不在指定值中间
     *
     * @param n
     * @param min
     * @param max
     * @return
     */
    public static boolean isNotBetween(Integer n, Integer min, Integer max) {
        return !isBetween(n, min, max);
    }


}
