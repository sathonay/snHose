package net.minecraft.server.v1_7_R4;

import java.io.*;

public class NBTTagFloat extends NBTNumber
{
    private float data;
    
    NBTTagFloat() {
    }
    
    public NBTTagFloat(final float data) {
        this.data = data;
    }
    
    @Override
    void write(final DataOutput dataOutput) {
        dataOutput.writeFloat(this.data);
    }
    
    @Override
    void load(final DataInput dataInput, final int n, final NBTReadLimiter nbtReadLimiter) {
        nbtReadLimiter.a(32L);
        this.data = dataInput.readFloat();
    }
    
    @Override
    public byte getTypeId() {
        return 5;
    }
    
    @Override
    public String toString() {
        return "" + this.data + "f";
    }
    
    @Override
    public NBTBase clone() {
        return new NBTTagFloat(this.data);
    }
    
    @Override
    public boolean equals(final Object object) {
        return super.equals(object) && this.data == ((NBTTagFloat)object).data;
    }
    
    @Override
    public int hashCode() {
        return super.hashCode() ^ Float.floatToIntBits(this.data);
    }
    
    @Override
    public long c() {
        return (long)this.data;
    }
    
    @Override
    public int d() {
        return MathHelper.d(this.data);
    }
    
    @Override
    public short e() {
        return (short)(MathHelper.d(this.data) & 0xFFFF);
    }
    
    @Override
    public byte f() {
        return (byte)(MathHelper.d(this.data) & 0xFF);
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
