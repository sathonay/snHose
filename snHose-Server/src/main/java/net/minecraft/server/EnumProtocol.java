package net.minecraft.server;

import net.minecraft.util.gnu.trove.map.*;
import org.apache.logging.log4j.*;
import net.minecraft.util.gnu.trove.map.hash.*;
import net.minecraft.util.com.google.common.collect.*;
import java.util.*;

public enum EnumProtocol
{
    HANDSHAKING("HANDSHAKING", 0, -1), 
    PLAY("PLAY", 1, 0), 
    STATUS("STATUS", 2, 1), 
    LOGIN("LOGIN", 3, 2);
    
    private static final TIntObjectMap e;
    private static final Map f;
    private final int g;
    private final BiMap h;
    private final BiMap i;
    
    private EnumProtocol(final String s, final int n, final int g) {
        this.h = HashBiMap.create();
        this.i = HashBiMap.create();
        this.g = g;
    }
    
    protected EnumProtocol a(final int n, final Class clazz) {
        if (this.h.containsKey(n)) {
            final String string = "Serverbound packet ID " + n + " is already assigned to " + this.h.get(n) + "; cannot re-assign to " + clazz;
            LogManager.getLogger().fatal(string);
            throw new IllegalArgumentException(string);
        }
        if (this.h.containsValue(clazz)) {
            final String string2 = "Serverbound packet " + clazz + " is already assigned to ID " + this.h.inverse().get(clazz) + "; cannot re-assign to " + n;
            LogManager.getLogger().fatal(string2);
            throw new IllegalArgumentException(string2);
        }
        this.h.put(n, clazz);
        return this;
    }
    
    protected EnumProtocol b(final int n, final Class clazz) {
        if (this.i.containsKey(n)) {
            final String string = "Clientbound packet ID " + n + " is already assigned to " + this.i.get(n) + "; cannot re-assign to " + clazz;
            LogManager.getLogger().fatal(string);
            throw new IllegalArgumentException(string);
        }
        if (this.i.containsValue(clazz)) {
            final String string2 = "Clientbound packet " + clazz + " is already assigned to ID " + this.i.inverse().get(clazz) + "; cannot re-assign to " + n;
            LogManager.getLogger().fatal(string2);
            throw new IllegalArgumentException(string2);
        }
        this.i.put(n, clazz);
        return this;
    }
    
    public BiMap a() {
        return this.h;
    }
    
    public BiMap b() {
        return this.i;
    }
    
    public BiMap a(final boolean b) {
        return b ? this.b() : this.a();
    }
    
    public BiMap b(final boolean b) {
        return b ? this.a() : this.b();
    }
    
    public int c() {
        return this.g;
    }
    
    public static EnumProtocol a(final int n) {
        return EnumProtocol.e.get(n);
    }
    
    public static EnumProtocol a(final Packet packet) {
        return EnumProtocol.f.get(packet.getClass());
    }
    
    static {
        e = new TIntObjectHashMap();
        f = Maps.newHashMap();
        for (final EnumProtocol enumProtocol : values()) {
            EnumProtocol.e.put(enumProtocol.c(), enumProtocol);
            for (final Class clazz : Iterables.concat((Iterable<? extends Class>)enumProtocol.b().values(), (Iterable<? extends Class>)enumProtocol.a().values())) {
                if (EnumProtocol.f.containsKey(clazz) && EnumProtocol.f.get(clazz) != enumProtocol) {
                    throw new Error("Packet " + clazz + " is already assigned to protocol " + EnumProtocol.f.get(clazz) + " - can't reassign to " + enumProtocol);
                }
                EnumProtocol.f.put(clazz, enumProtocol);
            }
        }
    }
}
