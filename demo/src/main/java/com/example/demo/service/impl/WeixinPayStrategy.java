package com.example.demo.service.impl;

import com.example.demo.service.PayStrategy;
import org.springframework.stereotype.Component;

@Component
public class WeixinPayStrategy implements PayStrategy {
    @Override
    public String payHtml() {
        return "微信支付。。。WeixinPayStrategy";
    }
}
