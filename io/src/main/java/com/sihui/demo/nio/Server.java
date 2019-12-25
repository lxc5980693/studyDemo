package com.sihui.demo.nio;

import com.sihui.demo.bio.handle.ServerHandle;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: io
 * @Package: com.sihui.demo.nio
 * @ClassName: Server
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2019-12-23  11:22
 * @Version: 1.0
 */
public class Server {
    private static final int DEFAULT_PORT = 12345;

    private static ServerSocket serverSocket;

    private static List<Socket> socketList = new ArrayList<>();

    public static void main(String[] args) {
        start(DEFAULT_PORT);
    }

    private static void start(int defaultPort) {
        try {
            serverSocket = new ServerSocket(DEFAULT_PORT);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    String name = Thread.currentThread().getName();
                    System.out.println(name + " start...");
                    while (true) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(name + " " + System.currentTimeMillis());
                        if (socketList != null && socketList.size() > 0) {
                            System.out.println("查询的集合：" + socketList.toString());
                            Socket socket = socketList.get(0);
                            new Thread(new ServerHandle(socket)).start();
                            if (socket.isClosed()){
                                socketList.remove(socket);
                            }
                        }
                    }
                }
            }).start();
            while (true) {
                Socket accept = serverSocket.accept();
                if (accept != null) {
                    System.out.println("连接放入集合：" + accept);
                    socketList.add(accept);
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
