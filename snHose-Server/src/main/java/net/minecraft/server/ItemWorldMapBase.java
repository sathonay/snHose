package net.minecraft.server.v1_7_R4;

public class ItemWorldMapBase extends Item
{
    @Override
    public boolean h() {
        return true;
    }
    
    public Packet c(final ItemStack itemStack, final World world, final EntityHuman entityHuman) {
        return null;
    }
}
