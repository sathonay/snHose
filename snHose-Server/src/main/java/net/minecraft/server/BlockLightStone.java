package net.minecraft.server;

import java.util.*;

public class BlockLightStone extends Block
{
    public BlockLightStone(final Material material) {
        super(material);
        this.a(CreativeModeTab.b);
    }
    
    @Override
    public int getDropCount(final int n, final Random random) {
        return MathHelper.a(this.a(random) + random.nextInt(n + 1), 1, 4);
    }
    
    @Override
    public int a(final Random random) {
        return 2 + random.nextInt(3);
    }
    
    @Override
    public Item getDropType(final int n, final Random random, final int n2) {
        return Items.GLOWSTONE_DUST;
    }
    
    @Override
    public MaterialMapColor f(final int n) {
        return MaterialMapColor.d;
    }
}
