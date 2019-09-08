package net.minecraft.server.v1_7_R4;

import net.minecraft.util.io.netty.handler.codec.*;
import javax.crypto.*;
import net.minecraft.util.io.netty.channel.*;
import net.minecraft.util.io.netty.buffer.*;
import java.util.*;

public class PacketDecrypter extends MessageToMessageDecoder
{
    private final PacketEncryptionHandler a;
    
    public PacketDecrypter(final Cipher cipher) {
        this.a = new PacketEncryptionHandler(cipher);
    }
    
    protected void a(final ChannelHandlerContext channelHandlerContext, final ByteBuf byteBuf, final List list) {
        list.add(this.a.a(channelHandlerContext, byteBuf));
    }
}
