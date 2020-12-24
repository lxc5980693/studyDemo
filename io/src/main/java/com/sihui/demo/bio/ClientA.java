package com.sihui.demo.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

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
    private static final int DEFAULT_PORT = 12345;

    private static Socket socket;

    public static void main(String[] args) {
        sendMessage(DEFAULT_PORT);
    }

    private static void sendMessage(int port) {
        try {
            socket = new Socket();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(InetAddress.getLocalHost(), port);
            socket.connect(inetSocketAddress);
            while (true) {
                Scanner scanner = new Scanner(System.in);
                socket.getOutputStream().write(scanner.next().getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
