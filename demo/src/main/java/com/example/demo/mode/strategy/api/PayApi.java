package com.example.demo.mode.strategy.api;

import com.example.demo.mode.strategy.context.PayStrategyContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PayApi {

    @Autowired
    private PayStrategyContext payStrategyContext;

    @RequestMapping(value = "/pay",method = RequestMethod.GET)
    public String pay(String payCode){
       return payStrategyContext.toPayHtml(payCode);
    }

}
