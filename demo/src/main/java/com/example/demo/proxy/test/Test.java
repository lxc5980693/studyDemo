package com.example.demo.proxy.test;

import com.example.demo.proxy.proxy.dynamic.CglibProxyMethod;
import com.example.demo.proxy.proxy.dynamic.JdkDynamicProxy;
import com.example.demo.proxy.proxy.jdkstatic.OrderServiceProxyByClass;
import com.example.demo.proxy.proxy.jdkstatic.OrderServiceProxyByInterface;
import com.example.demo.proxy.service.OrderService;
import com.example.demo.proxy.service.impl.OrderServiceImpl;
import net.sf.cglib.proxy.Enhancer;

public class Test {
    public static void main(String[] args) {
        //靜態代理（實現接口模式）
//        OrderServiceProxyByInterface orderServiceProxyByInterface = new OrderServiceProxyByInterface(new OrderServiceImpl());
//        orderServiceProxyByInterface.order();
        //靜態代理（繼承類模式）
//        OrderServiceProxyByClass orderServiceProxyByClass = new OrderServiceProxyByClass();
//        orderServiceProxyByClass.order();

        //jdk動態代理
        System.getProperties().setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        OrderService proxy = new JdkDynamicProxy(new OrderServiceImpl()).getProxy();
        proxy.order();

        //cglib動態代理
//        CglibProxyMethod cglibProxyMethod = new CglibProxyMethod();
//        Enhancer enhancer = new Enhancer();
//        enhancer.setSuperclass(OrderServiceImpl.class);
//        enhancer.setCallback(cglibProxyMethod);
//        OrderServiceImpl o = (OrderServiceImpl) enhancer.create();
//        o.order();
    }
}
