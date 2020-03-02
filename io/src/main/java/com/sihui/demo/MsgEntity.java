package com.sihui.demo;

import java.io.Serializable;

/**
 * @ProjectName: io
 * @Package: com.sihui.demo
 * @ClassName: MsgEntity
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-03-02  18:01
 * @Version: 1.0
 */
public class MsgEntity implements Serializable {
    private String messageContext;
    private transient String msgId;

    public MsgEntity(String messageContext, String msgId) {
        this.messageContext = messageContext;
        this.msgId = msgId;
    }

    @Override
    public String toString() {
        return "MsgEntity{" +
                "messageContext='" + messageContext + '\'' +
                ", msgId='" + msgId + '\'' +
                '}';
    }
}
