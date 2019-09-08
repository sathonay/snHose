package net.minecraft.server.v1_7_R4;

import java.util.*;

public class BiomePlains extends BiomeBase
{
    protected boolean aC;
    
    protected BiomePlains(final int i) {
        super(i);
        this.a(0.8f, 0.4f);
        this.a(BiomePlains.e);
        this.at.add(new BiomeMeta(EntityHorse.class, 5, 2, 6));
        this.ar.x = -999;
        this.ar.y = 4;
        this.ar.z = 10;
    }
    
    @Override
    public String a(final Random random, final int n, final int n2, final int n3) {
        if (BiomePlains.ad.a(n / 200.0, n3 / 200.0) < -0.8) {
            return BlockFlowers.a[4 + random.nextInt(4)];
        }
        if (random.nextInt(3) <= 0) {
            return BlockFlowers.b[0];
        }
        final int nextInt = random.nextInt(3);
        if (nextInt == 0) {
            return BlockFlowers.a[0];
        }
        if (nextInt == 1) {
            return BlockFlowers.a[3];
        }
        return BlockFlowers.a[8];
    }
    
    @Override
    public void a(final World world, final Random random, final int i, final int j) {
        if (BiomePlains.ad.a((i + 8) / 200.0, (j + 8) / 200.0) < -0.8) {
            this.ar.y = 15;
            this.ar.z = 5;
        }
        else {
            this.ar.y = 4;
            this.ar.z = 10;
            BiomePlains.ae.a(2);
            for (int k = 0; k < 7; ++k) {
                final int l = i + random.nextInt(16) + 8;
                final int m = j + random.nextInt(16) + 8;
                BiomePlains.ae.generate(world, random, l, random.nextInt(world.getHighestBlockYAt(l, m) + 32), m);
            }
        }
        if (this.aC) {
            BiomePlains.ae.a(0);
            for (int n = 0; n < 10; ++n) {
                final int i2 = i + random.nextInt(16) + 8;
                final int j2 = j + random.nextInt(16) + 8;
                BiomePlains.ae.generate(world, random, i2, random.nextInt(world.getHighestBlockYAt(i2, j2) + 32), j2);
            }
        }
        super.a(world, random, i, j);
    }
    
    @Override
    protected BiomeBase k() {
        final BiomePlains biomePlains = new BiomePlains(this.id + 128);
        biomePlains.a("Sunflower Plains");
        biomePlains.aC = true;
        biomePlains.b(9286496);
        biomePlains.ah = 14273354;
        return biomePlains;
    }
}
