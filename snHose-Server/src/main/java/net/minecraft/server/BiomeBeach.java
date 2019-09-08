package net.minecraft.server.v1_7_R4;

public class BiomeBeach extends BiomeBase
{
    public BiomeBeach(final int i) {
        super(i);
        this.at.clear();
        this.ai = Blocks.SAND;
        this.ak = Blocks.SAND;
        this.ar.x = -999;
        this.ar.A = 0;
        this.ar.C = 0;
        this.ar.D = 0;
    }
}
