package net.minecraft.server;

import net.minecraft.util.com.mojang.authlib.*;
import java.util.*;

public class PacketLoginInStart extends Packet
{
    private GameProfile a;
    
    public PacketLoginInStart() {
    }
    
    public PacketLoginInStart(final GameProfile a) {
        this.a = a;
    }
    
    @Override
    public void a(final PacketDataSerializer packetDataSerializer) {
        this.a = new GameProfile(null, packetDataSerializer.c(16));
    }
    
    @Override
    public void b(final PacketDataSerializer packetDataSerializer) {
        packetDataSerializer.a(this.a.getName());
    }
    
    public void a(final PacketLoginInListener packetLoginInListener) {
        packetLoginInListener.a(this);
    }
    
    public GameProfile c() {
        return this.a;
    }
}
