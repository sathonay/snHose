package net.minecraft.server.v1_7_R4;

import java.util.*;

public class WorldGenHellLava extends WorldGenerator
{
    private Block a;
    private boolean b;
    
    public WorldGenHellLava(final Block a, final boolean b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public boolean generate(final World world, final Random random, final int i, final int n, final int k) {
        if (world.getType(i, n + 1, k) != Blocks.NETHERRACK) {
            return false;
        }
        if (world.getType(i, n, k).getMaterial() != Material.AIR && world.getType(i, n, k) != Blocks.NETHERRACK) {
            return false;
        }
        int n2 = 0;
        if (world.getType(i - 1, n, k) == Blocks.NETHERRACK) {
            ++n2;
        }
        if (world.getType(i + 1, n, k) == Blocks.NETHERRACK) {
            ++n2;
        }
        if (world.getType(i, n, k - 1) == Blocks.NETHERRACK) {
            ++n2;
        }
        if (world.getType(i, n, k + 1) == Blocks.NETHERRACK) {
            ++n2;
        }
        if (world.getType(i, n - 1, k) == Blocks.NETHERRACK) {
            ++n2;
        }
        int n3 = 0;
        if (world.isEmpty(i - 1, n, k)) {
            ++n3;
        }
        if (world.isEmpty(i + 1, n, k)) {
            ++n3;
        }
        if (world.isEmpty(i, n, k - 1)) {
            ++n3;
        }
        if (world.isEmpty(i, n, k + 1)) {
            ++n3;
        }
        if (world.isEmpty(i, n - 1, k)) {
            ++n3;
        }
        if ((!this.b && n2 == 4 && n3 == 1) || n2 == 5) {
            world.setTypeAndData(i, n, k, this.a, 0, 2);
            world.d = true;
            this.a.a(world, i, n, k, random);
            world.d = false;
        }
        return true;
    }
}
