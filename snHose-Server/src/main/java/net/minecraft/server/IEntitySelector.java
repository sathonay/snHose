package net.minecraft.server.v1_7_R4;

public interface IEntitySelector
{
    public static final IEntitySelector a = new EntitySelectorLiving();
    public static final IEntitySelector b = new EntitySelectorChickenJockey();
    public static final IEntitySelector c = new EntitySelectorContainer();
    
    boolean a(final Entity p0);
}
