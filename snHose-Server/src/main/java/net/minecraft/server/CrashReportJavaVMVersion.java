package net.minecraft.server;

import java.util.concurrent.*;

class CrashReportJavaVMVersion implements Callable
{
    final /* synthetic */ CrashReport a;
    
    CrashReportJavaVMVersion(final CrashReport a) {
        this.a = a;
    }
    
    public String a() {
        return System.getProperty("java.vm.name") + " (" + System.getProperty("java.vm.info") + "), " + System.getProperty("java.vm.vendor");
    }
}
