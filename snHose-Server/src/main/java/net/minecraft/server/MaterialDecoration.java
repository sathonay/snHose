package net.minecraft.server;

public class MaterialDecoration extends Material
{
    public MaterialDecoration(final MaterialMapColor materialMapColor) {
        super(materialMapColor);
        this.p();
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
