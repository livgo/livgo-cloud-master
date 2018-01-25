package com.livgo.cloud.common.util.date;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Description:日期时间工具类
 * Author:     gaocl
 * Date:       2017/12/20
 * Version:    V1.0.0
 * Update:     更新说明
 */
public final class DateUtil {

    public final static String BEGINDATE = "2010-01-01 00:00:00";
    public final static String BEGINTIME = "00:00:00";
    public final static String ENDTIME = "23:59:59 999";
    public final static String SEPARATOR = ":";
    public final static String FORMAT1 = "yyyy-MM-dd HH:mm:ss";
    public final static String FORMAT2 = "yyyy-MM-dd";
    public final static String FORMAT3 = "HH:mm:ss";
    public final static String FORMAT4 = "yyyy/MM/dd";
    public final static String FORMAT5 = "yyyyMMdd";
    public final static String FORMAT6 = "yyyyMMddHHmmss";
    public final static String FORMAT7 = "HH:mm:ss";
    public final static String FORMAT8 = "yyyy-MM-dd HH:mm";
    public final static String FORMAT9 = "yyyy年MM月dd日 HH:mm:ss";
    public final static String FORMAT10 = "yyyyMMddHHmmssSSS";
    public final static int MONTH = 12;
    public final static int DAY = 7;
    public final static int HOUR = 24;
    public final static int MINUTE = 60;
    public final static int SECOND = 60;
    public final static int MILLSECOND = 1000;
    public final static int DAYMILLSECOND = HOUR * MINUTE * SECOND * MILLSECOND;
    public final static int HOURMILLSECOND = MINUTE * SECOND * MILLSECOND;
    public final static int MINUTEMILLSECOND = SECOND * MILLSECOND;


    /**
     * 不同format的安全SimpleDateFormat集合
     */
    private static Map<String, ThreadLocal<SimpleDateFormat>> sdfMap = new HashMap<String, ThreadLocal<SimpleDateFormat>>();

    /**
     * 获取一个安全的SimpleDateFormat
     *
     * @param format
     * @return
     */
    private synchronized static SimpleDateFormat getSdf(final String format) {
        ThreadLocal<SimpleDateFormat> tl = sdfMap.get(format);
        if (tl == null) {
            tl = ThreadLocal.withInitial(() -> new SimpleDateFormat(format));
            sdfMap.put(format, tl);
        }
        return tl.get();
    }

    /**
     * 获取当前日期
     *
     * @return
     */
    public static String getCurDate() {
        return format(new Date(), FORMAT2);
    }

    /**
     * 获取当前日期时间
     *
     * @return
     */
    public static String getCurDateTime() {
        return format(new Date(), FORMAT1);
    }

    /**
     * 获取当前时间(毫秒)
     *
     * @return
     */
    public static long getCurTimeMillis() {
        return System.currentTimeMillis();
    }


    /**
     * 获取当前时间戳(秒)
     *
     * @return
     */
    public static int getCurTimestamp() {
        return (int) (System.currentTimeMillis() / MILLSECOND);
    }

    /**
     * 时间戳转日期时间
     *
     * @param timestamp
     * @return
     */
    public static Date timestampToDate(int timestamp) {
        return new Timestamp((long) timestamp * MILLSECOND);
    }

    /**
     * 日期时间转时间戳
     *
     * @param date
     * @return
     */
    public static int dateToTimestamp(Date date) throws NullPointerException {
        return (int) (new Timestamp(date.getTime()).getTime() / MILLSECOND);
    }

    /**
     * 时间戳转日期时间格式
     *
     * @param timestamp
     * @return
     */
    public static String timestampToDateFormat(int timestamp) {
        return format(new Timestamp((long) timestamp * MILLSECOND), FORMAT1);
    }

    /**
     * 日期时间格式转时间戳
     *
     * @param dateFormat
     * @return
     */
    public static int dateFormatToTimestamp(String dateFormat) {
        return (int) (Timestamp.valueOf(dateFormat).getTime() / MILLSECOND);
    }

    /**
     * 时间格式转换
     *
     * @param formatDate
     * @param format
     * @return
     */
    public static Date parse(String formatDate, String format) throws ParseException {
        return getSdf(format).parse(formatDate);
    }

    /**
     * 获取指定格式的时间format
     *
     * @param date
     * @param format
     * @return
     */
    public static String format(Date date, String format) {
        return getSdf(format).format(date);
    }

    /**
     * 获取指定格式的时间format
     *
     * @param format
     * @return
     */
    public static String format(String format) {
        return getSdf(format).format(new Date());
    }
    /**
     * 获取指定日期的截止时间
     *
     * @param date
     * @return
     */
    public static long getDateTimeEnd(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return cal.getTimeInMillis();
    }

    /**
     * 获取指定日期的起始时间
     *
     * @param date
     * @return
     */
    public static long getDateTimeBegin(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTimeInMillis();
    }

    /**
     * 获取指定日期的下一天
     *
     * @param date
     * @return
     */
    public static long getDateTimeBeginNextDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 24);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTimeInMillis();
    }

    /**
     * 指定日期加减年
     *
     * @param date
     * @param n    可负数
     */
    public static Date getDateTimeAddYear(Date date, int n) {
        java.util.Calendar Cal = java.util.Calendar.getInstance();
        Cal.setTime(date);
        Cal.add(Calendar.YEAR, n);
        return Cal.getTime();
    }

    /**
     * 指定日期加减月
     *
     * @param date
     * @param n    可负数
     * @return
     */
    public static Date getDateTimeAddMonth(Date date, int n) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, n);
        return calendar.getTime();
    }

    /**
     * 指定日期加减天
     *
     * @param n    可以为负数
     * @param date 某个日期
     * @return
     */
    public static Date getDateTimeAddDay(Date date, int n) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, n);
        return calendar.getTime();
    }

    /**
     * 指定日期加减时
     *
     * @param n    可以为负数
     * @param date 某个日期
     * @return
     */
    public static Date getDateTimeAddHour(Date date, int n) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, n * MINUTE);
        return calendar.getTime();
    }

    /**
     * 指定日期加减分
     *
     * @param n    可以为负数
     * @param date 某个日期
     * @return
     */
    public static Date getDateTimeAddMinute(Date date, int n) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, n);
        return calendar.getTime();
    }


    /**
     * 时间date1和date2的时间差-单位秒
     *
     * @param date1
     * @param date2
     * @return 秒
     */
    public static long subtract(Date date1, Date date2) {
        return (date2.getTime() - date1.getTime()) / MILLSECOND;
    }

    /**
     * 时间date1和date2的时间差-单位分钟
     *
     * @param date1
     * @param date2
     * @return 分钟
     */
    public static int subtractMinute(Date date1, Date date2) {
        return (int) (date2.getTime() - date1.getTime()) / MINUTEMILLSECOND;
    }

    /**
     * 时间date1和date2的时间差-单位小时
     *
     * @param date1
     * @param date2
     * @return 分钟
     */
    public static int subtractHour(Date date1, Date date2) {
        return (int) (date2.getTime() - date1.getTime()) / HOURMILLSECOND;
    }

    /**
     * 时间date1和date2的时间差-单位天
     *
     * @param date1
     * @param date2
     * @return 天
     */
    public static int subtractDay(Date date1, Date date2) {
        return (int) (date2.getTime() - date1.getTime()) / DAYMILLSECOND;
    }

    /**
     * 时间date1和date2的时间差-单位月
     *
     * @param date1
     * @param date2
     * @return 月
     */
    public static int subtractMonth(Date date1, Date date2) {
        int result;
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(date1);
        c2.setTime(date2);
        int year1 = c1.get(Calendar.YEAR);
        int month1 = c1.get(Calendar.MONTH);
        int year2 = c2.get(Calendar.YEAR);
        int month2 = c2.get(Calendar.MONTH);
        if (year1 == year2) {
            result = month2 - month1;
        } else {
            result = MONTH * (year2 - year1) + month2 - month1;
        }
        return result;
    }


    /**
     * 时间date1和date2的时间差-单位年
     *
     * @param date1
     * @param date2
     * @return 年
     */
    public static int subtractYear(Date date1, Date date2) {
        int result;
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(date1);
        c2.setTime(date2);
        int year1 = c1.get(Calendar.YEAR);
        int year2 = c2.get(Calendar.YEAR);
        result = year2 - year1;
        return result;
    }


    /**
     * 获取指定时间的天数
     *
     * @param date
     * @return
     */
    public static int getDaysFromDate(Date date) throws ParseException {
        Date beginDate = null;
        beginDate = parse(BEGINDATE, FORMAT1);
        long time = date.getTime() - beginDate.getTime();
        return (int) (time / (DAYMILLSECOND));
    }

    /**
     * 获取指定时间Format的天数
     *
     * @param dateFormat
     * @return
     */
    public static int getDaysFromDateFormat(String dateFormat) throws ParseException {
        Date beginDate = null;
        long time = 0;
        beginDate = parse(BEGINDATE, FORMAT1);
        time = parse(dateFormat, FORMAT1).getTime() - beginDate.getTime();
        return (int) (time / (DAYMILLSECOND));
    }

    /**
     * 天数转日期
     *
     * @param days
     * @return
     */
    public static Date getDateFromDays(int days) throws ParseException {
        Date beginDate = null;
        beginDate = parse(BEGINDATE, FORMAT1);
        Calendar cal = Calendar.getInstance();
        cal.setTime(beginDate);
        cal.add(Calendar.DAY_OF_MONTH, days);
        return cal.getTime();
    }

    /**
     * 天数转日期Format
     *
     * @param days
     * @return
     * @throws ParseException
     */
    public static String getDateFormatFromDays(int days, String format) throws ParseException {
        Date beginDate = null;
        beginDate = parse(BEGINDATE, FORMAT1);
        Calendar cal = Calendar.getInstance();
        cal.setTime(beginDate);
        cal.add(Calendar.DAY_OF_MONTH, days);
        return format(cal.getTime(), format);
    }

    /**
     * 天数和时间转日期
     *
     * @param days
     * @return
     */
    public static Date getDateFromDaysAndTime(int days, int time) throws ParseException {
        Date beginDate = null;
        beginDate = parse(BEGINDATE, FORMAT1);
        Calendar cal = Calendar.getInstance();
        cal.setTime(beginDate);
        cal.add(Calendar.DAY_OF_MONTH, days);
        cal.add(Calendar.HOUR_OF_DAY, time / HOURMILLSECOND);
        cal.add(Calendar.MINUTE, (time / MINUTEMILLSECOND) % SECOND);
        cal.add(Calendar.SECOND, (time / MILLSECOND) % SECOND);
        cal.add(Calendar.MILLISECOND, time % MILLSECOND);
        return cal.getTime();
    }

    /**
     * 天数和时间转日期Format
     *
     * @param days
     * @param time
     * @param format
     * @return
     */
    public static String getDateFormatFromDaysAndTime(int days, int time, String format) throws ParseException {
        Date beginDate = parse(BEGINDATE, FORMAT1);
        Calendar cal = Calendar.getInstance();
        cal.setTime(beginDate);
        cal.add(Calendar.DAY_OF_MONTH, days);
        cal.add(Calendar.HOUR_OF_DAY, time / HOURMILLSECOND);
        cal.add(Calendar.MINUTE, (time / MINUTEMILLSECOND) % SECOND);
        cal.add(Calendar.SECOND, (time / MILLSECOND) % SECOND);
        cal.add(Calendar.MILLISECOND, time % MILLSECOND);
        return format(cal.getTime(), format);
    }

    /**
     * 获取指定时间月份的第一天
     *
     * @param date
     * @return
     */
    public static String getFirstDayOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        // 获取某月最小天数
        int firstDay = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
        // 设置日历中月份的最大天数
        cal.set(Calendar.DAY_OF_MONTH, firstDay);
        // 格式化日期
        return format(cal.getTime(), FORMAT2);
    }

    /**
     * 获取指定时间月份的最后一天
     *
     * @param date
     * @return
     */
    public static String getLastDayOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        // 获取某月最大天数
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        // 设置日历中月份的最大天数
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        // 格式化日期
        return format(cal.getTime(), FORMAT2);
    }

    /**
     * 获取指定时间月份的下个月第一天
     *
     * @param date
     * @return
     */
    public static String getFirstDayOfNextMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        // 获取某月最大天数
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        // 设置日历中月份的最大天数
        cal.set(Calendar.DAY_OF_MONTH, lastDay + 1);
        // 格式化日期
        return format(cal.getTime(), FORMAT2);
    }

    /**
     * 指定日期所在周的周一
     *
     * @return yyyy-MM-dd
     */
    public static String getMondayOfThisWeek(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int day_of_week = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (day_of_week == 0)
            day_of_week = 7;
        cal.add(Calendar.DATE, -day_of_week + 1);
        return format(cal.getTime(), FORMAT2);
    }

    /**
     * 指定日期所在周的周日
     *
     * @return yyyy-MM-dd
     */
    public static String getSundayOfThisWeek(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int day_of_week = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (day_of_week == 0)
            day_of_week = 7;
        cal.add(Calendar.DATE, -day_of_week + 7);
        return format(cal.getTime(), FORMAT2);
    }

    /**
     * 指定日期所在周的下周一
     *
     * @return yyyy-MM-dd
     */
    public static String getMondayOfNextWeek(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int day_of_week = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (day_of_week == 0)
            day_of_week = 7;
        cal.add(Calendar.DATE, -day_of_week + 7 + 1);
        return format(cal.getTime(), FORMAT2);
    }


    /**
     * 指定日期的星期
     *
     * @param date
     * @return
     */
    public static String getWeekStr(Date date) {
        String[] weeks = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int weekIndex = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (weekIndex < 0) {
            weekIndex = 0;
        }
        return weeks[weekIndex];
    }

    /**
     * 指定日期所在年的第一天
     *
     * @param date 日期
     * @return String
     */
    public static String getYearFirstOfDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        cal.clear();
        cal.set(Calendar.YEAR, year);
        return format(cal.getTime(), FORMAT2);
    }

    /**
     * 指定日期所在年的最后一天
     *
     * @param date 日期
     * @return String
     */
    public static String getYearLastOfDate(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        cal.clear();
        cal.set(Calendar.YEAR, year);
        cal.roll(Calendar.DAY_OF_YEAR, -1);
        return format(cal.getTime(), FORMAT2);
    }


    /**
     * 获取某年第一天日期
     *
     * @param year 年份
     * @return String
     */
    public static String getYearFirst(String year) {
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(Calendar.YEAR, Integer.parseInt(year));
        return format(cal.getTime(), FORMAT2);
    }

    /**
     * 获取某年最后一天日期
     *
     * @param year 年份
     * @return String
     */
    public static String getYearLast(String year) {
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(Calendar.YEAR, Integer.parseInt(year));
        cal.roll(Calendar.DAY_OF_YEAR, -1);
        return format(cal.getTime(), FORMAT2);
    }


    /**
     * 判断指定时间是否在某段时间内
     *
     * @param startTime
     * @param endTime
     * @param date
     * @return
     */
    public static boolean between(Date startTime, Date endTime, Date date) {
        return date.after(startTime) && date.before(endTime);
    }


}
