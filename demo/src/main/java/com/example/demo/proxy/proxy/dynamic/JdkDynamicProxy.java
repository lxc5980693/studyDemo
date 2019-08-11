package com.example.demo.proxy.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkDynamicProxy implements InvocationHandler {

    private Object target;

    public JdkDynamicProxy(Object target) {
        super();
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("jdk動態代理 執行前。。。。");
        Object invoke = method.invoke(target, args);
        System.out.println("jdk動態代理 執行後。。。。");
        return invoke;
    }

    public  <T> T getProxy(){
        T o = (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
        return o;
    }
}
