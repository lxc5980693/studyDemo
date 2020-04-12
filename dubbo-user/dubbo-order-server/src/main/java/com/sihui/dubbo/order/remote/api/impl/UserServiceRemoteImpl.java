package com.sihui.dubbo.order.remote.api.impl;

import com.sihui.api.dto.UserEntity;
import com.sihui.api.service.UserService;
import com.sihui.dubbo.order.remote.api.UserRemoteService;
import com.sihui.dubbo.server.proxy.RpcClientProxy;

/**
 * @ProjectName: dubbouser
 * @Package: com.sihui.dubbo.order.remote.api.impl
 * @ClassName: UserServiceImpl
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-04-06  18:53
 * @Version: 1.0
 */
public class UserServiceRemoteImpl implements UserRemoteService {

    private UserService userService;

    public UserEntity getUser(Long id) {
        UserEntity user = userService.getUser(String.valueOf(id));
        return null;
    }
}
