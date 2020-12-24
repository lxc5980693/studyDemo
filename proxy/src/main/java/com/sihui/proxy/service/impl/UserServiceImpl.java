package com.sihui.proxy.service.impl;

import com.sihui.proxy.entity.User;
import com.sihui.proxy.service.UserService;

import java.util.List;

/**
 * @ProjectName: proxy
 * @Package: com.sihui.proxy.service.impl
 * @ClassName: UserServiceImpl
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2019-12-09  15:56
 * @Version: 1.0
 */
public class UserServiceImpl implements UserService {
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
        User user = new User("李小花", 25, "津巴布韦");
        System.out.println(user.toString());
        return user;
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
    public List<User> getAllUser() {
        return null;
    }
}
