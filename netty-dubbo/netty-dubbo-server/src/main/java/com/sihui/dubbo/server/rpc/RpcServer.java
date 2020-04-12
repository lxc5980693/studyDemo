package com.sihui.dubbo.server.rpc;

import com.sihui.dubbo.common.annotation.RpcAnnotation;
import com.sihui.dubbo.server.handle.DubboServerHandle;
import com.sihui.dubbo.server.marshalling.MarshallingCodeCFactory;
import com.sihui.dubbo.server.regist.ServiceRegister;
import com.sihui.dubbo.server.regist.impl.ServiceRegisterImpl;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ProjectName: netty-dubbo
 * @Package: com.sihui.dubbo.server.rpc
 * @ClassName: SihuiRpcServer
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-04-06  16:58
 * @Version: 1.0
 */
public class RpcServer {

    private ServiceRegister serviceRegister;

    /**
     * 注册的服务的ip地址
     */
    private String host;

    /**
     * 注册服务的端口号
     */
    private int port;

    private Map<String, Object> maps = new ConcurrentHashMap<String, Object>();

    public RpcServer(String host, int port) {
        this.host = host;
        this.port = port;
        serviceRegister = new ServiceRegisterImpl();
    }

    /**
     * bind,将本地服务注册到zk上，启动netty服务器端进行监听
     */
    public void bind(Object object) throws Exception {
        RpcAnnotation rpcAnnotation = object.getClass().getDeclaredAnnotation(RpcAnnotation.class);
        //获取接口上是否有RpcAnnocation注解
        if (Objects.isNull(rpcAnnotation)) {
            //抛出异常
            throw new Exception("interface lack annocation...");
        }
        //获取serviceName
        Class value = rpcAnnotation.value();
        String serviceName = value.getName();
        //拼接服务地址
        String serviceAddr = "sihui://" + host + ":" + port;
        serviceRegister.regist(serviceName, serviceAddr);
        maps.put(serviceName, object);
    }

    public void start(Object object) throws Exception {
        bind(object);
        nettyStart();
    }

    /**
     * 消费者调用生产者服务的时候：sihui://192.168.1.1:8080/com.sihui.service.UserService.getUser 参数、类型、返回值
     */
    /**
     * 开启netty 服务器端开启监听
     */
    private void nettyStart() {
        //Boss线程池 专门接收连接请求
        NioEventLoopGroup bossExecutors = new NioEventLoopGroup();

        //工作线程池 专门处理请求的读写操作
        NioEventLoopGroup workExecutors = new NioEventLoopGroup();

        //创建serverBootstrap
        ServerBootstrap serverBootstrap = new ServerBootstrap();

        serverBootstrap.group(bossExecutors, workExecutors).channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {

                    @Override
                    protected void initChannel(SocketChannel ch) {
                        ch.pipeline().addLast(MarshallingCodeCFactory.buildMarshallingEncoder());
                        ch.pipeline().addLast(MarshallingCodeCFactory.buildMarshallingDecoder());
                        ch.pipeline().addLast(new DubboServerHandle(maps));
                    }
                });
        try {
            //绑定端口号
            ChannelFuture channelFuture = serverBootstrap.bind(port).sync();
            System.out.println("服务器启动成功，ip:+" + host + "端口号：" + port);
            channelFuture.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bossExecutors.shutdownGracefully();
            workExecutors.shutdownGracefully();
        }
    }
}
