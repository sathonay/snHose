package net.minecraft.server;

import java.io.*;

public class NBTTagString extends NBTBase
{
    private String data;
    
    public NBTTagString() {
        this.data = "";
    }
    
    public NBTTagString(final String data) {
        this.data = data;
        if (data == null) {
            throw new IllegalArgumentException("Empty string not allowed");
        }
    }
    
    @Override
    void write(final DataOutput dataOutput) {
        dataOutput.writeUTF(this.data);
    }
    
    @Override
    void load(final DataInput dataInput, final int n, final NBTReadLimiter nbtReadLimiter) {
        this.data = dataInput.readUTF();
        nbtReadLimiter.a(16 * this.data.length());
    }
    
    @Override
    public byte getTypeId() {
        return 8;
    }
    
    @Override
    public String toString() {
        return "\"" + this.data + "\"";
    }
    
    @Override
    public NBTBase clone() {
        return new NBTTagString(this.data);
    }
    
    @Override
    public boolean equals(final Object object) {
        if (super.equals(object)) {
            final NBTTagString nbtTagString = (NBTTagString)object;
            return (this.data == null && nbtTagString.data == null) || (this.data != null && this.data.equals(nbtTagString.data));
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return super.hashCode() ^ this.data.hashCode();
    }
    
    public String a_() {
        return this.data;
    }
}
