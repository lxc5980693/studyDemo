package com.example.demo.proxy.proxy.jdkstatic;

import com.example.demo.proxy.service.OrderService;

public class OrderServiceProxyByInterface implements OrderService {

    private OrderService orderService;

    public OrderServiceProxyByInterface(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public void order() {
        System.out.println("執行前。。。。");
        orderService.order();
        System.out.println("執行後。。。。");
    }
}
