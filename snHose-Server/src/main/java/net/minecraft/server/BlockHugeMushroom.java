package net.minecraft.server.v1_7_R4;

import java.util.*;

public class BlockHugeMushroom extends Block
{
    private static final String[] a;
    private final int b;
    
    public BlockHugeMushroom(final Material material, final int b) {
        super(material);
        this.b = b;
    }
    
    @Override
    public int a(final Random random) {
        int n = random.nextInt(10) - 7;
        if (n < 0) {
            n = 0;
        }
        return n;
    }
    
    @Override
    public Item getDropType(final int n, final Random random, final int n2) {
        return Item.getById(Block.getId(Blocks.BROWN_MUSHROOM) + this.b);
    }
    
    static {
        a = new String[] { "skin_brown", "skin_red" };
    }
}
