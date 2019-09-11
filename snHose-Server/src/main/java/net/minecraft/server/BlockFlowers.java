package net.minecraft.server;

public class BlockFlowers extends BlockPlant
{
    private static final String[][] M;
    public static final String[] a;
    public static final String[] b;
    private int O;
    
    protected BlockFlowers(final int o) {
        super(Material.PLANT);
        this.O = o;
    }
    
    @Override
    public int getDropData(final int n) {
        return n;
    }
    
    public static BlockFlowers e(final String s) {
        final String[] b = BlockFlowers.b;
        for (int length = b.length, i = 0; i < length; ++i) {
            if (b[i].equals(s)) {
                return Blocks.YELLOW_FLOWER;
            }
        }
        final String[] a = BlockFlowers.a;
        for (int length2 = a.length, j = 0; j < length2; ++j) {
            if (a[j].equals(s)) {
                return Blocks.RED_ROSE;
            }
        }
        return null;
    }
    
    public static int f(final String s) {
        for (int i = 0; i < BlockFlowers.b.length; ++i) {
            if (BlockFlowers.b[i].equals(s)) {
                return i;
            }
        }
        for (int j = 0; j < BlockFlowers.a.length; ++j) {
            if (BlockFlowers.a[j].equals(s)) {
                return j;
            }
        }
        return 0;
    }
    
    static {
        M = new String[][] { { "flower_dandelion" }, { "flower_rose", "flower_blue_orchid", "flower_allium", "flower_houstonia", "flower_tulip_red", "flower_tulip_orange", "flower_tulip_white", "flower_tulip_pink", "flower_oxeye_daisy" } };
        a = new String[] { "poppy", "blueOrchid", "allium", "houstonia", "tulipRed", "tulipOrange", "tulipWhite", "tulipPink", "oxeyeDaisy" };
        b = new String[] { "dandelion" };
    }
}
