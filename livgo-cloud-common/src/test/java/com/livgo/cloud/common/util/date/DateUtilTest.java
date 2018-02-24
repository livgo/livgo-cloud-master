package com.livgo.cloud.common.util.date;

import java.util.Date;

/**
 * Description:
 * Author:     gaocl
 * Date:       2017/12/20
 * Version:    V1.0.0
 * Update:     更新说明
 */
public class DateUtilTest {

    public static void main(String[] args) {
        System.out.println(DateUtil.getLastDayOfMonth(new Date()));
        System.out.println(DateUtil.getFirstDayOfMonth(new Date()));
        System.out.println(DateUtil.getFirstDayOfNextMonth(new Date()));
        System.out.println(DateUtil.getMondayOfThisWeek(new Date()));
        System.out.println(DateUtil.getSundayOfThisWeek(new Date()));
        System.out.println(DateUtil.getMondayOfNextWeek(new Date()));
        System.out.println(DateUtil.getDateTimeBegin(new Date()));
        System.out.println(DateUtil.getDateTimeEnd(new Date()));
        System.out.println(DateUtil.getDateTimeBeginNextDay(new Date()));
        System.out.println(DateUtil.getYearFirst("2018"));
        System.out.println(DateUtil.getYearLast("2018"));
        System.out.println(DateUtil.getYearFirstOfDate(new Date()));
        System.out.println(DateUtil.getYearLastOfDate(new Date()));

        System.out.println(DateUtil.getCurTimestamp());
        System.out.println(DateUtil.timestampToDate(DateUtil.getCurTimestamp()));
        System.out.println(DateUtil.dateToTimestamp(new Date()));
        System.out.println(DateUtil.timestampToDateFormat(DateUtil.getCurTimestamp()));
        System.out.println(DateUtil.dateFormatToTimestamp("2017-12-20 17:43:00"));
        System.out.println(DateUtil.subtractMinute(new Date(), new Date(new Date().getTime() + 1 * 60 * 1000)));


    }
}
