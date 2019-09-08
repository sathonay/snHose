package net.minecraft.server.v1_7_R4;

import java.util.*;

public class BiomeForest extends BiomeBase
{
    private int aF;
    protected static final WorldGenForest aC;
    protected static final WorldGenForest aD;
    protected static final WorldGenForestTree aE;
    
    public BiomeForest(final int i, final int af) {
        super(i);
        this.aF = af;
        this.ar.x = 10;
        this.ar.z = 2;
        if (this.aF == 1) {
            this.ar.x = 6;
            this.ar.y = 100;
            this.ar.z = 1;
        }
        this.a(5159473);
        this.a(0.7f, 0.8f);
        if (this.aF == 2) {
            this.ah = 353825;
            this.ag = 3175492;
            this.a(0.6f, 0.6f);
        }
        if (this.aF == 0) {
            this.at.add(new BiomeMeta(EntityWolf.class, 5, 4, 4));
        }
        if (this.aF == 3) {
            this.ar.x = -999;
        }
    }
    
    @Override
    protected BiomeBase a(final int n, final boolean flag) {
        if (this.aF == 2) {
            this.ah = 353825;
            this.ag = n;
            if (flag) {
                this.ah = (this.ah & 0xFEFEFE) >> 1;
            }
            return this;
        }
        return super.a(n, flag);
    }
    
    @Override
    public WorldGenTreeAbstract a(final Random random) {
        if (this.aF == 3 && random.nextInt(3) > 0) {
            return BiomeForest.aE;
        }
        if (this.aF == 2 || random.nextInt(5) == 0) {
            return BiomeForest.aD;
        }
        return this.az;
    }
    
    @Override
    public String a(final Random random, final int i, final int j, final int k) {
        if (this.aF == 1) {
            int n = (int)(MathHelper.a((1.0 + BiomeForest.ad.a(i / 48.0, k / 48.0)) / 2.0, 0.0, 0.9999) * BlockFlowers.a.length);
            if (n == 1) {
                n = 0;
            }
            return BlockFlowers.a[n];
        }
        return super.a(random, i, j, k);
    }
    
    @Override
    public void a(final World world, final Random random, final int i, final int j) {
        if (this.aF == 3) {
            for (int k = 0; k < 4; ++k) {
                for (int l = 0; l < 4; ++l) {
                    final int m = i + k * 4 + 1 + 8 + random.nextInt(3);
                    final int j2 = j + l * 4 + 1 + 8 + random.nextInt(3);
                    final int highestBlockYAt = world.getHighestBlockYAt(m, j2);
                    if (random.nextInt(20) == 0) {
                        new WorldGenHugeMushroom().generate(world, random, m, highestBlockYAt, j2);
                    }
                    else {
                        final WorldGenTreeAbstract a = this.a(random);
                        a.a(1.0, 1.0, 1.0);
                        if (a.generate(world, random, m, highestBlockYAt, j2)) {
                            a.b(world, random, m, highestBlockYAt, j2);
                        }
                    }
                }
            }
        }
        int n = random.nextInt(5) - 3;
        if (this.aF == 1) {
            n += 2;
        }
        for (int n2 = 0; n2 < n; ++n2) {
            final int nextInt = random.nextInt(3);
            if (nextInt == 0) {
                BiomeForest.ae.a(1);
            }
            else if (nextInt == 1) {
                BiomeForest.ae.a(4);
            }
            else if (nextInt == 2) {
                BiomeForest.ae.a(5);
            }
            for (int n3 = 0; n3 < 5; ++n3) {
                final int i2 = i + random.nextInt(16) + 8;
                final int j3 = j + random.nextInt(16) + 8;
                if (BiomeForest.ae.generate(world, random, i2, random.nextInt(world.getHighestBlockYAt(i2, j3) + 32), j3)) {
                    break;
                }
            }
        }
        super.a(world, random, i, j);
    }
    
    @Override
    protected BiomeBase k() {
        if (this.id == BiomeBase.FOREST.id) {
            final BiomeForest biomeForest = new BiomeForest(this.id + 128, 1);
            biomeForest.a(new BiomeTemperature(this.am, this.an + 0.2f));
            biomeForest.a("Flower Forest");
            biomeForest.a(6976549, true);
            biomeForest.a(8233509);
            return biomeForest;
        }
        if (this.id == BiomeBase.BIRCH_FOREST.id || this.id == BiomeBase.BIRCH_FOREST_HILLS.id) {
            return new BiomeBaseSubForest(this, this.id + 128, this);
        }
        return new BiomeBaseSubForest2(this, this.id + 128, this);
    }
    
    static {
        aC = new WorldGenForest(false, true);
        aD = new WorldGenForest(false, false);
        aE = new WorldGenForestTree(false);
    }
}
