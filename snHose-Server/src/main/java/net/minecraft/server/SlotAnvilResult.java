package net.minecraft.server;

class SlotAnvilResult extends Slot
{
    final /* synthetic */ World a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ int d;
    final /* synthetic */ ContainerAnvil e;
    
    SlotAnvilResult(final ContainerAnvil e, final IInventory iinventory, final int i, final int j, final int k, final World a, final int b, final int c, final int d) {
        super(iinventory, i, j, k);
        this.e = e;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    @Override
    public boolean isAllowed(final ItemStack itemStack) {
        return false;
    }
    
    @Override
    public boolean isAllowed(final EntityHuman entityHuman) {
        return (entityHuman.abilities.canInstantlyBuild || entityHuman.expLevel >= this.e.a) && this.e.a > 0 && this.hasItem();
    }
    
    @Override
    public void a(final EntityHuman entityHuman, final ItemStack itemStack) {
        if (!entityHuman.abilities.canInstantlyBuild) {
            entityHuman.levelDown(-this.e.a);
        }
        ContainerAnvil.a(this.e).setItem(0, null);
        if (ContainerAnvil.b(this.e) > 0) {
            final ItemStack item = ContainerAnvil.a(this.e).getItem(1);
            if (item != null && item.count > ContainerAnvil.b(this.e)) {
                final ItemStack itemStack2 = item;
                itemStack2.count -= ContainerAnvil.b(this.e);
                ContainerAnvil.a(this.e).setItem(1, item);
            }
            else {
                ContainerAnvil.a(this.e).setItem(1, null);
            }
        }
        else {
            ContainerAnvil.a(this.e).setItem(1, null);
        }
        this.e.a = 0;
        if (!entityHuman.abilities.canInstantlyBuild && !this.a.isStatic && this.a.getType(this.b, this.c, this.d) == Blocks.ANVIL && entityHuman.aI().nextFloat() < 0.12f) {
            final int data = this.a.getData(this.b, this.c, this.d);
            final int n = data & 0x3;
            int n2 = data >> 2;
            if (++n2 > 2) {
                this.a.setAir(this.b, this.c, this.d);
                this.a.triggerEffect(1020, this.b, this.c, this.d, 0);
            }
            else {
                this.a.setData(this.b, this.c, this.d, n | n2 << 2, 2);
                this.a.triggerEffect(1021, this.b, this.c, this.d, 0);
            }
        }
        else if (!this.a.isStatic) {
            this.a.triggerEffect(1021, this.b, this.c, this.d, 0);
        }
    }
}
