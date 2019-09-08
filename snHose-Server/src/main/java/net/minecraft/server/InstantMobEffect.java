package net.minecraft.server.v1_7_R4;

public class InstantMobEffect extends MobEffectList
{
    public InstantMobEffect(final int i, final boolean flag, final int j) {
        super(i, flag, j);
    }
    
    @Override
    public boolean isInstant() {
        return true;
    }
    
    @Override
    public boolean a(final int n, final int n2) {
        return n >= 1;
    }
}
