package net.minecraft.server;

import java.util.concurrent.*;

class CrashReportLevelStorageVersion implements Callable
{
    final /* synthetic */ WorldData a;
    
    CrashReportLevelStorageVersion(final WorldData a) {
        this.a = a;
    }
    
    public String a() {
        String s = "Unknown?";
        try {
            switch (WorldData.j(this.a)) {
                case 19133: {
                    s = "Anvil";
                    break;
                }
                case 19132: {
                    s = "McRegion";
                    break;
                }
            }
        }
        catch (Throwable t) {}
        return String.format("0x%05X - %s", WorldData.j(this.a), s);
    }
}
