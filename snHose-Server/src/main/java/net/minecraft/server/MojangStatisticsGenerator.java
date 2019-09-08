package net.minecraft.server.v1_7_R4;

import net.minecraft.util.com.google.common.collect.*;
import java.net.*;
import java.lang.management.*;
import java.util.*;

public class MojangStatisticsGenerator
{
    private final Map a;
    private final Map b;
    private final String c;
    private final URL d;
    private final IMojangStatistics e;
    private final Timer f;
    private final Object g;
    private final long h;
    private boolean i;
    private int j;
    
    public MojangStatisticsGenerator(final String s, final IMojangStatistics e, final long h) {
        this.a = Maps.newHashMap();
        this.b = Maps.newHashMap();
        this.c = UUID.randomUUID().toString();
        this.f = new Timer("Snooper Timer", true);
        this.g = new Object();
        try {
            this.d = new URL("http://snoop.minecraft.net/" + s + "?version=" + 2);
        }
        catch (MalformedURLException ex) {
            throw new IllegalArgumentException();
        }
        this.e = e;
        this.h = h;
    }
    
    public void a() {
        if (this.i) {
            return;
        }
        this.i = true;
        this.h();
        this.f.schedule(new MojangStatisticsTask(this), 0L, 900000L);
    }
    
    private void h() {
        this.i();
        this.a("snooper_token", this.c);
        this.b("snooper_token", this.c);
        this.b("os_name", System.getProperty("os.name"));
        this.b("os_version", System.getProperty("os.version"));
        this.b("os_architecture", System.getProperty("os.arch"));
        this.b("java_version", System.getProperty("java.version"));
        this.b("version", "1.7.10");
        this.e.b(this);
    }
    
    private void i() {
        final List<String> inputArguments = ManagementFactory.getRuntimeMXBean().getInputArguments();
        int n = 0;
        for (final String s : inputArguments) {
            if (s.startsWith("-X")) {
                this.a("jvm_arg[" + n++ + "]", s);
            }
        }
        this.a("jvm_args", n);
    }
    
    public void b() {
        this.b("memory_total", Runtime.getRuntime().totalMemory());
        this.b("memory_max", Runtime.getRuntime().maxMemory());
        this.b("memory_free", Runtime.getRuntime().freeMemory());
        this.b("cpu_cores", Runtime.getRuntime().availableProcessors());
        this.e.a(this);
    }
    
    public void a(final String s, final Object o) {
        synchronized (this.g) {
            this.b.put(s, o);
        }
    }
    
    public void b(final String s, final Object o) {
        synchronized (this.g) {
            this.a.put(s, o);
        }
    }
    
    public boolean d() {
        return this.i;
    }
    
    public void e() {
        this.f.cancel();
    }
    
    public long g() {
        return this.h;
    }
}
