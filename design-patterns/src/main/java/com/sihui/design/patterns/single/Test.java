package com.sihui.design.patterns.single;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @ProjectName: design-patterns
 * @Package: com.sihui.design.patterns.single
 * @ClassName: Test
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-03-07  20:33
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException, IOException, ClassNotFoundException {
//        for (int i = 0; i < 100; i++) {
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    Demo02 instance = Demo02.getInstance();
//                    System.out.println(Thread.currentThread().getName() + ": " + instance);
//                }
//            }).start();
//        }
        /**
         * 使用java反射破解单例
         */
        Demo02 instance = Demo02.getInstance();
        Class cla = Demo02.class;
        Constructor<Demo02> declaredConstructor = cla.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        Demo02 o = declaredConstructor.newInstance();
        System.out.println(instance == o);

        /**
         * 使用序列化与反序列化破解单例
         */
        Demo02 instance1 = Demo02.getInstance();
        File file = new File("/Users/lixuanchen/Desktop/msg");
        ObjectOutputStream fileOutputStream = new ObjectOutputStream(new FileOutputStream(file));
        fileOutputStream.writeObject(instance1);
        fileOutputStream.flush();
        fileOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
        Demo02 o1 = (Demo02) objectInputStream.readObject();
        System.out.println(instance1 == o1);
        objectInputStream.close();
    }
}
