//package com.livgo.cloud.common.util.lang;
//
//import org.apache.commons.beanutils.PropertyUtilsBean;
//
//import java.beans.PropertyDescriptor;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * Description:
// * Author:     gaocl
// * Date:       2016/12/15
// * Version:     V1.0.0
// * Update:     更新说明
// */
//public class MapUtil {
//
//    public static Map<String, Object> beanToMap(Object obj) {
//        Map<String, Object> params = new HashMap<String, Object>(0);
//        try {
//            PropertyUtilsBean propertyUtilsBean = new PropertyUtilsBean();
//            PropertyDescriptor[] descriptors = propertyUtilsBean.getPropertyDescriptors(obj);
//            for (int i = 0; i < descriptors.length; i++) {
//                String name = descriptors[i].getName();
//                if (!"class".equals(name)) {
//                    params.put(name, propertyUtilsBean.getNestedProperty(obj, name));
//                }
//            }
//        } catch (Exception e) {
//            LogUtil.error(logger, e);
//        }
//        return params;
//    }
//}
