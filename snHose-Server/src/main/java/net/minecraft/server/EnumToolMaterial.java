package net.minecraft.server;

public enum EnumToolMaterial
{
    WOOD("WOOD", 0, 0, 59, 2.0f, 0.0f, 15), 
    STONE("STONE", 1, 1, 131, 4.0f, 1.0f, 5), 
    IRON("IRON", 2, 2, 250, 6.0f, 2.0f, 14), 
    DIAMOND("EMERALD", 3, 3, 1561, 8.0f, 3.0f, 10), 
    GOLD("GOLD", 4, 0, 32, 12.0f, 0.0f, 22);
    
    private final int f;
    private final int g;
    private final float h;
    private final float i;
    private final int j;
    
    private EnumToolMaterial(final String s, final int n, final int f, final int g, final float h, final float i, final int j) {
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
        this.j = j;
    }
    
    public int a() {
        return this.g;
    }
    
    public float b() {
        return this.h;
    }
    
    public float c() {
        return this.i;
    }
    
    public int d() {
        return this.f;
    }
    
    public int e() {
        return this.j;
    }
    
    public Item f() {
        if (this == EnumToolMaterial.WOOD) {
            return Item.getItemOf(Blocks.WOOD);
        }
        if (this == EnumToolMaterial.STONE) {
            return Item.getItemOf(Blocks.COBBLESTONE);
        }
        if (this == EnumToolMaterial.GOLD) {
            return Items.GOLD_INGOT;
        }
        if (this == EnumToolMaterial.IRON) {
            return Items.IRON_INGOT;
        }
        if (this == EnumToolMaterial.DIAMOND) {
            return Items.DIAMOND;
        }
        return null;
    }
}
