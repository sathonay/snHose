package net.minecraft.server;

public interface IWorldAccess
{
    void a(final int p0, final int p1, final int p2);
    
    void b(final int p0, final int p1, final int p2);
    
    void a(final int p0, final int p1, final int p2, final int p3, final int p4, final int p5);
    
    void a(final String p0, final double p1, final double p2, final double p3, final float p4, final float p5);
    
    void a(final EntityHuman p0, final String p1, final double p2, final double p3, final double p4, final float p5, final float p6);
    
    void a(final String p0, final double p1, final double p2, final double p3, final double p4, final double p5, final double p6);
    
    void a(final Entity p0);
    
    void b(final Entity p0);
    
    void a(final String p0, final int p1, final int p2, final int p3);
    
    void a(final int p0, final int p1, final int p2, final int p3, final int p4);
    
    void a(final EntityHuman p0, final int p1, final int p2, final int p3, final int p4, final int p5);
    
    void b(final int p0, final int p1, final int p2, final int p3, final int p4);
    
    void b();
}
