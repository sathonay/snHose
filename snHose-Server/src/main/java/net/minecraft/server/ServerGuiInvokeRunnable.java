package net.minecraft.server.v1_7_R4;

import javax.swing.*;

class ServerGuiInvokeRunnable implements Runnable
{
    final /* synthetic */ JTextArea a;
    final /* synthetic */ JScrollPane b;
    final /* synthetic */ String c;
    final /* synthetic */ ServerGUI d;
    
    ServerGuiInvokeRunnable(final ServerGUI d, final JTextArea a, final JScrollPane b, final String c) {
        this.d = d;
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public void run() {
        this.d.a(this.a, this.b, this.c);
    }
}
