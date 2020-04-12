package com.sihui.proxy.service;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @ProjectName: proxy
 * @Package: com.sihui.proxy.service
 * @ClassName: Demo01
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-03-01  17:34
 * @Version: 1.0
 */
public class Demo01 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, InterruptedException {
        URL url = new URL("\\Users\\lixuanchen\\Desktop\\studyDemo\\proxy\\src\\main\\java\\com\\sihui\\proxy\\test\\");
        URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{url});
        for (; ; ) {
            if (urlClassLoader == null){
                break;
            }
            Class<?> demo02 = urlClassLoader.loadClass("Demo02");
            System.out.println("HelloService 使用的类加载 器是:" + demo02.getClassLoader());
            Object instance = demo02.newInstance();
            demo02.getMethod("test").invoke(instance);
            Thread.sleep(3000);
            urlClassLoader = null;
            instance = null;
        }
        System.gc();
        Thread.sleep(10000);
    }
}
