package net.minecraft.server.v1_7_R4;

public enum EnumCreatureType
{
    MONSTER("monster", 0, (Class)IMonster.class, 70, Material.AIR, false, false), 
    CREATURE("creature", 1, (Class)EntityAnimal.class, 10, Material.AIR, true, true), 
    AMBIENT("ambient", 2, (Class)EntityAmbient.class, 15, Material.AIR, true, false), 
    WATER_CREATURE("waterCreature", 3, (Class)EntityWaterAnimal.class, 5, Material.WATER, true, false);
    
    private final Class e;
    private final int f;
    private final Material g;
    private final boolean h;
    private final boolean i;
    
    private EnumCreatureType(final String s, final int n, final Class e, final int f, final Material g, final boolean h, final boolean i) {
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
    }
    
    public Class a() {
        return this.e;
    }
    
    public int b() {
        return this.f;
    }
    
    public Material c() {
        return this.g;
    }
    
    public boolean d() {
        return this.h;
    }
    
    public boolean e() {
        return this.i;
    }
}
