package com.sihui.design.patterns.proxy.myJdk.impl;import java.lang.reflect.Method;import com.sihui.design.patterns.proxy.myJdk.MyExtJdkInvocationHandler;public class $Proxy0 implements com.sihui.design.patterns.proxy.myJdk.service.UserService {    private MyExtJdkInvocationHandler h;    public $Proxy0(MyExtJdkInvocationHandler h) {        this.h = h;    }    public void addUser() throws Throwable {        Method method = com.sihui.design.patterns.proxy.myJdk.service.UserService.class.getMethod("addUser", new Class[]{});        this.h.invoke(this, method, null);    }}