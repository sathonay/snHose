package net.minecraft.server;

import java.util.*;

public class DistanceComparator implements Comparator<Entity>
{
    private final Entity a;
    
    public DistanceComparator(final Entity a) {
        this.a = a;
    }
    
    public int a(final Entity entity, final Entity entity2) {
        final double f = this.a.f(entity);
        final double f2 = this.a.f(entity2);
        if (f < f2) {
            return -1;
        }
        if (f > f2) {
            return 1;
        }
        return 0;
    }


    @Override
    public int compare(Entity o1, Entity o2) {
        return this.a(o1, o2);
    }
}
