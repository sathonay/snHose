package net.minecraft.server;

import java.util.*;

public class PathfinderGoalTakeFlower extends PathfinderGoal
{
    private EntityVillager a;
    private EntityIronGolem b;
    private int c;
    private boolean d;
    
    public PathfinderGoalTakeFlower(final EntityVillager a) {
        this.a = a;
        this.a(3);
    }
    
    @Override
    public boolean a() {
        if (this.a.getAge() >= 0) {
            return false;
        }
        if (!this.a.world.w()) {
            return false;
        }
        final List a = this.a.world.a(EntityIronGolem.class, this.a.boundingBox.grow(6.0, 2.0, 6.0));
        if (a.isEmpty()) {
            return false;
        }
        for (final EntityIronGolem b : a) {
            if (b.cb() > 0) {
                this.b = b;
                break;
            }
        }
        return this.b != null;
    }
    
    @Override
    public boolean b() {
        return this.b.cb() > 0;
    }
    
    @Override
    public void c() {
        this.c = this.a.aI().nextInt(320);
        this.d = false;
        this.b.getNavigation().h();
    }
    
    @Override
    public void d() {
        this.b = null;
        this.a.getNavigation().h();
    }
    
    @Override
    public void e() {
        this.a.getControllerLook().a(this.b, 30.0f, 30.0f);
        if (this.b.cb() == this.c) {
            this.a.getNavigation().a(this.b, 0.5);
            this.d = true;
        }
        if (this.d && this.a.f(this.b) < 4.0) {
            this.b.a(false);
            this.a.getNavigation().h();
        }
    }
}
