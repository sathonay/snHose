package net.minecraft.server.v1_7_R4;

public class OldChunk
{
    public long a;
    public boolean b;
    public byte[] c;
    public OldNibbleArray d;
    public OldNibbleArray e;
    public OldNibbleArray f;
    public byte[] g;
    public NBTTagList h;
    public NBTTagList i;
    public NBTTagList j;
    public final int k;
    public final int l;
    
    public OldChunk(final int k, final int l) {
        this.k = k;
        this.l = l;
    }
}
