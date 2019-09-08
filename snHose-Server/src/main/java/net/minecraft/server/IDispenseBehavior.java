package net.minecraft.server.v1_7_R4;

public interface IDispenseBehavior
{
    public static final IDispenseBehavior a = new DispenseBehaviorNoop();
    
    ItemStack a(final ISourceBlock p0, final ItemStack p1);
}
