package net.minecraft.server;

public enum EnumEntitySize
{
    SIZE_1("SIZE_1", 0), 
    SIZE_2("SIZE_2", 1), 
    SIZE_3("SIZE_3", 2), 
    SIZE_4("SIZE_4", 3), 
    SIZE_5("SIZE_5", 4), 
    SIZE_6("SIZE_6", 5);
    
    private EnumEntitySize(final String s, final int n) {
    }
    
    public int a(final double var0) {
        final double n = var0 - (MathHelper.floor(var0) + 0.5);
        switch (EntitySizes.a[this.ordinal()]) {
            case 1: {
                if (n < 0.0) {
                    if (n >= -0.3125) {
                        return MathHelper.floor(var0 * 32.0);
                    }
                }
                else if (n >= 0.3125) {
                    return MathHelper.floor(var0 * 32.0);
                }
                return MathHelper.f(var0 * 32.0);
            }
            case 2: {
                if (n < 0.0) {
                    if (n >= -0.3125) {
                        return MathHelper.f(var0 * 32.0);
                    }
                }
                else if (n >= 0.3125) {
                    return MathHelper.f(var0 * 32.0);
                }
                return MathHelper.floor(var0 * 32.0);
            }
            case 3: {
                if (n > 0.0) {
                    return MathHelper.floor(var0 * 32.0);
                }
                return MathHelper.f(var0 * 32.0);
            }
            case 4: {
                if (n < 0.0) {
                    if (n >= -0.1875) {
                        return MathHelper.floor(var0 * 32.0);
                    }
                }
                else if (n >= 0.1875) {
                    return MathHelper.floor(var0 * 32.0);
                }
                return MathHelper.f(var0 * 32.0);
            }
            case 5: {
                if (n < 0.0) {
                    if (n >= -0.1875) {
                        return MathHelper.f(var0 * 32.0);
                    }
                }
                else if (n >= 0.1875) {
                    return MathHelper.f(var0 * 32.0);
                }
                return MathHelper.floor(var0 * 32.0);
            }
            default: {
                if (n > 0.0) {
                    return MathHelper.f(var0 * 32.0);
                }
                return MathHelper.floor(var0 * 32.0);
            }
        }
    }
}
