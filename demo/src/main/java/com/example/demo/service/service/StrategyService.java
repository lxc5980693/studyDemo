package com.example.demo.service.service;

import com.example.demo.model.Strategy;

/**
 * (Strategy)表服务接口
 *
 * @author makejava
 * @since 2020-08-13 15:52:20
 */
public interface StrategyService {

    /**
     * 新增数据
     *
     * @param strategy 实例对象
     * @return 实例对象
     */
    Strategy insert(Strategy strategy);

}