package net.minecraft.server;

public interface IDispenseBehavior
{
    public static final IDispenseBehavior a = new DispenseBehaviorNoop();
    
    ItemStack a(final ISourceBlock p0, final ItemStack p1);
}
