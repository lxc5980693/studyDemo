package com.sihui.dubbo.server.handle;

import com.sihui.dubbo.server.req.RpcRequest;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.Objects;

/**
 * @ProjectName: netty-dubbo
 * @Package: com.sihui.dubbo.server.handle
 * @ClassName: DubboServerHandle
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-04-06  17:45
 * @Version: 1.0
 */
public class DubboServerHandle extends ChannelInboundHandlerAdapter {

    private Map<String, Object> maps;

    public DubboServerHandle(Map<String, Object> maps) {
        this.maps = maps;
    }

    /**
     * 服务端监听客户端发送的消息
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("netty服务端收到了消息：" + msg.toString());
        //获取参数
        RpcRequest rpcRequest = (RpcRequest) msg;
        //采用反射机制执行方法。
        if (Objects.isNull(rpcRequest)) {
            throw new Exception("params is null error..");
        }
        String serviceName = rpcRequest.getClassName();
        Object val = maps.get(serviceName);
        if (Objects.isNull(val)) {
            throw new Exception("interface is not regist...");
        }
        //使用反射机制执行方法
        Method method = val.getClass().getMethod(rpcRequest.getMethodName(), rpcRequest.getParameterTypes());
        Object result = method.invoke(val, rpcRequest.getParamsValue());
        //返回结果
        ctx.writeAndFlush(result);
    }
}
