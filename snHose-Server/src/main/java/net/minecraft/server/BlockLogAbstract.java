package net.minecraft.server;

import java.util.*;

public abstract class BlockLogAbstract extends BlockRotatable
{
    public BlockLogAbstract() {
        super(Material.WOOD);
        this.a(CreativeModeTab.b);
        this.c(2.0f);
        this.a(BlockLogAbstract.f);
    }
    
    public static int c(final int n) {
        return n & 0x3;
    }
    
    @Override
    public int a(final Random random) {
        return 1;
    }
    
    @Override
    public Item getDropType(final int n, final Random random, final int n2) {
        return Item.getItemOf(this);
    }
    
    @Override
    public void remove(final World world, final int n, final int n2, final int n3, final Block block, final int n4) {
        final int n5 = 4;
        final int n6 = n5 + 1;
        if (world.b(n - n6, n2 - n6, n3 - n6, n + n6, n2 + n6, n3 + n6)) {
            for (int i = -n5; i <= n5; ++i) {
                for (int j = -n5; j <= n5; ++j) {
                    for (int k = -n5; k <= n5; ++k) {
                        if (world.getType(n + i, n2 + j, n3 + k).getMaterial() == Material.LEAVES) {
                            final int data = world.getData(n + i, n2 + j, n3 + k);
                            if ((data & 0x8) == 0x0) {
                                world.setData(n + i, n2 + j, n3 + k, data | 0x8, 4);
                            }
                        }
                    }
                }
            }
        }
    }
}
