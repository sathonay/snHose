package net.minecraft.server.v1_7_R4;

public class ServerPingServerData
{
    private final String a;
    private final int b;
    
    public ServerPingServerData(final String a, final int b) {
        this.a = a;
        this.b = b;
    }
    
    public String a() {
        return this.a;
    }
    
    public int b() {
        return this.b;
    }
}
