package com.example.demo.context;

import com.example.demo.factory.PayStrategyFactory;
import com.example.demo.service.strategy.impl.PayStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class PayStrategyContext {

    @Autowired
    private PayStrategyFactory payStrategyFactory;

    public String toPayHtml(String payCode) {
        if (StringUtils.isEmpty(payCode)) {
            return null;
        }
        PayStrategy instance = payStrategyFactory.getInstance(payCode);
        if (null == instance) {
            System.out.println("沒有找到對應的策略。。。");
            return null;
        }
        return instance.payHtml();
    }

}
