package com.sihui.demo.nio;

import org.openjdk.jol.info.ClassLayout;

/**
 * @ProjectName: io
 * @Package: com.sihui.demo.nio
 * @ClassName: ObjTest
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-04-22  10:39
 * @Version: 1.0
 */
public class ObjTest {
    public static void main(String[] args) {
        Object o = new Object();
        System.out.println(ClassLayout.parseClass(o.getClass()).toPrintable(o));
        o.hashCode();
        System.out.println(ClassLayout.parseClass(o.getClass()).toPrintable(o));
        synchronized (o){
            System.out.println(ClassLayout.parseClass(o.getClass()).toPrintable(o));
        }
    }
}
