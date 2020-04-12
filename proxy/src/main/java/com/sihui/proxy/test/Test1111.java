package com.sihui.proxy.test;

/**
 * @ProjectName: proxy
 * @Package: com.sihui.proxy.test
 * @ClassName: Test1111
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-03-04  15:23
 * @Version: 1.0
 */
public class Test1111 {
    public static void main(String[] args) {
        A a = new A();
        new Thread(){
            @Override
            public void run() {
                a.setNumber();
            }
        }.start();
        while (a.number == 0){
            System.out.println("aaa");
        }
        System.out.println("**********");
    }
}
