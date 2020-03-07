package com.sihui.design.patterns.observer.myobserver.concrete;

import com.sihui.design.patterns.observer.myobserver.ObServer;
import com.sihui.design.patterns.observer.myobserver.SubjectInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: design-patterns
 * @Package: com.sihui.design.patterns.observer.myobserver.concrete
 * @ClassName: WeChatSubject
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-03-07  15:09
 * @Version: 1.0
 */
public class WeChatSubject implements SubjectInterface {

    private List<ObServer> obServers = new ArrayList<ObServer>();

    //设置的消息
    private String message;

    /**
     * @param obServer
     * @Author lixuanchen
     * @Version 1.0
     * @Description 添加观察者 注册订阅者
     * @Return void
     * @Exception
     * @Date 2020-03-07  15:05
     */
    @Override
    public void addObServer(ObServer obServer) {
        //注册 、添加观察者
        obServers.add(obServer);
    }

    /**
     * @param obServer
     * @Author lixuanchen
     * @Version 1.0
     * @Description 移除观察者 注册订阅者
     * @Return void
     * @Exception
     * @Date 2020-03-07  15:05
     */
    @Override
    public void removeObServer(ObServer obServer) {
        obServers.remove(obServer);
    }

    /**
     * @Author lixuanchen
     * @Version 1.0
     * @Description 通知观察者
     * @Return void
     * @Exception
     * @Date 2020-03-07  15:05
     */
    @Override
    public void notifyObServers(String message) {
        //调用观察者通知方法
        for (ObServer obServer : obServers){
            //调用该方法群发消息
            obServer.update(message);
        }
    }
}
