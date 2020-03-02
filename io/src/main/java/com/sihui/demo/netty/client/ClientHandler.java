package com.sihui.demo.netty.client;

import com.sihui.demo.MsgEntity;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.UUID;

/**
 * @ProjectName: io
 * @Package: com.sihui.demo.netty.client
 * @ClassName: ClientHandler
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-03-02  16:52
 * @Version: 1.0
 */
public class ClientHandler extends SimpleChannelInboundHandler<Object> {
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
//        for (int i=0;i<10;i++){
//          ctx.writeAndFlush(Unpooled.copiedBuffer("李呱么？\n", CharsetUtil.UTF_8));
//        }

        //客户端将对象转换成JSON
        MsgEntity msgEntity = new MsgEntity("李呱呱真的牛逼", UUID.randomUUID().toString());
        ctx.writeAndFlush(msgEntity);
    }

    /**
     * 获取消息
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
//        ByteBuf byteBuf = (ByteBuf) msg;
//        String response = byteBuf.toString(CharsetUtil.UTF_8);
        System.out.println("客户端获取到服务器端的消息：" + msg);
    }
}
