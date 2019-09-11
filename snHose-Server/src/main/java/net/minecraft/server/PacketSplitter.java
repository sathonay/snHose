package net.minecraft.server;

import net.minecraft.util.io.netty.channel.*;
import java.util.*;
import net.minecraft.util.io.netty.buffer.*;
import net.minecraft.util.io.netty.handler.codec.*;

public class PacketSplitter extends ByteToMessageDecoder
{
    @Override
    protected void decode(final ChannelHandlerContext channelHandlerContext, final ByteBuf byteBuf, final List list) {
        byteBuf.markReaderIndex();
        final byte[] array = new byte[3];
        for (int i = 0; i < array.length; ++i) {
            if (!byteBuf.isReadable()) {
                byteBuf.resetReaderIndex();
                return;
            }
            array[i] = byteBuf.readByte();
            if (array[i] >= 0) {
                final PacketDataSerializer packetDataSerializer = new PacketDataSerializer(Unpooled.wrappedBuffer(array));
                try {
                    final int a = packetDataSerializer.a();
                    if (byteBuf.readableBytes() < a) {
                        byteBuf.resetReaderIndex();
                        return;
                    }
                    list.add(byteBuf.readBytes(a));
                    return;
                }
                finally {
                    packetDataSerializer.release();
                }
            }
        }
        throw new CorruptedFrameException("length wider than 21-bit");
    }
}
