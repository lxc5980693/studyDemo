package com.sihui.design.patterns.observer.controller;

import com.alibaba.fastjson.JSONObject;
import com.sihui.design.patterns.observer.spring.event.OrderMessageEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ProjectName: design-patterns
 * @Package: com.sihui.design.patterns.observer.controller
 * @ClassName: OrderController
 * @Author: lixuanchen
 * @Description: 观察者模式
 * @Date: 2020-03-07  16:10
 * @Version: 1.0
 */
@RestController
public class OrderController {
    @Autowired
    private ApplicationContext applicationContext;

    @RequestMapping("/addOrder")
    public String sendMessage() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "李呱呱");
        jsonObject.put("age", 12);
        jsonObject.put("price", 1399);
        OrderMessageEvent orderMessageEvent = new OrderMessageEvent(this,jsonObject);
        applicationContext.publishEvent(orderMessageEvent);
        return "success";
    }
}
