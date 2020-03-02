package com.sihui.demo.netty.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @ProjectName: io
 * @Package: com.sihui.demo.netty.client
 * @ClassName: NettyClient
 * @Author: lixuanchen
 * @Description: nettyClient端
 * @Date: 2020-03-02  16:48
 * @Version: 1.0
 */
public class NettyClient {
    public static void main(String[] args) {
        //创建一个线程池
        NioEventLoopGroup eventExecutors = new NioEventLoopGroup();
        //创建一个bootstrap
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(eventExecutors).channel(NioSocketChannel.class)
                .remoteAddress("127.0.0.1", 8080)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new ClientHandler());
                    }
                });
        try {
            ChannelFuture channelFuture = bootstrap.connect().sync();
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            eventExecutors.shutdownGracefully();
        }
    }
}