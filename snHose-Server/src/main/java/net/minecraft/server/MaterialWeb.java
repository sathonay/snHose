package net.minecraft.server.v1_7_R4;

final class MaterialWeb extends Material
{
    MaterialWeb(final MaterialMapColor materialMapColor) {
        super(materialMapColor);
    }
    
    @Override
    public boolean isSolid() {
        return false;
    }
}
