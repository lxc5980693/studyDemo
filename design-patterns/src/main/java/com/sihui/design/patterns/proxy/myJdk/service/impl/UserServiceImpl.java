package com.sihui.design.patterns.proxy.myJdk.service.impl;

import com.sihui.design.patterns.proxy.myJdk.service.UserService;

/**
 * @ProjectName: design-patterns
 * @Package: com.sihui.design.patterns.proxy.myJdk.service.impl
 * @ClassName: UserServiceImpl
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-03-06  14:27
 * @Version: 1.0
 */
public class UserServiceImpl  implements UserService {
    public void addUser() {
        System.out.println("添加一个用户。。。。。");
    }
}
