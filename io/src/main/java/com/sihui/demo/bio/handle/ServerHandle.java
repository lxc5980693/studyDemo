package com.sihui.demo.bio.handle;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ProjectName: mybatis-plus-demo
 * @Package: com.sihui.mybatisplusdemo.bio.handle
 * @ClassName: ServerMonitorHandle
 * @Author: lixuanchen
 * @Description: 服务器处理线程类
 * @Date: 2019-12-20  15:59
 * @Version: 1.0
 */
public class ServerHandle implements Runnable {

    private Socket socket;

    public ServerHandle(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        BufferedReader inputStream = null;
        PrintStream bufferedWriter = null;
        if (socket != null) {
            try {
                inputStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String messgae = inputStream.readLine();
                if (messgae != null) {
                    System.out.println(name + "收到来自" + socket.getInetAddress().getHostName() + "的消息：" + messgae);
                }
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                bufferedWriter = new PrintStream(socket.getOutputStream(), true);
                bufferedWriter.println("服务端已收到您的消息");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
