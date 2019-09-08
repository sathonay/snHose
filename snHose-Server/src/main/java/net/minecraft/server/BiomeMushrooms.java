package net.minecraft.server.v1_7_R4;

public class BiomeMushrooms extends BiomeBase
{
    public BiomeMushrooms(final int i) {
        super(i);
        this.ar.x = -100;
        this.ar.y = -100;
        this.ar.z = -100;
        this.ar.B = 1;
        this.ar.H = 1;
        this.ai = Blocks.MYCEL;
        this.as.clear();
        this.at.clear();
        this.au.clear();
        this.at.add(new BiomeMeta(EntityMushroomCow.class, 8, 4, 8));
    }
}
