package net.minecraft.server.v1_7_R4;

public class ItemBookAndQuill extends Item
{
    public ItemBookAndQuill() {
        this.e(1);
    }
    
    @Override
    public ItemStack a(final ItemStack itemstack, final World world, final EntityHuman entityHuman) {
        entityHuman.b(itemstack);
        return itemstack;
    }
    
    @Override
    public boolean s() {
        return true;
    }
    
    public static boolean a(final NBTTagCompound nbtTagCompound) {
        if (nbtTagCompound == null) {
            return false;
        }
        if (!nbtTagCompound.hasKeyOfType("pages", 9)) {
            return false;
        }
        final NBTTagList list = nbtTagCompound.getList("pages", 8);
        for (int i = 0; i < list.size(); ++i) {
            final String string = list.getString(i);
            if (string == null) {
                return false;
            }
            if (string.length() > 256) {
                return false;
            }
        }
        return true;
    }
}
