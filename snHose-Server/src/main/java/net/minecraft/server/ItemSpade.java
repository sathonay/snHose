package net.minecraft.server.v1_7_R4;

import java.util.*;
import net.minecraft.util.com.google.common.collect.*;

public class ItemSpade extends ItemTool
{
    private static final Set c;
    
    public ItemSpade(final EnumToolMaterial enumToolMaterial) {
        super(1.0f, enumToolMaterial, ItemSpade.c);
    }
    
    @Override
    public boolean canDestroySpecialBlock(final Block block) {
        return block == Blocks.SNOW || block == Blocks.SNOW_BLOCK;
    }
    
    static {
        c = Sets.newHashSet(Blocks.GRASS, Blocks.DIRT, Blocks.SAND, Blocks.GRAVEL, Blocks.SNOW, Blocks.SNOW_BLOCK, Blocks.CLAY, Blocks.SOIL, Blocks.SOUL_SAND, Blocks.MYCEL);
    }
}
