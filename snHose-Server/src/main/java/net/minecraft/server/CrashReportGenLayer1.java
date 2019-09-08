package net.minecraft.server.v1_7_R4;

import java.util.concurrent.*;

final class CrashReportGenLayer1 implements Callable
{
    final /* synthetic */ int a;
    
    CrashReportGenLayer1(final int a) {
        this.a = a;
    }
    
    public String a() {
        return String.valueOf(BiomeBase.getBiome(this.a));
    }
}
