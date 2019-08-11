package com.example.demo.proxy.proxy.dynamic;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxyMethod implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib 動態代理執行前。。。");
        Object o1 = methodProxy.invokeSuper(o, objects);
        System.out.println("cglib 動態代理執行後。。。");
        return o1;
    }
}
