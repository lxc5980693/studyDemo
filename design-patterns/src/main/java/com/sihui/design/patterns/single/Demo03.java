package com.sihui.design.patterns.single;

/**
 * @ProjectName: design-patterns
 * @Package: com.sihui.design.patterns.single
 * @ClassName: Demo
 * @Author: lixuanchen
 * @Description: 静态内部类
 * @Date: 2020-03-07  20:10
 * @Version: 1.0
 */
public class Demo03 {

    private Demo03() {
        System.out.println("构造函数被初始化。。。");
    }

    public static Demo03 getInstance() {
        return Demo03Utils.demo03;
    }

    private static class Demo03Utils {
        private static final Demo03 demo03 = new Demo03();
    }

    public static void main(String[] args) {
        System.out.println("项目初始化成功。。。");
        Demo03 instance = Demo03.getInstance();
        Demo03 instance1= Demo03.getInstance();
        System.out.println(instance == instance1);
    }
}
