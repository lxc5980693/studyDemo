package com.sihui.design.patterns.status;

import java.util.Objects;

/**
 * @ProjectName: design-patterns
 * @Package: com.sihui.design.patterns.status
 * @ClassName: OrderStatus
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-03-07  17:06
 * @Version: 1.0
 */
public interface OrderStatus {

    /**
     * 每个状态下的行为返回的都不一样
     * @return
     */
    public Object orderService();
}
