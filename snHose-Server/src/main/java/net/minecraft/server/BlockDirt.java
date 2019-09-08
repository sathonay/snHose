package net.minecraft.server.v1_7_R4;

public class BlockDirt extends Block
{
    public static final String[] a;
    
    protected BlockDirt() {
        super(Material.EARTH);
        this.a(CreativeModeTab.b);
    }
    
    @Override
    public int getDropData(final int n) {
        return 0;
    }
    
    @Override
    protected ItemStack j(int i) {
        if (i == 1) {
            i = 0;
        }
        return super.j(i);
    }
    
    @Override
    public int getDropData(final World world, final int i, final int j, final int k) {
        int data = world.getData(i, j, k);
        if (data == 1) {
            data = 0;
        }
        return data;
    }
    
    static {
        a = new String[] { "default", "default", "podzol" };
    }
}
