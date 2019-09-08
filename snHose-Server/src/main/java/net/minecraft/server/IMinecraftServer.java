package net.minecraft.server.v1_7_R4;

public interface IMinecraftServer
{
    int a(final String p0, final int p1);
    
    String a(final String p0, final String p1);
    
    void a(final String p0, final Object p1);
    
    void a();
    
    String b();
    
    String y();
    
    int z();
    
    String A();
    
    String getVersion();
    
    int C();
    
    int D();
    
    String[] getPlayers();
    
    String O();
    
    String getPlugins();
    
    String g(final String p0);
    
    boolean isDebugging();
    
    void info(final String p0);
    
    void warning(final String p0);
    
    void h(final String p0);
    
    void i(final String p0);
}
