package com.sihui.demo.netty.client;

import com.sihui.demo.netty.coder.MessageEncoder;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

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
//                        ch.pipeline().addLast(new LineBasedFrameDecoder(1024));
//                        ch.pipeline().addLast(new StringEncoder());
////                        ch.pipeline().addLast(new StringDecoder());
                        ch.pipeline().addLast(new MessageEncoder());
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
