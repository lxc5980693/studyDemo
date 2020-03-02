package com.sihui.demo.netty.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

/**
 * @ProjectName: io
 * @Package: com.sihui.demo.netty.client
 * @ClassName: ClientHandler
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-03-02  16:52
 * @Version: 1.0
 */
public class ClientHandler extends SimpleChannelInboundHandler<String> {
    /**
     * 发送消息
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        /**
         * 模拟粘包和拆包的场景
         */
//        ctx.writeAndFlush(Unpooled.copiedBuffer("李呱呱是个什么？\n", CharsetUtil.UTF_8));
        ctx.writeAndFlush("李呱呱是个什么?\n");
    }

    /**
     * 获取消息
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
//        ByteBuf byteBuf = (ByteBuf) msg;
//        String response = byteBuf.toString(CharsetUtil.UTF_8);
        System.out.println("客户端获取到服务器端的消息：" + msg);
    }
}
