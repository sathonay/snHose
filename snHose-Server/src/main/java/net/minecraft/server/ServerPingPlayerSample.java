package net.minecraft.server.v1_7_R4;

import net.minecraft.util.com.mojang.authlib.*;

public class ServerPingPlayerSample
{
    private final int a;
    private final int b;
    private GameProfile[] c;
    
    public ServerPingPlayerSample(final int a, final int b) {
        this.a = a;
        this.b = b;
    }
    
    public int a() {
        return this.a;
    }
    
    public int b() {
        return this.b;
    }
    
    public GameProfile[] c() {
        return this.c;
    }
    
    public void a(final GameProfile[] c) {
        this.c = c;
    }
}
