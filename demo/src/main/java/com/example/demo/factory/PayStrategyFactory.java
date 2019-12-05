package com.example.demo.factory;

import com.example.demo.Enum.PayStrategyEnum;
import com.example.demo.mapper.StrategyMapper;
import com.example.demo.model.Strategy;
import com.example.demo.service.strategy.impl.PayStrategy;
import com.example.demo.util.SpringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class PayStrategyFactory {

    @Autowired
    private StrategyMapper strategyMapper;

    public PayStrategy getInstance(String payCode) {
        if (StringUtils.isEmpty(payCode)) {
            return null;
        }
        String path = PayStrategyEnum.valueOf(payCode).getPath();
//        Strategy strategy = strategyMapper.selectByName(payCode);
//        if (null == strategy) {
//            System.out.println("不存在该策略类");
//            return null;
//        }
        try {
            Class<?> aClass = Class.forName(path);
            PayStrategy payStrategy = (PayStrategy) aClass.newInstance();
//            PayStrategy bean = (PayStrategy)SpringUtils.getBean(strategy.getClassPath());
            return payStrategy;
        } catch (Exception e) {
            return null;
        }
    }
}
