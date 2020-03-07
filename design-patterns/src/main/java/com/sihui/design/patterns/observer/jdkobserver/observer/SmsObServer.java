package com.sihui.design.patterns.observer.jdkobserver.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @ProjectName: design-patterns
 * @Package: com.sihui.design.patterns.observer.jdkobserver.observer
 * @ClassName: SmsObServer
 * @Author: lixuanchen
 * @Description: 短信发送观察者
 * @Date: 2020-03-07  15:35
 * @Version: 1.0
 */
public class SmsObServer implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("用户下单成功，发送短信消息内容：" + arg);
    }
}
