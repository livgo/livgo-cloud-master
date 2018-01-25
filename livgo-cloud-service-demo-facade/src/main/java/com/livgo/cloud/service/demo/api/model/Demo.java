package com.livgo.cloud.service.demo.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Description:
 * Author:     gaocl
 * Date:       2017/12/28
 * Version:    V1.0.0
 * Update:     更新说明
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Demo implements Serializable {
    private final static long serialVersionUID = 1L;

    private String id;

}
