package com.sihui.demo.bio;

import com.sihui.demo.bio.handle.ServerHandle;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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

    public static void main(String[] args) {
        start(DEFAULT_PORT);
    }

    private static void start(int port) {

        try {
            serverSocket = new ServerSocket(DEFAULT_PORT);
            while (true){
                new Thread(new ServerHandle(serverSocket.accept())).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
