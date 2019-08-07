package com.example.demo.service.handle.impl;

import com.example.demo.service.handle.GetWayHandle;
import org.springframework.stereotype.Component;

@Component
public class BlackListVerificationHandle extends GetWayHandle {

    @Override
    public void handleMethod() {
        System.out.println("第二關：黑名單校驗。。。BlackListVerificationHandle");
        nextHandleMethod();
    }
}
