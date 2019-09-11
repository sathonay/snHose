package net.minecraft.server;

import java.util.*;

public class BlockWoodStep extends BlockStepAbstract
{
    public static final String[] b;
    
    public BlockWoodStep(final boolean b) {
        super(b, Material.WOOD);
        this.a(CreativeModeTab.b);
    }
    
    @Override
    public Item getDropType(final int n, final Random random, final int n2) {
        return Item.getItemOf(Blocks.WOOD_STEP);
    }
    
    @Override
    protected ItemStack j(final int n) {
        return new ItemStack(Item.getItemOf(Blocks.WOOD_STEP), 2, n & 0x7);
    }
    
    @Override
    public String b(int n) {
        if (n < 0 || n >= BlockWoodStep.b.length) {
            n = 0;
        }
        return super.a() + "." + BlockWoodStep.b[n];
    }
    
    static {
        b = new String[] { "oak", "spruce", "birch", "jungle", "acacia", "big_oak" };
    }
}
