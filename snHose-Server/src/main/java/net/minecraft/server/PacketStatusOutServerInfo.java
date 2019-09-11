package net.minecraft.server;

import java.lang.reflect.*;
import net.minecraft.util.com.google.gson.*;

public class PacketStatusOutServerInfo extends Packet
{
    private static final Gson a;
    private ServerPing b;
    
    public PacketStatusOutServerInfo() {
    }
    
    public PacketStatusOutServerInfo(final ServerPing b) {
        this.b = b;
    }
    
    @Override
    public void a(final PacketDataSerializer packetDataSerializer) {
        this.b = PacketStatusOutServerInfo.a.fromJson(packetDataSerializer.c(32767), ServerPing.class);
    }
    
    @Override
    public void b(final PacketDataSerializer packetDataSerializer) {
        packetDataSerializer.a(PacketStatusOutServerInfo.a.toJson(this.b));
    }
    
    public void a(final PacketStatusOutListener packetStatusOutListener) {
        packetStatusOutListener.a(this);
    }
    
    @Override
    public boolean a() {
        return true;
    }
    
    static {
        a = new GsonBuilder().registerTypeAdapter(ServerPingServerData.class, new ServerPingServerDataSerializer()).registerTypeAdapter(ServerPingPlayerSample.class, new ServerPingPlayerSampleSerializer()).registerTypeAdapter(ServerPing.class, new ServerPingSerializer()).registerTypeHierarchyAdapter(IChatBaseComponent.class, new ChatSerializer()).registerTypeHierarchyAdapter(ChatModifier.class, new ChatModifierSerializer()).registerTypeAdapterFactory(new ChatTypeAdapterFactory()).create();
    }
}
