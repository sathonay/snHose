package net.minecraft.server.v1_7_R4;

final class StepSoundAnvil extends StepSound
{
    StepSoundAnvil(final String s, final float n, final float n2) {
        super(s, n, n2);
    }
    
    @Override
    public String getBreakSound() {
        return "dig.stone";
    }
    
    @Override
    public String getPlaceSound() {
        return "random.anvil_land";
    }
}
