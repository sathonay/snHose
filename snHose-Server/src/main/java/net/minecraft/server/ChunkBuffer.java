package net.minecraft.server;

import java.io.*;

class ChunkBuffer extends ByteArrayOutputStream
{
    private int b;
    private int c;
    final /* synthetic */ RegionFile a;
    
    public ChunkBuffer(final RegionFile a, final int b, final int c) {
        this.a = a;
        super(8096);
        this.b = b;
        this.c = c;
    }
    
    @Override
    public void close() {
        this.a.a(this.b, this.c, this.buf, this.count);
    }
}
