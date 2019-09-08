package net.minecraft.server.v1_7_R4;

import java.util.*;

public class WorldGenBonusChest extends WorldGenerator
{
    private final StructurePieceTreasure[] a;
    private final int b;
    
    public WorldGenBonusChest(final StructurePieceTreasure[] a, final int b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public boolean generate(final World iblockaccess, final Random random, final int i, int j, final int k) {
        Block type;
        while (((type = iblockaccess.getType(i, j, k)).getMaterial() == Material.AIR || type.getMaterial() == Material.LEAVES) && j > 1) {
            --j;
        }
        if (j < 1) {
            return false;
        }
        ++j;
        for (int l = 0; l < 4; ++l) {
            final int n = i + random.nextInt(4) - random.nextInt(4);
            final int m = j + random.nextInt(3) - random.nextInt(3);
            final int n2 = k + random.nextInt(4) - random.nextInt(4);
            if (iblockaccess.isEmpty(n, m, n2) && World.a(iblockaccess, n, m - 1, n2)) {
                iblockaccess.setTypeAndData(n, m, n2, Blocks.CHEST, 0, 2);
                final TileEntityChest tileEntityChest = (TileEntityChest)iblockaccess.getTileEntity(n, m, n2);
                if (tileEntityChest != null && tileEntityChest != null) {
                    StructurePieceTreasure.a(random, this.a, tileEntityChest, this.b);
                }
                if (iblockaccess.isEmpty(n - 1, m, n2) && World.a(iblockaccess, n - 1, m - 1, n2)) {
                    iblockaccess.setTypeAndData(n - 1, m, n2, Blocks.TORCH, 0, 2);
                }
                if (iblockaccess.isEmpty(n + 1, m, n2) && World.a(iblockaccess, n - 1, m - 1, n2)) {
                    iblockaccess.setTypeAndData(n + 1, m, n2, Blocks.TORCH, 0, 2);
                }
                if (iblockaccess.isEmpty(n, m, n2 - 1) && World.a(iblockaccess, n - 1, m - 1, n2)) {
                    iblockaccess.setTypeAndData(n, m, n2 - 1, Blocks.TORCH, 0, 2);
                }
                if (iblockaccess.isEmpty(n, m, n2 + 1) && World.a(iblockaccess, n - 1, m - 1, n2)) {
                    iblockaccess.setTypeAndData(n, m, n2 + 1, Blocks.TORCH, 0, 2);
                }
                return true;
            }
        }
        return false;
    }
}
