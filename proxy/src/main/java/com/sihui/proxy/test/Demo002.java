package com.sihui.proxy.test;

/**
 * @ProjectName: proxy
 * @Package: com.sihui.proxy.test
 * @ClassName: Demo002
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-03-04  15:30
 * @Version: 1.0
 */
public class Demo002 {
    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "world";
        String s3 = "hello" + "world";
        String s4 = s1 + "world";
        String s5 = "hello" + s2;
        System.out.println(s5 == s4);
    }
}
