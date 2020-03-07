package com.sihui.design.patterns.status;

import lombok.extern.slf4j.Slf4j;

/**
 * @ProjectName: design-patterns
 * @Package: com.sihui.design.patterns.status
 * @ClassName: AlreadySingedOrderStatus
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-03-07  17:08
 * @Version: 1.0
 */
@Slf4j
public class InTranitOrderStatus implements OrderStatus {
    /**
     * 每个状态下的行为返回的都不一样
     *
     * @return
     */
    @Override
    public Object orderService() {
        log.info("切换为正在运送的状态");
        return "切换为正在运送的状态";
    }
}
