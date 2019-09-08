package net.minecraft.server.v1_7_R4;

import java.util.*;

public class WorldGenLiquids extends WorldGenerator
{
    private Block a;
    
    public WorldGenLiquids(final Block a) {
        this.a = a;
    }
    
    @Override
    public boolean generate(final World world, final Random random, final int n, final int n2, final int n3) {
        if (world.getType(n, n2 + 1, n3) != Blocks.STONE) {
            return false;
        }
        if (world.getType(n, n2 - 1, n3) != Blocks.STONE) {
            return false;
        }
        if (world.getType(n, n2, n3).getMaterial() != Material.AIR && world.getType(n, n2, n3) != Blocks.STONE) {
            return false;
        }
        int n4 = 0;
        if (world.getType(n - 1, n2, n3) == Blocks.STONE) {
            ++n4;
        }
        if (world.getType(n + 1, n2, n3) == Blocks.STONE) {
            ++n4;
        }
        if (world.getType(n, n2, n3 - 1) == Blocks.STONE) {
            ++n4;
        }
        if (world.getType(n, n2, n3 + 1) == Blocks.STONE) {
            ++n4;
        }
        int n5 = 0;
        if (world.isEmpty(n - 1, n2, n3)) {
            ++n5;
        }
        if (world.isEmpty(n + 1, n2, n3)) {
            ++n5;
        }
        if (world.isEmpty(n, n2, n3 - 1)) {
            ++n5;
        }
        if (world.isEmpty(n, n2, n3 + 1)) {
            ++n5;
        }
        if (n4 == 3 && n5 == 1) {
            world.setTypeAndData(n, n2, n3, this.a, 0, 2);
            world.d = true;
            this.a.a(world, n, n2, n3, random);
            world.d = false;
        }
        return true;
    }
}
