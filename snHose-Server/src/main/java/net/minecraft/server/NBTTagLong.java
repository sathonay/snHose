package net.minecraft.server.v1_7_R4;

import java.io.*;

public class NBTTagLong extends NBTNumber
{
    private long data;
    
    NBTTagLong() {
    }
    
    public NBTTagLong(final long data) {
        this.data = data;
    }
    
    @Override
    void write(final DataOutput dataOutput) {
        dataOutput.writeLong(this.data);
    }
    
    @Override
    void load(final DataInput dataInput, final int n, final NBTReadLimiter nbtReadLimiter) {
        nbtReadLimiter.a(64L);
        this.data = dataInput.readLong();
    }
    
    @Override
    public byte getTypeId() {
        return 4;
    }
    
    @Override
    public String toString() {
        return "" + this.data + "L";
    }
    
    @Override
    public NBTBase clone() {
        return new NBTTagLong(this.data);
    }
    
    @Override
    public boolean equals(final Object object) {
        return super.equals(object) && this.data == ((NBTTagLong)object).data;
    }
    
    @Override
    public int hashCode() {
        return super.hashCode() ^ (int)(this.data ^ this.data >>> 32);
    }
    
    @Override
    public long c() {
        return this.data;
    }
    
    @Override
    public int d() {
        return (int)(this.data & -1L);
    }
    
    @Override
    public short e() {
        return (short)(this.data & 0xFFFFL);
    }
    
    @Override
    public byte f() {
        return (byte)(this.data & 0xFFL);
    }
    
    @Override
    public double g() {
        return this.data;
    }
    
    @Override
    public float h() {
        return this.data;
    }
}
