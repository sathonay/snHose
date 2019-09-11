package net.minecraft.server;

public class ItemWrittenBook extends Item
{
    public ItemWrittenBook() {
        this.e(1);
    }
    
    public static boolean a(final NBTTagCompound nbtTagCompound) {
        if (!ItemBookAndQuill.a(nbtTagCompound)) {
            return false;
        }
        if (!nbtTagCompound.hasKeyOfType("title", 8)) {
            return false;
        }
        final String string = nbtTagCompound.getString("title");
        return string != null && string.length() <= 16 && nbtTagCompound.hasKeyOfType("author", 8);
    }
    
    @Override
    public String n(final ItemStack itemstack) {
        if (itemstack.hasTag()) {
            final String string = itemstack.getTag().getString("title");
            if (!UtilColor.b(string)) {
                return string;
            }
        }
        return super.n(itemstack);
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
}
