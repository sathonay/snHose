package net.minecraft.server;

import java.io.*;

public class NBTTagEnd extends NBTBase
{
    @Override
    void load(final DataInput dataInput, final int n, final NBTReadLimiter nbtReadLimiter) {
    }
    
    @Override
    void write(final DataOutput dataOutput) {
    }
    
    @Override
    public byte getTypeId() {
        return 0;
    }
    
    @Override
    public String toString() {
        return "END";
    }
    
    @Override
    public NBTBase clone() {
        return new NBTTagEnd();
    }
}
