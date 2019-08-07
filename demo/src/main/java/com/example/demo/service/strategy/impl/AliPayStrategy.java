package com.example.demo.service.strategy.impl;

import org.springframework.stereotype.Component;

@Component
public class AliPayStrategy implements PayStrategy {

    @Override
    public String payHtml() {
        return "支付宝支付。。。AliPayStrategy";
    }
}
