package net.minecraft.server.v1_7_R4;

public interface IMerchant
{
    void a_(final EntityHuman p0);
    
    EntityHuman b();
    
    MerchantRecipeList getOffers(final EntityHuman p0);
    
    void a(final MerchantRecipe p0);
    
    void a_(final ItemStack p0);
}
