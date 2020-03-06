package com.sihui.design.patterns.proxy.myJdk;

import java.lang.reflect.Method;

/**
 * @ProjectName: design-patterns
 * @Package: com.sihui.design.patterns.proxy.myJdk
 * @ClassName: MyInvocationHandler
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-03-06  12:10
 * @Version: 1.0
 */
public interface MyExtJdkInvocationHandler {
    /**
     * @param proxy 代理类
     * @param method    目标方法
     * @param args  目标方法参数
     * @return
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;

}
