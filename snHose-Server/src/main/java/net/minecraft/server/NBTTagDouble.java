package net.minecraft.server;

import java.io.*;

public class NBTTagDouble extends NBTNumber
{
    private double data;
    
    NBTTagDouble() {
    }
    
    public NBTTagDouble(final double data) {
        this.data = data;
    }
    
    @Override
    void write(final DataOutput dataOutput) {
        dataOutput.writeDouble(this.data);
    }
    
    @Override
    void load(final DataInput dataInput, final int n, final NBTReadLimiter nbtReadLimiter) {
        nbtReadLimiter.a(64L);
        this.data = dataInput.readDouble();
    }
    
    @Override
    public byte getTypeId() {
        return 6;
    }
    
    @Override
    public String toString() {
        return "" + this.data + "d";
    }
    
    @Override
    public NBTBase clone() {
        return new NBTTagDouble(this.data);
    }
    
    @Override
    public boolean equals(final Object object) {
        return super.equals(object) && this.data == ((NBTTagDouble)object).data;
    }
    
    @Override
    public int hashCode() {
        final long doubleToLongBits = Double.doubleToLongBits(this.data);
        return super.hashCode() ^ (int)(doubleToLongBits ^ doubleToLongBits >>> 32);
    }
    
    @Override
    public long c() {
        return (long)Math.floor(this.data);
    }
    
    @Override
    public int d() {
        return MathHelper.floor(this.data);
    }
    
    @Override
    public short e() {
        return (short)(MathHelper.floor(this.data) & 0xFFFF);
    }
    
    @Override
    public byte f() {
        return (byte)(MathHelper.floor(this.data) & 0xFF);
    }
    
    @Override
    public double g() {
        return this.data;
    }
    
    @Override
    public float h() {
        return (float)this.data;
    }
}
