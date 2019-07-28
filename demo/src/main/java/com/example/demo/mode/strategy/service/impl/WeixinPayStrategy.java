package com.example.demo.mode.strategy.service.impl;

import com.example.demo.mode.strategy.service.PayStrategy;
import org.springframework.stereotype.Component;

@Component
public class WeixinPayStrategy implements PayStrategy {
    @Override
    public String payHtml() {
        return "微信支付。。。WeixinPayStrategy";
    }
}
