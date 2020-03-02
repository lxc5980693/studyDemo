package com.sihui.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

/**
 * @ProjectName: io
 * @Package: com.sihui.demo
 * @ClassName: Test01
 * @Author: lixuanchen
 * @Description: 序列化和反序列化的过程
 * @Date: 2020-03-02  17:51
 * @Version: 1.0
 */
public class Test01 {
    public static void main(String[] args) {
        String fileName = "/Users/lixuanchen/Desktop/msg";
        try {
            serialize(fileName);
            deserialize(fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void deserialize(String fileName) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName));
        String o = (String) objectInputStream.readObject();
        Date date = (Date) objectInputStream.readObject();
        MsgEntity msgEntity = (MsgEntity) objectInputStream.readObject();
        System.out.println(o);
        System.out.println(date);
        System.out.println(msgEntity.toString());
        objectInputStream.close();

    }

    private static void serialize(String fileName) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));
        objectOutputStream.writeObject("序列化的日期是：");
        objectOutputStream.writeObject(new Date());
        MsgEntity lixuanchen = new MsgEntity("李呱呱是个牛逼的人", "222");
        objectOutputStream.writeObject(lixuanchen);
        objectOutputStream.close();
    }
}
