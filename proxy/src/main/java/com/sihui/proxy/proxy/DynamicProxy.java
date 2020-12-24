package com.sihui.proxy.proxy;

import com.sihui.proxy.entity.User;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;

/**
 * @ProjectName: proxy
 * @Package: com.sihui.proxy.proxy
 * @ClassName: UserDynamicProxy
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2019-12-09  16:14
 * @Version: 1.0
 */
public class DynamicProxy implements InvocationHandler {

    private Object target;

    public DynamicProxy(Object target) {
        this.target = target;
    }

    public <T> T getProxy() {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        User user = new User("动态李小花", 25, "动态地址");
        User user1 = new User("动态李小花", 25, "动态地址");
        List<User> users = Arrays.asList(user, user1);
//        String s = JSON.toJSONString(users);
//        System.out.println("UserDynamicProxy 执行前。。。");
        System.out.println("typeName: "+ method.getAnnotatedReturnType().getType().getTypeName());
        System.out.println("Annotations: "+ method.getAnnotatedReturnType().getAnnotations());
        System.out.println("Declareds: "+ method.getAnnotatedReturnType().getDeclaredAnnotations());
//        Class<?> aClass = Class.forName(annotatedReturnType.getType().getTypeName());
//        System.out.println("method return type:" + aClass);
//        List<?> objects = JSON.parseArray(s, aClass);
//        System.out.println("result:" + objects.toString());
//        if (Object.class.equals(method.getDeclaringClass())){
//            Object invoke = method.invoke(target, args);
//            System.out.println("UserDynamicProxy result:" + invoke.toString());
//            System.out.println("UserDynamicProxy 执行后。。。");
//            return invoke;
//        }else {
//            return new User("动态李小花", 25, "动态地址");
//        }
        return users;
    }
}
