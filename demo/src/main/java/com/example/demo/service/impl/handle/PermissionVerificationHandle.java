package com.example.demo.service.impl.handle;

import com.example.demo.service.GetWayHandle;
import org.springframework.stereotype.Component;

@Component
public class PermissionVerificationHandle extends GetWayHandle {
    @Override
    public void handleMethod() {
        System.out.println("第三關：權限校驗。。。PermissionVerificationHandle");
    }
}
