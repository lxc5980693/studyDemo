package com.example.demo.factory;

import com.example.demo.service.handle.impl.AccountVerificationHandle;
import com.example.demo.service.handle.impl.BlackListVerificationHandle;
import com.example.demo.service.handle.impl.PermissionVerificationHandle;

public class HandleFactory {

    public static AccountVerificationHandle getFirstHandle(){
        //獲取第一個handle對象
        AccountVerificationHandle accountVerificationHandle = new AccountVerificationHandle();
        BlackListVerificationHandle blackListVerificationHandle = new BlackListVerificationHandle();
        accountVerificationHandle.setNextGetWayHandle(blackListVerificationHandle);
        PermissionVerificationHandle permissionVerificationHandle = new PermissionVerificationHandle();
        blackListVerificationHandle.setNextGetWayHandle(permissionVerificationHandle);
        return accountVerificationHandle;
    }
}
