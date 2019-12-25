package com.sihui.demo.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ProjectName: mybatis-plus-demo
 * @Package: com.sihui.mybatisplusdemo.bio
 * @ClassName: Server
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2019-12-20  15:02
 * @Version: 1.0
 */
public class Server {

    private static final int DEFAULT_PORT = 12345;
    private static ServerSocket serverSocket;
    private static byte[] BYTES = new byte[100];

    public static void main(String[] args) {
        try {
            serverSocket = new ServerSocket(DEFAULT_PORT);
            System.out.println("开始接收客户端请求。");
            Socket accept = serverSocket.accept();
            while (true) {
                InputStream inputStream = accept.getInputStream();
                int read = inputStream.read(BYTES);
                if (read != -1){
                    String msg = new String(BYTES, 0, read);
                    System.out.println("接收到来自客户端的消息：" + msg);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
