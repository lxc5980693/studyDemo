package com.sihui.design.patterns.proxy.myJdk.impl;

import com.sihui.design.patterns.proxy.myJdk.MyExtJdkInvocationHandler;

import java.lang.reflect.Method;

/**
 * @ProjectName: design-patterns
 * @Package: com.sihui.design.patterns.proxy.myJdk.impl
 * @ClassName: MyJdkInvocationHandler
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-03-06  14:26
 * @Version: 1.0
 */
public class MyJdkInvocationHandler implements MyExtJdkInvocationHandler {

    private Object target;

    public MyJdkInvocationHandler(Object target){
        this.target = target;
    }

    /**
     * @param proxy  代理类
     * @param method 目标方法
     * @param args   目标方法参数
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("纯手写JDK动态代理。。。。之前");
        Object invoke = method.invoke(target, args);
        System.out.println("纯手写JDK动态代理。。。。之后");
        return invoke;
    }


}
