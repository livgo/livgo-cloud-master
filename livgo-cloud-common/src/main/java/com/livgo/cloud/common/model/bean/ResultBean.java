package com.livgo.cloud.common.model.bean;

import com.livgo.cloud.common.Const;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Description:服务响应体
 * Author:     gaocl
 * Date:       2017/12/19
 * Version:    V1.0.0
 * Update:     更新说明
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultBean implements Serializable {
    private final static long serialVersionUID = 1L;

    private String scode;//业务返回码,例userservice.invalidPassword无效的密码
    private String msg;//业务返回码描述
    private Object result;//返回结果

    /**
     * 正确的结果
     *
     * @param result
     * @return
     */
    public static ResultBean SUCCESS(Object result) {
        return new ResultBean(Const.SUCCESS, Const.SUCCESS, result);
    }

    /**
     * 多用于事务性服务，触发调用方回滚事务
     *
     * @param msg
     * @return
     */
    public static ResultBean FAIL(String msg) {
        return new ResultBean(Const.FAIL, msg, null);
    }

    /**
     * 多用于查询服务，也可做"服务降级"
     *
     * @param result 多为空数据的结果
     * @return
     */
    public static ResultBean FALLBACK(Object result) {
        return new ResultBean(Const.FAILBACK, Const.FAILBACK, result);
    }
}

