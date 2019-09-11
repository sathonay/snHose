package net.minecraft.server;

public class BlockLeaves2 extends BlockLeaves
{
    public static final String[][] N;
    public static final String[] O;
    
    @Override
    protected void c(final World world, final int i, final int j, final int k, final int n, final int n2) {
        if ((n & 0x3) == 0x1 && world.random.nextInt(n2) == 0) {
            this.a(world, i, j, k, new ItemStack(Items.APPLE, 1, 0));
        }
    }
    
    @Override
    public int getDropData(final int i) {
        return super.getDropData(i) + 4;
    }
    
    @Override
    public int getDropData(final World world, final int i, final int j, final int k) {
        return world.getData(i, j, k) & 0x3;
    }
    
    @Override
    public String[] e() {
        return BlockLeaves2.O;
    }
    
    static {
        N = new String[][] { { "leaves_acacia", "leaves_big_oak" }, { "leaves_acacia_opaque", "leaves_big_oak_opaque" } };
        O = new String[] { "acacia", "big_oak" };
    }
}
