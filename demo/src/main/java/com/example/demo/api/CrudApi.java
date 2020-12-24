package com.example.demo.api;

import com.example.demo.cache.AuctionCacheCallBack;
import com.example.demo.cache.CacheService;
import com.example.demo.model.Strategy;
import com.example.demo.service.service.StrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CrudApi {

    @Autowired
    private StrategyService strategyService;

    @Autowired
    private CacheService cacheService;

    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public String insert(String payCode) {
        strategyService.insert(new Strategy());
        return "success";
    }

    @RequestMapping(value = "/setCache", method = RequestMethod.GET)
    public String setCache(String payCode) {
        cacheService.setCache("lixuanchen", new AuctionCacheCallBack<String, String>() {
            @Override
            public String execte(String input) {
                return "qwertyuytrewq";
            }
        });
        return "success";
    }
}
