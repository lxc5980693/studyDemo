package com.example.demo.service.handle.impl;

import com.example.demo.service.handle.GetWayHandle;
import org.springframework.stereotype.Component;

@Component
public class AccountVerificationHandle extends GetWayHandle {

    @Override
    public void handleMethod() {
        System.out.println("第一關：賬號校驗。。。AccountVerificationHandle");
        nextHandleMethod();
    }
}
