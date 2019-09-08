package net.minecraft.server.v1_7_R4;

import javax.crypto.*;
import net.minecraft.util.io.netty.buffer.*;
import net.minecraft.util.io.netty.channel.*;

public class PacketEncryptionHandler
{
    private final Cipher a;
    private byte[] b;
    private byte[] c;
    
    protected PacketEncryptionHandler(final Cipher a) {
        this.b = new byte[0];
        this.c = new byte[0];
        this.a = a;
    }
    
    private byte[] a(final ByteBuf byteBuf) {
        final int readableBytes = byteBuf.readableBytes();
        if (this.b.length < readableBytes) {
            this.b = new byte[readableBytes];
        }
        byteBuf.readBytes(this.b, 0, readableBytes);
        return this.b;
    }
    
    protected ByteBuf a(final ChannelHandlerContext channelHandlerContext, final ByteBuf byteBuf) {
        final int readableBytes = byteBuf.readableBytes();
        final byte[] a = this.a(byteBuf);
        final ByteBuf heapBuffer = channelHandlerContext.alloc().heapBuffer(this.a.getOutputSize(readableBytes));
        heapBuffer.writerIndex(this.a.update(a, 0, readableBytes, heapBuffer.array(), heapBuffer.arrayOffset()));
        return heapBuffer;
    }
    
    protected void a(final ByteBuf byteBuf, final ByteBuf byteBuf2) {
        final int readableBytes = byteBuf.readableBytes();
        final byte[] a = this.a(byteBuf);
        final int outputSize = this.a.getOutputSize(readableBytes);
        if (this.c.length < outputSize) {
            this.c = new byte[outputSize];
        }
        byteBuf2.writeBytes(this.c, 0, this.a.update(a, 0, readableBytes, this.c));
    }
}
