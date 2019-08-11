package com.example.demo.proxy.service.impl;

import com.example.demo.proxy.service.OrderService;

public class OrderServiceImpl implements OrderService {

    @Override
    public void order() {
        System.out.println("執行order方法。。。");
    }
}
