package com.livgo.cloud.common.model.bean;

import com.livgo.cloud.common.Const;
import com.livgo.cloud.common.model.em.ResponseCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Description:请求响应体
 * Author:     gaocl
 * Date:       2017/12/19
 * Version:    V1.0.0
 * Update:     更新说明
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseBean implements Serializable {
    private final static long serialVersionUID = 1L;

    private String code;//业务返回码,见ResponseCodeEnum.java
    private String msg;//业务返回码描述
    private String scode;//业务返回码,例userservice.invalidPassword无效的密码
    private String smsg;//业务返回码描述
    private Object result;//返回结果


    /**
     * 正确的结果
     *
     * @param result
     * @return
     */
    public static ResponseBean SUCCESS(Object result) {
        return new ResponseBean(ResponseCodeEnum.SUCCESS.getVal(), ResponseCodeEnum.SUCCESS.getDesp(), "", "", result);
    }

    /**
     * 处理失败
     *
     * @return
     */
    public static ResponseBean FAIL() {
        return new ResponseBean(ResponseCodeEnum.FAIL.getVal(), ResponseCodeEnum.FAIL.getDesp(), "","", null);
    }

    //TODO 持续增加
}
