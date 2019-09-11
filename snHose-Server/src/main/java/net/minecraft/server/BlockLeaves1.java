package net.minecraft.server;

public class BlockLeaves1 extends BlockLeaves
{
    public static final String[][] N;
    public static final String[] O;
    
    @Override
    protected void c(final World world, final int i, final int j, final int k, final int n, final int n2) {
        if ((n & 0x3) == 0x0 && world.random.nextInt(n2) == 0) {
            this.a(world, i, j, k, new ItemStack(Items.APPLE, 1, 0));
        }
    }
    
    @Override
    protected int b(final int i) {
        int b = super.b(i);
        if ((i & 0x3) == 0x3) {
            b = 40;
        }
        return b;
    }
    
    @Override
    public String[] e() {
        return BlockLeaves1.O;
    }
    
    static {
        N = new String[][] { { "leaves_oak", "leaves_spruce", "leaves_birch", "leaves_jungle" }, { "leaves_oak_opaque", "leaves_spruce_opaque", "leaves_birch_opaque", "leaves_jungle_opaque" } };
        O = new String[] { "oak", "spruce", "birch", "jungle" };
    }
}
