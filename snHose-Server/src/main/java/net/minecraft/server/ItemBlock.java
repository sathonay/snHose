package net.minecraft.server;

public class ItemBlock extends Item {
    protected final Block block;

    public ItemBlock(final Block block) {
        this.block = block;
    }

    public ItemBlock b(final String s) {
        super.c(s);
        return this;
    }

    @Override
    public boolean interactWith(final ItemStack itemstack, final EntityHuman entityHuman, final World world, int i, int j, int k, int l, final float f, final float f2, final float f3) {
        final Block type = world.getType(i, j, k);
        if (type == Blocks.SNOW && (world.getData(i, j, k) & 0x7) < 1) {
            l = 1;
        }
        else if (type != Blocks.VINE && type != Blocks.LONG_GRASS) {
            if (type != Blocks.DEAD_BUSH) {
                if (l == 0) {
                    --j;
                }
                if (l == 1) {
                    ++j;
                }
                if (l == 2) {
                    --k;
                }
                if (l == 3) {
                    ++k;
                }
                if (l == 4) {
                    --i;
                }
                if (l == 5) {
                    ++i;
                }
            }
        }
        if (itemstack.count == 0) {
            return false;
        }
        if (!entityHuman.a(i, j, k, l, itemstack)) {
            return false;
        }
        if (j == 255 && this.block.getMaterial().isBuildable()) {
            return false;
        }
        if (world.mayPlace(this.block, i, j, k, false, l, entityHuman, itemstack)) {
            final int placedData = this.block.getPlacedData(world, i, j, k, l, f, f2, f3, this.filterData(itemstack.getData()));
            if (world.setTypeAndData(i, j, k, this.block, placedData, 3)) {
                if (world.getType(i, j, k) == this.block) {
                    this.block.postPlace(world, i, j, k, entityHuman, itemstack);
                    this.block.postPlace(world, i, j, k, placedData);
                }
                world.makeSound(entityHuman, i + 0.5f, j + 0.5f, k + 0.5f, this.block.stepSound.getPlaceSound(), (this.block.stepSound.getVolume1() + 1.0f) / 2.0f, this.block.stepSound.getVolume2() * 0.8f);
                --itemstack.count;
            }
            return true;
        }
        return false;
    }

    @Override
    public String a(final ItemStack itemStack) {
        return this.block.a();
    }

    @Override
    public String getName() {
        return this.block.a();
    }
}
