package com.sihui.dubbo.server.handle;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @ProjectName: netty-dubbo
 * @Package: com.sihui.dubbo.server.handle
 * @ClassName: DubboClientHandle
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-04-12  17:32
 * @Version: 1.0
 */
public class DubboClientHandle extends ChannelInboundHandlerAdapter {

    private Object response;

    public Object getResponse(){
        return response;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("netty客户端收到了消息：" + msg.toString());
        this.response = msg;
        ctx.close();
    }
}
