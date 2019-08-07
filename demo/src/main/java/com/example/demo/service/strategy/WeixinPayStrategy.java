package com.example.demo.service.strategy;

import com.example.demo.service.strategy.impl.PayStrategy;
import org.springframework.stereotype.Component;

@Component
public class WeixinPayStrategy implements PayStrategy {
    @Override
    public String payHtml() {
        return "微信支付。。。WeixinPayStrategy";
    }
}
