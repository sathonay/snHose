package net.minecraft.server.v1_7_R4;

public class MaterialPortal extends Material
{
    public MaterialPortal(final MaterialMapColor materialMapColor) {
        super(materialMapColor);
    }
    
    @Override
    public boolean isBuildable() {
        return false;
    }
    
    @Override
    public boolean blocksLight() {
        return false;
    }
    
    @Override
    public boolean isSolid() {
        return false;
    }
}
