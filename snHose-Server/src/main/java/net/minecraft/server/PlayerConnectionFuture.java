package net.minecraft.server.v1_7_R4;

import net.minecraft.util.io.netty.util.concurrent.*;

class PlayerConnectionFuture implements GenericFutureListener
{
    final /* synthetic */ ChatComponentText a;
    final /* synthetic */ PlayerConnection b;
    
    PlayerConnectionFuture(final PlayerConnection b, final ChatComponentText a) {
        this.b = b;
        this.a = a;
    }
    
    @Override
    public void operationComplete(final Future future) {
        this.b.networkManager.close(this.a);
    }
}
