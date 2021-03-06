package net.minecraft.server;

public class ReportedException extends RuntimeException
{
    private final CrashReport a;
    
    public ReportedException(final CrashReport a) {
        this.a = a;
    }
    
    public CrashReport a() {
        return this.a;
    }
    
    @Override
    public Throwable getCause() {
        return this.a.b();
    }
    
    @Override
    public String getMessage() {
        return this.a.a();
    }
}
