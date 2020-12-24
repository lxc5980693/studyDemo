package com.example.demo.service.service.impl;

import com.example.demo.cache.CacheService;
import com.example.demo.mapper.HandleMapper;
import com.example.demo.mapper.StrategyMapper;
import com.example.demo.model.Handle;
import com.example.demo.model.Strategy;
import com.example.demo.service.AfterCommitExector;
import com.example.demo.service.service.StrategyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
@Slf4j
public class StrategyServiceImpl implements StrategyService {
    @Resource
    private StrategyMapper strategyDao;

    @Resource
    private HandleMapper handleMapper;

    @Resource
    @Qualifier("afterCommitExectorImpl")
    private AfterCommitExector afterCommitExector;

    /**
     * 新增数据
     *
     * @param strategy 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional(timeout = 3,rollbackFor = Exception.class)
    public Strategy insert(Strategy strategy) {
        strategy.setStrategyName("strategy_liguagua");
        strategy.setClassPath("qqqqq");

        Handle handle = new Handle();
        handle.setHandleId("qweqweq");
        handle.setHandleName("handle_liguagua");
        handle.setNextHandleId("qwertyu");
        handle.setPrevHandleId("iuyyuiokjnj");
        this.handleMapper.insert(handle);
        log.info("StrategyService -> insert Handle:{}",handle.getHandleName());

        afterCommitExector.submitTask(()->{
            log.info("one after transaction exect");
        });

        this.strategyDao.insert(strategy);
        log.info("StrategyService -> insert strategy:{}",strategy.getStrategyName());

        return strategy;
    }
}