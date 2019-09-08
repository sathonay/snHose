package net.minecraft.server.v1_7_R4;

import java.util.*;

public class BiomeSwamp extends BiomeBase
{
    protected BiomeSwamp(final int i) {
        super(i);
        this.ar.x = 2;
        this.ar.y = 1;
        this.ar.A = 1;
        this.ar.B = 8;
        this.ar.C = 10;
        this.ar.G = 1;
        this.ar.w = 4;
        this.ar.F = 0;
        this.ar.E = 0;
        this.ar.z = 5;
        this.aq = 14745518;
        this.as.add(new BiomeMeta(EntitySlime.class, 1, 1, 1));
    }
    
    @Override
    public WorldGenTreeAbstract a(final Random random) {
        return this.aB;
    }
    
    @Override
    public String a(final Random random, final int n, final int n2, final int n3) {
        return BlockFlowers.a[1];
    }
    
    @Override
    public void a(final World world, final Random random, final Block[] ablock, final byte[] abyte, final int i, final int j, final double d0) {
        final double a = BiomeSwamp.ad.a(i * 0.25, j * 0.25);
        if (a > 0.0) {
            final int n = i & 0xF;
            final int n2 = j & 0xF;
            final int n3 = ablock.length / 256;
            int k = 255;
            while (k >= 0) {
                final int n4 = (n2 * 16 + n) * n3 + k;
                if (ablock[n4] == null || ablock[n4].getMaterial() != Material.AIR) {
                    if (k != 62 || ablock[n4] == Blocks.STATIONARY_WATER) {
                        break;
                    }
                    ablock[n4] = Blocks.STATIONARY_WATER;
                    if (a < 0.12) {
                        ablock[n4 + 1] = Blocks.WATER_LILY;
                        break;
                    }
                    break;
                }
                else {
                    --k;
                }
            }
        }
        this.b(world, random, ablock, abyte, i, j, d0);
    }
}
