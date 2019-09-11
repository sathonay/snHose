package net.minecraft.server;

import net.minecraft.util.io.netty.util.concurrent.*;
import net.minecraft.util.io.netty.channel.*;

class QueuedProtocolSwitch implements Runnable
{
    final /* synthetic */ EnumProtocol a;
    final /* synthetic */ EnumProtocol b;
    final /* synthetic */ Packet c;
    final /* synthetic */ GenericFutureListener[] d;
    final /* synthetic */ NetworkManager e;
    
    QueuedProtocolSwitch(final NetworkManager e, final EnumProtocol a, final EnumProtocol b, final Packet c, final GenericFutureListener[] d) {
        this.e = e;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    @Override
    public void run() {
        if (this.a != this.b) {
            this.e.a(this.a);
        }
        NetworkManager.a(this.e).writeAndFlush(this.c).addListeners((GenericFutureListener<? extends Future<? super Void>>[])this.d).addListener((GenericFutureListener<? extends Future<? super Void>>)ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
    }
}
