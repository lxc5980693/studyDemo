package com.sihui.mybatisplusdemo.builder;

import com.sihui.mybatisplusdemo.builder.entity.Bike;

/**
 * @ProjectName: mybatis-plus-demo
 * @Package: com.sihui.mybatisplusdemo.builder
 * @ClassName: BikeBuilder
 * @Author: lixuanchen
 * @Description: 自行车生产类
 * @Date: 2020-01-07  16:55
 * @Version: 1.0
 */
public abstract class BikeBuilder {
    /**
     * 组装轮胎
     */
    public abstract void buildTyres();

    /**
     * 组装车架
     */
    public abstract void buildFrame();

    /**
     * 组装GPS
     */
    public abstract void buildGPS();

    /**
     * 生产车辆
     * @return
     */
    public abstract Bike getBike();
}
