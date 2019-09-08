package net.minecraft.server.v1_7_R4;

import java.util.*;

public class StructurePieceTreasure extends WeightedRandomChoice
{
    private ItemStack b;
    private int c;
    private int d;
    
    public StructurePieceTreasure(final Item item, final int j, final int c, final int d, final int n) {
        super(n);
        this.b = new ItemStack(item, 1, j);
        this.c = c;
        this.d = d;
    }
    
    public StructurePieceTreasure(final ItemStack b, final int c, final int d, final int n) {
        super(n);
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public static void a(final Random random, final StructurePieceTreasure[] array, final IInventory inventory, final int n) {
        for (int i = 0; i < n; ++i) {
            final StructurePieceTreasure structurePieceTreasure = (StructurePieceTreasure)WeightedRandom.a(random, array);
            final int count = structurePieceTreasure.c + random.nextInt(structurePieceTreasure.d - structurePieceTreasure.c + 1);
            if (structurePieceTreasure.b.getMaxStackSize() >= count) {
                final ItemStack cloneItemStack = structurePieceTreasure.b.cloneItemStack();
                cloneItemStack.count = count;
                inventory.setItem(random.nextInt(inventory.getSize()), cloneItemStack);
            }
            else {
                for (int j = 0; j < count; ++j) {
                    final ItemStack cloneItemStack2 = structurePieceTreasure.b.cloneItemStack();
                    cloneItemStack2.count = 1;
                    inventory.setItem(random.nextInt(inventory.getSize()), cloneItemStack2);
                }
            }
        }
    }
    
    public static void a(final Random random, final StructurePieceTreasure[] array, final TileEntityDispenser tileEntityDispenser, final int n) {
        for (int i = 0; i < n; ++i) {
            final StructurePieceTreasure structurePieceTreasure = (StructurePieceTreasure)WeightedRandom.a(random, array);
            final int count = structurePieceTreasure.c + random.nextInt(structurePieceTreasure.d - structurePieceTreasure.c + 1);
            if (structurePieceTreasure.b.getMaxStackSize() >= count) {
                final ItemStack cloneItemStack = structurePieceTreasure.b.cloneItemStack();
                cloneItemStack.count = count;
                tileEntityDispenser.setItem(random.nextInt(tileEntityDispenser.getSize()), cloneItemStack);
            }
            else {
                for (int j = 0; j < count; ++j) {
                    final ItemStack cloneItemStack2 = structurePieceTreasure.b.cloneItemStack();
                    cloneItemStack2.count = 1;
                    tileEntityDispenser.setItem(random.nextInt(tileEntityDispenser.getSize()), cloneItemStack2);
                }
            }
        }
    }
    
    public static StructurePieceTreasure[] a(final StructurePieceTreasure[] array, final StructurePieceTreasure... array2) {
        final StructurePieceTreasure[] array3 = new StructurePieceTreasure[array.length + array2.length];
        int n = 0;
        for (int i = 0; i < array.length; ++i) {
            array3[n++] = array[i];
        }
        for (int length = array2.length, j = 0; j < length; ++j) {
            array3[n++] = array2[j];
        }
        return array3;
    }
}
