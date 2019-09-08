package net.minecraft.server.v1_7_R4;

import java.util.*;
import net.minecraft.util.com.google.common.collect.*;

public class ItemTool extends Item
{
    private Set c;
    protected float a;
    private float d;
    protected EnumToolMaterial b;
    
    protected ItemTool(final float n, final EnumToolMaterial b, final Set c) {
        this.a = 4.0f;
        this.b = b;
        this.c = c;
        this.maxStackSize = 1;
        this.setMaxDurability(b.a());
        this.a = b.b();
        this.d = n + b.c();
        this.a(CreativeModeTab.i);
    }
    
    @Override
    public float getDestroySpeed(final ItemStack itemStack, final Block block) {
        return this.c.contains(block) ? this.a : 1.0f;
    }
    
    @Override
    public boolean a(final ItemStack itemStack, final EntityLiving entityLiving, final EntityLiving entityliving) {
        itemStack.damage(2, entityliving);
        return true;
    }
    
    @Override
    public boolean a(final ItemStack itemStack, final World world, final Block block, final int i, final int j, final int k, final EntityLiving entityliving) {
        if (block.f(world, i, j, k) != 0.0) {
            itemStack.damage(1, entityliving);
        }
        return true;
    }
    
    public EnumToolMaterial i() {
        return this.b;
    }
    
    @Override
    public int c() {
        return this.b.e();
    }
    
    public String j() {
        return this.b.toString();
    }
    
    @Override
    public boolean a(final ItemStack itemstack, final ItemStack itemstack2) {
        return this.b.f() == itemstack2.getItem() || super.a(itemstack, itemstack2);
    }
    
    @Override
    public Multimap k() {
        final Multimap k = super.k();
        k.put(GenericAttributes.e.getName(), new AttributeModifier(ItemTool.f, "Tool modifier", this.d, 0));
        return k;
    }
}
