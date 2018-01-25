package com.livgo.cloud.common.model.em;

/**
 * Description:状态
 * Author:     gaocl
 * Date:       2017/12/19
 * Version:    V1.0.0
 * Update:     更新说明
 */
public enum ResponseCodeEnum {

    SUCCESS("10000", "SUCCESS"),//成功
    FAIL("40000", "处理失败"),
    FAIL_ARGS("40001", "非法参数"),
    FAIL_SERVICE("40002", "服务不可用"),
    FAIL_AUTH("40003", "无权限"),
    ERROR("90000", "系统异常");


    private String val;
    private String desp;

    ResponseCodeEnum() {
    }

    ResponseCodeEnum(String val, String desp) {
        this.val = val;
        this.desp = desp;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public String getDesp() {
        return desp;
    }

    public void setDesp(String desp) {
        this.desp = desp;
    }
}
