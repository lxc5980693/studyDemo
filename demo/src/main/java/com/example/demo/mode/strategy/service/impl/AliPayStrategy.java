package com.example.demo.mode.strategy.service.impl;

import com.example.demo.mode.strategy.service.PayStrategy;
import org.springframework.stereotype.Component;

@Component
public class AliPayStrategy implements PayStrategy {

    @Override
    public String payHtml() {
        return "支付宝支付。。。AliPayStrategy";
    }
}
