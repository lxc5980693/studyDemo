package com.sihui.design.patterns.observer.spring.event;

import com.alibaba.fastjson.JSONObject;
import org.springframework.context.ApplicationEvent;

/**
 * @ProjectName: design-patterns
 * @Package: com.sihui.design.patterns.observer.spring
 * @ClassName: OrderMessageEvent
 * @Author: lixuanchen
 * @Description: 群发消息作为一个事件
 * @Date: 2020-03-07  15:53
 * @Version: 1.0
 */
public class OrderMessageEvent extends ApplicationEvent {

    /**
     * 群发消息内容
     */
    private JSONObject jsonObject;

    public OrderMessageEvent(Object source, JSONObject jsonObject) {
        super(source);
        this.jsonObject = jsonObject;
    }

    public void setJsonObject(JSONObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    public JSONObject getJsonObject() {
        return jsonObject;
    }

}
