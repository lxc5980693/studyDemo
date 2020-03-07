package com.sihui.design.patterns.observer.myobserver.concrete;

import com.sihui.design.patterns.observer.myobserver.ObServer;

/**
 * @ProjectName: design-patterns
 * @Package: com.sihui.design.patterns.observer.myobserver.concrete
 * @ClassName: UserObServer
 * @Author: lixuanchen
 * @Description: 具体的用户观察者
 * @Date: 2020-03-07  15:15
 * @Version: 1.0
 */
public class UserObServer implements ObServer {

    private String name;

    public UserObServer(String name) {
        this.name = name;
    }

    /**
     * @param message
     * @Author lixuanchen
     * @Version 1.0
     * @Description 主题发送消息方法
     * @Return void
     * @Exception
     * @Date 2020-03-07  15:03
     */
    @Override
    public void update(String message) {
        System.out.println(name + "收到消息：" + message);
    }
}
