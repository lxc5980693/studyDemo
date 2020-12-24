package com.sihui.design.patterns.proxy.dynamicProxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @ProjectName: design-patterns
 * @Package: com.sihui.design.patterns.proxy.dynamicProxy
 * @ClassName: CglibDynamicProxy
 * @Author: lixuanchen
 * @Description: 基于Cglib实现动态代理类
 * @Date: 2020-03-05  22:32
 * @Version: 1.0
 */
public class CglibDynamicProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("我是orderServiceClass的代理类。。。。。之前执行的方法");
        Object o1 = methodProxy.invokeSuper(o, objects);
        System.out.println("我是orderServiceClass的代理类。。。。。之后执行的方法");
        return o1;
    }
}
