package com.example.demo.mode.strategy.context;

import com.example.demo.mode.strategy.factory.PayStrategyFactory;
import com.example.demo.mode.strategy.service.PayStrategy;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class PayStrategyContext {

    public String toPayHtml(String payCode) {
        if (StringUtils.isEmpty(payCode)) {
            return null;
        }
        PayStrategy instance = PayStrategyFactory.getInstance(payCode);
        if (null == instance) {
            System.out.println("沒有找到對應的策略。。。");
            return null;
        }
        return instance.payHtml();
    }

}
