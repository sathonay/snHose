package net.minecraft.server.v1_7_R4;

import java.util.*;

public class BlockBookshelf extends Block
{
    public BlockBookshelf() {
        super(Material.WOOD);
        this.a(CreativeModeTab.b);
    }
    
    @Override
    public int a(final Random random) {
        return 3;
    }
    
    @Override
    public Item getDropType(final int n, final Random random, final int n2) {
        return Items.BOOK;
    }
}
