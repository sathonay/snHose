package net.minecraft.server.v1_7_R4;

import java.util.*;

public class BiomeIcePlains extends BiomeBase
{
    private boolean aC;
    private WorldGenPackedIce2 aD;
    private WorldGenPackedIce1 aE;
    
    public BiomeIcePlains(final int i, final boolean ac) {
        super(i);
        this.aD = new WorldGenPackedIce2();
        this.aE = new WorldGenPackedIce1(4);
        this.aC = ac;
        if (ac) {
            this.ai = Blocks.SNOW_BLOCK;
        }
        this.at.clear();
    }
    
    @Override
    public void a(final World world, final Random random, final int i, final int j) {
        if (this.aC) {
            for (int k = 0; k < 3; ++k) {
                final int n = i + random.nextInt(16) + 8;
                final int n2 = j + random.nextInt(16) + 8;
                this.aD.generate(world, random, n, world.getHighestBlockYAt(n, n2), n2);
            }
            for (int l = 0; l < 2; ++l) {
                final int m = i + random.nextInt(16) + 8;
                final int j2 = j + random.nextInt(16) + 8;
                this.aE.generate(world, random, m, world.getHighestBlockYAt(m, j2), j2);
            }
        }
        super.a(world, random, i, j);
    }
    
    @Override
    public WorldGenTreeAbstract a(final Random random) {
        return new WorldGenTaiga2(false);
    }
    
    @Override
    protected BiomeBase k() {
        final BiomeBase a = new BiomeIcePlains(this.id + 128, true).a(13828095, true).a(this.af + " Spikes").c().a(0.0f, 0.5f).a(new BiomeTemperature(this.am + 0.1f, this.an + 0.1f));
        a.am = this.am + 0.3f;
        a.an = this.an + 0.4f;
        return a;
    }
}
