package com.sihui.demo.netty.coder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.msgpack.MessagePack;

/**
 * @ProjectName: io
 * @Package: com.sihui.demo.netty.coder
 * @ClassName: MessageEncoder
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-03-02  21:02
 * @Version: 1.0
 */
public class MessageEncoder extends MessageToByteEncoder {
    /**
     * 客户端加码
     * @param ctx
     * @param msg
     * @param byteBuf
     * @throws Exception
     */
    @Override
    protected void encode(ChannelHandlerContext ctx, Object msg, ByteBuf byteBuf) throws Exception {
        MessagePack messagePack = new MessagePack();
        byteBuf.writeBytes(messagePack.write(msg));
    }
}
