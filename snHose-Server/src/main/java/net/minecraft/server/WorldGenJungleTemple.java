package net.minecraft.server;

import java.util.*;

public class WorldGenJungleTemple extends WorldGenScatteredPiece
{
    private boolean e;
    private boolean i;
    private boolean j;
    private boolean k;
    private static final StructurePieceTreasure[] l;
    private static final StructurePieceTreasure[] m;
    private static WorldGenJungleTemplePiece n;
    
    public WorldGenJungleTemple() {
    }
    
    public WorldGenJungleTemple(final Random random, final int n, final int n2) {
        super(random, n, 64, n2, 12, 10, 15);
    }
    
    @Override
    protected void a(final NBTTagCompound nbtTagCompound) {
        super.a(nbtTagCompound);
        nbtTagCompound.setBoolean("placedMainChest", this.e);
        nbtTagCompound.setBoolean("placedHiddenChest", this.i);
        nbtTagCompound.setBoolean("placedTrap1", this.j);
        nbtTagCompound.setBoolean("placedTrap2", this.k);
    }
    
    @Override
    protected void b(final NBTTagCompound nbtTagCompound) {
        super.b(nbtTagCompound);
        this.e = nbtTagCompound.getBoolean("placedMainChest");
        this.i = nbtTagCompound.getBoolean("placedHiddenChest");
        this.j = nbtTagCompound.getBoolean("placedTrap1");
        this.k = nbtTagCompound.getBoolean("placedTrap2");
    }
    
    @Override
    public boolean a(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
        if (!this.a(world, structureBoundingBox, 0)) {
            return false;
        }
        final int a = this.a(Blocks.COBBLESTONE_STAIRS, 3);
        final int a2 = this.a(Blocks.COBBLESTONE_STAIRS, 2);
        final int a3 = this.a(Blocks.COBBLESTONE_STAIRS, 0);
        final int a4 = this.a(Blocks.COBBLESTONE_STAIRS, 1);
        this.a(world, structureBoundingBox, 0, -4, 0, this.a - 1, 0, this.c - 1, false, random, WorldGenJungleTemple.n);
        this.a(world, structureBoundingBox, 2, 1, 2, 9, 2, 2, false, random, WorldGenJungleTemple.n);
        this.a(world, structureBoundingBox, 2, 1, 12, 9, 2, 12, false, random, WorldGenJungleTemple.n);
        this.a(world, structureBoundingBox, 2, 1, 3, 2, 2, 11, false, random, WorldGenJungleTemple.n);
        this.a(world, structureBoundingBox, 9, 1, 3, 9, 2, 11, false, random, WorldGenJungleTemple.n);
        this.a(world, structureBoundingBox, 1, 3, 1, 10, 6, 1, false, random, WorldGenJungleTemple.n);
        this.a(world, structureBoundingBox, 1, 3, 13, 10, 6, 13, false, random, WorldGenJungleTemple.n);
        this.a(world, structureBoundingBox, 1, 3, 2, 1, 6, 12, false, random, WorldGenJungleTemple.n);
        this.a(world, structureBoundingBox, 10, 3, 2, 10, 6, 12, false, random, WorldGenJungleTemple.n);
        this.a(world, structureBoundingBox, 2, 3, 2, 9, 3, 12, false, random, WorldGenJungleTemple.n);
        this.a(world, structureBoundingBox, 2, 6, 2, 9, 6, 12, false, random, WorldGenJungleTemple.n);
        this.a(world, structureBoundingBox, 3, 7, 3, 8, 7, 11, false, random, WorldGenJungleTemple.n);
        this.a(world, structureBoundingBox, 4, 8, 4, 7, 8, 10, false, random, WorldGenJungleTemple.n);
        this.a(world, structureBoundingBox, 3, 1, 3, 8, 2, 11);
        this.a(world, structureBoundingBox, 4, 3, 6, 7, 3, 9);
        this.a(world, structureBoundingBox, 2, 4, 2, 9, 5, 12);
        this.a(world, structureBoundingBox, 4, 6, 5, 7, 6, 9);
        this.a(world, structureBoundingBox, 5, 7, 6, 6, 7, 8);
        this.a(world, structureBoundingBox, 5, 1, 2, 6, 2, 2);
        this.a(world, structureBoundingBox, 5, 2, 12, 6, 2, 12);
        this.a(world, structureBoundingBox, 5, 5, 1, 6, 5, 1);
        this.a(world, structureBoundingBox, 5, 5, 13, 6, 5, 13);
        this.a(world, Blocks.AIR, 0, 1, 5, 5, structureBoundingBox);
        this.a(world, Blocks.AIR, 0, 10, 5, 5, structureBoundingBox);
        this.a(world, Blocks.AIR, 0, 1, 5, 9, structureBoundingBox);
        this.a(world, Blocks.AIR, 0, 10, 5, 9, structureBoundingBox);
        for (int i = 0; i <= 14; i += 14) {
            this.a(world, structureBoundingBox, 2, 4, i, 2, 5, i, false, random, WorldGenJungleTemple.n);
            this.a(world, structureBoundingBox, 4, 4, i, 4, 5, i, false, random, WorldGenJungleTemple.n);
            this.a(world, structureBoundingBox, 7, 4, i, 7, 5, i, false, random, WorldGenJungleTemple.n);
            this.a(world, structureBoundingBox, 9, 4, i, 9, 5, i, false, random, WorldGenJungleTemple.n);
        }
        this.a(world, structureBoundingBox, 5, 6, 0, 6, 6, 0, false, random, WorldGenJungleTemple.n);
        for (int j = 0; j <= 11; j += 11) {
            for (int k = 2; k <= 12; k += 2) {
                this.a(world, structureBoundingBox, j, 4, k, j, 5, k, false, random, WorldGenJungleTemple.n);
            }
            this.a(world, structureBoundingBox, j, 6, 5, j, 6, 5, false, random, WorldGenJungleTemple.n);
            this.a(world, structureBoundingBox, j, 6, 9, j, 6, 9, false, random, WorldGenJungleTemple.n);
        }
        this.a(world, structureBoundingBox, 2, 7, 2, 2, 9, 2, false, random, WorldGenJungleTemple.n);
        this.a(world, structureBoundingBox, 9, 7, 2, 9, 9, 2, false, random, WorldGenJungleTemple.n);
        this.a(world, structureBoundingBox, 2, 7, 12, 2, 9, 12, false, random, WorldGenJungleTemple.n);
        this.a(world, structureBoundingBox, 9, 7, 12, 9, 9, 12, false, random, WorldGenJungleTemple.n);
        this.a(world, structureBoundingBox, 4, 9, 4, 4, 9, 4, false, random, WorldGenJungleTemple.n);
        this.a(world, structureBoundingBox, 7, 9, 4, 7, 9, 4, false, random, WorldGenJungleTemple.n);
        this.a(world, structureBoundingBox, 4, 9, 10, 4, 9, 10, false, random, WorldGenJungleTemple.n);
        this.a(world, structureBoundingBox, 7, 9, 10, 7, 9, 10, false, random, WorldGenJungleTemple.n);
        this.a(world, structureBoundingBox, 5, 9, 7, 6, 9, 7, false, random, WorldGenJungleTemple.n);
        this.a(world, Blocks.COBBLESTONE_STAIRS, a, 5, 9, 6, structureBoundingBox);
        this.a(world, Blocks.COBBLESTONE_STAIRS, a, 6, 9, 6, structureBoundingBox);
        this.a(world, Blocks.COBBLESTONE_STAIRS, a2, 5, 9, 8, structureBoundingBox);
        this.a(world, Blocks.COBBLESTONE_STAIRS, a2, 6, 9, 8, structureBoundingBox);
        this.a(world, Blocks.COBBLESTONE_STAIRS, a, 4, 0, 0, structureBoundingBox);
        this.a(world, Blocks.COBBLESTONE_STAIRS, a, 5, 0, 0, structureBoundingBox);
        this.a(world, Blocks.COBBLESTONE_STAIRS, a, 6, 0, 0, structureBoundingBox);
        this.a(world, Blocks.COBBLESTONE_STAIRS, a, 7, 0, 0, structureBoundingBox);
        this.a(world, Blocks.COBBLESTONE_STAIRS, a, 4, 1, 8, structureBoundingBox);
        this.a(world, Blocks.COBBLESTONE_STAIRS, a, 4, 2, 9, structureBoundingBox);
        this.a(world, Blocks.COBBLESTONE_STAIRS, a, 4, 3, 10, structureBoundingBox);
        this.a(world, Blocks.COBBLESTONE_STAIRS, a, 7, 1, 8, structureBoundingBox);
        this.a(world, Blocks.COBBLESTONE_STAIRS, a, 7, 2, 9, structureBoundingBox);
        this.a(world, Blocks.COBBLESTONE_STAIRS, a, 7, 3, 10, structureBoundingBox);
        this.a(world, structureBoundingBox, 4, 1, 9, 4, 1, 9, false, random, WorldGenJungleTemple.n);
        this.a(world, structureBoundingBox, 7, 1, 9, 7, 1, 9, false, random, WorldGenJungleTemple.n);
        this.a(world, structureBoundingBox, 4, 1, 10, 7, 2, 10, false, random, WorldGenJungleTemple.n);
        this.a(world, structureBoundingBox, 5, 4, 5, 6, 4, 5, false, random, WorldGenJungleTemple.n);
        this.a(world, Blocks.COBBLESTONE_STAIRS, a3, 4, 4, 5, structureBoundingBox);
        this.a(world, Blocks.COBBLESTONE_STAIRS, a4, 7, 4, 5, structureBoundingBox);
        for (int l = 0; l < 4; ++l) {
            this.a(world, Blocks.COBBLESTONE_STAIRS, a2, 5, 0 - l, 6 + l, structureBoundingBox);
            this.a(world, Blocks.COBBLESTONE_STAIRS, a2, 6, 0 - l, 6 + l, structureBoundingBox);
            this.a(world, structureBoundingBox, 5, 0 - l, 7 + l, 6, 0 - l, 9 + l);
        }
        this.a(world, structureBoundingBox, 1, -3, 12, 10, -1, 13);
        this.a(world, structureBoundingBox, 1, -3, 1, 3, -1, 13);
        this.a(world, structureBoundingBox, 1, -3, 1, 9, -1, 5);
        for (int n = 1; n <= 13; n += 2) {
            this.a(world, structureBoundingBox, 1, -3, n, 1, -2, n, false, random, WorldGenJungleTemple.n);
        }
        for (int n2 = 2; n2 <= 12; n2 += 2) {
            this.a(world, structureBoundingBox, 1, -1, n2, 3, -1, n2, false, random, WorldGenJungleTemple.n);
        }
        this.a(world, structureBoundingBox, 2, -2, 1, 5, -2, 1, false, random, WorldGenJungleTemple.n);
        this.a(world, structureBoundingBox, 7, -2, 1, 9, -2, 1, false, random, WorldGenJungleTemple.n);
        this.a(world, structureBoundingBox, 6, -3, 1, 6, -3, 1, false, random, WorldGenJungleTemple.n);
        this.a(world, structureBoundingBox, 6, -1, 1, 6, -1, 1, false, random, WorldGenJungleTemple.n);
        this.a(world, Blocks.TRIPWIRE_SOURCE, this.a(Blocks.TRIPWIRE_SOURCE, 3) | 0x4, 1, -3, 8, structureBoundingBox);
        this.a(world, Blocks.TRIPWIRE_SOURCE, this.a(Blocks.TRIPWIRE_SOURCE, 1) | 0x4, 4, -3, 8, structureBoundingBox);
        this.a(world, Blocks.TRIPWIRE, 4, 2, -3, 8, structureBoundingBox);
        this.a(world, Blocks.TRIPWIRE, 4, 3, -3, 8, structureBoundingBox);
        this.a(world, Blocks.REDSTONE_WIRE, 0, 5, -3, 7, structureBoundingBox);
        this.a(world, Blocks.REDSTONE_WIRE, 0, 5, -3, 6, structureBoundingBox);
        this.a(world, Blocks.REDSTONE_WIRE, 0, 5, -3, 5, structureBoundingBox);
        this.a(world, Blocks.REDSTONE_WIRE, 0, 5, -3, 4, structureBoundingBox);
        this.a(world, Blocks.REDSTONE_WIRE, 0, 5, -3, 3, structureBoundingBox);
        this.a(world, Blocks.REDSTONE_WIRE, 0, 5, -3, 2, structureBoundingBox);
        this.a(world, Blocks.REDSTONE_WIRE, 0, 5, -3, 1, structureBoundingBox);
        this.a(world, Blocks.REDSTONE_WIRE, 0, 4, -3, 1, structureBoundingBox);
        this.a(world, Blocks.MOSSY_COBBLESTONE, 0, 3, -3, 1, structureBoundingBox);
        if (!this.j) {
            this.j = this.a(world, structureBoundingBox, random, 3, -2, 1, 2, WorldGenJungleTemple.m, 2);
        }
        this.a(world, Blocks.VINE, 15, 3, -2, 2, structureBoundingBox);
        this.a(world, Blocks.TRIPWIRE_SOURCE, this.a(Blocks.TRIPWIRE_SOURCE, 2) | 0x4, 7, -3, 1, structureBoundingBox);
        this.a(world, Blocks.TRIPWIRE_SOURCE, this.a(Blocks.TRIPWIRE_SOURCE, 0) | 0x4, 7, -3, 5, structureBoundingBox);
        this.a(world, Blocks.TRIPWIRE, 4, 7, -3, 2, structureBoundingBox);
        this.a(world, Blocks.TRIPWIRE, 4, 7, -3, 3, structureBoundingBox);
        this.a(world, Blocks.TRIPWIRE, 4, 7, -3, 4, structureBoundingBox);
        this.a(world, Blocks.REDSTONE_WIRE, 0, 8, -3, 6, structureBoundingBox);
        this.a(world, Blocks.REDSTONE_WIRE, 0, 9, -3, 6, structureBoundingBox);
        this.a(world, Blocks.REDSTONE_WIRE, 0, 9, -3, 5, structureBoundingBox);
        this.a(world, Blocks.MOSSY_COBBLESTONE, 0, 9, -3, 4, structureBoundingBox);
        this.a(world, Blocks.REDSTONE_WIRE, 0, 9, -2, 4, structureBoundingBox);
        if (!this.k) {
            this.k = this.a(world, structureBoundingBox, random, 9, -2, 3, 4, WorldGenJungleTemple.m, 2);
        }
        this.a(world, Blocks.VINE, 15, 8, -1, 3, structureBoundingBox);
        this.a(world, Blocks.VINE, 15, 8, -2, 3, structureBoundingBox);
        if (!this.e) {
            this.e = this.a(world, structureBoundingBox, random, 8, -3, 3, StructurePieceTreasure.a(WorldGenJungleTemple.l, Items.ENCHANTED_BOOK.b(random)), 2 + random.nextInt(5));
        }
        this.a(world, Blocks.MOSSY_COBBLESTONE, 0, 9, -3, 2, structureBoundingBox);
        this.a(world, Blocks.MOSSY_COBBLESTONE, 0, 8, -3, 1, structureBoundingBox);
        this.a(world, Blocks.MOSSY_COBBLESTONE, 0, 4, -3, 5, structureBoundingBox);
        this.a(world, Blocks.MOSSY_COBBLESTONE, 0, 5, -2, 5, structureBoundingBox);
        this.a(world, Blocks.MOSSY_COBBLESTONE, 0, 5, -1, 5, structureBoundingBox);
        this.a(world, Blocks.MOSSY_COBBLESTONE, 0, 6, -3, 5, structureBoundingBox);
        this.a(world, Blocks.MOSSY_COBBLESTONE, 0, 7, -2, 5, structureBoundingBox);
        this.a(world, Blocks.MOSSY_COBBLESTONE, 0, 7, -1, 5, structureBoundingBox);
        this.a(world, Blocks.MOSSY_COBBLESTONE, 0, 8, -3, 5, structureBoundingBox);
        this.a(world, structureBoundingBox, 9, -1, 1, 9, -1, 5, false, random, WorldGenJungleTemple.n);
        this.a(world, structureBoundingBox, 8, -3, 8, 10, -1, 10);
        this.a(world, Blocks.SMOOTH_BRICK, 3, 8, -2, 11, structureBoundingBox);
        this.a(world, Blocks.SMOOTH_BRICK, 3, 9, -2, 11, structureBoundingBox);
        this.a(world, Blocks.SMOOTH_BRICK, 3, 10, -2, 11, structureBoundingBox);
        this.a(world, Blocks.LEVER, BlockLever.b(this.a(Blocks.LEVER, 2)), 8, -2, 12, structureBoundingBox);
        this.a(world, Blocks.LEVER, BlockLever.b(this.a(Blocks.LEVER, 2)), 9, -2, 12, structureBoundingBox);
        this.a(world, Blocks.LEVER, BlockLever.b(this.a(Blocks.LEVER, 2)), 10, -2, 12, structureBoundingBox);
        this.a(world, structureBoundingBox, 8, -3, 8, 8, -3, 10, false, random, WorldGenJungleTemple.n);
        this.a(world, structureBoundingBox, 10, -3, 8, 10, -3, 10, false, random, WorldGenJungleTemple.n);
        this.a(world, Blocks.MOSSY_COBBLESTONE, 0, 10, -2, 9, structureBoundingBox);
        this.a(world, Blocks.REDSTONE_WIRE, 0, 8, -2, 9, structureBoundingBox);
        this.a(world, Blocks.REDSTONE_WIRE, 0, 8, -2, 10, structureBoundingBox);
        this.a(world, Blocks.REDSTONE_WIRE, 0, 10, -1, 9, structureBoundingBox);
        this.a(world, Blocks.PISTON_STICKY, 1, 9, -2, 8, structureBoundingBox);
        this.a(world, Blocks.PISTON_STICKY, this.a(Blocks.PISTON_STICKY, 4), 10, -2, 8, structureBoundingBox);
        this.a(world, Blocks.PISTON_STICKY, this.a(Blocks.PISTON_STICKY, 4), 10, -1, 8, structureBoundingBox);
        this.a(world, Blocks.DIODE_OFF, this.a(Blocks.DIODE_OFF, 2), 10, -2, 10, structureBoundingBox);
        if (!this.i) {
            this.i = this.a(world, structureBoundingBox, random, 9, -3, 10, StructurePieceTreasure.a(WorldGenJungleTemple.l, Items.ENCHANTED_BOOK.b(random)), 2 + random.nextInt(5));
        }
        return true;
    }
    
    static {
        l = new StructurePieceTreasure[] { new StructurePieceTreasure(Items.DIAMOND, 0, 1, 3, 3), new StructurePieceTreasure(Items.IRON_INGOT, 0, 1, 5, 10), new StructurePieceTreasure(Items.GOLD_INGOT, 0, 2, 7, 15), new StructurePieceTreasure(Items.EMERALD, 0, 1, 3, 2), new StructurePieceTreasure(Items.BONE, 0, 4, 6, 20), new StructurePieceTreasure(Items.ROTTEN_FLESH, 0, 3, 7, 16), new StructurePieceTreasure(Items.SADDLE, 0, 1, 1, 3), new StructurePieceTreasure(Items.HORSE_ARMOR_IRON, 0, 1, 1, 1), new StructurePieceTreasure(Items.HORSE_ARMOR_GOLD, 0, 1, 1, 1), new StructurePieceTreasure(Items.HORSE_ARMOR_DIAMOND, 0, 1, 1, 1) };
        m = new StructurePieceTreasure[] { new StructurePieceTreasure(Items.ARROW, 0, 2, 7, 30) };
        WorldGenJungleTemple.n = new WorldGenJungleTemplePiece(null);
    }
}
