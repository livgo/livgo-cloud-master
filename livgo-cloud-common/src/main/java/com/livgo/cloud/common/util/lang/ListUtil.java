//package com.livgo.cloud.common.util.lang;
//
//import org.apache.commons.beanutils.BeanComparator;
//import org.apache.commons.collections.ComparatorUtils;
//import org.apache.commons.collections.comparators.ComparableComparator;
//import org.apache.commons.collections.comparators.ComparatorChain;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.List;
//
///**
// * Description:
// * Author:     gaocl
// * Date:       2016/12/15
// * Version:     V1.0.0
// * Update:     更新说明
// */
//public class ListUtil {
//
//    public static <T> String listToString(List<T> lst, String separator) {
//        StringBuffer sb = new StringBuffer();
//        for (T t : lst) {
//            sb.append(t.toString() + separator);
//        }
//        return sb.substring(0, sb.length() - 1);
//    }
//
//    public static <T> String[] listToArray(List<T> list) {
//        String[] arr = new String[list.size()];
//        for (int i = 0; i < list.size(); i++) {
//            arr[i] = String.valueOf(list.get(i));
//        }
//        return arr;
//    }
//
//    /**
//     * 对list进行排序
//     *
//     * @param sortList  需要排序的list
//     * @param param1    排序的参数名称
//     * @param orderType 排序类型：正序-asc；倒序-desc
//     */
//    public static List sort(List sortList, String param1, String orderType) {
//        Comparator mycmp1 = ComparableComparator.getInstance();
//        if ("desc".equals(orderType)) {
//            mycmp1 = ComparatorUtils.reversedComparator(mycmp1); //逆序（默认为正序）
//        }
//
//        ArrayList<Object> sortFields = new ArrayList<Object>();
//        sortFields.add(new BeanComparator(param1, mycmp1)); //主排序（第一排序）
//
//        ComparatorChain multiSort = new ComparatorChain(sortFields);
//        Collections.sort(sortList, multiSort);
//
//        return sortList;
//    }
//
//    /**
//     * 对list进行排序
//     *
//     * @param sortList  需要排序的list
//     * @param param1    排序的参数名称:参数长度
//     * @param param2    排序的参数名称:排序参数
//     * @param orderType 排序类型：正序-asc；倒序-desc
//     */
//    public static List sortParam2(List sortList, String param1, String param2, String orderType) {
//        Comparator mycmp1 = ComparableComparator.getInstance();
//        Comparator mycmp2 = ComparableComparator.getInstance();
//        if ("desc".equals(orderType)) {
//            mycmp1 = ComparatorUtils.reversedComparator(mycmp1); //逆序（默认为正序）
//        }
//
//        ArrayList<Object> sortFields = new ArrayList<Object>();
//        sortFields.add(new BeanComparator(param1, mycmp1)); //主排序（第一排序）
//        sortFields.add(new BeanComparator(param2, mycmp2)); //主排序（第一排序）
//
//        ComparatorChain multiSort = new ComparatorChain(sortFields);
//        Collections.sort(sortList, multiSort);
//
//        return sortList;
//    }
//}
