package com.sihui.design.patterns.proxy.myJdk;

import com.sihui.design.patterns.proxy.myJdk.impl.MyJdkInvocationHandler;
import com.sihui.design.patterns.proxy.myJdk.proxy.$Proxy0;
import com.sihui.design.patterns.proxy.myJdk.service.UserService;
import com.sihui.design.patterns.proxy.myJdk.service.impl.UserServiceImpl;

/**
 * @ProjectName: design-patterns
 * @Package: com.sihui.design.patterns.proxy.myJdk
 * @ClassName: Test
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-03-06  14:42
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) throws Throwable {
        UserService $Proxy0 = (UserService) new $Proxy0(new MyJdkInvocationHandler(new UserServiceImpl()));
        $Proxy0.addUser();
    }
}
