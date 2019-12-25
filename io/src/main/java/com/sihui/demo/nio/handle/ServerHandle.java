package com.sihui.demo.nio.handle;

import java.net.Socket;
import java.util.List;

/**
 * @ProjectName: io
 * @Package: com.sihui.demo.nio.handle
 * @ClassName: ServerMonitorHandle
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2019-12-23  11:24
 * @Version: 1.0
 */
public class ServerHandle implements Runnable {

    private List<Socket> sockets;

    ServerHandle(List<Socket> sockets){
        this.sockets = sockets;
    }

    @Override
    public void run() {

    }
}
