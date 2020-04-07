package com.sihui.dubbo.server.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ProjectName: netty-dubbo
 * @Package: com.sihui.dubbo.server.proxy
 * @ClassName: RpcClientProxy
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-04-06  18:58
 * @Version: 1.0
 */
public class RpcClientProxy {
    public static <T> T createProxy(Class<T> interfaceClass){
        T t = (T)Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return "真的很想疼爱一个小姑娘";
            }
        });
        return t;
    }
}
