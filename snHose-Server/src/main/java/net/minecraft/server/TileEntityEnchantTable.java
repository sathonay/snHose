package net.minecraft.server;

import java.util.*;

public class TileEntityEnchantTable extends TileEntity
{
    public int a;
    public float i;
    public float j;
    public float k;
    public float l;
    public float m;
    public float n;
    public float o;
    public float p;
    public float q;
    private static Random r;
    private String s;
    
    @Override
    public void b(final NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
        if (this.b()) {
            nbttagcompound.setString("CustomName", this.s);
        }
    }
    
    @Override
    public void a(final NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
        if (nbttagcompound.hasKeyOfType("CustomName", 8)) {
            this.s = nbttagcompound.getString("CustomName");
        }
    }
    
    @Override
    public void h() {
        super.h();
        this.n = this.m;
        this.p = this.o;
        final EntityHuman nearbyPlayer = this.world.findNearbyPlayer(this.x + 0.5f, this.y + 0.5f, this.z + 0.5f, 3.0);
        if (nearbyPlayer != null) {
            this.q = (float)Math.atan2(nearbyPlayer.locZ - (this.z + 0.5f), nearbyPlayer.locX - (this.x + 0.5f));
            this.m += 0.1f;
            if (this.m < 0.5f || TileEntityEnchantTable.r.nextInt(40) == 0) {
                do {
                    this.k += TileEntityEnchantTable.r.nextInt(4) - TileEntityEnchantTable.r.nextInt(4);
                } while (this.k == this.k);
            }
        }
        else {
            this.q += 0.02f;
            this.m -= 0.1f;
        }
        while (this.o >= 3.1415927f) {
            this.o -= 6.2831855f;
        }
        while (this.o < -3.1415927f) {
            this.o += 6.2831855f;
        }
        while (this.q >= 3.1415927f) {
            this.q -= 6.2831855f;
        }
        while (this.q < -3.1415927f) {
            this.q += 6.2831855f;
        }
        float n;
        for (n = this.q - this.o; n >= 3.1415927f; n -= 6.2831855f) {}
        while (n < -3.1415927f) {
            n += 6.2831855f;
        }
        this.o += n * 0.4f;
        if (this.m < 0.0f) {
            this.m = 0.0f;
        }
        if (this.m > 1.0f) {
            this.m = 1.0f;
        }
        ++this.a;
        this.j = this.i;
        float n2 = (this.k - this.i) * 0.4f;
        final float n3 = 0.2f;
        if (n2 < -n3) {
            n2 = -n3;
        }
        if (n2 > n3) {
            n2 = n3;
        }
        this.l += (n2 - this.l) * 0.9f;
        this.i += this.l;
    }
    
    public String a() {
        return this.b() ? this.s : "container.enchant";
    }
    
    public boolean b() {
        return this.s != null && this.s.length() > 0;
    }
    
    public void a(final String s) {
        this.s = s;
    }
    
    static {
        TileEntityEnchantTable.r = new Random();
    }
}
