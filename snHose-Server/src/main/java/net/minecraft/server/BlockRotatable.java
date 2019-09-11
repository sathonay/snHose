package net.minecraft.server;

public abstract class BlockRotatable extends Block
{
    protected BlockRotatable(final Material material) {
        super(material);
    }
    
    @Override
    public int b() {
        return 31;
    }
    
    @Override
    public int getPlacedData(final World world, final int n, final int n2, final int n3, final int n4, final float n5, final float n6, final float n7, final int n8) {
        final int n9 = n8 & 0x3;
        int n10 = 0;
        switch (n4) {
            case 2:
            case 3: {
                n10 = 8;
                break;
            }
            case 4:
            case 5: {
                n10 = 4;
                break;
            }
            case 0:
            case 1: {
                n10 = 0;
                break;
            }
        }
        return n9 | n10;
    }
    
    @Override
    public int getDropData(final int n) {
        return n & 0x3;
    }
    
    public int k(final int n) {
        return n & 0x3;
    }
    
    @Override
    protected ItemStack j(final int n) {
        return new ItemStack(Item.getItemOf(this), 1, this.k(n));
    }
}
