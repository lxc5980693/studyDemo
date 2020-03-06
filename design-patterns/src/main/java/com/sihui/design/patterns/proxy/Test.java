package com.sihui.design.patterns.proxy;

import com.sihui.design.patterns.proxy.dynamicProxy.CglibDynamicProxy;
import com.sihui.design.patterns.proxy.dynamicProxy.JDKDynamicProxy;
import com.sihui.design.patterns.proxy.service.OrderService;
import com.sihui.design.patterns.proxy.service.impl.OrderServiceClass;
import com.sihui.design.patterns.proxy.service.impl.OrderServiceImpl;
import com.sihui.design.patterns.proxy.staticProxy.OrderServiceExtendProxy;
import com.sihui.design.patterns.proxy.staticProxy.OrderServiceImplProxy;
import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

/**
 * @ProjectName: design-patterns
 * @Package: com.sihui.design.patterns.proxy
 * @ClassName: Test
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-03-05  21:18
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) {
//        //基于静态代理的实现接口模式实现
//        OrderServiceImplProxy orderServiceProxy = new OrderServiceImplProxy(new OrderServiceImpl());
//        orderServiceProxy.addOrder();
//        //基于静态代理的继承模式实现
//        OrderServiceExtendProxy orderServiceExtendProxy = new OrderServiceExtendProxy();
//        orderServiceExtendProxy.addOrder();

        //基于JDK动态代理模式实现
//        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
//        JDKDynamicProxy jdkDynamicProxy = new JDKDynamicProxy(new OrderServiceImpl());
//        OrderServiceImpl proxy = jdkDynamicProxy.getProxy();
//        proxy.addOrder();

        //使用CGlib动态代理
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,"/Users/lixuanchen/Desktop");
        CglibDynamicProxy cglibDynamicProxy = new CglibDynamicProxy();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(OrderServiceClass.class);
        enhancer.setCallback(cglibDynamicProxy);
        OrderServiceClass orderServiceClass = (OrderServiceClass) enhancer.create();
        orderServiceClass.addOrder();
    }
}
