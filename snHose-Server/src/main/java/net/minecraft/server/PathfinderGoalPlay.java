package net.minecraft.server.v1_7_R4;

import java.util.*;

public class PathfinderGoalPlay extends PathfinderGoal
{
    private EntityVillager a;
    private EntityLiving b;
    private double c;
    private int d;
    
    public PathfinderGoalPlay(final EntityVillager a, final double c) {
        this.a = a;
        this.c = c;
        this.a(1);
    }
    
    @Override
    public boolean a() {
        if (this.a.getAge() >= 0) {
            return false;
        }
        if (this.a.aI().nextInt(400) != 0) {
            return false;
        }
        final List a = this.a.world.a(EntityVillager.class, this.a.boundingBox.grow(6.0, 3.0, 6.0));
        double n = Double.MAX_VALUE;
        for (final EntityVillager b : a) {
            if (b == this.a) {
                continue;
            }
            if (b.cb()) {
                continue;
            }
            if (b.getAge() >= 0) {
                continue;
            }
            final double f = b.f(this.a);
            if (f > n) {
                continue;
            }
            n = f;
            this.b = b;
        }
        return this.b != null || RandomPositionGenerator.a(this.a, 16, 3) != null;
    }
    
    @Override
    public boolean b() {
        return this.d > 0;
    }
    
    @Override
    public void c() {
        if (this.b != null) {
            this.a.j(true);
        }
        this.d = 1000;
    }
    
    @Override
    public void d() {
        this.a.j(false);
        this.b = null;
    }
    
    @Override
    public void e() {
        --this.d;
        if (this.b != null) {
            if (this.a.f(this.b) > 4.0) {
                this.a.getNavigation().a(this.b, this.c);
            }
        }
        else if (this.a.getNavigation().g()) {
            final Vec3D a = RandomPositionGenerator.a(this.a, 16, 3);
            if (a == null) {
                return;
            }
            this.a.getNavigation().a(a.a, a.b, a.c, this.c);
        }
    }
}
