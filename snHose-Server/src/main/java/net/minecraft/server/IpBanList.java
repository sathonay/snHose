package net.minecraft.server.v1_7_R4;

import java.io.*;
import net.minecraft.util.com.google.gson.*;
import java.net.*;

public class IpBanList extends JsonList
{
    public IpBanList(final File file1) {
        super(file1);
    }
    
    @Override
    protected JsonListEntry a(final JsonObject jsonObject) {
        return new IpBanEntry(jsonObject);
    }
    
    public boolean isBanned(final SocketAddress socketAddress) {
        return this.d(this.c(socketAddress));
    }
    
    public IpBanEntry get(final SocketAddress socketAddress) {
        return (IpBanEntry)this.get(this.c(socketAddress));
    }
    
    private String c(final SocketAddress socketAddress) {
        String s = socketAddress.toString();
        if (s.contains("/")) {
            s = s.substring(s.indexOf(47) + 1);
        }
        if (s.contains(":")) {
            s = s.substring(0, s.indexOf(58));
        }
        return s;
    }
}
