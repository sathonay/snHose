package net.minecraft.server;

import java.util.*;

public interface ICrafting
{
    void a(final Container p0, final List p1);
    
    void a(final Container p0, final int p1, final ItemStack p2);
    
    void setContainerData(final Container p0, final int p1, final int p2);
}
