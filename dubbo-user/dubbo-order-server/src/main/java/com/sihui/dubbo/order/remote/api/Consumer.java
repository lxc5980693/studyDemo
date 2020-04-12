package com.sihui.dubbo.order.remote.api;

import com.sihui.api.dto.UserEntity;
import com.sihui.api.service.UserService;
import com.sihui.dubbo.server.proxy.RpcClientProxy;

/**
 * @ProjectName: dubbouser
 * @Package: com.sihui.dubbo.order.remote.api
 * @ClassName: Consumer
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-04-12  19:19
 * @Version: 1.0
 */
public class Consumer {
    public static void main(String[] args) {
        UserService proxy = new RpcClientProxy().createProxy(UserService.class);
        UserEntity user = proxy.getUser("1");
        System.out.println(user);
    }
}
