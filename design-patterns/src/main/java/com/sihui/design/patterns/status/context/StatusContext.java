package com.sihui.design.patterns.status.context;

import com.sihui.design.patterns.status.OrderStatus;

/**
 * @ProjectName: design-patterns
 * @Package: com.sihui.design.patterns.status.context
 * @ClassName: StatusContext
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-03-07  17:14
 * @Version: 1.0
 */
public class StatusContext {
    private OrderStatus orderStatus;

    public StatusContext(OrderStatus orderStatus){
        this.orderStatus = orderStatus;
    }

    public void switchOrderStatus(){
        orderStatus.orderService();
    }
}
