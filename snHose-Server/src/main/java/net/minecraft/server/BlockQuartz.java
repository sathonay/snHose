package net.minecraft.server;

public class BlockQuartz extends Block
{
    public static final String[] a;
    private static final String[] b;
    
    public BlockQuartz() {
        super(Material.STONE);
        this.a(CreativeModeTab.b);
    }
    
    @Override
    public int getPlacedData(final World world, final int n, final int n2, final int n3, final int n4, final float n5, final float n6, final float n7, int n8) {
        if (n8 == 2) {
            switch (n4) {
                case 2:
                case 3: {
                    n8 = 4;
                    break;
                }
                case 4:
                case 5: {
                    n8 = 3;
                    break;
                }
                case 0:
                case 1: {
                    n8 = 2;
                    break;
                }
            }
        }
        return n8;
    }
    
    @Override
    public int getDropData(final int n) {
        if (n == 3 || n == 4) {
            return 2;
        }
        return n;
    }
    
    @Override
    protected ItemStack j(final int i) {
        if (i == 3 || i == 4) {
            return new ItemStack(Item.getItemOf(this), 1, 2);
        }
        return super.j(i);
    }
    
    @Override
    public int b() {
        return 39;
    }
    
    @Override
    public MaterialMapColor f(final int n) {
        return MaterialMapColor.p;
    }
    
    static {
        a = new String[] { "default", "chiseled", "lines" };
        b = new String[] { "side", "chiseled", "lines", null, null };
    }
}
