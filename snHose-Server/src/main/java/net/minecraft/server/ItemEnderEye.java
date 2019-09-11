package net.minecraft.server;

public class ItemEnderEye extends Item
{
    public ItemEnderEye() {
        this.a(CreativeModeTab.f);
    }
    
    @Override
    public boolean interactWith(final ItemStack itemstack, final EntityHuman entityHuman, final World world, final int i, final int n, final int k, final int l, final float n2, final float n3, final float n4) {
        final Block type = world.getType(i, n, k);
        final int data = world.getData(i, n, k);
        if (!entityHuman.a(i, n, k, l, itemstack) || type != Blocks.ENDER_PORTAL_FRAME || BlockEnderPortalFrame.b(data)) {
            return false;
        }
        if (world.isStatic) {
            return true;
        }
        world.setData(i, n, k, data + 4, 2);
        world.updateAdjacentComparators(i, n, k, Blocks.ENDER_PORTAL_FRAME);
        --itemstack.count;
        for (int j = 0; j < 16; ++j) {
            world.addParticle("smoke", i + (5.0f + ItemEnderEye.g.nextFloat() * 6.0f) / 16.0f, n + 0.8125f, k + (5.0f + ItemEnderEye.g.nextFloat() * 6.0f) / 16.0f, 0.0, 0.0, 0.0);
        }
        final int n5 = data & 0x3;
        int n6 = 0;
        int n7 = 0;
        int n8 = 0;
        int n9 = 1;
        final int n10 = Direction.g[n5];
        for (int n11 = -2; n11 <= 2; ++n11) {
            final int n12 = i + Direction.a[n10] * n11;
            final int n13 = k + Direction.b[n10] * n11;
            if (world.getType(n12, n, n13) == Blocks.ENDER_PORTAL_FRAME) {
                if (!BlockEnderPortalFrame.b(world.getData(n12, n, n13))) {
                    n9 = 0;
                    break;
                }
                n7 = n11;
                if (n8 == 0) {
                    n6 = n11;
                    n8 = 1;
                }
            }
        }
        if (n9 != 0 && n7 == n6 + 2) {
            for (int n14 = n6; n14 <= n7; ++n14) {
                final int n15 = i + Direction.a[n10] * n14;
                final int n16 = k + Direction.b[n10] * n14;
                final int n17 = n15 + Direction.a[n5] * 4;
                final int n18 = n16 + Direction.b[n5] * 4;
                if (world.getType(n17, n, n18) != Blocks.ENDER_PORTAL_FRAME || !BlockEnderPortalFrame.b(world.getData(n17, n, n18))) {
                    n9 = 0;
                    break;
                }
            }
            for (int n19 = n6 - 1; n19 <= n7 + 1; n19 += 4) {
                for (int n20 = 1; n20 <= 3; ++n20) {
                    final int n21 = i + Direction.a[n10] * n19;
                    final int n22 = k + Direction.b[n10] * n19;
                    final int n23 = n21 + Direction.a[n5] * n20;
                    final int n24 = n22 + Direction.b[n5] * n20;
                    if (world.getType(n23, n, n24) != Blocks.ENDER_PORTAL_FRAME || !BlockEnderPortalFrame.b(world.getData(n23, n, n24))) {
                        n9 = 0;
                        break;
                    }
                }
            }
            if (n9 != 0) {
                for (int n25 = n6; n25 <= n7; ++n25) {
                    for (int n26 = 1; n26 <= 3; ++n26) {
                        world.setTypeAndData(i + Direction.a[n10] * n25 + Direction.a[n5] * n26, n, k + Direction.b[n10] * n25 + Direction.b[n5] * n26, Blocks.ENDER_PORTAL, 0, 2);
                    }
                }
            }
        }
        return true;
    }
    
    @Override
    public ItemStack a(final ItemStack itemStack, final World world, final EntityHuman entityHuman) {
        final MovingObjectPosition a = this.a(world, entityHuman, false);
        if (a != null && a.type == EnumMovingObjectType.BLOCK && world.getType(a.b, a.c, a.d) == Blocks.ENDER_PORTAL_FRAME) {
            return itemStack;
        }
        if (!world.isStatic) {
            final ChunkPosition b = world.b("Stronghold", (int)entityHuman.locX, (int)entityHuman.locY, (int)entityHuman.locZ);
            if (b != null) {
                final EntityEnderSignal entity = new EntityEnderSignal(world, entityHuman.locX, entityHuman.locY + 1.62 - entityHuman.height, entityHuman.locZ);
                entity.a(b.x, b.y, (double)b.z);
                world.addEntity(entity);
                world.makeSound(entityHuman, "random.bow", 0.5f, 0.4f / (ItemEnderEye.g.nextFloat() * 0.4f + 0.8f));
                world.a(null, 1002, (int)entityHuman.locX, (int)entityHuman.locY, (int)entityHuman.locZ, 0);
                if (!entityHuman.abilities.canInstantlyBuild) {
                    --itemStack.count;
                }
            }
        }
        return itemStack;
    }
}
