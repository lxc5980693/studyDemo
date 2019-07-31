package com.example.demo.mode.strategy.mapper;

import com.example.demo.mode.strategy.model.Strategy;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StrategyMapper {

    Strategy selectByStrategyName(@Param("strategyName") String strategyName);
}
