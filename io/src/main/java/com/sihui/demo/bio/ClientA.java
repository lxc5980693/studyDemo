package com.sihui.demo.bio;

import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @ProjectName: mybatis-plus-demo
 * @Package: com.sihui.mybatisplusdemo.bio
 * @ClassName: ClientA
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2019-12-20  15:02
 * @Version: 1.0
 */
public class ClientA {
    private static final String DEFAULT_HOST = "127.0.0.1";
    private static final int DEFAULT_PORT = 12345;

    private static Socket socket;

    public static void main(String[] args) {
        sendMessage(DEFAULT_PORT, Thread.currentThread().getName() + "给服务端发送消息：湖人总冠军");
    }

    private static void sendMessage(int port, String msg) {
        PrintStream bufferedWriter = null;
        BufferedReader bufferedReader = null;
        try {
            socket = new Socket(DEFAULT_HOST, port);
            bufferedWriter = new PrintStream(socket.getOutputStream(), true);
            bufferedWriter.println(msg);

            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String s = bufferedReader.readLine();
            if (!StringUtils.isEmpty(s)) {
                System.out.println("客户端接收来自服务端的消息：" + s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedWriter != null){
                bufferedWriter.close();
            }
            if (bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
