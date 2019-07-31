package com.example.demo.mode.strategy.factory;

import com.example.demo.mode.strategy.mapper.StrategyMapper;
import com.example.demo.mode.strategy.model.Strategy;
import com.example.demo.mode.strategy.service.PayStrategy;
import com.example.demo.mode.strategy.utils.SpringUtils;
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
//        String path = PayStrategyEnum.valueOf(payCode).getPath();
        Strategy strategyDO = strategyMapper.selectByStrategyName(payCode);
        if (null == strategyDO) {
            System.out.println("不存在该策略类");
            return null;
        }
        try {
//            Class<?> aClass = Class.forName(path);
//            PayStrategy payStrategy = (PayStrategy) aClass.newInstance();
            PayStrategy bean = (PayStrategy)SpringUtils.getBean(strategyDO.getClassPath());
            return bean;
        } catch (Exception e) {
            return null;
        }
    }
}
