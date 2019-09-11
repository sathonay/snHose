package net.minecraft.server;

import java.util.*;

public class WorldGenNether extends StructureGenerator
{
    private List e;
    
    public WorldGenNether() {
        (this.e = new ArrayList()).add(new BiomeMeta(EntityBlaze.class, 10, 2, 3));
        this.e.add(new BiomeMeta(EntityPigZombie.class, 5, 4, 4));
        this.e.add(new BiomeMeta(EntitySkeleton.class, 10, 4, 4));
        this.e.add(new BiomeMeta(EntityMagmaCube.class, 3, 4, 4));
    }
    
    @Override
    public String a() {
        return "Fortress";
    }
    
    public List b() {
        return this.e;
    }
    
    @Override
    protected boolean a(final int n, final int n2) {
        final int n3 = n >> 4;
        final int n4 = n2 >> 4;
        this.b.setSeed(n3 ^ n4 << 4 ^ this.c.getSeed());
        this.b.nextInt();
        return this.b.nextInt(3) == 0 && n == (n3 << 4) + 4 + this.b.nextInt(8) && n2 == (n4 << 4) + 4 + this.b.nextInt(8);
    }
    
    @Override
    protected StructureStart b(final int n, final int n2) {
        return new WorldGenNetherStart(this.c, this.b, n, n2);
    }
}
