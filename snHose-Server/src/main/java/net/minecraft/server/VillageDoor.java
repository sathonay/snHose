package net.minecraft.server;

public class VillageDoor
{
    public final int locX;
    public final int locY;
    public final int locZ;
    public final int d;
    public final int e;
    public int addedTime;
    public boolean removed;
    private int bookings;
    
    public VillageDoor(final int locX, final int locY, final int locZ, final int d, final int e, final int addedTime) {
        this.locX = locX;
        this.locY = locY;
        this.locZ = locZ;
        this.d = d;
        this.e = e;
        this.addedTime = addedTime;
    }
    
    public int b(final int n, final int n2, final int n3) {
        final int n4 = n - this.locX;
        final int n5 = n2 - this.locY;
        final int n6 = n3 - this.locZ;
        return n4 * n4 + n5 * n5 + n6 * n6;
    }
    
    public int c(final int n, final int n2, final int n3) {
        final int n4 = n - this.locX - this.d;
        final int n5 = n2 - this.locY;
        final int n6 = n3 - this.locZ - this.e;
        return n4 * n4 + n5 * n5 + n6 * n6;
    }
    
    public int getIndoorsX() {
        return this.locX + this.d;
    }
    
    public int getIndoorsY() {
        return this.locY;
    }
    
    public int getIndoorsZ() {
        return this.locZ + this.e;
    }
    
    public boolean a(final int n, final int n2) {
        return (n - this.locX) * this.d + (n2 - this.locZ) * this.e >= 0;
    }
    
    public void d() {
        this.bookings = 0;
    }
    
    public void e() {
        ++this.bookings;
    }
    
    public int f() {
        return this.bookings;
    }
}
