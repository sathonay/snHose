package net.minecraft.server.v1_7_R4;

import net.minecraft.util.io.netty.util.concurrent.*;

class ServerConnectionFuture implements GenericFutureListener
{
    final /* synthetic */ NetworkManager a;
    final /* synthetic */ ChatComponentText b;
    final /* synthetic */ ServerConnection c;
    
    ServerConnectionFuture(final ServerConnection c, final NetworkManager a, final ChatComponentText b) {
        this.c = c;
        this.a = a;
        this.b = b;
    }
    
    @Override
    public void operationComplete(final Future future) {
        this.a.close(this.b);
    }
}
