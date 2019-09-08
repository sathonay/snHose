package net.minecraft.server.v1_7_R4;

import java.util.*;

public class ItemRecord extends Item
{
    private static final Map b;
    public final String a;
    
    protected ItemRecord(final String a) {
        this.a = a;
        this.maxStackSize = 1;
        this.a(CreativeModeTab.f);
        ItemRecord.b.put(a, this);
    }
    
    @Override
    public boolean interactWith(final ItemStack itemStack, final EntityHuman entityHuman, final World world, final int j, final int k, final int l, final int n, final float n2, final float n3, final float n4) {
        if (world.getType(j, k, l) != Blocks.JUKEBOX || world.getData(j, k, l) != 0) {
            return false;
        }
        if (world.isStatic) {
            return true;
        }
        ((BlockJukeBox)Blocks.JUKEBOX).b(world, j, k, l, itemStack);
        world.a(null, 1005, j, k, l, Item.getId(this));
        --itemStack.count;
        return true;
    }
    
    @Override
    public EnumItemRarity f(final ItemStack itemStack) {
        return EnumItemRarity.RARE;
    }
    
    static {
        b = new HashMap();
    }
}
