package com.sihui.design.patterns.status;

import com.sihui.design.patterns.status.context.StatusContext;

/**
 * @ProjectName: design-patterns
 * @Package: com.sihui.design.patterns.status
 * @ClassName: Test
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-03-07  17:22
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        StatusContext statusContext = new StatusContext(new AlreadySingedOrderStatus());
        statusContext.switchOrderStatus();
    }
}
