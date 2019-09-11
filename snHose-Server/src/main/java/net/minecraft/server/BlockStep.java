package net.minecraft.server;

import java.util.*;

public class BlockStep extends BlockStepAbstract
{
    public static final String[] b;
    
    public BlockStep(final boolean b) {
        super(b, Material.STONE);
        this.a(CreativeModeTab.b);
    }
    
    @Override
    public Item getDropType(final int n, final Random random, final int n2) {
        return Item.getItemOf(Blocks.STEP);
    }
    
    @Override
    protected ItemStack j(final int n) {
        return new ItemStack(Item.getItemOf(Blocks.STEP), 2, n & 0x7);
    }
    
    @Override
    public String b(int n) {
        if (n < 0 || n >= BlockStep.b.length) {
            n = 0;
        }
        return super.a() + "." + BlockStep.b[n];
    }
    
    static {
        b = new String[] { "stone", "sand", "wood", "cobble", "brick", "smoothStoneBrick", "netherBrick", "quartz" };
    }
}
