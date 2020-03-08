package com.sihui.design.patterns.reflect;

import com.sihui.design.patterns.reflect.entity.UserEntity;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @ProjectName: design-patterns
 * @Package: com.sihui.design.patterns.reflect
 * @ClassName: Demo
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-03-07  22:12
 * @Version: 1.0
 */
public class Demo {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<?> aClass = Class.forName("com.sihui.design.patterns.reflect.entity.UserEntity");
//        UserEntity o = (UserEntity)aClass.newInstance();
        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(String.class, Integer.class);
        UserEntity o1 = (UserEntity)declaredConstructor.newInstance("lixuanchen", 18);
        System.out.println(o1.getName() + o1.getAge());
    }
}
