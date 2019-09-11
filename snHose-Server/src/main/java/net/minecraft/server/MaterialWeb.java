package net.minecraft.server;

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
