package net.minecraft.server;

import java.util.*;

public class BlockCauldron extends Block
{
    public BlockCauldron() {
        super(Material.ORE);
    }
    
    @Override
    public void a(final World world, final int i, final int j, final int k, final AxisAlignedBB axisalignedbb, final List list, final Entity entity) {
        this.a(0.0f, 0.0f, 0.0f, 1.0f, 0.3125f, 1.0f);
        super.a(world, i, j, k, axisalignedbb, list, entity);
        final float n = 0.125f;
        this.a(0.0f, 0.0f, 0.0f, n, 1.0f, 1.0f);
        super.a(world, i, j, k, axisalignedbb, list, entity);
        this.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, n);
        super.a(world, i, j, k, axisalignedbb, list, entity);
        this.a(1.0f - n, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
        super.a(world, i, j, k, axisalignedbb, list, entity);
        this.a(0.0f, 0.0f, 1.0f - n, 1.0f, 1.0f, 1.0f);
        super.a(world, i, j, k, axisalignedbb, list, entity);
        this.g();
    }
    
    @Override
    public void g() {
        this.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
    }
    
    @Override
    public boolean c() {
        return false;
    }
    
    @Override
    public int b() {
        return 24;
    }
    
    @Override
    public boolean d() {
        return false;
    }
    
    @Override
    public void a(final World world, final int i, final int j, final int k, final Entity entity) {
        final int b = b(world.getData(i, j, k));
        final float n = j + (6.0f + 3 * b) / 16.0f;
        if (!world.isStatic && entity.isBurning() && b > 0 && entity.boundingBox.b <= n) {
            entity.extinguish();
            this.a(world, i, j, k, b - 1);
        }
    }
    
    @Override
    public boolean interact(final World world, final int i, final int j, final int k, final EntityHuman entityHuman, final int n, final float n2, final float n3, final float n4) {
        if (world.isStatic) {
            return true;
        }
        final ItemStack itemInHand = entityHuman.inventory.getItemInHand();
        if (itemInHand == null) {
            return true;
        }
        final int b = b(world.getData(i, j, k));
        if (itemInHand.getItem() == Items.WATER_BUCKET) {
            if (b < 3) {
                if (!entityHuman.abilities.canInstantlyBuild) {
                    entityHuman.inventory.setItem(entityHuman.inventory.itemInHandIndex, new ItemStack(Items.BUCKET));
                }
                this.a(world, i, j, k, 3);
            }
            return true;
        }
        if (itemInHand.getItem() == Items.GLASS_BOTTLE) {
            if (b > 0) {
                if (!entityHuman.abilities.canInstantlyBuild) {
                    final ItemStack itemStack = new ItemStack(Items.POTION, 1, 0);
                    if (!entityHuman.inventory.pickup(itemStack)) {
                        world.addEntity(new EntityItem(world, i + 0.5, j + 1.5, k + 0.5, itemStack));
                    }
                    else if (entityHuman instanceof EntityPlayer) {
                        ((EntityPlayer)entityHuman).updateInventory(entityHuman.defaultContainer);
                    }
                    final ItemStack itemStack2 = itemInHand;
                    --itemStack2.count;
                    if (itemInHand.count <= 0) {
                        entityHuman.inventory.setItem(entityHuman.inventory.itemInHandIndex, null);
                    }
                }
                this.a(world, i, j, k, b - 1);
            }
        }
        else if (b > 0 && itemInHand.getItem() instanceof ItemArmor && ((ItemArmor)itemInHand.getItem()).m_() == EnumArmorMaterial.CLOTH) {
            ((ItemArmor)itemInHand.getItem()).c(itemInHand);
            this.a(world, i, j, k, b - 1);
            return true;
        }
        return false;
    }
    
    public void a(final World world, final int n, final int n2, final int n3, final int n4) {
        world.setData(n, n2, n3, MathHelper.a(n4, 0, 3), 2);
        world.updateAdjacentComparators(n, n2, n3, this);
    }
    
    @Override
    public void l(final World world, final int n, final int n2, final int n3) {
        if (world.random.nextInt(20) != 1) {
            return;
        }
        final int data = world.getData(n, n2, n3);
        if (data < 3) {
            world.setData(n, n2, n3, data + 1, 2);
        }
    }
    
    @Override
    public Item getDropType(final int n, final Random random, final int n2) {
        return Items.CAULDRON;
    }
    
    @Override
    public boolean isComplexRedstone() {
        return true;
    }
    
    @Override
    public int g(final World world, final int i, final int j, final int k, final int n) {
        return b(world.getData(i, j, k));
    }
    
    public static int b(final int n) {
        return n;
    }
}
