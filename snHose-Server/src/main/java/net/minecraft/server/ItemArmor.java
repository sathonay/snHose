package net.minecraft.server.v1_7_R4;

public class ItemArmor extends Item
{
    private static final int[] m;
    private static final String[] n;
    public static final String[] a;
    private static final IDispenseBehavior o;
    public final int b;
    public final int c;
    public final int d;
    private final EnumArmorMaterial p;
    
    public ItemArmor(final EnumArmorMaterial p3, final int d, final int b) {
        this.p = p3;
        this.b = b;
        this.d = d;
        this.c = p3.b(b);
        this.setMaxDurability(p3.a(b));
        this.maxStackSize = 1;
        this.a(CreativeModeTab.j);
        BlockDispenser.a.a(this, ItemArmor.o);
    }
    
    @Override
    public int c() {
        return this.p.a();
    }
    
    public EnumArmorMaterial m_() {
        return this.p;
    }
    
    public boolean c_(final ItemStack itemStack) {
        return this.p == EnumArmorMaterial.CLOTH && itemStack.hasTag() && itemStack.getTag().hasKeyOfType("display", 10) && itemStack.getTag().getCompound("display").hasKeyOfType("color", 3);
    }
    
    public int b(final ItemStack itemStack) {
        if (this.p != EnumArmorMaterial.CLOTH) {
            return -1;
        }
        final NBTTagCompound tag = itemStack.getTag();
        if (tag == null) {
            return 10511680;
        }
        final NBTTagCompound compound = tag.getCompound("display");
        if (compound == null) {
            return 10511680;
        }
        if (compound.hasKeyOfType("color", 3)) {
            return compound.getInt("color");
        }
        return 10511680;
    }
    
    public void c(final ItemStack itemStack) {
        if (this.p != EnumArmorMaterial.CLOTH) {
            return;
        }
        final NBTTagCompound tag = itemStack.getTag();
        if (tag == null) {
            return;
        }
        final NBTTagCompound compound = tag.getCompound("display");
        if (compound.hasKey("color")) {
            compound.remove("color");
        }
    }
    
    public void b(final ItemStack itemStack, final int n) {
        if (this.p != EnumArmorMaterial.CLOTH) {
            throw new UnsupportedOperationException("Can't dye non-leather!");
        }
        NBTTagCompound tag = itemStack.getTag();
        if (tag == null) {
            tag = new NBTTagCompound();
            itemStack.setTag(tag);
        }
        final NBTTagCompound compound = tag.getCompound("display");
        if (!tag.hasKeyOfType("display", 10)) {
            tag.set("display", compound);
        }
        compound.setInt("color", n);
    }
    
    @Override
    public boolean a(final ItemStack itemstack, final ItemStack itemstack2) {
        return this.p.b() == itemstack2.getItem() || super.a(itemstack, itemstack2);
    }
    
    @Override
    public ItemStack a(final ItemStack itemstack, final World world, final EntityHuman entityHuman) {
        final int n = EntityInsentient.b(itemstack) - 1;
        if (entityHuman.r(n) == null) {
            entityHuman.setEquipment(n, itemstack.cloneItemStack());
            itemstack.count = 0;
        }
        return itemstack;
    }
    
    static {
        m = new int[] { 11, 16, 15, 13 };
        n = new String[] { "leather_helmet_overlay", "leather_chestplate_overlay", "leather_leggings_overlay", "leather_boots_overlay" };
        a = new String[] { "empty_armor_slot_helmet", "empty_armor_slot_chestplate", "empty_armor_slot_leggings", "empty_armor_slot_boots" };
        o = new DispenseBehaviorArmor();
    }
}
