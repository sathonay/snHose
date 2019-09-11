package net.minecraft.server;

public class BlockWorkbench extends Block
{
    protected BlockWorkbench() {
        super(Material.WOOD);
        this.a(CreativeModeTab.c);
    }
    
    @Override
    public boolean interact(final World world, final int i, final int j, final int k, final EntityHuman entityHuman, final int n, final float n2, final float n3, final float n4) {
        if (world.isStatic) {
            return true;
        }
        entityHuman.startCrafting(i, j, k);
        return true;
    }
}
