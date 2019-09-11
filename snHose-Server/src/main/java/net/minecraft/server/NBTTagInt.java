package net.minecraft.server;

import java.io.*;

public class NBTTagInt extends NBTNumber
{
    private int data;
    
    NBTTagInt() {
    }
    
    public NBTTagInt(final int data) {
        this.data = data;
    }
    
    @Override
    void write(final DataOutput dataOutput) {
        dataOutput.writeInt(this.data);
    }
    
    @Override
    void load(final DataInput dataInput, final int n, final NBTReadLimiter nbtReadLimiter) {
        nbtReadLimiter.a(32L);
        this.data = dataInput.readInt();
    }
    
    @Override
    public byte getTypeId() {
        return 3;
    }
    
    @Override
    public String toString() {
        return "" + this.data;
    }
    
    @Override
    public NBTBase clone() {
        return new NBTTagInt(this.data);
    }
    
    @Override
    public boolean equals(final Object object) {
        return super.equals(object) && this.data == ((NBTTagInt)object).data;
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
        return (short)(this.data & 0xFFFF);
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
