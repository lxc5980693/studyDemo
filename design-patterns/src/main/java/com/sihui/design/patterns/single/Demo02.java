package com.sihui.design.patterns.single;

import java.io.Serializable;

/**
 * @ProjectName: design-patterns
 * @Package: com.sihui.design.patterns.single
 * @ClassName: Demo
 * @Author: lixuanchen
 * @Description: 双重检验锁
 * @Date: 2020-03-07  20:10
 * @Version: 1.0
 */
public class Demo02 implements Serializable {

    private static Demo02 demo;

    private Demo02() {

    }

    /**
     * 解决 懒汉式下 使用synchronized关键字导致读写都加锁，
     * 从而导致多线程下同步执行的效率问题
     */
    public static Demo02 getInstance() {
        if (demo == null){
            synchronized (Demo02.class){
                //当前线程已经获取到锁，然后在对该对象判断一次。
                if (demo == null){
                    demo = new Demo02();
                }
            }
        }
        return demo;
    }
}
