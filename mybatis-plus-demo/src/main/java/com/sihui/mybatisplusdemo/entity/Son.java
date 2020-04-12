package com.sihui.mybatisplusdemo.entity;

/**
 * @ProjectName: mybatis-plus-demo
 * @Package: com.sihui.mybatisplusdemo.entity
 * @ClassName: Test
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-01-07  11:10
 * @Version: 1.0
 */
public class Son extends Father{

    static {
        System.out.println("---Son 静态代码块---");
    }

    public Son(){
        System.out.println("---Son 构造函数---");
    }

    public static void main(String[] args) {
        new Son();
    }

}