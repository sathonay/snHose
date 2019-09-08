package net.minecraft.server.v1_7_R4;

public class ItemBook extends Item
{
    @Override
    public boolean e_(final ItemStack itemStack) {
        return itemStack.count == 1;
    }
    
    @Override
    public int c() {
        return 1;
    }
}
