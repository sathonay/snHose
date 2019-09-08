package net.minecraft.server.v1_7_R4;

public class ItemCarrotStick extends Item
{
    public ItemCarrotStick() {
        this.a(CreativeModeTab.e);
        this.e(1);
        this.setMaxDurability(25);
    }
    
    @Override
    public ItemStack a(final ItemStack itemStack, final World world, final EntityHuman entityliving) {
        if (entityliving.am() && entityliving.vehicle instanceof EntityPig) {
            final EntityPig entityPig = (EntityPig)entityliving.vehicle;
            if (entityPig.ca().h() && itemStack.l() - itemStack.getData() >= 7) {
                entityPig.ca().g();
                itemStack.damage(7, entityliving);
                if (itemStack.count == 0) {
                    final ItemStack itemStack2 = new ItemStack(Items.FISHING_ROD);
                    itemStack2.setTag(itemStack.tag);
                    return itemStack2;
                }
            }
        }
        return itemStack;
    }
}
