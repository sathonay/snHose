package net.minecraft.server.v1_7_R4;

import java.util.*;
import net.minecraft.util.com.google.common.collect.*;

public class ItemAxe extends ItemTool
{
    private static final Set c;
    
    protected ItemAxe(final EnumToolMaterial enumToolMaterial) {
        super(3.0f, enumToolMaterial, ItemAxe.c);
    }
    
    @Override
    public float getDestroySpeed(final ItemStack itemStack, final Block block) {
        if (block.getMaterial() == Material.WOOD || block.getMaterial() == Material.PLANT || block.getMaterial() == Material.REPLACEABLE_PLANT) {
            return this.a;
        }
        return super.getDestroySpeed(itemStack, block);
    }
    
    static {
        c = Sets.newHashSet(Blocks.WOOD, Blocks.BOOKSHELF, Blocks.LOG, Blocks.LOG2, Blocks.CHEST, Blocks.PUMPKIN, Blocks.JACK_O_LANTERN);
    }
}
