package net.minecraft.server.v1_7_R4;

public enum EnumGamemode
{
    NONE("NOT_SET", 0, -1, ""), 
    SURVIVAL("SURVIVAL", 1, 0, "survival"), 
    CREATIVE("CREATIVE", 2, 1, "creative"), 
    ADVENTURE("ADVENTURE", 3, 2, "adventure");
    
    int e;
    String f;
    
    private EnumGamemode(final String s, final int n, final int e, final String f) {
        this.e = e;
        this.f = f;
    }
    
    public int getId() {
        return this.e;
    }
    
    public String b() {
        return this.f;
    }
    
    public void a(final PlayerAbilities playerAbilities) {
        if (this == EnumGamemode.CREATIVE) {
            playerAbilities.canFly = true;
            playerAbilities.canInstantlyBuild = true;
            playerAbilities.isInvulnerable = true;
        }
        else {
            playerAbilities.canFly = false;
            playerAbilities.canInstantlyBuild = false;
            playerAbilities.isInvulnerable = false;
            playerAbilities.isFlying = false;
        }
        playerAbilities.mayBuild = !this.isAdventure();
    }
    
    public boolean isAdventure() {
        return this == EnumGamemode.ADVENTURE;
    }
    
    public boolean d() {
        return this == EnumGamemode.CREATIVE;
    }
    
    public static EnumGamemode getById(final int n) {
        for (final EnumGamemode enumGamemode : values()) {
            if (enumGamemode.e == n) {
                return enumGamemode;
            }
        }
        return EnumGamemode.SURVIVAL;
    }
}
