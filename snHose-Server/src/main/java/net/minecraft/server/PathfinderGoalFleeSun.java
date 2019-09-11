package net.minecraft.server;

import java.util.*;

public class PathfinderGoalFleeSun extends PathfinderGoal
{
    private EntityCreature a;
    private double b;
    private double c;
    private double d;
    private double e;
    private World f;
    
    public PathfinderGoalFleeSun(final EntityCreature a, final double e) {
        this.a = a;
        this.e = e;
        this.f = a.world;
        this.a(1);
    }
    
    @Override
    public boolean a() {
        if (!this.f.w()) {
            return false;
        }
        if (!this.a.isBurning()) {
            return false;
        }
        if (!this.f.i(MathHelper.floor(this.a.locX), (int)this.a.boundingBox.b, MathHelper.floor(this.a.locZ))) {
            return false;
        }
        final Vec3D f = this.f();
        if (f == null) {
            return false;
        }
        this.b = f.a;
        this.c = f.b;
        this.d = f.c;
        return true;
    }
    
    @Override
    public boolean b() {
        return !this.a.getNavigation().g();
    }
    
    @Override
    public void c() {
        this.a.getNavigation().a(this.b, this.c, this.d, this.e);
    }
    
    private Vec3D f() {
        final Random ai = this.a.aI();
        for (int i = 0; i < 10; ++i) {
            final int floor = MathHelper.floor(this.a.locX + ai.nextInt(20) - 10.0);
            final int floor2 = MathHelper.floor(this.a.boundingBox.b + ai.nextInt(6) - 3.0);
            final int floor3 = MathHelper.floor(this.a.locZ + ai.nextInt(20) - 10.0);
            if (!this.f.i(floor, floor2, floor3) && this.a.a(floor, floor2, floor3) < 0.0f) {
                return Vec3D.a(floor, floor2, floor3);
            }
        }
        return null;
    }
}
