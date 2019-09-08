package net.minecraft.server.v1_7_R4;

import java.io.*;

public class NBTTagShort extends NBTNumber
{
    private short data;
    
    public NBTTagShort() {
    }
    
    public NBTTagShort(final short data) {
        this.data = data;
    }
    
    @Override
    void write(final DataOutput dataOutput) {
        dataOutput.writeShort(this.data);
    }
    
    @Override
    void load(final DataInput dataInput, final int n, final NBTReadLimiter nbtReadLimiter) {
        nbtReadLimiter.a(16L);
        this.data = dataInput.readShort();
    }
    
    @Override
    public byte getTypeId() {
        return 2;
    }
    
    @Override
    public String toString() {
        return "" + this.data + "s";
    }
    
    @Override
    public NBTBase clone() {
        return new NBTTagShort(this.data);
    }
    
    @Override
    public boolean equals(final Object object) {
        return super.equals(object) && this.data == ((NBTTagShort)object).data;
    }
    
    @Override
    public int hashCode() {
        return super.hashCode() ^ this.data;
    }
    
    @Override
    public long c() {
        return this.data;
    }
    
    @Override
    public int d() {
        return this.data;
    }
    
    @Override
    public short e() {
        return this.data;
    }
    
    @Override
    public byte f() {
        return (byte)(this.data & 0xFF);
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
