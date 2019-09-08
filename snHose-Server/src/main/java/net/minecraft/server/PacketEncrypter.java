package net.minecraft.server.v1_7_R4;

import net.minecraft.util.io.netty.handler.codec.*;
import javax.crypto.*;
import net.minecraft.util.io.netty.channel.*;
import net.minecraft.util.io.netty.buffer.*;

public class PacketEncrypter extends MessageToByteEncoder
{
    private final PacketEncryptionHandler a;
    
    public PacketEncrypter(final Cipher cipher) {
        this.a = new PacketEncryptionHandler(cipher);
    }
    
    protected void a(final ChannelHandlerContext channelHandlerContext, final ByteBuf byteBuf, final ByteBuf byteBuf2) {
        this.a.a(byteBuf, byteBuf2);
    }
}
