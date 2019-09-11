package net.minecraft.server;

public class StepSound
{
    public final String a;
    public final float b;
    public final float c;
    
    public StepSound(final String a, final float b, final float c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public float getVolume1() {
        return this.b;
    }
    
    public float getVolume2() {
        return this.c;
    }
    
    public String getBreakSound() {
        return "dig." + this.a;
    }
    
    public String getStepSound() {
        return "step." + this.a;
    }
    
    public String getPlaceSound() {
        return this.getBreakSound();
    }
}
