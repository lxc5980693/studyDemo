package com.sihui.mybatisplusdemo.builder.entity;

import lombok.Data;

/**
 * @ProjectName: mybatis-plus-demo
 * @Package: com.sihui.mybatisplusdemo.builder.entity
 * @ClassName: Bike
 * @Author: lixuanchen
 * @Description: 单车对象
 * @Date: 2020-01-07  16:59
 * @Version: 1.0
 */
@Data
public class Bike {
    /**
     * 轮胎
     */
    private String tyres;
    /**
     * 车架
     */
    private String frame;
    /**
     * gps
     */
    private String gps;
}
