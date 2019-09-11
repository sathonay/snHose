package net.minecraft.server;

import java.util.*;

public interface AttributeInstance
{
    IAttribute getAttribute();
    
    double b();
    
    void setValue(final double p0);
    
    Collection c();
    
    AttributeModifier a(final UUID p0);
    
    void a(final AttributeModifier p0);
    
    void b(final AttributeModifier p0);
    
    double getValue();
}
