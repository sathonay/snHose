package net.minecraft.server.v1_7_R4;

import java.io.*;

public class RemoteStatusReply
{
    private ByteArrayOutputStream buffer;
    private DataOutputStream stream;
    
    public RemoteStatusReply(final int n) {
        this.buffer = new ByteArrayOutputStream(n);
        this.stream = new DataOutputStream(this.buffer);
    }
    
    public void write(final byte[] array) {
        this.stream.write(array, 0, array.length);
    }
    
    public void write(final String s) {
        this.stream.writeBytes(s);
        this.stream.write(0);
    }
    
    public void write(final int n) {
        this.stream.write(n);
    }
    
    public void write(final short n) {
        this.stream.writeShort(Short.reverseBytes(n));
    }
    
    public byte[] getBytes() {
        return this.buffer.toByteArray();
    }
    
    public void reset() {
        this.buffer.reset();
    }
}
