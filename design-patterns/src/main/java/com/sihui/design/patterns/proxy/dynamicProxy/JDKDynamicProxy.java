package com.sihui.design.patterns.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ProjectName: design-patterns
 * @Package: com.sihui.design.patterns.proxy.dynamicProxy
 * @ClassName: JDKDynamicProxy
 * @Author: lixuanchen
 * @Description: 基于JDK动态代理创建代理类
 * @Date: 2020-03-05  21:35
 * @Version: 1.0
 */
public class JDKDynamicProxy implements InvocationHandler {

    /**
     * 被代理类对象，目标代理对象
     */
    private Object target;

    public JDKDynamicProxy(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是orderServiceImpl的代理类。。。。。之前执行的方法");
        System.out.println("proxy: " + proxy.getClass().toString());
        //执行目标对象的方法，通过java的反射机制
        Object invoke = method.invoke(target, args);
        System.out.println("我是orderServiceImpl的代理类。。。。。之前执行的方法");
        return invoke;
    }

    /**
     * 使用jdk动态代理创建代理类对象
     *
     * @param <T>
     * @return
     */
    public <T> T getProxy() {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }
}
