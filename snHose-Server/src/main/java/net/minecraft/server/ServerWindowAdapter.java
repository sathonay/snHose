package net.minecraft.server;

import java.awt.event.*;

final class ServerWindowAdapter extends WindowAdapter
{
    final /* synthetic */ DedicatedServer a;
    
    ServerWindowAdapter(final DedicatedServer a) {
        this.a = a;
    }
    
    @Override
    public void windowClosing(final WindowEvent windowEvent) {
        this.a.safeShutdown();
        while (!this.a.isStopped()) {
            try {
                Thread.sleep(100L);
            }
            catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        System.exit(0);
    }
}
