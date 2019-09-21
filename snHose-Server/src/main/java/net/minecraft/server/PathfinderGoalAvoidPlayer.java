package net.minecraft.server;

import java.util.*;

public class PathfinderGoalAvoidPlayer extends PathfinderGoal
{
    public final IEntitySelector a;
    private EntityCreature b;
    private double c;
    private double d;
    private Entity e;
    private float f;
    private PathEntity g;
    private Navigation h;
    private Class i;
    
    public PathfinderGoalAvoidPlayer(final EntityCreature b, final Class i, final float f, final double c, final double d) {
        this.a = new EntitySelectorViewable(this);
        this.b = b;
        this.i = i;
        this.f = f;
        this.c = c;
        this.d = d;
        this.h = b.getNavigation();
        this.a(1);
    }
    
    @Override
    public boolean a() {
        if (this.i == EntityHuman.class) {
            if (this.b instanceof EntityTameableAnimal && ((EntityTameableAnimal)this.b).isTamed()) {
                return false;
            }
            this.e = this.b.world.findNearbyPlayer(this.b, this.f);
            if (this.e == null) {
                return false;
            }
        }
        else {
            final List a = this.b.world.a(this.i, this.b.boundingBox.grow(this.f, 3.0, this.f), this.a);
            if (a.isEmpty()) {
                return false;
            }
            this.e = (Entity) a.get(0);
        }
        final Vec3D b = RandomPositionGenerator.b(this.b, 16, 7, Vec3D.a(this.e.locX, this.e.locY, this.e.locZ));
        if (b == null) {
            return false;
        }
        if (this.e.e(b.a, b.b, b.c) < this.e.f(this.b)) {
            return false;
        }
        this.g = this.h.a(b.a, b.b, b.c);
        return this.g != null && this.g.b(b);
    }
    
    @Override
    public boolean b() {
        return !this.h.g();
    }
    
    @Override
    public void c() {
        this.h.a(this.g, this.c);
    }
    
    @Override
    public void d() {
        this.e = null;
    }
    
    @Override
    public void e() {
        if (this.b.f(this.e) < 49.0) {
            this.b.getNavigation().a(this.d);
        }
        else {
            this.b.getNavigation().a(this.c);
        }
    }
}
