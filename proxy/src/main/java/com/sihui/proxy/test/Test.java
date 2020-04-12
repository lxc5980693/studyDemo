package com.sihui.proxy.test;

import com.sihui.proxy.entity.User;
import com.sihui.proxy.proxy.DynamicProxy;
import com.sihui.proxy.proxy.UserStaticProxy;
import com.sihui.proxy.service.UserService;
import com.sihui.proxy.service.impl.UserServiceImpl;

/**
 * @ProjectName: proxy
 * @Package: com.sihui.proxy.test
 * @ClassName: Test
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2019-12-09  16:03
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        /**
         * 静态代理
         * 缺点：得为每一个接口服务手动创建一个代理类，工作量大
         */
        UserStaticProxy userProxy = new UserStaticProxy(new UserServiceImpl());
        userProxy.getUser();

        /**
         * 动态代理
         * 1、保存生成的代理类的字节码文件
         * 2、创建代理类
         */
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        UserService userService = new DynamicProxy(new UserServiceImpl()).getProxy();
        User user = userService.getUser();
        System.out.println("result:" + user.toString());
    }
}
