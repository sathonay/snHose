package net.minecraft.server.v1_7_R4;

final class WorldGenStrongholdUnknown extends WorldGenStrongholdPieceWeight
{
    WorldGenStrongholdUnknown(final Class clazz, final int n, final int n2) {
        super(clazz, n, n2);
    }
    
    @Override
    public boolean a(final int n) {
        return super.a(n) && n > 4;
    }
}
