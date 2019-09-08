package net.minecraft.server.v1_7_R4;

public class ServerPing
{
    private IChatBaseComponent a;
    private ServerPingPlayerSample b;
    private ServerPingServerData c;
    private String d;
    
    public IChatBaseComponent a() {
        return this.a;
    }
    
    public void setMOTD(final IChatBaseComponent a) {
        this.a = a;
    }
    
    public ServerPingPlayerSample b() {
        return this.b;
    }
    
    public void setPlayerSample(final ServerPingPlayerSample b) {
        this.b = b;
    }
    
    public ServerPingServerData c() {
        return this.c;
    }
    
    public void setServerInfo(final ServerPingServerData c) {
        this.c = c;
    }
    
    public void setFavicon(final String d) {
        this.d = d;
    }
    
    public String d() {
        return this.d;
    }
}
