package net.minecraft.server.v1_7_R4;

public class MaterialLiquid extends Material
{
    public MaterialLiquid(final MaterialMapColor materialMapColor) {
        super(materialMapColor);
        this.i();
        this.n();
    }
    
    @Override
    public boolean isLiquid() {
        return true;
    }
    
    @Override
    public boolean isSolid() {
        return false;
    }
    
    @Override
    public boolean isBuildable() {
        return false;
    }
}
