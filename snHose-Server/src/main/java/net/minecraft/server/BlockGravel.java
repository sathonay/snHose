package net.minecraft.server.v1_7_R4;

import java.util.*;

public class BlockGravel extends BlockFalling
{
    @Override
    public Item getDropType(final int n, final Random random, int n2) {
        if (n2 > 3) {
            n2 = 3;
        }
        if (random.nextInt(10 - n2 * 3) == 0) {
            return Items.FLINT;
        }
        return Item.getItemOf(this);
    }
}
