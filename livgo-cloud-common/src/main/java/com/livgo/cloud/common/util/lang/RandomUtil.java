package com.livgo.cloud.common.util.lang;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Description: 随机工具类
 * Author:     gaocl
 * Date:       2017/12/22
 * Version:    V1.0.0
 * Update:     更新说明
 */
public final class RandomUtil {

    /**
     * 字符串全部由小写字符组成
     */
    public final static int LOWERCASE_TYPE = 0;
    /**
     * 字符串全部由大写字母组成
     */
    public final static int UPPERCASE_TYPE = 1;
    /**
     * 字符串全部由数字组成
     */
    public final static int NUMBER_TYPE = 2;
    /**
     * 字符串由大小写字母混合组成
     */
    public final static int LOWERCASEANDUPPERCASE_TYPE = 3;
    /**
     * 字符串由小写字母和数字混合组成
     */
    public final static int LOWERCASEANDNUMBER_TYPE = 4;
    /**
     * 字符串由大写字母和数字混合组成
     */
    public final static int UPPERCASEANDNUMBER_TYPE = 5;
    /**
     * 字符串由大小写字母和数字混合组成
     */
    public final static int ALL_TYPE = 6;
    /**
     * 字符串由大小写字母和数字和特殊字符混合组成
     */
    public final static int OTHER_TYPE = 7;
    /**
     * 字符串由16位的数字组成
     */
    public final static int HEX_TYPE = 8;


    /**
     * 产生max以内随机数,不包括num
     *
     * @param scopeMax 最大数字
     * @return 随机数字
     */
    public static int getRandomNum(int scopeMax) {
        return (new Random()).nextInt(scopeMax);
    }

    /**
     * 生成制定范围内的随机数
     *
     * @param scopeMin
     * @param scopeMax
     * @return
     */
    public static int getRandomNum(int scopeMin, int scopeMax) {
        Random random = new Random();
        return (random.nextInt(scopeMax) % (scopeMax - scopeMin + 1) + scopeMin);
    }

    /**
     * 给定范围获得随机颜色
     *
     * @return 随机颜色
     */
    public static Color getRandomColor(int fc, int bc) {
        if (fc > 255)
            fc = 255;
        if (bc > 255)
            bc = 255;
        int r = fc + getRandomNum(bc - fc);
        int g = fc + getRandomNum(bc - fc);
        int b = fc + getRandomNum(bc - fc);
        return new Color(r, g, b);
    }

    /**
     * 随机字符串
     *
     * @param randomType 随机范围类型
     * @param length     字符串长度
     * @return
     */
    public static String getRandomString(int randomType, int length) {
        if (randomType <= 0 || length <= 0) {
            return "";
        }
        StringBuffer random = new StringBuffer();
        for (int i = 0; i < length; i++) {
            switch (randomType) {
                case LOWERCASE_TYPE:
                    char c0 = (char) (Math.random() * 26 + 'a');
                    random.append(c0);
                    break;
                case UPPERCASE_TYPE:
                    char c1 = (char) (Math.random() * 26 + 'A');
                    random.append(c1);
                    break;
                case NUMBER_TYPE:
                    char c2 = (char) (Math.random() * 10 + '0');
                    random.append(c2);
                    break;
                case LOWERCASEANDUPPERCASE_TYPE:
                    char[] limit3 = {'a', 'A'};
                    char temp3 = getRandomFromArray(limit3);
                    char c3 = (char) (Math.random() * 26 + temp3);
                    random.append(c3);
                    break;
                case LOWERCASEANDNUMBER_TYPE:
                    char[] limit4 = {'a', '0'};
                    char temp4 = getRandomFromArray(limit4);
                    char c4 = '\u0000';
                    if (temp4 == '0') {
                        c4 = (char) (Math.random() * 10 + temp4);
                    } else {
                        c4 = (char) (Math.random() * 26 + temp4);
                    }
                    random.append(c4);
                    break;
                case UPPERCASEANDNUMBER_TYPE:
                    char[] limit5 = {'A', '0'};
                    char temp5 = getRandomFromArray(limit5);
                    char c5 = '\u0000';
                    if (temp5 == '0') {
                        c5 = (char) (Math.random() * 10 + temp5);
                    } else {
                        c5 = (char) (Math.random() * 26 + temp5);
                    }
                    random.append(c5);
                    break;
                case ALL_TYPE:
                    char[] limit6 = {'a', 'A', '0'};
                    char temp6 = getRandomFromArray(limit6);
                    char c6 = '\u0000';
                    if (temp6 == '0') {
                        c6 = (char) (Math.random() * 10 + temp6);
                    } else {
                        c6 = (char) (Math.random() * 26 + temp6);
                    }
                    random.append(c6);
                    break;
                case HEX_TYPE:
                    char[] limit8 = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
                    char c8 = getRandomFromArray(limit8);
                    random.append(c8);
                    break;
                case OTHER_TYPE:
                default:
                    char[] limit7 = {'a', '@', '0', '#', '('};
                    char temp7 = getRandomFromArray(limit7);
                    char c7 = '\u0000';
                    if (temp7 == '0') {
                        c7 = (char) (Math.random() * 10 + temp7);
                    } else if (temp7 == 'a') {
                        c7 = (char) (Math.random() * 26 + temp7);
                    } else if (temp7 == '@') {
                        c7 = (char) (Math.random() * 27 + temp7);
                    } else if (temp7 == '#') {
                        c7 = (char) (Math.random() * 4 + temp7);
                    } else if (temp7 == '(') {
                        c7 = (char) (Math.random() * 4 + temp7);
                    }
                    random.append(c7);
                    break;
            }
        }
        return random.toString();
    }

    /**
     * 从一个数组中随机取出一个
     *
     * @param array
     * @return String
     */
    public static String getRandomFromArray(String[] array) {
        String random = "";
        int length = array.length;
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * length);
            random = array[index];
        }
        return random;
    }

    /**
     * 从一个数组中随机取出一个
     *
     * @param array
     * @return char
     */
    public static char getRandomFromArray(char[] array) {
        char random = '\u0000';
        int length = array.length;
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * length);
            random = array[index];
        }
        return random;
    }

    /**
     * 从一个数组中随机取出一个
     *
     * @param array
     * @return int
     */
    public static int getRandomFromArray(int[] array) {
        int random = 0;
        int length = array.length;
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * length);
            random = array[index];
        }
        return random;
    }

    /**
     * 从一个数组中随机取出一个
     *
     * @param array
     * @return int
     */
    public static float getRandomFromArray(float[] array) {
        float random = 0;
        int length = array.length;
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * length);
            random = array[index];
        }
        return random;
    }

    /**
     * 从一个数组中随机取出一个
     *
     * @param array
     * @return int
     */
    public static double getRandomFromArray(double[] array) {
        double random = 0;
        int length = array.length;
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * length);
            random = array[index];
        }
        return random;
    }

    /**
     * 从一个数组中随机取出一个
     *
     * @param array
     * @return long
     */
    public static long getRandomFromArray(long[] array) {
        long random = 0;
        int length = array.length;
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * length);
            random = array[index];
        }
        return random;
    }


    /**
     * 从数组中随机取出一定数量的不重复的数据
     *
     * @param array
     * @param count
     * @return
     */
    public static List getRandomListFromArray(String[] array, int count) {
        List list = new ArrayList();
        for (int i = 0; i < count; i++) {
            String string = getRandomFromArray(array);
            while (list.contains(string)) {
                string = getRandomFromArray(array);
            }
            list.add(string);
        }
        return list;
    }


    /**
     * 从指定的数组中随机数组中的某个元素
     *
     * @param array
     * @return
     */
    public static Object getRandomFromArray(Object[] array) {
        int index = getRandomNum(0, array.length);
        return array[index];
    }

    /**
     * 从数组中随机取出一定数量的数据
     *
     * @param array
     * @param count
     * @return
     */
    public static List getRandomListFromArray(Object[] array, int count) {
        List list = new ArrayList();
        for (int i = 0; i < count; i++) {
            Object obj = getRandomFromArray(array);
            list.add(obj);
        }
        return list;
    }

    /**
     * 从数组中随机取出一定数量的不重复的数据
     *
     * @param array
     * @param count
     * @return
     */
    public static List getRandomListFromArrayUnique(Object[] array, int count) {
        List list = new ArrayList();
        for (int i = 0; i < count; i++) {
            Object obj = getRandomFromArray(array);
            while (list.contains(obj)) {
                obj = getRandomFromArray(array);
            }
            list.add(obj);
        }
        return list;
    }


}
