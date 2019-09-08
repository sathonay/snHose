package net.minecraft.server.v1_7_R4;

import java.util.concurrent.*;

class CrashReportLevelWeather implements Callable
{
    final /* synthetic */ WorldData a;
    
    CrashReportLevelWeather(final WorldData a) {
        this.a = a;
    }
    
    public String a() {
        return String.format("Rain time: %d (now: %b), thunder time: %d (now: %b)", WorldData.k(this.a), WorldData.l(this.a), WorldData.m(this.a), WorldData.n(this.a));
    }
}
