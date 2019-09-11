package net.minecraft.server;

class SlotHorseArmor extends Slot
{
    final /* synthetic */ EntityHorse a;
    final /* synthetic */ ContainerHorse b;
    
    SlotHorseArmor(final ContainerHorse b, final IInventory iinventory, final int i, final int j, final int k, final EntityHorse a) {
        this.b = b;
        this.a = a;
        super(iinventory, i, j, k);
    }
    
    @Override
    public boolean isAllowed(final ItemStack itemstack) {
        return super.isAllowed(itemstack) && this.a.cB() && EntityHorse.a(itemstack.getItem());
    }
}
