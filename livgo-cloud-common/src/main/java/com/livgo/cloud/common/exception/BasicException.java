package com.livgo.cloud.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description:基本异常对象
 * Author:     gaocl
 * Date:       2017/12/26
 * Version:    V1.0.0
 * Update:     更新说明
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BasicException extends RuntimeException {

    private String method;
    private Exception exception;
}
