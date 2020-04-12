package com.sihui.api;

import com.sihui.api.impl.UserServiceImpl;
import com.sihui.dubbo.server.rpc.RpcServer;

/**
 * @ProjectName: dubbouser
 * @Package: com.sihui.api
 * @ClassName: Test
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-04-12  18:04
 * @Version: 1.0
 */
public class UserProductor {
    public static void main(String[] args) throws Exception {
        RpcServer rpcServer = new RpcServer("127.0.0.1", 8089);
        rpcServer.start(new UserServiceImpl());
    }
}
