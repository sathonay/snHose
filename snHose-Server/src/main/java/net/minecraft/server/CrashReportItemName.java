package net.minecraft.server;

import java.util.concurrent.*;

class CrashReportItemName implements Callable
{
    final /* synthetic */ ItemStack a;
    final /* synthetic */ PlayerInventory b;
    
    CrashReportItemName(final PlayerInventory b, final ItemStack a) {
        this.b = b;
        this.a = a;
    }
    
    public String a() {
        return this.a.getName();
    }
}
