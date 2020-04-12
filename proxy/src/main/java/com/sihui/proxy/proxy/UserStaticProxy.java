package com.sihui.proxy.proxy;

import com.sihui.proxy.entity.User;
import com.sihui.proxy.service.UserService;

/**
 * @ProjectName: proxy
 * @Package: com.sihui.proxy.proxy
 * @ClassName: UserProxy
 * @Author: lixuanchen
 * @Description: 静态代理类
 * @Date: 2019-12-09  16:00
 * @Version: 1.0
 */
public class UserStaticProxy implements UserService {

    private UserService target;

    public UserStaticProxy(UserService object){
        this.target = object;
    }

    /**
     * @Author lixuanchen
     * @Version 1.0
     * @Description 获取用户信息
     * @Return com.sihui.proxy.entity.User
     * @Exception
     * @Date 2019-12-09  15:56
     */
    @Override
    public User getUser() {
        System.out.println("UserStaticProxy 执行前。。。。");
        User user = target.getUser();
        System.out.println("UserStaticProxy 执行后。。。。");
        return user;
    }
}
