package com.sihui.demo.netty.coder;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import org.msgpack.MessagePack;

import java.util.List;

/**
 * @ProjectName: io
 * @Package: com.sihui.demo.netty.coder
 * @ClassName: MessageDecoder
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-03-02  21:05
 * @Version: 1.0
 */
public class MessageDecoder extends MessageToMessageDecoder<ByteBuf> {
    /**
     * 服务端解码
     * @param ctx
     * @param msg
     * @param out
     * @throws Exception
     */
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List out) throws Exception {
        int length = msg.readableBytes();
        byte[] bytes = new byte[length];
        msg.getBytes(msg.readerIndex(), bytes, 0, length);
        MessagePack messagePack = new MessagePack();
        out.add(messagePack.read(bytes));
    }
}
