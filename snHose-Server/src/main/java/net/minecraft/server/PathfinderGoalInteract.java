package net.minecraft.server;

public class PathfinderGoalInteract extends PathfinderGoalLookAtPlayer
{
    public PathfinderGoalInteract(final EntityInsentient entityInsentient, final Class clazz, final float n, final float n2) {
        super(entityInsentient, clazz, n, n2);
        this.a(3);
    }
}
