package net.minecraft.server;

import java.util.concurrent.*;

class CrashReportCorruptNBTTag2 implements Callable
{
    final /* synthetic */ int a;
    final /* synthetic */ NBTTagCompound b;
    
    CrashReportCorruptNBTTag2(final NBTTagCompound b, final int a) {
        this.b = b;
        this.a = a;
    }
    
    public String a() {
        return NBTBase.a[this.a];
    }
}
