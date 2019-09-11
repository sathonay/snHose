package net.minecraft.server;

import java.util.*;
import net.minecraft.util.com.google.common.collect.*;

public class ItemPickaxe extends ItemTool
{
    private static final Set c;
    
    protected ItemPickaxe(final EnumToolMaterial enumToolMaterial) {
        super(2.0f, enumToolMaterial, ItemPickaxe.c);
    }
    
    @Override
    public boolean canDestroySpecialBlock(final Block block) {
        if (block == Blocks.OBSIDIAN) {
            return this.b.d() == 3;
        }
        if (block == Blocks.DIAMOND_BLOCK || block == Blocks.DIAMOND_ORE) {
            return this.b.d() >= 2;
        }
        if (block == Blocks.EMERALD_ORE || block == Blocks.EMERALD_BLOCK) {
            return this.b.d() >= 2;
        }
        if (block == Blocks.GOLD_BLOCK || block == Blocks.GOLD_ORE) {
            return this.b.d() >= 2;
        }
        if (block == Blocks.IRON_BLOCK || block == Blocks.IRON_ORE) {
            return this.b.d() >= 1;
        }
        if (block == Blocks.LAPIS_BLOCK || block == Blocks.LAPIS_ORE) {
            return this.b.d() >= 1;
        }
        if (block == Blocks.REDSTONE_ORE || block == Blocks.GLOWING_REDSTONE_ORE) {
            return this.b.d() >= 2;
        }
        return block.getMaterial() == Material.STONE || block.getMaterial() == Material.ORE || block.getMaterial() == Material.HEAVY;
    }
    
    @Override
    public float getDestroySpeed(final ItemStack itemStack, final Block block) {
        if (block.getMaterial() == Material.ORE || block.getMaterial() == Material.HEAVY || block.getMaterial() == Material.STONE) {
            return this.a;
        }
        return super.getDestroySpeed(itemStack, block);
    }
    
    static {
        c = Sets.newHashSet(Blocks.COBBLESTONE, Blocks.DOUBLE_STEP, Blocks.STEP, Blocks.STONE, Blocks.SANDSTONE, Blocks.MOSSY_COBBLESTONE, Blocks.IRON_ORE, Blocks.IRON_BLOCK, Blocks.COAL_ORE, Blocks.GOLD_BLOCK, Blocks.GOLD_ORE, Blocks.DIAMOND_ORE, Blocks.DIAMOND_BLOCK, Blocks.ICE, Blocks.NETHERRACK, Blocks.LAPIS_ORE, Blocks.LAPIS_BLOCK, Blocks.REDSTONE_ORE, Blocks.GLOWING_REDSTONE_ORE, Blocks.RAILS, Blocks.DETECTOR_RAIL, Blocks.GOLDEN_RAIL, Blocks.ACTIVATOR_RAIL);
    }
}
