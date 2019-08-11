package com.example.demo.proxy.proxy.jdkstatic;

import com.example.demo.proxy.service.impl.OrderServiceImpl;

public class OrderServiceProxyByClass extends OrderServiceImpl {

    @Override
    public void order() {
        System.out.println("執行前。。。。");
        super.order();
        System.out.println("執行後。。。。");
    }
}
