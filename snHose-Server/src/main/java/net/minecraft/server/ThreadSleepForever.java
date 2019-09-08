package net.minecraft.server.v1_7_R4;

class ThreadSleepForever extends Thread
{
    final /* synthetic */ DedicatedServer a;
    
    ThreadSleepForever(final DedicatedServer a, final String s) {
        this.a = a;
        super(s);
        this.setDaemon(true);
        this.start();
    }
    
    @Override
    public void run() {
        while (true) {
            try {
                while (true) {
                    Thread.sleep(2147483647L);
                }
            }
            catch (InterruptedException ex) {
                continue;
            }
            break;
        }
    }
}
