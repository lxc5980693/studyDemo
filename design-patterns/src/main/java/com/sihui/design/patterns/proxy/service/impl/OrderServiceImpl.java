package com.sihui.design.patterns.proxy.service.impl;

import com.sihui.design.patterns.proxy.service.OrderService;

/**
 * @ProjectName: design-patterns
 * @Package: com.sihui.design.patterns.proxy.service.impl
 * @ClassName: OrderServiceImpl
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-03-05  21:18
 * @Version: 1.0
 */
public class OrderServiceImpl implements OrderService {

    public void addOrder() {
        System.out.println("我是OrderService的业务实现类。。。。");
    }
}
