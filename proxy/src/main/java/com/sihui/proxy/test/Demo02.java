package com.sihui.proxy.test;

/**
 * @ProjectName: proxy
 * @Package: com.sihui.proxy.test
 * @ClassName: Demo02
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-03-01  20:58
 * @Version: 1.0
 */
public class Demo02 {
    public static void main(String[] args) {
        String s0 = "a1";
        String s1 = "a" + 1;
        System.out.println("===========test6============");
        System.out.println((s0 == s1)); //result = true
        String s2 = "atrue";
        String s3= "a" + "true";
        System.out.println((s2 == s3)); //result = true
        String s4 = "a3.4";
        String s5 = "a" + 3.4;
        System.out.println((s4 == s5)); //result = true
    }
}
