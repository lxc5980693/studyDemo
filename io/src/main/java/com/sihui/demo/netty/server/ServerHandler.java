package com.sihui.demo.netty.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

/**
 * @ProjectName: io
 * @Package: com.sihui.demo.netty.server
 * @ClassName: ServerHandler
 * @Author: lixuanchen
 * @Description: 作为服务端处理客户端请求的处理器
 * @Date: 2020-03-02  16:14
 * @Version: 1.0
 */
public class ServerHandler extends SimpleChannelInboundHandler {

    /**
     * 获取数据
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf byteBuf = (ByteBuf)msg;
        String request = byteBuf.toString(CharsetUtil.UTF_8);
        System.out.println("request: " + request);

        //响应代码
        ctx.writeAndFlush(Unpooled.copiedBuffer("李呱呱是个大怂逼\n", CharsetUtil.UTF_8));
    }
}
