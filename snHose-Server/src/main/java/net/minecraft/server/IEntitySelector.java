package net.minecraft.server;

public interface IEntitySelector
{
    public static final IEntitySelector a = new EntitySelectorLiving();
    public static final IEntitySelector b = new EntitySelectorChickenJockey();
    public static final IEntitySelector c = new EntitySelectorContainer();
    
    boolean a(final Entity p0);
}
