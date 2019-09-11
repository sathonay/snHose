package net.minecraft.server;

import java.util.concurrent.atomic.*;
import java.net.*;
import java.io.*;
import java.util.*;

public abstract class RemoteConnectionThread implements Runnable
{
    private static final AtomicInteger h;
    protected boolean running;
    protected IMinecraftServer server;
    protected final String c;
    protected Thread thread;
    protected int e;
    protected List f;
    protected List g;
    
    protected RemoteConnectionThread(final IMinecraftServer server, final String c) {
        this.e = 5;
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.server = server;
        this.c = c;
        if (this.server.isDebugging()) {
            this.warning("Debugging is enabled, performance maybe reduced!");
        }
    }
    
    public synchronized void a() {
        (this.thread = new Thread(this, this.c + " #" + RemoteConnectionThread.h.incrementAndGet())).start();
        this.running = true;
    }
    
    public boolean c() {
        return this.running;
    }
    
    protected void debug(final String s) {
        this.server.i(s);
    }
    
    protected void info(final String s) {
        this.server.info(s);
    }
    
    protected void warning(final String s) {
        this.server.warning(s);
    }
    
    protected void error(final String s) {
        this.server.h(s);
    }
    
    protected int d() {
        return this.server.C();
    }
    
    protected void a(final DatagramSocket datagramSocket) {
        this.debug("registerSocket: " + datagramSocket);
        this.f.add(datagramSocket);
    }
    
    protected boolean a(final DatagramSocket datagramSocket, final boolean b) {
        this.debug("closeSocket: " + datagramSocket);
        if (null == datagramSocket) {
            return false;
        }
        boolean b2 = false;
        if (!datagramSocket.isClosed()) {
            datagramSocket.close();
            b2 = true;
        }
        if (b) {
            this.f.remove(datagramSocket);
        }
        return b2;
    }
    
    protected boolean b(final ServerSocket serverSocket) {
        return this.a(serverSocket, true);
    }
    
    protected boolean a(final ServerSocket serverSocket, final boolean b) {
        this.debug("closeSocket: " + serverSocket);
        if (null == serverSocket) {
            return false;
        }
        boolean b2 = false;
        try {
            if (!serverSocket.isClosed()) {
                serverSocket.close();
                b2 = true;
            }
        }
        catch (IOException ex) {
            this.warning("IO: " + ex.getMessage());
        }
        if (b) {
            this.g.remove(serverSocket);
        }
        return b2;
    }
    
    protected void e() {
        this.a(false);
    }
    
    protected void a(final boolean b) {
        int n = 0;
        final Iterator<DatagramSocket> iterator = this.f.iterator();
        while (iterator.hasNext()) {
            if (this.a(iterator.next(), false)) {
                ++n;
            }
        }
        this.f.clear();
        final Iterator<ServerSocket> iterator2 = this.g.iterator();
        while (iterator2.hasNext()) {
            if (this.a(iterator2.next(), false)) {
                ++n;
            }
        }
        this.g.clear();
        if (b && 0 < n) {
            this.warning("Force closed " + n + " sockets");
        }
    }
    
    static {
        h = new AtomicInteger(0);
    }
}
