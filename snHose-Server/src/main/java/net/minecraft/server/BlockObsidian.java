package net.minecraft.server;

import java.util.*;

public class BlockObsidian extends BlockStone
{
    @Override
    public int a(final Random random) {
        return 1;
    }
    
    @Override
    public Item getDropType(final int n, final Random random, final int n2) {
        return Item.getItemOf(Blocks.OBSIDIAN);
    }
    
    @Override
    public MaterialMapColor f(final int n) {
        return MaterialMapColor.J;
    }
}
