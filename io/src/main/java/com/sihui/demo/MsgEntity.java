package com.sihui.demo;

import org.msgpack.annotation.Message;

/**
 * @ProjectName: io
 * @Package: com.sihui.demo
 * @ClassName: MsgEntity
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-03-02  18:01
 * @Version: 1.0
 */
@Message
public class MsgEntity {
    private String messageContext;
    private String msgId;

    public MsgEntity() {

    }

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

    public String getMessageContext() {
        return messageContext;
    }

    public void setMessageContext(String messageContext) {
        this.messageContext = messageContext;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }
}
