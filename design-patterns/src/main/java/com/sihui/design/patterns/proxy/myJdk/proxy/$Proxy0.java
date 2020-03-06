package com.sihui.design.patterns.proxy.myJdk.proxy;

import com.sihui.design.patterns.proxy.myJdk.MyExtJdkInvocationHandler;
import com.sihui.design.patterns.proxy.myJdk.service.UserService;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ProjectName: design-patterns
 * @Package: com.sihui.design.patterns.proxy.myJdk.proxy
 * @ClassName: $Proxy0
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-03-06  14:35
 * @Version: 1.0
 */
public class $Proxy0 implements UserService {

    private MyExtJdkInvocationHandler h;

    public $Proxy0(MyExtJdkInvocationHandler h){
        this.h = h;
    }


    public void addUser() throws Throwable {
        Method addUser = UserService.class.getMethod("addUser", new Class[]{});
        this.h.invoke(this,addUser,null);
    }
}
