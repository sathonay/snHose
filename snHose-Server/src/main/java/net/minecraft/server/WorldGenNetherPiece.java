package net.minecraft.server.v1_7_R4;

import java.util.*;

abstract class WorldGenNetherPiece extends StructurePiece
{
    protected static final StructurePieceTreasure[] a;
    
    public WorldGenNetherPiece() {
    }
    
    protected WorldGenNetherPiece(final int n) {
        super(n);
    }
    
    @Override
    protected void b(final NBTTagCompound nbtTagCompound) {
    }
    
    @Override
    protected void a(final NBTTagCompound nbtTagCompound) {
    }
    
    private int a(final List list) {
        boolean b = false;
        int n = 0;
        for (final WorldGenNetherPieceWeight worldGenNetherPieceWeight : list) {
            if (worldGenNetherPieceWeight.d > 0 && worldGenNetherPieceWeight.c < worldGenNetherPieceWeight.d) {
                b = true;
            }
            n += worldGenNetherPieceWeight.b;
        }
        return b ? n : -1;
    }
    
    private WorldGenNetherPiece a(final WorldGenNetherPiece15 worldGenNetherPiece15, final List list, final List list2, final Random random, final int n, final int n2, final int n3, final int n4, final int n5) {
        final int a = this.a(list);
        final boolean b = a > 0 && n5 <= 30;
        int n6 = 0;
        while (n6 < 5 && b) {
            ++n6;
            int nextInt = random.nextInt(a);
            for (final WorldGenNetherPieceWeight b2 : list) {
                nextInt -= b2.b;
                if (nextInt < 0) {
                    if (!b2.a(n5)) {
                        break;
                    }
                    if (b2 == worldGenNetherPiece15.b && !b2.e) {
                        break;
                    }
                    final WorldGenNetherPiece a2 = b(b2, list2, random, n, n2, n3, n4, n5);
                    if (a2 != null) {
                        final WorldGenNetherPieceWeight worldGenNetherPieceWeight = b2;
                        ++worldGenNetherPieceWeight.c;
                        worldGenNetherPiece15.b = b2;
                        if (!b2.a()) {
                            list.remove(b2);
                        }
                        return a2;
                    }
                    continue;
                }
            }
        }
        return WorldGenNetherPiece2.a(list2, random, n, n2, n3, n4, n5);
    }
    
    private StructurePiece a(final WorldGenNetherPiece15 worldGenNetherPiece15, final List list, final Random random, final int n, final int n2, final int n3, final int n4, final int n5, final boolean b) {
        if (Math.abs(n - worldGenNetherPiece15.c().a) > 112 || Math.abs(n3 - worldGenNetherPiece15.c().c) > 112) {
            return WorldGenNetherPiece2.a(list, random, n, n2, n3, n4, n5);
        }
        List list2 = worldGenNetherPiece15.c;
        if (b) {
            list2 = worldGenNetherPiece15.d;
        }
        final WorldGenNetherPiece a = this.a(worldGenNetherPiece15, list2, list, random, n, n2, n3, n4, n5 + 1);
        if (a != null) {
            list.add(a);
            worldGenNetherPiece15.e.add(a);
        }
        return a;
    }
    
    protected StructurePiece a(final WorldGenNetherPiece15 worldGenNetherPiece15, final List list, final Random random, final int n, final int n2, final boolean b) {
        switch (this.g) {
            case 2: {
                return this.a(worldGenNetherPiece15, list, random, this.f.a + n, this.f.b + n2, this.f.c - 1, this.g, this.d(), b);
            }
            case 0: {
                return this.a(worldGenNetherPiece15, list, random, this.f.a + n, this.f.b + n2, this.f.f + 1, this.g, this.d(), b);
            }
            case 1: {
                return this.a(worldGenNetherPiece15, list, random, this.f.a - 1, this.f.b + n2, this.f.c + n, this.g, this.d(), b);
            }
            case 3: {
                return this.a(worldGenNetherPiece15, list, random, this.f.d + 1, this.f.b + n2, this.f.c + n, this.g, this.d(), b);
            }
            default: {
                return null;
            }
        }
    }
    
    protected StructurePiece b(final WorldGenNetherPiece15 worldGenNetherPiece15, final List list, final Random random, final int n, final int n2, final boolean b) {
        switch (this.g) {
            case 2: {
                return this.a(worldGenNetherPiece15, list, random, this.f.a - 1, this.f.b + n, this.f.c + n2, 1, this.d(), b);
            }
            case 0: {
                return this.a(worldGenNetherPiece15, list, random, this.f.a - 1, this.f.b + n, this.f.c + n2, 1, this.d(), b);
            }
            case 1: {
                return this.a(worldGenNetherPiece15, list, random, this.f.a + n2, this.f.b + n, this.f.c - 1, 2, this.d(), b);
            }
            case 3: {
                return this.a(worldGenNetherPiece15, list, random, this.f.a + n2, this.f.b + n, this.f.c - 1, 2, this.d(), b);
            }
            default: {
                return null;
            }
        }
    }
    
    protected StructurePiece c(final WorldGenNetherPiece15 worldGenNetherPiece15, final List list, final Random random, final int n, final int n2, final boolean b) {
        switch (this.g) {
            case 2: {
                return this.a(worldGenNetherPiece15, list, random, this.f.d + 1, this.f.b + n, this.f.c + n2, 3, this.d(), b);
            }
            case 0: {
                return this.a(worldGenNetherPiece15, list, random, this.f.d + 1, this.f.b + n, this.f.c + n2, 3, this.d(), b);
            }
            case 1: {
                return this.a(worldGenNetherPiece15, list, random, this.f.a + n2, this.f.b + n, this.f.f + 1, 0, this.d(), b);
            }
            case 3: {
                return this.a(worldGenNetherPiece15, list, random, this.f.a + n2, this.f.b + n, this.f.f + 1, 0, this.d(), b);
            }
            default: {
                return null;
            }
        }
    }
    
    protected static boolean a(final StructureBoundingBox structureBoundingBox) {
        return structureBoundingBox != null && structureBoundingBox.b > 10;
    }
    
    static {
        a = new StructurePieceTreasure[] { new StructurePieceTreasure(Items.DIAMOND, 0, 1, 3, 5), new StructurePieceTreasure(Items.IRON_INGOT, 0, 1, 5, 5), new StructurePieceTreasure(Items.GOLD_INGOT, 0, 1, 3, 15), new StructurePieceTreasure(Items.GOLD_SWORD, 0, 1, 1, 5), new StructurePieceTreasure(Items.GOLD_CHESTPLATE, 0, 1, 1, 5), new StructurePieceTreasure(Items.FLINT_AND_STEEL, 0, 1, 1, 5), new StructurePieceTreasure(Items.NETHER_STALK, 0, 3, 7, 5), new StructurePieceTreasure(Items.SADDLE, 0, 1, 1, 10), new StructurePieceTreasure(Items.HORSE_ARMOR_GOLD, 0, 1, 1, 8), new StructurePieceTreasure(Items.HORSE_ARMOR_IRON, 0, 1, 1, 5), new StructurePieceTreasure(Items.HORSE_ARMOR_DIAMOND, 0, 1, 1, 3) };
    }
}
