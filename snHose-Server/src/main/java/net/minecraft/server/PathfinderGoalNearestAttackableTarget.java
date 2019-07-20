package net.minecraft.server;

import java.lang.ref.WeakReference; // Spigot
import java.util.Collections;
import java.util.List;

public class PathfinderGoalNearestAttackableTarget extends PathfinderGoalTarget {

    private final Class a;
    private final int b;
    private final DistanceComparator e;
    private final IEntitySelector f;
    private WeakReference<EntityLiving> g = new WeakReference<EntityLiving>(null); // Spigot

    public PathfinderGoalNearestAttackableTarget(EntityCreature entitycreature, Class oclass, int i, boolean flag) {
        this(entitycreature, oclass, i, flag, false);
    }

    public PathfinderGoalNearestAttackableTarget(EntityCreature entitycreature, Class oclass, int i, boolean flag, boolean flag1) {
        this(entitycreature, oclass, i, flag, flag1, (IEntitySelector) null);
    }

    public PathfinderGoalNearestAttackableTarget(EntityCreature entitycreature, Class oclass, int i, boolean flag, boolean flag1, IEntitySelector ientityselector) {
        super(entitycreature, flag, flag1);
        this.a = oclass;
        this.b = i;
        this.e = new DistanceComparator(entitycreature);
        this.a(1);
        this.f = new EntitySelectorNearestAttackableTarget(this, ientityselector);
    }

    public boolean a() {
        if (this.b > 0 && this.c.aI().nextInt(this.b) != 0) {
            return false;
        } else {
            double d0 = this.f();
            List list = this.c.world.a(this.a, this.c.boundingBox.grow(d0, 4.0D, d0), this.f);

            Collections.sort(list, this.e);
            if (list.isEmpty()) {
                return false;
            } else {
                this.g = new WeakReference<EntityLiving>((EntityLiving) list.get(0)); // Spigot
                return true;
            }
        }
    }

    public void c() {
        this.c.setGoalTarget(this.g.get()); // Spigot
        super.c();
    }
}
