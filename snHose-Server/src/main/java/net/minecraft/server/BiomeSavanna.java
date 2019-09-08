package net.minecraft.server.v1_7_R4;

import java.util.*;

public class BiomeSavanna extends BiomeBase
{
    private static final WorldGenAcaciaTree aC;
    
    protected BiomeSavanna(final int i) {
        super(i);
        this.at.add(new BiomeMeta(EntityHorse.class, 1, 2, 6));
        this.ar.x = 1;
        this.ar.y = 4;
        this.ar.z = 20;
    }
    
    @Override
    public WorldGenTreeAbstract a(final Random random) {
        if (random.nextInt(5) > 0) {
            return BiomeSavanna.aC;
        }
        return this.az;
    }
    
    @Override
    protected BiomeBase k() {
        final BiomeSavannaSub biomeSavannaSub = new BiomeSavannaSub(this.id + 128, this);
        biomeSavannaSub.temperature = (this.temperature + 1.0f) * 0.5f;
        biomeSavannaSub.am = this.am * 0.5f + 0.3f;
        biomeSavannaSub.an = this.an * 0.5f + 1.2f;
        return biomeSavannaSub;
    }
    
    @Override
    public void a(final World world, final Random random, final int i, final int j) {
        BiomeSavanna.ae.a(2);
        for (int k = 0; k < 7; ++k) {
            final int l = i + random.nextInt(16) + 8;
            final int m = j + random.nextInt(16) + 8;
            BiomeSavanna.ae.generate(world, random, l, random.nextInt(world.getHighestBlockYAt(l, m) + 32), m);
        }
        super.a(world, random, i, j);
    }
    
    static {
        aC = new WorldGenAcaciaTree(false);
    }
}
