package com.sihui.design.patterns.single;

/**
 * @ProjectName: design-patterns
 * @Package: com.sihui.design.patterns.single
 * @ClassName: Demo
 * @Author: lixuanchen
 * @Description: 懒汉式单例（线程不安全）
 * @Date: 2020-03-07  20:10
 * @Version: 1.0
 */
public class Demo01 {

    private static Demo01 demo;

    private Demo01() {

    }

    public static synchronized Demo01 getInstance() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (demo == null){
            demo = new Demo01();
        }
        return demo;
    }
}
