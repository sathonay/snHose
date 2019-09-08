package net.minecraft.server.v1_7_R4;

import java.util.*;

public class PossibleFishingResult extends WeightedRandomChoice
{
    private final ItemStack b;
    private float c;
    private boolean d;
    
    public PossibleFishingResult(final ItemStack b, final int n) {
        super(n);
        this.b = b;
    }
    
    public ItemStack a(final Random random) {
        final ItemStack cloneItemStack = this.b.cloneItemStack();
        if (this.c > 0.0f) {
            final int n = (int)(this.c * this.b.l());
            int data = cloneItemStack.l() - random.nextInt(random.nextInt(n) + 1);
            if (data > n) {
                data = n;
            }
            if (data < 1) {
                data = 1;
            }
            cloneItemStack.setData(data);
        }
        if (this.d) {
            EnchantmentManager.a(random, cloneItemStack, 30);
        }
        return cloneItemStack;
    }
    
    public PossibleFishingResult a(final float c) {
        this.c = c;
        return this;
    }
    
    public PossibleFishingResult a() {
        this.d = true;
        return this;
    }
}
