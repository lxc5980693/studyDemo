package com.sihui.design.patterns.single;

/**
 * @ProjectName: design-patterns
 * @Package: com.sihui.design.patterns.single
 * @ClassName: Demo
 * @Author: lixuanchen
 * @Description: 饿汉式单例
 * @Date: 2020-03-07  20:10
 * @Version: 1.0
 */
public class Demo {

    private static Demo demo = new Demo();

    private Demo() {

    }

    public static Demo getInstance() {
        return demo;
    }
}
