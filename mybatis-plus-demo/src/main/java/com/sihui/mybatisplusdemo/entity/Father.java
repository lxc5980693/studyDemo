package com.sihui.mybatisplusdemo.entity;

/**
 * @ProjectName: mybatis-plus-demo
 * @Package: com.sihui.mybatisplusdemo.entity
 * @ClassName: Super
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-01-07  11:36
 * @Version: 1.0
 */
public class Father {
    static {
        System.out.println("---Father 静态代码块---");
    }

    public Father(){
        System.out.println("---Father 构造函数---");
    }
}
