package net.minecraft.server.v1_7_R4;

import java.util.*;

public class BlockMelon extends Block
{
    protected BlockMelon() {
        super(Material.PUMPKIN);
        this.a(CreativeModeTab.b);
    }
    
    @Override
    public Item getDropType(final int n, final Random random, final int n2) {
        return Items.MELON;
    }
    
    @Override
    public int a(final Random random) {
        return 3 + random.nextInt(5);
    }
    
    @Override
    public int getDropCount(final int n, final Random random) {
        int n2 = this.a(random) + random.nextInt(1 + n);
        if (n2 > 9) {
            n2 = 9;
        }
        return n2;
    }
}
