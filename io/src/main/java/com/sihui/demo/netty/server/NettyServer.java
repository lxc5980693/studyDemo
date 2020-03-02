package com.sihui.demo.netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ServerChannel;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @ProjectName: io
 * @Package: com.sihui.demo.netty.server
 * @ClassName: NettyServer
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-03-02  15:54
 * @Version: 1.0
 */
public class NettyServer {

    private static int PORT = 8080;

    /**
     * 使用netty创建服务器端，会采用两个线程池
     */
    public static void main(String[] args) {
        //Boss线程池 专门接收连接请求
        NioEventLoopGroup bossExecutors = new NioEventLoopGroup();

        //工作线程池 专门处理请求的读写操作
        NioEventLoopGroup workExecutors = new NioEventLoopGroup();

        //创建serverBootstrap
        ServerBootstrap serverBootstrap = new ServerBootstrap();

        /**
         * NioServerSocketChannel 标记当前是为服务器端
         * SocketChannel 是为客户端
         * 因为在NIO中是通过channel管道进行连接的，每一个client都有自己的socketChannel
         * 而server端中是通过Selector统一管理和维护不同的client连接，所以称为ServerSocketChannel
         */
        serverBootstrap.group(bossExecutors, workExecutors).channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {

                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        //处理每个请求的handler
                        ch.pipeline().addLast(new ServerHandler());
                    }
                });
        try {
            //绑定端口号
            ChannelFuture channelFuture = serverBootstrap.bind(PORT).sync();
            System.out.println("服务器启动成功，端口号：" + PORT);
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bossExecutors.shutdownGracefully();
            workExecutors.shutdownGracefully();
        }
    }
}
