package net.minecraft.server.v1_7_R4;

public class ItemCoal extends Item
{
    public ItemCoal() {
        this.a(true);
        this.setMaxDurability(0);
        this.a(CreativeModeTab.l);
    }
    
    @Override
    public String a(final ItemStack itemStack) {
        if (itemStack.getData() == 1) {
            return "item.charcoal";
        }
        return "item.coal";
    }
}
