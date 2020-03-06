package com.sihui.design.patterns.proxy.staticProxy;

import com.sihui.design.patterns.proxy.service.OrderService;
import com.sihui.design.patterns.proxy.service.impl.OrderServiceImpl;

/**
 * @ProjectName: design-patterns
 * @Package: com.sihui.design.patterns.proxy.staticProxy
 * @ClassName: OrderServiceProxy
 * @Author: lixuanchen
 * @Description: 静态代理通过继承实现类实现
 * @Date: 2020-03-05  21:17
 * @Version: 1.0
 */
public class OrderServiceExtendProxy extends OrderServiceImpl {

    @Override
    public void addOrder() {
        System.out.println("我是orderServiceImpl的代理类。。。。。之前执行的方法");
        super.addOrder();
        System.out.println("我是orderServiceImpl的代理类。。。。。之后执行的方法");
    }
}
