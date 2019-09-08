package net.minecraft.server.v1_7_R4;

import java.util.*;

public class BlockSnowBlock extends Block
{
    protected BlockSnowBlock() {
        super(Material.SNOW_BLOCK);
        this.a(true);
        this.a(CreativeModeTab.b);
    }
    
    @Override
    public Item getDropType(final int n, final Random random, final int n2) {
        return Items.SNOW_BALL;
    }
    
    @Override
    public int a(final Random random) {
        return 4;
    }
    
    @Override
    public void a(final World world, final int n, final int n2, final int n3, final Random random) {
        if (world.b(EnumSkyBlock.BLOCK, n, n2, n3) > 11) {
            this.b(world, n, n2, n3, world.getData(n, n2, n3), 0);
            world.setAir(n, n2, n3);
        }
    }
}
