package com.sihui.design.patterns.observer.spring.listen;

import com.sihui.design.patterns.observer.spring.event.OrderMessageEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: design-patterns
 * @Package: com.sihui.design.patterns.observer.spring.listen
 * @ClassName: SmsListener
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-03-07  16:08
 * @Version: 1.0
 */
@Component
public class WechatListener implements ApplicationListener<OrderMessageEvent> {

    @Override
    @Async
    public void onApplicationEvent(OrderMessageEvent orderMessageEvent) {
        System.out.println(Thread.currentThread().getName() + "发送用户下单的微信消息内容：" + orderMessageEvent.getJsonObject().toJSONString());
    }
}
