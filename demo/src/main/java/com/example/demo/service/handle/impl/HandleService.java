package com.example.demo.service.handle.impl;

import com.example.demo.mapper.HandleMapper;
import com.example.demo.model.Handle;
import com.example.demo.service.handle.GetWayHandle;
import com.example.demo.util.SpringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class HandleService {

    @Autowired
    private HandleMapper handleMapper;

    public GetWayHandle getFirstHandle() {
        //獲取第一個handle對象
        Handle firstHandle = handleMapper.seletFirstHandle();
        if (firstHandle == null || StringUtils.isEmpty(firstHandle.getHandleId())) {
            return null;
        }
        GetWayHandle firstGetWayHandle = SpringUtils.getBean(firstHandle.getHandleId(), GetWayHandle.class);
        if (firstGetWayHandle == null) {
            return null;
        }
        GetWayHandle tempGetWayHandle = firstGetWayHandle;
        String nextHandleId = firstHandle.getNextHandleId();
        while (!StringUtils.isEmpty(nextHandleId)) {
            Handle nextHandle = handleMapper.seletByHandleId(nextHandleId);
            if (nextHandle == null || StringUtils.isEmpty(nextHandle.getHandleId())) {
                break;
            }

            GetWayHandle nextGetWayHandle = SpringUtils.getBean(nextHandle.getHandleId(), GetWayHandle.class);
            if (null == nextGetWayHandle) {
                break;
            }
            nextHandleId = nextHandle.getNextHandleId();

            tempGetWayHandle.setNextGetWayHandle(nextGetWayHandle);
            tempGetWayHandle = nextGetWayHandle;
        }
        return firstGetWayHandle;
    }
}
