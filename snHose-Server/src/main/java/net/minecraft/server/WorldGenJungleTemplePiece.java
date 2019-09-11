package net.minecraft.server;

import java.util.*;

class WorldGenJungleTemplePiece extends StructurePieceBlockSelector
{
    @Override
    public void a(final Random random, final int n, final int n2, final int n3, final boolean b) {
        if (random.nextFloat() < 0.4f) {
            this.a = Blocks.COBBLESTONE;
        }
        else {
            this.a = Blocks.MOSSY_COBBLESTONE;
        }
    }
}
