package net.minecraft.server;

import java.util.concurrent.*;
import java.util.*;

public class CrashReportSystemDetails
{
    private final CrashReport a;
    private final String b;
    private final List c;
    private StackTraceElement[] d;
    
    public CrashReportSystemDetails(final CrashReport a, final String b) {
        this.c = new ArrayList();
        this.d = new StackTraceElement[0];
        this.a = a;
        this.b = b;
    }
    
    public static String a(final int n, final int n2, final int n3) {
        final StringBuilder sb = new StringBuilder();
        try {
            sb.append(String.format("World: (%d,%d,%d)", n, n2, n3));
        }
        catch (Throwable t) {
            sb.append("(Error finding world loc)");
        }
        sb.append(", ");
        try {
            final int n4 = n >> 4;
            final int n5 = n3 >> 4;
            sb.append(String.format("Chunk: (at %d,%d,%d in %d,%d; contains blocks %d,0,%d to %d,255,%d)", n & 0xF, n2 >> 4, n3 & 0xF, n4, n5, n4 << 4, n5 << 4, (n4 + 1 << 4) - 1, (n5 + 1 << 4) - 1));
        }
        catch (Throwable t2) {
            sb.append("(Error finding chunk loc)");
        }
        sb.append(", ");
        try {
            final int n6 = n >> 9;
            final int n7 = n3 >> 9;
            sb.append(String.format("Region: (%d,%d; contains chunks %d,%d to %d,%d, blocks %d,0,%d to %d,255,%d)", n6, n7, n6 << 5, n7 << 5, (n6 + 1 << 5) - 1, (n7 + 1 << 5) - 1, n6 << 9, n7 << 9, (n6 + 1 << 9) - 1, (n7 + 1 << 9) - 1));
        }
        catch (Throwable t3) {
            sb.append("(Error finding world loc)");
        }
        return sb.toString();
    }
    
    public void a(final String s, final Callable callable) {
        try {
            this.a(s, callable.call());
        }
        catch (Throwable t) {
            this.a(s, t);
        }
    }
    
    public void a(final String s, final Object o) {
        this.c.add(new CrashReportDetail(s, o));
    }
    
    public void a(final String s, final Throwable t) {
        this.a(s, (Object)t);
    }
    
    public int a(final int n) {
        final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length <= 0) {
            return 0;
        }
        System.arraycopy(stackTrace, 3 + n, this.d = new StackTraceElement[stackTrace.length - 3 - n], 0, this.d.length);
        return this.d.length;
    }
    
    public boolean a(final StackTraceElement stackTraceElement, final StackTraceElement stackTraceElement2) {
        if (this.d.length == 0 || stackTraceElement == null) {
            return false;
        }
        final StackTraceElement stackTraceElement3 = this.d[0];
        if (stackTraceElement3.isNativeMethod() != stackTraceElement.isNativeMethod() || !stackTraceElement3.getClassName().equals(stackTraceElement.getClassName()) || !stackTraceElement3.getFileName().equals(stackTraceElement.getFileName()) || !stackTraceElement3.getMethodName().equals(stackTraceElement.getMethodName())) {
            return false;
        }
        if (stackTraceElement2 != null != this.d.length > 1) {
            return false;
        }
        if (stackTraceElement2 != null && !this.d[1].equals(stackTraceElement2)) {
            return false;
        }
        this.d[0] = stackTraceElement;
        return true;
    }
    
    public void b(final int n) {
        final StackTraceElement[] d = new StackTraceElement[this.d.length - n];
        System.arraycopy(this.d, 0, d, 0, d.length);
        this.d = d;
    }
    
    public void a(final StringBuilder sb) {
        sb.append("-- ").append(this.b).append(" --\n");
        sb.append("Details:");
        for (final CrashReportDetail crashReportDetail : this.c) {
            sb.append("\n\t");
            sb.append(crashReportDetail.a());
            sb.append(": ");
            sb.append(crashReportDetail.b());
        }
        if (this.d != null && this.d.length > 0) {
            sb.append("\nStacktrace:");
            for (final StackTraceElement stackTraceElement : this.d) {
                sb.append("\n\tat ");
                sb.append(stackTraceElement.toString());
            }
        }
    }
    
    public StackTraceElement[] a() {
        return this.d;
    }
    
    public static void a(final CrashReportSystemDetails crashReportSystemDetails, final int n, final int n2, final int n3, final Block block, final int n4) {
        crashReportSystemDetails.a("Block type", new CrashReportBlockType(Block.getId(block), block));
        crashReportSystemDetails.a("Block data value", new CrashReportBlockDataValue(n4));
        crashReportSystemDetails.a("Block location", new CrashReportBlockLocation(n, n2, n3));
    }
}
