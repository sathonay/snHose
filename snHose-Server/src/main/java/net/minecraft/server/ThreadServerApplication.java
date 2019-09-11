package net.minecraft.server;

public class ThreadServerApplication extends Thread
{
    final /* synthetic */ MinecraftServer a;
    
    public ThreadServerApplication(final MinecraftServer a, final String s) {
        this.a = a;
        super(s);
    }
    
    @Override
    public void run() {
        this.a.run();
    }
}
