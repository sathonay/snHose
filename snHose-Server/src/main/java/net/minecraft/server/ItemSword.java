package net.minecraft.server.v1_7_R4;

import net.minecraft.util.com.google.common.collect.*;

public class ItemSword extends Item
{
    private float damage;
    private final EnumToolMaterial b;
    
    public ItemSword(final EnumToolMaterial b) {
        this.b = b;
        this.maxStackSize = 1;
        this.setMaxDurability(b.a());
        this.a(CreativeModeTab.j);
        this.damage = 4.0f + b.c();
    }
    
    public float i() {
        return this.b.c();
    }
    
    @Override
    public float getDestroySpeed(final ItemStack itemStack, final Block block) {
        if (block == Blocks.WEB) {
            return 15.0f;
        }
        final Material material = block.getMaterial();
        if (material == Material.PLANT || material == Material.REPLACEABLE_PLANT || material == Material.CORAL || material == Material.LEAVES || material == Material.PUMPKIN) {
            return 1.5f;
        }
        return 1.0f;
    }
    
    @Override
    public boolean a(final ItemStack itemStack, final EntityLiving entityLiving, final EntityLiving entityliving) {
        itemStack.damage(1, entityliving);
        return true;
    }
    
    @Override
    public boolean a(final ItemStack itemStack, final World world, final Block block, final int i, final int j, final int k, final EntityLiving entityliving) {
        if (block.f(world, i, j, k) != 0.0) {
            itemStack.damage(2, entityliving);
        }
        return true;
    }
    
    @Override
    public EnumAnimation d(final ItemStack itemStack) {
        return EnumAnimation.BLOCK;
    }
    
    @Override
    public int d_(final ItemStack itemStack) {
        return 72000;
    }
    
    @Override
    public ItemStack a(final ItemStack itemstack, final World world, final EntityHuman entityHuman) {
        entityHuman.a(itemstack, this.d_(itemstack));
        return itemstack;
    }
    
    @Override
    public boolean canDestroySpecialBlock(final Block block) {
        return block == Blocks.WEB;
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
        k.put(GenericAttributes.e.getName(), new AttributeModifier(ItemSword.f, "Weapon modifier", this.damage, 0));
        return k;
    }
}
