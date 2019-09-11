package net.minecraft.server;

import java.util.*;

public class BiomeTaiga extends BiomeBase
{
    private static final WorldGenTaiga1 aC;
    private static final WorldGenTaiga2 aD;
    private static final WorldGenMegaTree aE;
    private static final WorldGenMegaTree aF;
    private static final WorldGenTaigaStructure aG;
    private int aH;
    
    public BiomeTaiga(final int i, final int ah) {
        super(i);
        this.aH = ah;
        this.at.add(new BiomeMeta(EntityWolf.class, 8, 4, 4));
        this.ar.x = 10;
        if (ah == 1 || ah == 2) {
            this.ar.z = 7;
            this.ar.A = 1;
            this.ar.B = 3;
        }
        else {
            this.ar.z = 1;
            this.ar.B = 1;
        }
    }
    
    @Override
    public WorldGenTreeAbstract a(final Random random) {
        if ((this.aH == 1 || this.aH == 2) && random.nextInt(3) == 0) {
            if (this.aH == 2 || random.nextInt(13) == 0) {
                return BiomeTaiga.aF;
            }
            return BiomeTaiga.aE;
        }
        else {
            if (random.nextInt(3) == 0) {
                return BiomeTaiga.aC;
            }
            return BiomeTaiga.aD;
        }
    }
    
    @Override
    public WorldGenerator b(final Random random) {
        if (random.nextInt(5) > 0) {
            return new WorldGenGrass(Blocks.LONG_GRASS, 2);
        }
        return new WorldGenGrass(Blocks.LONG_GRASS, 1);
    }
    
    @Override
    public void a(final World world, final Random random, final int i, final int j) {
        if (this.aH == 1 || this.aH == 2) {
            for (int nextInt = random.nextInt(3), k = 0; k < nextInt; ++k) {
                final int l = i + random.nextInt(16) + 8;
                final int m = j + random.nextInt(16) + 8;
                BiomeTaiga.aG.generate(world, random, l, world.getHighestBlockYAt(l, m), m);
            }
        }
        BiomeTaiga.ae.a(3);
        for (int n = 0; n < 7; ++n) {
            final int i2 = i + random.nextInt(16) + 8;
            final int j2 = j + random.nextInt(16) + 8;
            BiomeTaiga.ae.generate(world, random, i2, random.nextInt(world.getHighestBlockYAt(i2, j2) + 32), j2);
        }
        super.a(world, random, i, j);
    }
    
    @Override
    public void a(final World world, final Random random, final Block[] ablock, final byte[] abyte, final int i, final int j, final double d0) {
        if (this.aH == 1 || this.aH == 2) {
            this.ai = Blocks.GRASS;
            this.aj = 0;
            this.ak = Blocks.DIRT;
            if (d0 > 1.75) {
                this.ai = Blocks.DIRT;
                this.aj = 1;
            }
            else if (d0 > -0.95) {
                this.ai = Blocks.DIRT;
                this.aj = 2;
            }
        }
        this.b(world, random, ablock, abyte, i, j, d0);
    }
    
    @Override
    protected BiomeBase k() {
        if (this.id == BiomeBase.MEGA_TAIGA.id) {
            return new BiomeTaiga(this.id + 128, 2).a(5858897, true).a("Mega Spruce Taiga").a(5159473).a(0.25f, 0.8f).a(new BiomeTemperature(this.am, this.an));
        }
        return super.k();
    }
    
    static {
        aC = new WorldGenTaiga1();
        aD = new WorldGenTaiga2(false);
        aE = new WorldGenMegaTree(false, false);
        aF = new WorldGenMegaTree(false, true);
        aG = new WorldGenTaigaStructure(Blocks.MOSSY_COBBLESTONE, 0);
    }
}
