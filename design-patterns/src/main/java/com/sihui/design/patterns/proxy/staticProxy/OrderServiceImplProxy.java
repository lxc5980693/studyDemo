package com.sihui.design.patterns.proxy.staticProxy;

import com.sihui.design.patterns.proxy.service.OrderService;

/**
 * @ProjectName: design-patterns
 * @Package: com.sihui.design.patterns.proxy.staticProxy
 * @ClassName: OrderServiceProxy
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-03-05  21:17
 * @Version: 1.0
 */
public class OrderServiceImplProxy implements OrderService {

    /**
     * 被代理类
     */
    private OrderService orderService;

    public OrderServiceImplProxy(OrderService orderService){
        this.orderService = orderService;
    }

    public void addOrder() {
        System.out.println("我是orderServiceImpl的代理类。。。。。之前执行的方法");
        orderService.addOrder();
        System.out.println("我是orderServiceImpl的代理类。。。。。之后执行的方法");
    }
}
