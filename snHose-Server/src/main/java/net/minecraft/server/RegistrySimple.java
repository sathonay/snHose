package net.minecraft.server.v1_7_R4;

import net.minecraft.util.com.google.common.collect.*;
import java.util.*;
import org.apache.logging.log4j.*;

public class RegistrySimple implements IRegistry
{
    private static final Logger a;
    protected final Map c;
    
    public RegistrySimple() {
        this.c = this.a();
    }
    
    protected Map a() {
        return Maps.newHashMap();
    }
    
    @Override
    public Object get(final Object o) {
        return this.c.get(o);
    }
    
    @Override
    public void a(final Object o, final Object o2) {
        if (this.c.containsKey(o)) {
            RegistrySimple.a.debug("Adding duplicate key '" + o + "' to registry");
        }
        this.c.put(o, o2);
    }
    
    public Set keySet() {
        return Collections.unmodifiableSet(this.c.keySet());
    }
    
    public boolean d(final Object o) {
        return this.c.containsKey(o);
    }
    
    static {
        a = LogManager.getLogger();
    }
}
