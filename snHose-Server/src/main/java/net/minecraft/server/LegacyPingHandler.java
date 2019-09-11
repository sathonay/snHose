package net.minecraft.server;

import java.net.*;
import net.minecraft.util.com.google.common.base.*;
import net.minecraft.util.io.netty.channel.*;
import net.minecraft.util.io.netty.util.concurrent.*;
import net.minecraft.util.io.netty.buffer.*;
import org.apache.logging.log4j.*;

public class LegacyPingHandler extends ChannelInboundHandlerAdapter
{
    private static final Logger a;
    private ServerConnection b;
    
    public LegacyPingHandler(final ServerConnection b) {
        this.b = b;
    }
    
    @Override
    public void channelRead(final ChannelHandlerContext channelHandlerContext, final Object o) {
        final ByteBuf byteBuf = (ByteBuf)o;
        byteBuf.markReaderIndex();
        boolean b = true;
        try {
            if (byteBuf.readUnsignedByte() != 254) {
                return;
            }
            final InetSocketAddress inetSocketAddress = (InetSocketAddress)channelHandlerContext.channel().remoteAddress();
            final MinecraftServer d = this.b.d();
            switch (byteBuf.readableBytes()) {
                case 0: {
                    LegacyPingHandler.a.debug("Ping: (<1.3.x) from {}:{}", inetSocketAddress.getAddress(), inetSocketAddress.getPort());
                    this.a(channelHandlerContext, this.a(String.format("%s�%d�%d", d.getMotd(), d.C(), d.D())));
                    break;
                }
                case 1: {
                    if (byteBuf.readUnsignedByte() != 1) {
                        return;
                    }
                    LegacyPingHandler.a.debug("Ping: (1.4-1.5.x) from {}:{}", inetSocketAddress.getAddress(), inetSocketAddress.getPort());
                    this.a(channelHandlerContext, this.a(String.format("�1\u0000%d\u0000%s\u0000%s\u0000%d\u0000%d", 127, d.getVersion(), d.getMotd(), d.C(), d.D())));
                    break;
                }
                default: {
                    if (!(byteBuf.readUnsignedByte() == 1 & byteBuf.readUnsignedByte() == 250 & "MC|PingHost".equals(new String(byteBuf.readBytes(byteBuf.readShort() * 2).array(), Charsets.UTF_16BE)) & byteBuf.readUnsignedByte() >= 73 & 3 + byteBuf.readBytes(byteBuf.readShort() * 2).array().length + 4 == byteBuf.readUnsignedShort() & byteBuf.readInt() <= 65535 & byteBuf.readableBytes() == 0)) {
                        return;
                    }
                    LegacyPingHandler.a.debug("Ping: (1.6) from {}:{}", inetSocketAddress.getAddress(), inetSocketAddress.getPort());
                    final ByteBuf a = this.a(String.format("�1\u0000%d\u0000%s\u0000%s\u0000%d\u0000%d", 127, d.getVersion(), d.getMotd(), d.C(), d.D()));
                    try {
                        this.a(channelHandlerContext, a);
                    }
                    finally {
                        a.release();
                    }
                    break;
                }
            }
            byteBuf.release();
            b = false;
        }
        catch (RuntimeException ex) {}
        finally {
            if (b) {
                byteBuf.resetReaderIndex();
                channelHandlerContext.channel().pipeline().remove("legacy_query");
                channelHandlerContext.fireChannelRead(o);
            }
        }
    }
    
    private void a(final ChannelHandlerContext channelHandlerContext, final ByteBuf byteBuf) {
        channelHandlerContext.pipeline().firstContext().writeAndFlush(byteBuf).addListener((GenericFutureListener<? extends Future<? super Void>>)ChannelFutureListener.CLOSE);
    }
    
    private ByteBuf a(final String s) {
        final ByteBuf buffer = Unpooled.buffer();
        buffer.writeByte(255);
        final char[] charArray = s.toCharArray();
        buffer.writeShort(charArray.length);
        final char[] array = charArray;
        for (int length = array.length, i = 0; i < length; ++i) {
            buffer.writeChar(array[i]);
        }
        return buffer;
    }
    
    static {
        a = LogManager.getLogger();
    }
}
