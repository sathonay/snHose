package net.minecraft.server;

import java.util.concurrent.*;

final class CrashReportGenLayer2 implements Callable
{
    final /* synthetic */ int a;
    
    CrashReportGenLayer2(final int a) {
        this.a = a;
    }
    
    public String a() {
        return String.valueOf(BiomeBase.getBiome(this.a));
    }
}
