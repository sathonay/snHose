package net.minecraft.server;

public interface Convertable
{
    IDataManager a(final String p0, final boolean p1);
    
    void d();
    
    boolean e(final String p0);
    
    boolean isConvertable(final String p0);
    
    boolean convert(final String p0, final IProgressUpdate p1);
}
