package net.minecraft.server;

import java.util.concurrent.*;
import java.lang.management.*;
import java.util.*;

class CrashReportJVMFlags implements Callable
{
    final /* synthetic */ CrashReport a;
    
    CrashReportJVMFlags(final CrashReport a) {
        this.a = a;
    }
    
    public String a() {
        final List<String> inputArguments = ManagementFactory.getRuntimeMXBean().getInputArguments();
        int n = 0;
        final StringBuilder sb = new StringBuilder();
        for (final String s : inputArguments) {
            if (s.startsWith("-X")) {
                if (n++ > 0) {
                    sb.append(" ");
                }
                sb.append(s);
            }
        }
        return String.format("%d total; %s", n, sb.toString());
    }
}
