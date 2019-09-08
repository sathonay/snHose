package net.minecraft.server.v1_7_R4;

final class StepSoundStone extends StepSound
{
    StepSoundStone(final String s, final float n, final float n2) {
        super(s, n, n2);
    }
    
    @Override
    public String getBreakSound() {
        return "dig.glass";
    }
    
    @Override
    public String getPlaceSound() {
        return "step.stone";
    }
}
