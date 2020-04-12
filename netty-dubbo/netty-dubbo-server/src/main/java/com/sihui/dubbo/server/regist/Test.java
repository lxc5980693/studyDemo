package com.sihui.dubbo.server.regist;

import com.sihui.dubbo.server.regist.impl.ServiceRegisterImpl;

/**
 * @ProjectName: netty-dubbo
 * @Package: com.sihui.dubbo.server.regist
 * @ClassName: Test
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-03-02  22:14
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        ServiceRegister serviceRegister = new ServiceRegisterImpl();
        String siHuiRpcAddress = "sihui://192.168.0.103:8081/com.sihui.api.service.UserService getUser";
        serviceRegister.regist("com.sihui.api.service.UserService",siHuiRpcAddress);

        //UserService中会存在多个方法，发布几个地址？
        /**
         * dubbo中一个接口存在多个方法，只会生成一个provider：suhui://192.168.0.103:8081/
         * com.sihui.api.service.UserService getUser delUser
         */
    }
}
