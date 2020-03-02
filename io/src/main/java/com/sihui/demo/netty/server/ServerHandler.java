package com.sihui.demo.netty.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @ProjectName: io
 * @Package: com.sihui.demo.netty.server
 * @ClassName: ServerHandler
 * @Author: lixuanchen
 * @Description: 作为服务端处理客户端请求的处理器
 * @Date: 2020-03-02  16:14
 * @Version: 1.0
 */
public class ServerHandler extends SimpleChannelInboundHandler<String> {

    /**
     * 获取数据
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
//        ByteBuf byteBuf = (ByteBuf)msg;
//        String request = byteBuf.toString(CharsetUtil.UTF_8);
        System.out.println("request: " + msg);

        //响应代码
//        ctx.writeAndFlush(Unpooled.copiedBuffer("李呱呱是个大怂逼\n", CharsetUtil.UTF_8));
        ctx.writeAndFlush("李呱呱是个大怂逼\n");
    }
}
