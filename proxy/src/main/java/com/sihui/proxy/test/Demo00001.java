package com.sihui.proxy.test;

/**
 * @ProjectName: proxy
 * @Package: com.sihui.proxy.test
 * @ClassName: Demo00001
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-03-04  15:27
 * @Version: 1.0
 */
public class Demo00001 {
    public static void main(String [] args) {
        String name = "tom";
        Person p = new Person();
        System.out.println(p.name == name);
    }
}
class Person {
    public String name = "tom";
}
