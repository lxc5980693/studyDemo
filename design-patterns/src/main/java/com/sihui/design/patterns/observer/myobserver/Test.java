package com.sihui.design.patterns.observer.myobserver;

import com.sihui.design.patterns.observer.myobserver.concrete.UserObServer;
import com.sihui.design.patterns.observer.myobserver.concrete.WeChatSubject;

/**
 * @ProjectName: design-patterns
 * @Package: com.sihui.design.patterns.observer
 * @ClassName: Test
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-03-07  15:17
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        //创建一个具体的主题
        WeChatSubject weChatSubject = new WeChatSubject();
        //
        weChatSubject.addObServer(new UserObServer("李呱呱"));
        weChatSubject.addObServer(new UserObServer("程壮壮"));
        weChatSubject.notifyObServers("思慧教育开课啦！！！！！");
    }
}
