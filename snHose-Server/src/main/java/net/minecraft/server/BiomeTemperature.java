package net.minecraft.server.v1_7_R4;

public class BiomeTemperature
{
    public float a;
    public float b;
    
    public BiomeTemperature(final float a, final float b) {
        this.a = a;
        this.b = b;
    }
    
    public BiomeTemperature a() {
        return new BiomeTemperature(this.a * 0.8f, this.b * 0.6f);
    }
}
