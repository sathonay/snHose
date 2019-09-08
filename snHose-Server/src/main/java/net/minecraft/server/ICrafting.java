package net.minecraft.server.v1_7_R4;

import java.util.*;

public interface ICrafting
{
    void a(final Container p0, final List p1);
    
    void a(final Container p0, final int p1, final ItemStack p2);
    
    void setContainerData(final Container p0, final int p1, final int p2);
}
