package net.minecraft.server.v1_7_R4;

import java.util.*;

public abstract class StructurePiece
{
    protected StructureBoundingBox f;
    protected int g;
    protected int h;
    
    public StructurePiece() {
    }
    
    protected StructurePiece(final int h) {
        this.h = h;
        this.g = -1;
    }
    
    public NBTTagCompound b() {
        final NBTTagCompound nbtTagCompound = new NBTTagCompound();
        nbtTagCompound.setString("id", WorldGenFactory.a(this));
        nbtTagCompound.set("BB", this.f.h());
        nbtTagCompound.setInt("O", this.g);
        nbtTagCompound.setInt("GD", this.h);
        this.a(nbtTagCompound);
        return nbtTagCompound;
    }
    
    protected abstract void a(final NBTTagCompound p0);
    
    public void a(final World world, final NBTTagCompound nbtTagCompound) {
        if (nbtTagCompound.hasKey("BB")) {
            this.f = new StructureBoundingBox(nbtTagCompound.getIntArray("BB"));
        }
        this.g = nbtTagCompound.getInt("O");
        this.h = nbtTagCompound.getInt("GD");
        this.b(nbtTagCompound);
    }
    
    protected abstract void b(final NBTTagCompound p0);
    
    public void a(final StructurePiece structurePiece, final List list, final Random random) {
    }
    
    public abstract boolean a(final World p0, final Random p1, final StructureBoundingBox p2);
    
    public StructureBoundingBox c() {
        return this.f;
    }
    
    public int d() {
        return this.h;
    }
    
    public static StructurePiece a(final List list, final StructureBoundingBox structureBoundingBox) {
        for (final StructurePiece structurePiece : list) {
            if (structurePiece.c() != null && structurePiece.c().a(structureBoundingBox)) {
                return structurePiece;
            }
        }
        return null;
    }
    
    public ChunkPosition a() {
        return new ChunkPosition(this.f.e(), this.f.f(), this.f.g());
    }
    
    protected boolean a(final World world, final StructureBoundingBox structureBoundingBox) {
        final int max = Math.max(this.f.a - 1, structureBoundingBox.a);
        final int max2 = Math.max(this.f.b - 1, structureBoundingBox.b);
        final int max3 = Math.max(this.f.c - 1, structureBoundingBox.c);
        final int min = Math.min(this.f.d + 1, structureBoundingBox.d);
        final int min2 = Math.min(this.f.e + 1, structureBoundingBox.e);
        final int min3 = Math.min(this.f.f + 1, structureBoundingBox.f);
        for (int i = max; i <= min; ++i) {
            for (int j = max3; j <= min3; ++j) {
                if (world.getType(i, max2, j).getMaterial().isLiquid()) {
                    return true;
                }
                if (world.getType(i, min2, j).getMaterial().isLiquid()) {
                    return true;
                }
            }
        }
        for (int k = max; k <= min; ++k) {
            for (int l = max2; l <= min2; ++l) {
                if (world.getType(k, l, max3).getMaterial().isLiquid()) {
                    return true;
                }
                if (world.getType(k, l, min3).getMaterial().isLiquid()) {
                    return true;
                }
            }
        }
        for (int n = max3; n <= min3; ++n) {
            for (int n2 = max2; n2 <= min2; ++n2) {
                if (world.getType(max, n2, n).getMaterial().isLiquid()) {
                    return true;
                }
                if (world.getType(min, n2, n).getMaterial().isLiquid()) {
                    return true;
                }
            }
        }
        return false;
    }
    
    protected int a(final int n, final int n2) {
        switch (this.g) {
            case 0:
            case 2: {
                return this.f.a + n;
            }
            case 1: {
                return this.f.d - n2;
            }
            case 3: {
                return this.f.a + n2;
            }
            default: {
                return n;
            }
        }
    }
    
    protected int a(final int n) {
        if (this.g == -1) {
            return n;
        }
        return n + this.f.b;
    }
    
    protected int b(final int n, final int n2) {
        switch (this.g) {
            case 2: {
                return this.f.f - n2;
            }
            case 0: {
                return this.f.c + n2;
            }
            case 1:
            case 3: {
                return this.f.c + n;
            }
            default: {
                return n2;
            }
        }
    }
    
    protected int a(final Block block, final int n) {
        if (block == Blocks.RAILS) {
            if (this.g == 1 || this.g == 3) {
                if (n == 1) {
                    return 0;
                }
                return 1;
            }
        }
        else if (block == Blocks.WOODEN_DOOR || block == Blocks.IRON_DOOR_BLOCK) {
            if (this.g == 0) {
                if (n == 0) {
                    return 2;
                }
                if (n == 2) {
                    return 0;
                }
            }
            else {
                if (this.g == 1) {
                    return n + 1 & 0x3;
                }
                if (this.g == 3) {
                    return n + 3 & 0x3;
                }
            }
        }
        else if (block == Blocks.COBBLESTONE_STAIRS || block == Blocks.WOOD_STAIRS || block == Blocks.NETHER_BRICK_STAIRS || block == Blocks.STONE_STAIRS || block == Blocks.SANDSTONE_STAIRS) {
            if (this.g == 0) {
                if (n == 2) {
                    return 3;
                }
                if (n == 3) {
                    return 2;
                }
            }
            else if (this.g == 1) {
                if (n == 0) {
                    return 2;
                }
                if (n == 1) {
                    return 3;
                }
                if (n == 2) {
                    return 0;
                }
                if (n == 3) {
                    return 1;
                }
            }
            else if (this.g == 3) {
                if (n == 0) {
                    return 2;
                }
                if (n == 1) {
                    return 3;
                }
                if (n == 2) {
                    return 1;
                }
                if (n == 3) {
                    return 0;
                }
            }
        }
        else if (block == Blocks.LADDER) {
            if (this.g == 0) {
                if (n == 2) {
                    return 3;
                }
                if (n == 3) {
                    return 2;
                }
            }
            else if (this.g == 1) {
                if (n == 2) {
                    return 4;
                }
                if (n == 3) {
                    return 5;
                }
                if (n == 4) {
                    return 2;
                }
                if (n == 5) {
                    return 3;
                }
            }
            else if (this.g == 3) {
                if (n == 2) {
                    return 5;
                }
                if (n == 3) {
                    return 4;
                }
                if (n == 4) {
                    return 2;
                }
                if (n == 5) {
                    return 3;
                }
            }
        }
        else if (block == Blocks.STONE_BUTTON) {
            if (this.g == 0) {
                if (n == 3) {
                    return 4;
                }
                if (n == 4) {
                    return 3;
                }
            }
            else if (this.g == 1) {
                if (n == 3) {
                    return 1;
                }
                if (n == 4) {
                    return 2;
                }
                if (n == 2) {
                    return 3;
                }
                if (n == 1) {
                    return 4;
                }
            }
            else if (this.g == 3) {
                if (n == 3) {
                    return 2;
                }
                if (n == 4) {
                    return 1;
                }
                if (n == 2) {
                    return 3;
                }
                if (n == 1) {
                    return 4;
                }
            }
        }
        else if (block == Blocks.TRIPWIRE_SOURCE || block instanceof BlockDirectional) {
            if (this.g == 0) {
                if (n == 0 || n == 2) {
                    return Direction.f[n];
                }
            }
            else if (this.g == 1) {
                if (n == 2) {
                    return 1;
                }
                if (n == 0) {
                    return 3;
                }
                if (n == 1) {
                    return 2;
                }
                if (n == 3) {
                    return 0;
                }
            }
            else if (this.g == 3) {
                if (n == 2) {
                    return 3;
                }
                if (n == 0) {
                    return 1;
                }
                if (n == 1) {
                    return 2;
                }
                if (n == 3) {
                    return 0;
                }
            }
        }
        else if (block == Blocks.PISTON || block == Blocks.PISTON_STICKY || block == Blocks.LEVER || block == Blocks.DISPENSER) {
            if (this.g == 0) {
                if (n == 2 || n == 3) {
                    return Facing.OPPOSITE_FACING[n];
                }
            }
            else if (this.g == 1) {
                if (n == 2) {
                    return 4;
                }
                if (n == 3) {
                    return 5;
                }
                if (n == 4) {
                    return 2;
                }
                if (n == 5) {
                    return 3;
                }
            }
            else if (this.g == 3) {
                if (n == 2) {
                    return 5;
                }
                if (n == 3) {
                    return 4;
                }
                if (n == 4) {
                    return 2;
                }
                if (n == 5) {
                    return 3;
                }
            }
        }
        return n;
    }
    
    protected void a(final World world, final Block block, final int l, final int n, final int n2, final int n3, final StructureBoundingBox structureBoundingBox) {
        final int a = this.a(n, n3);
        final int a2 = this.a(n2);
        final int b = this.b(n, n3);
        if (!structureBoundingBox.b(a, a2, b)) {
            return;
        }
        world.setTypeAndData(a, a2, b, block, l, 2);
    }
    
    protected Block a(final World world, final int n, final int n2, final int n3, final StructureBoundingBox structureBoundingBox) {
        final int a = this.a(n, n3);
        final int a2 = this.a(n2);
        final int b = this.b(n, n3);
        if (!structureBoundingBox.b(a, a2, b)) {
            return Blocks.AIR;
        }
        return world.getType(a, a2, b);
    }
    
    protected void a(final World world, final StructureBoundingBox structureBoundingBox, final int n, final int n2, final int n3, final int n4, final int n5, final int n6) {
        for (int i = n2; i <= n5; ++i) {
            for (int j = n; j <= n4; ++j) {
                for (int k = n3; k <= n6; ++k) {
                    this.a(world, Blocks.AIR, 0, j, i, k, structureBoundingBox);
                }
            }
        }
    }
    
    protected void a(final World world, final StructureBoundingBox structureBoundingBox, final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final Block block, final Block block2, final boolean b) {
        for (int i = n2; i <= n5; ++i) {
            for (int j = n; j <= n4; ++j) {
                for (int k = n3; k <= n6; ++k) {
                    if (!b || this.a(world, j, i, k, structureBoundingBox).getMaterial() != Material.AIR) {
                        if (i == n2 || i == n5 || j == n || j == n4 || k == n3 || k == n6) {
                            this.a(world, block, 0, j, i, k, structureBoundingBox);
                        }
                        else {
                            this.a(world, block2, 0, j, i, k, structureBoundingBox);
                        }
                    }
                }
            }
        }
    }
    
    protected void a(final World world, final StructureBoundingBox structureBoundingBox, final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final Block block, final int n7, final Block block2, final int n8, final boolean b) {
        for (int i = n2; i <= n5; ++i) {
            for (int j = n; j <= n4; ++j) {
                for (int k = n3; k <= n6; ++k) {
                    if (!b || this.a(world, j, i, k, structureBoundingBox).getMaterial() != Material.AIR) {
                        if (i == n2 || i == n5 || j == n || j == n4 || k == n3 || k == n6) {
                            this.a(world, block, n7, j, i, k, structureBoundingBox);
                        }
                        else {
                            this.a(world, block2, n8, j, i, k, structureBoundingBox);
                        }
                    }
                }
            }
        }
    }
    
    protected void a(final World world, final StructureBoundingBox structureBoundingBox, final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final boolean b, final Random random, final StructurePieceBlockSelector structurePieceBlockSelector) {
        for (int i = n2; i <= n5; ++i) {
            for (int j = n; j <= n4; ++j) {
                for (int k = n3; k <= n6; ++k) {
                    if (!b || this.a(world, j, i, k, structureBoundingBox).getMaterial() != Material.AIR) {
                        structurePieceBlockSelector.a(random, j, i, k, i == n2 || i == n5 || j == n || j == n4 || k == n3 || k == n6);
                        this.a(world, structurePieceBlockSelector.a(), structurePieceBlockSelector.b(), j, i, k, structureBoundingBox);
                    }
                }
            }
        }
    }
    
    protected void a(final World world, final StructureBoundingBox structureBoundingBox, final Random random, final float n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7, final Block block, final Block block2, final boolean b) {
        for (int i = n3; i <= n6; ++i) {
            for (int j = n2; j <= n5; ++j) {
                for (int k = n4; k <= n7; ++k) {
                    if (random.nextFloat() <= n) {
                        if (!b || this.a(world, j, i, k, structureBoundingBox).getMaterial() != Material.AIR) {
                            if (i == n3 || i == n6 || j == n2 || j == n5 || k == n4 || k == n7) {
                                this.a(world, block, 0, j, i, k, structureBoundingBox);
                            }
                            else {
                                this.a(world, block2, 0, j, i, k, structureBoundingBox);
                            }
                        }
                    }
                }
            }
        }
    }
    
    protected void a(final World world, final StructureBoundingBox structureBoundingBox, final Random random, final float n, final int n2, final int n3, final int n4, final Block block, final int n5) {
        if (random.nextFloat() < n) {
            this.a(world, block, n5, n2, n3, n4, structureBoundingBox);
        }
    }
    
    protected void a(final World world, final StructureBoundingBox structureBoundingBox, final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final Block block, final boolean b) {
        final float n7 = n4 - n + 1;
        final float n8 = n5 - n2 + 1;
        final float n9 = n6 - n3 + 1;
        final float n10 = n + n7 / 2.0f;
        final float n11 = n3 + n9 / 2.0f;
        for (int i = n2; i <= n5; ++i) {
            final float n12 = (i - n2) / n8;
            for (int j = n; j <= n4; ++j) {
                final float n13 = (j - n10) / (n7 * 0.5f);
                for (int k = n3; k <= n6; ++k) {
                    final float n14 = (k - n11) / (n9 * 0.5f);
                    if (!b || this.a(world, j, i, k, structureBoundingBox).getMaterial() != Material.AIR) {
                        if (n13 * n13 + n12 * n12 + n14 * n14 <= 1.05f) {
                            this.a(world, block, 0, j, i, k, structureBoundingBox);
                        }
                    }
                }
            }
        }
    }
    
    protected void b(final World world, final int n, final int n2, final int n3, final StructureBoundingBox structureBoundingBox) {
        final int a = this.a(n, n3);
        int a2 = this.a(n2);
        final int b = this.b(n, n3);
        if (!structureBoundingBox.b(a, a2, b)) {
            return;
        }
        while (!world.isEmpty(a, a2, b) && a2 < 255) {
            world.setTypeAndData(a, a2, b, Blocks.AIR, 0, 2);
            ++a2;
        }
    }
    
    protected void b(final World world, final Block block, final int l, final int n, final int n2, final int n3, final StructureBoundingBox structureBoundingBox) {
        final int a = this.a(n, n3);
        int a2 = this.a(n2);
        final int b = this.b(n, n3);
        if (!structureBoundingBox.b(a, a2, b)) {
            return;
        }
        while ((world.isEmpty(a, a2, b) || world.getType(a, a2, b).getMaterial().isLiquid()) && a2 > 1) {
            world.setTypeAndData(a, a2, b, block, l, 2);
            --a2;
        }
    }
    
    protected boolean a(final World world, final StructureBoundingBox structureBoundingBox, final Random random, final int n, final int n2, final int n3, final StructurePieceTreasure[] array, final int n4) {
        final int a = this.a(n, n3);
        final int a2 = this.a(n2);
        final int b = this.b(n, n3);
        if (structureBoundingBox.b(a, a2, b) && world.getType(a, a2, b) != Blocks.CHEST) {
            world.setTypeAndData(a, a2, b, Blocks.CHEST, 0, 2);
            final TileEntityChest tileEntityChest = (TileEntityChest)world.getTileEntity(a, a2, b);
            if (tileEntityChest != null) {
                StructurePieceTreasure.a(random, array, tileEntityChest, n4);
            }
            return true;
        }
        return false;
    }
    
    protected boolean a(final World world, final StructureBoundingBox structureBoundingBox, final Random random, final int n, final int n2, final int n3, final int n4, final StructurePieceTreasure[] array, final int n5) {
        final int a = this.a(n, n3);
        final int a2 = this.a(n2);
        final int b = this.b(n, n3);
        if (structureBoundingBox.b(a, a2, b) && world.getType(a, a2, b) != Blocks.DISPENSER) {
            world.setTypeAndData(a, a2, b, Blocks.DISPENSER, this.a(Blocks.DISPENSER, n4), 2);
            final TileEntityDispenser tileEntityDispenser = (TileEntityDispenser)world.getTileEntity(a, a2, b);
            if (tileEntityDispenser != null) {
                StructurePieceTreasure.a(random, array, tileEntityDispenser, n5);
            }
            return true;
        }
        return false;
    }
    
    protected void a(final World world, final StructureBoundingBox structureBoundingBox, final Random random, final int n, final int n2, final int n3, final int l) {
        final int a = this.a(n, n3);
        final int a2 = this.a(n2);
        final int b = this.b(n, n3);
        if (structureBoundingBox.b(a, a2, b)) {
            ItemDoor.place(world, a, a2, b, l, Blocks.WOODEN_DOOR);
        }
    }
}
