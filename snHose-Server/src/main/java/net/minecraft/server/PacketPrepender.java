package net.minecraft.server;

import net.minecraft.util.io.netty.handler.codec.*;
import net.minecraft.util.io.netty.channel.*;
import net.minecraft.util.io.netty.buffer.*;

public class PacketPrepender extends MessageToByteEncoder
{
    protected void a(final ChannelHandlerContext channelHandlerContext, final ByteBuf bytebuf, final ByteBuf bytebuf2) {
        final int readableBytes = bytebuf.readableBytes();
        final int a = PacketDataSerializer.a(readableBytes);
        if (a > 3) {
            throw new IllegalArgumentException("unable to fit " + readableBytes + " into " + 3);
        }
        final PacketDataSerializer packetDataSerializer = new PacketDataSerializer(bytebuf2);
        packetDataSerializer.ensureWritable(a + readableBytes);
        packetDataSerializer.b(readableBytes);
        packetDataSerializer.writeBytes(bytebuf, bytebuf.readerIndex(), readableBytes);
    }
}
