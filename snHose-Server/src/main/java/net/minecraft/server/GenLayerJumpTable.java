package net.minecraft.server;

class GenLayerJumpTable
{
    static {
        a = new int[EnumGenLayerSpecial.values().length];
        try {
            GenLayerJumpTable.a[EnumGenLayerSpecial.COOL_WARM.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            GenLayerJumpTable.a[EnumGenLayerSpecial.HEAT_ICE.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            GenLayerJumpTable.a[EnumGenLayerSpecial.PUFFERFISH.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
    }
}
