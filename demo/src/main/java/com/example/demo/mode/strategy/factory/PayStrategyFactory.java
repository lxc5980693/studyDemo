package com.example.demo.mode.strategy.factory;

import com.example.demo.mode.strategy.Enum.PayStrategyEnum;
import com.example.demo.mode.strategy.service.PayStrategy;
import org.springframework.util.StringUtils;

public class PayStrategyFactory {

    public static PayStrategy getInstance(String payCode) {
        if (StringUtils.isEmpty(payCode)) {
            return null;
        }
        String path = PayStrategyEnum.valueOf(payCode).getPath();
        if (StringUtils.isEmpty(path)) {
            System.out.println("不存在该类");
            return null;
        }
        try {
            Class<?> aClass = Class.forName(path);
            PayStrategy payStrategy = (PayStrategy) aClass.newInstance();
            return payStrategy;
        } catch (Exception e) {
            return null;
        }
    }
}
