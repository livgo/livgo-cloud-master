package com.livgo.cloud.api.demo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Description:
 * Author:     gaocl
 * Date:       2018/1/4
 * Version:    V1.0.0
 * Update:     更新说明
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Demo implements Serializable {
    private final static long serialVersionUID = 1L;

    private String id;
    private String name;
    private Integer age;

}
