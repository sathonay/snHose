package net.minecraft.server;

import java.util.*;

class WorldGenStrongholdStones extends StructurePieceBlockSelector
{
    @Override
    public void a(final Random random, final int n, final int n2, final int n3, final boolean b) {
        if (b) {
            this.a = Blocks.SMOOTH_BRICK;
            final float nextFloat = random.nextFloat();
            if (nextFloat < 0.2f) {
                this.b = 2;
            }
            else if (nextFloat < 0.5f) {
                this.b = 1;
            }
            else if (nextFloat < 0.55f) {
                this.a = Blocks.MONSTER_EGGS;
                this.b = 2;
            }
            else {
                this.b = 0;
            }
        }
        else {
            this.a = Blocks.AIR;
            this.b = 0;
        }
    }
}
