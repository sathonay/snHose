package net.minecraft.server;

import java.util.*;

public class WorldGenMineshaftCorridor extends StructurePiece
{
    private boolean a;
    private boolean b;
    private boolean c;
    private int d;
    
    public WorldGenMineshaftCorridor() {
    }
    
    @Override
    protected void a(final NBTTagCompound nbtTagCompound) {
        nbtTagCompound.setBoolean("hr", this.a);
        nbtTagCompound.setBoolean("sc", this.b);
        nbtTagCompound.setBoolean("hps", this.c);
        nbtTagCompound.setInt("Num", this.d);
    }
    
    @Override
    protected void b(final NBTTagCompound nbtTagCompound) {
        this.a = nbtTagCompound.getBoolean("hr");
        this.b = nbtTagCompound.getBoolean("sc");
        this.c = nbtTagCompound.getBoolean("hps");
        this.d = nbtTagCompound.getInt("Num");
    }
    
    public WorldGenMineshaftCorridor(final int n, final Random random, final StructureBoundingBox f, final int g) {
        super(n);
        this.g = g;
        this.f = f;
        this.a = (random.nextInt(3) == 0);
        this.b = (!this.a && random.nextInt(23) == 0);
        if (this.g == 2 || this.g == 0) {
            this.d = f.d() / 5;
        }
        else {
            this.d = f.b() / 5;
        }
    }
    
    public static StructureBoundingBox a(final List list, final Random random, final int n, final int n2, final int n3, final int n4) {
        final StructureBoundingBox structureBoundingBox = new StructureBoundingBox(n, n2, n3, n, n2 + 2, n3);
        int i;
        for (i = random.nextInt(3) + 2; i > 0; --i) {
            final int n5 = i * 5;
            switch (n4) {
                case 2: {
                    structureBoundingBox.d = n + 2;
                    structureBoundingBox.c = n3 - (n5 - 1);
                    break;
                }
                case 0: {
                    structureBoundingBox.d = n + 2;
                    structureBoundingBox.f = n3 + (n5 - 1);
                    break;
                }
                case 1: {
                    structureBoundingBox.a = n - (n5 - 1);
                    structureBoundingBox.f = n3 + 2;
                    break;
                }
                case 3: {
                    structureBoundingBox.d = n + (n5 - 1);
                    structureBoundingBox.f = n3 + 2;
                    break;
                }
            }
            if (StructurePiece.a(list, structureBoundingBox) == null) {
                break;
            }
        }
        if (i > 0) {
            return structureBoundingBox;
        }
        return null;
    }
    
    @Override
    public void a(final StructurePiece structurePiece, final List list, final Random random) {
        final int d = this.d();
        final int nextInt = random.nextInt(4);
        switch (this.g) {
            case 2: {
                if (nextInt <= 1) {
                    b(structurePiece, list, random, this.f.a, this.f.b - 1 + random.nextInt(3), this.f.c - 1, this.g, d);
                    break;
                }
                if (nextInt == 2) {
                    b(structurePiece, list, random, this.f.a - 1, this.f.b - 1 + random.nextInt(3), this.f.c, 1, d);
                    break;
                }
                b(structurePiece, list, random, this.f.d + 1, this.f.b - 1 + random.nextInt(3), this.f.c, 3, d);
                break;
            }
            case 0: {
                if (nextInt <= 1) {
                    b(structurePiece, list, random, this.f.a, this.f.b - 1 + random.nextInt(3), this.f.f + 1, this.g, d);
                    break;
                }
                if (nextInt == 2) {
                    b(structurePiece, list, random, this.f.a - 1, this.f.b - 1 + random.nextInt(3), this.f.f - 3, 1, d);
                    break;
                }
                b(structurePiece, list, random, this.f.d + 1, this.f.b - 1 + random.nextInt(3), this.f.f - 3, 3, d);
                break;
            }
            case 1: {
                if (nextInt <= 1) {
                    b(structurePiece, list, random, this.f.a - 1, this.f.b - 1 + random.nextInt(3), this.f.c, this.g, d);
                    break;
                }
                if (nextInt == 2) {
                    b(structurePiece, list, random, this.f.a, this.f.b - 1 + random.nextInt(3), this.f.c - 1, 2, d);
                    break;
                }
                b(structurePiece, list, random, this.f.a, this.f.b - 1 + random.nextInt(3), this.f.f + 1, 0, d);
                break;
            }
            case 3: {
                if (nextInt <= 1) {
                    b(structurePiece, list, random, this.f.d + 1, this.f.b - 1 + random.nextInt(3), this.f.c, this.g, d);
                    break;
                }
                if (nextInt == 2) {
                    b(structurePiece, list, random, this.f.d - 3, this.f.b - 1 + random.nextInt(3), this.f.c - 1, 2, d);
                    break;
                }
                b(structurePiece, list, random, this.f.d - 3, this.f.b - 1 + random.nextInt(3), this.f.f + 1, 0, d);
                break;
            }
        }
        if (d < 8) {
            if (this.g == 2 || this.g == 0) {
                for (int n = this.f.c + 3; n + 3 <= this.f.f; n += 5) {
                    final int nextInt2 = random.nextInt(5);
                    if (nextInt2 == 0) {
                        b(structurePiece, list, random, this.f.a - 1, this.f.b, n, 1, d + 1);
                    }
                    else if (nextInt2 == 1) {
                        b(structurePiece, list, random, this.f.d + 1, this.f.b, n, 3, d + 1);
                    }
                }
            }
            else {
                for (int n2 = this.f.a + 3; n2 + 3 <= this.f.d; n2 += 5) {
                    final int nextInt3 = random.nextInt(5);
                    if (nextInt3 == 0) {
                        b(structurePiece, list, random, n2, this.f.b, this.f.c - 1, 2, d + 1);
                    }
                    else if (nextInt3 == 1) {
                        b(structurePiece, list, random, n2, this.f.b, this.f.f + 1, 0, d + 1);
                    }
                }
            }
        }
    }
    
    @Override
    protected boolean a(final World world, final StructureBoundingBox structureBoundingBox, final Random random, final int n, final int n2, final int n3, final StructurePieceTreasure[] array, final int n4) {
        final int a = this.a(n, n3);
        final int a2 = this.a(n2);
        final int b = this.b(n, n3);
        if (structureBoundingBox.b(a, a2, b) && world.getType(a, a2, b).getMaterial() == Material.AIR) {
            world.setTypeAndData(a, a2, b, Blocks.RAILS, this.a(Blocks.RAILS, (int)(random.nextBoolean() ? 1 : 0)), 2);
            final EntityMinecartChest entity = new EntityMinecartChest(world, a + 0.5f, a2 + 0.5f, b + 0.5f);
            StructurePieceTreasure.a(random, array, entity, n4);
            world.addEntity(entity);
            return true;
        }
        return false;
    }
    
    @Override
    public boolean a(final World world, final Random random, final StructureBoundingBox structureBoundingBox) {
        if (this.a(world, structureBoundingBox)) {
            return false;
        }
        final int n = this.d * 5 - 1;
        this.a(world, structureBoundingBox, 0, 0, 0, 2, 1, n, Blocks.AIR, Blocks.AIR, false);
        this.a(world, structureBoundingBox, random, 0.8f, 0, 2, 0, 2, 2, n, Blocks.AIR, Blocks.AIR, false);
        if (this.b) {
            this.a(world, structureBoundingBox, random, 0.6f, 0, 0, 0, 2, 1, n, Blocks.WEB, Blocks.AIR, false);
        }
        for (int i = 0; i < this.d; ++i) {
            final int n2 = 2 + i * 5;
            this.a(world, structureBoundingBox, 0, 0, n2, 0, 1, n2, Blocks.FENCE, Blocks.AIR, false);
            this.a(world, structureBoundingBox, 2, 0, n2, 2, 1, n2, Blocks.FENCE, Blocks.AIR, false);
            if (random.nextInt(4) == 0) {
                this.a(world, structureBoundingBox, 0, 2, n2, 0, 2, n2, Blocks.WOOD, Blocks.AIR, false);
                this.a(world, structureBoundingBox, 2, 2, n2, 2, 2, n2, Blocks.WOOD, Blocks.AIR, false);
            }
            else {
                this.a(world, structureBoundingBox, 0, 2, n2, 2, 2, n2, Blocks.WOOD, Blocks.AIR, false);
            }
            this.a(world, structureBoundingBox, random, 0.1f, 0, 2, n2 - 1, Blocks.WEB, 0);
            this.a(world, structureBoundingBox, random, 0.1f, 2, 2, n2 - 1, Blocks.WEB, 0);
            this.a(world, structureBoundingBox, random, 0.1f, 0, 2, n2 + 1, Blocks.WEB, 0);
            this.a(world, structureBoundingBox, random, 0.1f, 2, 2, n2 + 1, Blocks.WEB, 0);
            this.a(world, structureBoundingBox, random, 0.05f, 0, 2, n2 - 2, Blocks.WEB, 0);
            this.a(world, structureBoundingBox, random, 0.05f, 2, 2, n2 - 2, Blocks.WEB, 0);
            this.a(world, structureBoundingBox, random, 0.05f, 0, 2, n2 + 2, Blocks.WEB, 0);
            this.a(world, structureBoundingBox, random, 0.05f, 2, 2, n2 + 2, Blocks.WEB, 0);
            this.a(world, structureBoundingBox, random, 0.05f, 1, 2, n2 - 1, Blocks.TORCH, 0);
            this.a(world, structureBoundingBox, random, 0.05f, 1, 2, n2 + 1, Blocks.TORCH, 0);
            if (random.nextInt(100) == 0) {
                this.a(world, structureBoundingBox, random, 2, 0, n2 - 1, StructurePieceTreasure.a(WorldGenMineshaftPieces.a, Items.ENCHANTED_BOOK.b(random)), 3 + random.nextInt(4));
            }
            if (random.nextInt(100) == 0) {
                this.a(world, structureBoundingBox, random, 0, 0, n2 + 1, StructurePieceTreasure.a(WorldGenMineshaftPieces.a, Items.ENCHANTED_BOOK.b(random)), 3 + random.nextInt(4));
            }
            if (this.b && !this.c) {
                final int a = this.a(0);
                final int n3 = n2 - 1 + random.nextInt(3);
                final int a2 = this.a(1, n3);
                final int b = this.b(1, n3);
                if (structureBoundingBox.b(a2, a, b)) {
                    this.c = true;
                    world.setTypeAndData(a2, a, b, Blocks.MOB_SPAWNER, 0, 2);
                    final TileEntityMobSpawner tileEntityMobSpawner = (TileEntityMobSpawner)world.getTileEntity(a2, a, b);
                    if (tileEntityMobSpawner != null) {
                        tileEntityMobSpawner.getSpawner().setMobName("CaveSpider");
                    }
                }
            }
        }
        for (int j = 0; j <= 2; ++j) {
            for (int k = 0; k <= n; ++k) {
                if (this.a(world, j, -1, k, structureBoundingBox).getMaterial() == Material.AIR) {
                    this.a(world, Blocks.WOOD, 0, j, -1, k, structureBoundingBox);
                }
            }
        }
        if (this.a) {
            for (int l = 0; l <= n; ++l) {
                final Block a3 = this.a(world, 1, -1, l, structureBoundingBox);
                if (a3.getMaterial() != Material.AIR && a3.j()) {
                    this.a(world, structureBoundingBox, random, 0.7f, 1, 0, l, Blocks.RAILS, this.a(Blocks.RAILS, 0));
                }
            }
        }
        return true;
    }
}
