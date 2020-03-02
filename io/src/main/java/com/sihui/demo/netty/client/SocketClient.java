package com.sihui.demo.netty.client;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @ProjectName: io
 * @Package: com.sihui.demo.netty.client
 * @ClassName: SocketCLient
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-03-02  16:27
 * @Version: 1.0
 */
public class SocketClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8080);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("李呱呱是个什么？".getBytes());
        while (true){

        }
    }
}
