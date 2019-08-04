package com.example.demo.factory;

import com.example.demo.mapper.HandleMapper;
import com.example.demo.model.Handle;
import com.example.demo.service.GetWayHandle;
import com.example.demo.service.impl.handle.AccountVerificationHandle;
import com.example.demo.service.impl.handle.BlackListVerificationHandle;
import com.example.demo.service.impl.handle.PermissionVerificationHandle;
import com.example.demo.util.SpringUtils;
import org.springframework.beans.factory.annotation.Autowired;

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
