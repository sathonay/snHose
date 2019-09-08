package net.minecraft.server.v1_7_R4;

public class GenLayerRiverMix extends GenLayer
{
    private GenLayer c;
    private GenLayer d;
    
    public GenLayerRiverMix(final long n, final GenLayer c, final GenLayer d) {
        super(n);
        this.c = c;
        this.d = d;
    }
    
    @Override
    public void a(final long n) {
        this.c.a(n);
        this.d.a(n);
        super.a(n);
    }
    
    @Override
    public int[] a(final int n, final int n2, final int n3, final int n4) {
        final int[] a = this.c.a(n, n2, n3, n4);
        final int[] a2 = this.d.a(n, n2, n3, n4);
        final int[] a3 = IntCache.a(n3 * n4);
        for (int i = 0; i < n3 * n4; ++i) {
            if (a[i] == BiomeBase.OCEAN.id || a[i] == BiomeBase.DEEP_OCEAN.id) {
                a3[i] = a[i];
            }
            else if (a2[i] == BiomeBase.RIVER.id) {
                if (a[i] == BiomeBase.ICE_PLAINS.id) {
                    a3[i] = BiomeBase.FROZEN_RIVER.id;
                }
                else if (a[i] == BiomeBase.MUSHROOM_ISLAND.id || a[i] == BiomeBase.MUSHROOM_SHORE.id) {
                    a3[i] = BiomeBase.MUSHROOM_SHORE.id;
                }
                else {
                    a3[i] = (a2[i] & 0xFF);
                }
            }
            else {
                a3[i] = a[i];
            }
        }
        return a3;
    }
}
