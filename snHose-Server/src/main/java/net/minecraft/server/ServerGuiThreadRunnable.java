package net.minecraft.server;

import javax.swing.*;
import net.minecraft.util.com.mojang.util.*;

class ServerGuiThreadRunnable implements Runnable
{
    final /* synthetic */ JTextArea a;
    final /* synthetic */ JScrollPane b;
    final /* synthetic */ ServerGUI c;
    
    ServerGuiThreadRunnable(final ServerGUI c, final JTextArea a, final JScrollPane b) {
        this.c = c;
        this.a = a;
        this.b = b;
    }
    
    @Override
    public void run() {
        String nextLogEvent;
        while ((nextLogEvent = QueueLogAppender.getNextLogEvent("ServerGuiConsole")) != null) {
            this.c.a(this.a, this.b, nextLogEvent);
        }
    }
}
