package net.minecraft.server;

import java.util.*;
import java.io.*;
import java.net.*;

public class RemoteControlListener extends RemoteConnectionThread
{
    private int h;
    private int i;
    private String j;
    private ServerSocket k;
    private String l;
    private Map m;
    
    public RemoteControlListener(final IMinecraftServer minecraftServer) {
        super(minecraftServer, "RCON Listener");
        this.h = minecraftServer.a("rcon.port", 0);
        this.l = minecraftServer.a("rcon.password", "");
        this.j = minecraftServer.y();
        this.i = minecraftServer.z();
        if (0 == this.h) {
            this.h = this.i + 10;
            this.info("Setting default rcon port to " + this.h);
            minecraftServer.a("rcon.port", (Object)this.h);
            if (0 == this.l.length()) {
                minecraftServer.a("rcon.password", (Object)"");
            }
            minecraftServer.a();
        }
        if (0 == this.j.length()) {
            this.j = "0.0.0.0";
        }
        this.f();
        this.k = null;
    }
    
    private void f() {
        this.m = new HashMap();
    }
    
    private void g() {
        final Iterator<Map.Entry<K, RemoteControlSession>> iterator = this.m.entrySet().iterator();
        while (iterator.hasNext()) {
            if (!iterator.next().getValue().c()) {
                iterator.remove();
            }
        }
    }
    
    @Override
    public void run() {
        this.info("RCON running on " + this.j + ":" + this.h);
        try {
            while (this.running) {
                try {
                    final Socket accept = this.k.accept();
                    accept.setSoTimeout(500);
                    final RemoteControlSession remoteControlSession = new RemoteControlSession(this.server, accept);
                    remoteControlSession.a();
                    this.m.put(accept.getRemoteSocketAddress(), remoteControlSession);
                    this.g();
                }
                catch (SocketTimeoutException ex2) {
                    this.g();
                }
                catch (IOException ex) {
                    if (!this.running) {
                        continue;
                    }
                    this.info("IO: " + ex.getMessage());
                }
            }
        }
        finally {
            this.b(this.k);
        }
    }
    
    @Override
    public void a() {
        if (0 == this.l.length()) {
            this.warning("No rcon password set in '" + this.server.b() + "', rcon disabled!");
            return;
        }
        if (0 >= this.h || 65535 < this.h) {
            this.warning("Invalid rcon port " + this.h + " found in '" + this.server.b() + "', rcon disabled!");
            return;
        }
        if (this.running) {
            return;
        }
        try {
            (this.k = new ServerSocket(this.h, 0, InetAddress.getByName(this.j))).setSoTimeout(500);
            super.a();
        }
        catch (IOException ex) {
            this.warning("Unable to initialise rcon on " + this.j + ":" + this.h + " : " + ex.getMessage());
        }
    }
}
