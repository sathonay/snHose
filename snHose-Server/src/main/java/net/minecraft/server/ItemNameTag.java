package net.minecraft.server.v1_7_R4;

public class ItemNameTag extends Item
{
    public ItemNameTag() {
        this.a(CreativeModeTab.i);
    }
    
    @Override
    public boolean a(final ItemStack itemstack, final EntityHuman entityhuman, final EntityLiving entityliving) {
        if (!itemstack.hasName()) {
            return false;
        }
        if (entityliving instanceof EntityInsentient) {
            final EntityInsentient entityInsentient = (EntityInsentient)entityliving;
            entityInsentient.setCustomName(itemstack.getName());
            entityInsentient.bF();
            --itemstack.count;
            return true;
        }
        return super.a(itemstack, entityhuman, entityliving);
    }
}
