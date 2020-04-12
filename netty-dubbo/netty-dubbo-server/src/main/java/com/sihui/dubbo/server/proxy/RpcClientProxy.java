package com.sihui.dubbo.server.proxy;

import com.sihui.dubbo.server.LoadBalance.impl.LoopLoadBalance;
import com.sihui.dubbo.server.dicover.ServiceDiscover;
import com.sihui.dubbo.server.dicover.impl.ServiceDiscoverImpl;
import com.sihui.dubbo.server.handle.DubboClientHandle;
import com.sihui.dubbo.server.marshalling.MarshallingCodeCFactory;
import com.sihui.dubbo.server.req.RpcRequest;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.URLDecoder;

/**
 * @ProjectName: netty-dubbo
 * @Package: com.sihui.dubbo.server.proxy
 * @ClassName: RpcClientProxy
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-04-06  18:58
 * @Version: 1.0
 */
public class RpcClientProxy {
    public <T> T createProxy(Class<T> interfaceClass) {
        T t = (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                /**
                 * 使用代理类对生产者地址进行拼接，
                 * 然后通过netty发送消息给服务端
                 * 获取结果返回给消费者。
                 */
                ServiceDiscover serviceDiscover = new ServiceDiscoverImpl();
                //通过代理类拿到消费者要调用的类
                String serviceName = interfaceClass.getName();
                LoopLoadBalance loopLoadBalance = new LoopLoadBalance();
                //拿到生产者注册地址 sihui://192.168.12.14:8081
                String serviceUrl = URLDecoder.decode(loopLoadBalance.select(serviceDiscover.getService(serviceName)));
                String[] split = serviceUrl.split(":");
                String ip = split[1].replace("//", "");
                int port = Integer.valueOf(split[2]);

                //封装消息参数
                RpcRequest rpcRequest = new RpcRequest(serviceName, method.getName(), method.getParameterTypes(), args);

                //启动netty的客户端发送消息
                return sendMsg(ip, port, rpcRequest);
            }
        });
        return t;
    }

    public Object sendMsg(String host, int port, RpcRequest rpcRequest) {
        //创建一个线程池
        NioEventLoopGroup eventExecutors = new NioEventLoopGroup();
        DubboClientHandle dubboClientHandle = new DubboClientHandle();
        //创建一个bootstrap
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(eventExecutors).channel(NioSocketChannel.class)
                .remoteAddress(host, port)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(MarshallingCodeCFactory.buildMarshallingDecoder());
                        ch.pipeline().addLast(MarshallingCodeCFactory.buildMarshallingEncoder());
                        ch.pipeline().addLast(dubboClientHandle);
                    }
                });
        try {
            ChannelFuture channelFuture = bootstrap.connect().sync();
            System.out.println("消费者发送消息：" + rpcRequest.toString());
            channelFuture.channel().writeAndFlush(rpcRequest);
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            eventExecutors.shutdownGracefully();
        }
        return dubboClientHandle.getResponse();
    }
}
