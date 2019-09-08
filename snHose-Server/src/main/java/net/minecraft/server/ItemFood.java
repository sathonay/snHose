package net.minecraft.server.v1_7_R4;

public class ItemFood extends Item
{
    public final int a = 32;
    private final int b;
    private final float c;
    private final boolean d;
    private boolean m;
    private int n;
    private int o;
    private int p;
    private float q;
    
    public ItemFood(final int b, final float c, final boolean d) {
        this.b = b;
        this.d = d;
        this.c = c;
        this.a(CreativeModeTab.h);
    }
    
    public ItemFood(final int n, final boolean b) {
        this(n, 0.6f, b);
    }
    
    @Override
    public ItemStack b(final ItemStack itemstack, final World world, final EntityHuman entity) {
        --itemstack.count;
        entity.getFoodData().a(this, itemstack);
        world.makeSound(entity, "random.burp", 0.5f, world.random.nextFloat() * 0.1f + 0.9f);
        this.c(itemstack, world, entity);
        return itemstack;
    }
    
    protected void c(final ItemStack itemStack, final World world, final EntityHuman entityHuman) {
        if (!world.isStatic && this.n > 0 && world.random.nextFloat() < this.q) {
            entityHuman.addEffect(new MobEffect(this.n, this.o * 20, this.p));
        }
    }
    
    @Override
    public int d_(final ItemStack itemStack) {
        return 32;
    }
    
    @Override
    public EnumAnimation d(final ItemStack itemStack) {
        return EnumAnimation.EAT;
    }
    
    @Override
    public ItemStack a(final ItemStack itemstack, final World world, final EntityHuman entityHuman) {
        if (entityHuman.g(this.m)) {
            entityHuman.a(itemstack, this.d_(itemstack));
        }
        return itemstack;
    }
    
    public int getNutrition(final ItemStack itemStack) {
        return this.b;
    }
    
    public float getSaturationModifier(final ItemStack itemStack) {
        return this.c;
    }
    
    public boolean i() {
        return this.d;
    }
    
    public ItemFood a(final int n, final int o, final int p4, final float q) {
        this.n = n;
        this.o = o;
        this.p = p4;
        this.q = q;
        return this;
    }
    
    public ItemFood j() {
        this.m = true;
        return this;
    }
}
