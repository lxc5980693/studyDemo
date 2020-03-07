package com.sihui.design.patterns.observer.jdkobserver;

import com.sihui.design.patterns.observer.jdkobserver.observable.MessageObServable;
import com.sihui.design.patterns.observer.jdkobserver.observer.MailObServer;
import com.sihui.design.patterns.observer.jdkobserver.observer.SmsObServer;
import com.sihui.design.patterns.observer.jdkobserver.observer.WeChatObServer;

import java.util.Observable;

/**
 * @ProjectName: design-patterns
 * @Package: com.sihui.design.patterns.observer.jdkobserver
 * @ClassName: TestJdkObServer
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-03-07  15:39
 * @Version: 1.0
 */
public class TestJdkObServer {
    public static void main(String[] args) {
        /**
         * 用户下单的流程 添加订单、发送短信、发送邮件、发送微信模版通知
         */
        //创建具体主题
        Observable obServable = new MessageObServable();
        //创建并添加观察者
        obServable.addObserver(new SmsObServer());
        obServable.addObserver(new MailObServer());
        obServable.addObserver(new WeChatObServer());
        //群发消息
        obServable.notifyObservers("恭喜用户李呱呱入驻我们的思慧教育！！！");
    }
}
