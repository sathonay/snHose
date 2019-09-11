package net.minecraft.server;

import java.util.*;

public class PathfinderGoalFollowParent extends PathfinderGoal
{
    EntityAnimal a;
    EntityAnimal b;
    double c;
    private int d;
    
    public PathfinderGoalFollowParent(final EntityAnimal a, final double c) {
        this.a = a;
        this.c = c;
    }
    
    @Override
    public boolean a() {
        if (this.a.getAge() >= 0) {
            return false;
        }
        final List a = this.a.world.a(this.a.getClass(), this.a.boundingBox.grow(8.0, 4.0, 8.0));
        EntityAnimal b = null;
        double n = Double.MAX_VALUE;
        for (final EntityAnimal entity : a) {
            if (entity.getAge() < 0) {
                continue;
            }
            final double f = this.a.f(entity);
            if (f > n) {
                continue;
            }
            n = f;
            b = entity;
        }
        if (b == null) {
            return false;
        }
        if (n < 9.0) {
            return false;
        }
        this.b = b;
        return true;
    }
    
    @Override
    public boolean b() {
        if (!this.b.isAlive()) {
            return false;
        }
        final double f = this.a.f(this.b);
        return f >= 9.0 && f <= 256.0;
    }
    
    @Override
    public void c() {
        this.d = 0;
    }
    
    @Override
    public void d() {
        this.b = null;
    }
    
    @Override
    public void e() {
        final int d = this.d - 1;
        this.d = d;
        if (d > 0) {
            return;
        }
        this.d = 10;
        this.a.getNavigation().a(this.b, this.c);
    }
}
