package com.example.demo.service.service.impl;

import com.example.demo.mapper.HandleMapper;
import com.example.demo.mapper.StrategyMapper;
import com.example.demo.model.Handle;
import com.example.demo.model.Strategy;
import com.example.demo.service.service.StrategyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * (Strategy)表服务实现类
 *
 * @author makejava
 * @since 2020-08-13 15:52:21
 */
@Service("strategyService")
public class StrategyServiceImpl implements StrategyService {
    @Resource
    private StrategyMapper strategyDao;

    @Resource
    private HandleMapper handleMapper;

    /**
     * 新增数据
     *
     * @param strategy 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional(timeout = 3,rollbackFor = Exception.class)
    public Strategy insert(Strategy strategy) {
        try {
            Thread.sleep(2900);
        } catch (InterruptedException e) {
        }
        strategy.setStrategyName("ttttt");
        strategy.setClassPath("qqqqq");

        Handle handle = new Handle();
        handle.setHandleId("qweqweq");
        handle.setHandleName("asdfgh");
        handle.setNextHandleId("qwertyu");
        handle.setPrevHandleId("iuyyuiokjnj");
        this.handleMapper.insert(handle);

        this.strategyDao.insert(strategy);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }

        System.out.println("12345676543456765432");
        return strategy;
    }
}