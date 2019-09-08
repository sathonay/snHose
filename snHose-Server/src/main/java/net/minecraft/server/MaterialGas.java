package net.minecraft.server.v1_7_R4;

public class MaterialGas extends Material
{
    public MaterialGas(final MaterialMapColor materialMapColor) {
        super(materialMapColor);
        this.i();
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
