package com.sihui.proxy.proxy;

import com.sihui.proxy.entity.User;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

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
        System.out.println("UserDynamicProxy 执行前。。。");
        if (Object.class.equals(method.getDeclaringClass())){
            Object invoke = method.invoke(target, args);
            System.out.println("UserDynamicProxy result:" + invoke.toString());
            System.out.println("UserDynamicProxy 执行后。。。");
            return invoke;
        }else {
            return new User("动态李小花", 25, "动态地址");
        }
    }
}
