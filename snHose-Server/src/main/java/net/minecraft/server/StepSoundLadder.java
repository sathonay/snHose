package net.minecraft.server.v1_7_R4;

final class StepSoundLadder extends StepSound
{
    StepSoundLadder(final String s, final float n, final float n2) {
        super(s, n, n2);
    }
    
    @Override
    public String getBreakSound() {
        return "dig.wood";
    }
}
