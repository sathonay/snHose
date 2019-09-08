package net.minecraft.server.v1_7_R4;

public enum EnumItemRarity
{
    COMMON("common", 0, EnumChatFormat.WHITE, "Common"), 
    UNCOMMON("uncommon", 1, EnumChatFormat.YELLOW, "Uncommon"), 
    RARE("rare", 2, EnumChatFormat.AQUA, "Rare"), 
    EPIC("epic", 3, EnumChatFormat.LIGHT_PURPLE, "Epic");
    
    public final EnumChatFormat e;
    public final String f;
    
    private EnumItemRarity(final String s, final int n, final EnumChatFormat e, final String f) {
        this.e = e;
        this.f = f;
    }
}
