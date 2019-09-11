package net.minecraft.server;

class EntitySizes
{
    static {
        a = new int[EnumEntitySize.values().length];
        try {
            EntitySizes.a[EnumEntitySize.SIZE_1.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            EntitySizes.a[EnumEntitySize.SIZE_2.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError2) {}
        try {
            EntitySizes.a[EnumEntitySize.SIZE_3.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError3) {}
        try {
            EntitySizes.a[EnumEntitySize.SIZE_4.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError4) {}
        try {
            EntitySizes.a[EnumEntitySize.SIZE_5.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError5) {}
        try {
            EntitySizes.a[EnumEntitySize.SIZE_6.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError6) {}
    }
}
