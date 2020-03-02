package com.sihui.demo;

import com.alibaba.fastjson.JSONObject;
import org.msgpack.MessagePack;
import org.msgpack.type.Value;

import java.io.IOException;
import java.util.UUID;

/**
 * @ProjectName: io
 * @Package: com.sihui.demo
 * @ClassName: Test002
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-03-02  20:52
 * @Version: 1.0
 */
public class Test002 {
    public static void main(String[] args) {
        MsgEntity msgEntity = new MsgEntity("context", UUID.randomUUID().toString());
        String s = JSONObject.toJSONString(msgEntity);
        System.out.println("json: " + s);
        MessagePack messagePack = new MessagePack();
        try {
            //序列化，将对象转化为字节
            byte[] write = messagePack.write(msgEntity);
            //反序列化，将字节转化成对象
            Value read = messagePack.read(write);
            System.out.println("messagePack: " + read);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
