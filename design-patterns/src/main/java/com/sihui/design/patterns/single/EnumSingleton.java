package com.sihui.design.patterns.single;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @ProjectName: design-patterns
 * @Package: com.sihui.design.patterns.single
 * @ClassName: EnumSingleton
 * @Author: lixuanchen
 * @Description: 枚举构造单例模式
 * @Date: 2020-03-07  21:25
 * @Version: 1.0
 */
public enum EnumSingleton {
    /**
     * 常量
     */
    INSTANCE;

    public static void add(){
        System.out.println("add方法。。。");
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        EnumSingleton enumSingleton = EnumSingleton.INSTANCE;
        EnumSingleton enumSingleton1 = EnumSingleton.INSTANCE;
        System.out.println(enumSingleton == enumSingleton1);
        Constructor<EnumSingleton> declaredConstructor = EnumSingleton.class.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        EnumSingleton enumSingleton2 = declaredConstructor.newInstance();
        System.out.println(enumSingleton == enumSingleton2);
    }
}
