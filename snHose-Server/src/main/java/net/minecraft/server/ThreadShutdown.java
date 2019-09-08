package net.minecraft.server.v1_7_R4;

public final class ThreadShutdown extends Thread
{
    final /* synthetic */ DedicatedServer a;
    
    public ThreadShutdown(final String s, final DedicatedServer a) {
        this.a = a;
        super(s);
    }
    
    @Override
    public void run() {
        this.a.stop();
    }
}
