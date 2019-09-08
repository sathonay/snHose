package net.minecraft.server.v1_7_R4;

import java.io.*;

public class NBTTagByte extends NBTNumber
{
    private byte data;
    
    NBTTagByte() {
    }
    
    public NBTTagByte(final byte data) {
        this.data = data;
    }
    
    @Override
    void write(final DataOutput dataOutput) {
        dataOutput.writeByte(this.data);
    }
    
    @Override
    void load(final DataInput dataInput, final int n, final NBTReadLimiter nbtReadLimiter) {
        nbtReadLimiter.a(8L);
        this.data = dataInput.readByte();
    }
    
    @Override
    public byte getTypeId() {
        return 1;
    }
    
    @Override
    public String toString() {
        return "" + this.data + "b";
    }
    
    @Override
    public NBTBase clone() {
        return new NBTTagByte(this.data);
    }
    
    @Override
    public boolean equals(final Object object) {
        return super.equals(object) && this.data == ((NBTTagByte)object).data;
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
        return this.data;
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
