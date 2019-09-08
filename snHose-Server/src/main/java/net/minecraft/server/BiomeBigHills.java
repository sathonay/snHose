package net.minecraft.server.v1_7_R4;

import java.util.*;

public class BiomeBigHills extends BiomeBase
{
    private WorldGenerator aC;
    private WorldGenTaiga2 aD;
    private int aE;
    private int aF;
    private int aG;
    private int aH;
    
    protected BiomeBigHills(final int i, final boolean b) {
        super(i);
        this.aC = new WorldGenMinable(Blocks.MONSTER_EGGS, 8);
        this.aD = new WorldGenTaiga2(false);
        this.aE = 0;
        this.aF = 1;
        this.aG = 2;
        this.aH = this.aE;
        if (b) {
            this.ar.x = 3;
            this.aH = this.aF;
        }
    }
    
    @Override
    public WorldGenTreeAbstract a(final Random random) {
        if (random.nextInt(3) > 0) {
            return this.aD;
        }
        return super.a(random);
    }
    
    @Override
    public void a(final World world, final Random random, final int i, final int j) {
        super.a(world, random, i, j);
        for (int n = 3 + random.nextInt(6), k = 0; k < n; ++k) {
            final int n2 = i + random.nextInt(16);
            final int n3 = random.nextInt(28) + 4;
            final int n4 = j + random.nextInt(16);
            if (world.getType(n2, n3, n4) == Blocks.STONE) {
                world.setTypeAndData(n2, n3, n4, Blocks.EMERALD_ORE, 0, 2);
            }
        }
        for (int l = 0; l < 7; ++l) {
            this.aC.generate(world, random, i + random.nextInt(16), random.nextInt(64), j + random.nextInt(16));
        }
    }
    
    @Override
    public void a(final World world, final Random random, final Block[] ablock, final byte[] abyte, final int i, final int j, final double d0) {
        this.ai = Blocks.GRASS;
        this.aj = 0;
        this.ak = Blocks.DIRT;
        if ((d0 < -1.0 || d0 > 2.0) && this.aH == this.aG) {
            this.ai = Blocks.GRAVEL;
            this.ak = Blocks.GRAVEL;
        }
        else if (d0 > 1.0 && this.aH != this.aF) {
            this.ai = Blocks.STONE;
            this.ak = Blocks.STONE;
        }
        this.b(world, random, ablock, abyte, i, j, d0);
    }
    
    private BiomeBigHills b(final BiomeBase biomeBase) {
        this.aH = this.aG;
        this.a(biomeBase.ag, true);
        this.a(biomeBase.af + " M");
        this.a(new BiomeTemperature(biomeBase.am, biomeBase.an));
        this.a(biomeBase.temperature, biomeBase.humidity);
        return this;
    }
    
    @Override
    protected BiomeBase k() {
        return new BiomeBigHills(this.id + 128, false).b(this);
    }
}
