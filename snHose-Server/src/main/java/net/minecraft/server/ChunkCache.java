package net.minecraft.server.v1_7_R4;

public class ChunkCache implements IBlockAccess
{
    private int a;
    private int b;
    private Chunk[][] c;
    private boolean d;
    private World e;
    
    public ChunkCache(final World e, final int n, final int i, final int n2, final int n3, final int j, final int n4, final int n5) {
        this.e = e;
        this.a = n - n5 >> 4;
        this.b = n2 - n5 >> 4;
        final int n6 = n3 + n5 >> 4;
        final int n7 = n4 + n5 >> 4;
        this.c = new Chunk[n6 - this.a + 1][n7 - this.b + 1];
        this.d = true;
        for (int k = this.a; k <= n6; ++k) {
            for (int l = this.b; l <= n7; ++l) {
                final Chunk chunk = e.getChunkAt(k, l);
                if (chunk != null) {
                    this.c[k - this.a][l - this.b] = chunk;
                }
            }
        }
        for (int n8 = n >> 4; n8 <= n3 >> 4; ++n8) {
            for (int n9 = n2 >> 4; n9 <= n4 >> 4; ++n9) {
                final Chunk chunk2 = this.c[n8 - this.a][n9 - this.b];
                if (chunk2 != null && !chunk2.c(i, j)) {
                    this.d = false;
                }
            }
        }
    }
    
    @Override
    public Block getType(final int n, final int j, final int n2) {
        Block block = Blocks.AIR;
        if (j >= 0 && j < 256) {
            final int n3 = (n >> 4) - this.a;
            final int n4 = (n2 >> 4) - this.b;
            if (n3 >= 0 && n3 < this.c.length && n4 >= 0 && n4 < this.c[n3].length) {
                final Chunk chunk = this.c[n3][n4];
                if (chunk != null) {
                    block = chunk.getType(n & 0xF, j, n2 & 0xF);
                }
            }
        }
        return block;
    }
    
    @Override
    public TileEntity getTileEntity(final int n, final int j, final int n2) {
        return this.c[(n >> 4) - this.a][(n2 >> 4) - this.b].e(n & 0xF, j, n2 & 0xF);
    }
    
    @Override
    public int getData(final int n, final int j, final int n2) {
        if (j < 0) {
            return 0;
        }
        if (j >= 256) {
            return 0;
        }
        return this.c[(n >> 4) - this.a][(n2 >> 4) - this.b].getData(n & 0xF, j, n2 & 0xF);
    }
    
    @Override
    public int getBlockPower(final int i, final int j, final int k, final int l) {
        return this.getType(i, j, k).c(this, i, j, k, l);
    }
}
