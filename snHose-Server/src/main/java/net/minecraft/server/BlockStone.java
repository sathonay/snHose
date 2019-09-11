package net.minecraft.server;

import java.util.*;

public class BlockStone extends Block
{
    public BlockStone() {
        super(Material.STONE);
        this.a(CreativeModeTab.b);
    }
    
    @Override
    public Item getDropType(final int n, final Random random, final int n2) {
        return Item.getItemOf(Blocks.COBBLESTONE);
    }
}
