package com.example.demo.service.template.impl;

import com.example.demo.service.template.PayTemplate;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: demo
 * @Package: com.example.demo.service.template.impl
 * @ClassName: WeixinPayImpl
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2019-08-06  16:29
 * @Version: 1.0
 */
@Component
public class WeixinPayImpl extends PayTemplate {
    @Override
    public void beforeMethod() {
        System.out.println("before method process ...");
    }

    @Override
    public void afterMethod() {
        System.out.println("after method process ...");
    }
}
