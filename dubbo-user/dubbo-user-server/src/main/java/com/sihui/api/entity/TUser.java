package com.sihui.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * (TUser)实体类
 *
 * @author makejava
 * @since 2020-03-04 12:00:07
 */
@Data
@AllArgsConstructor
public class TUser {
    /**
     * 编号
     */
    private Long id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private String age;
    /**
     * 地址
     */
    private String address;

}