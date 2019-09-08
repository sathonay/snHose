package net.minecraft.server.v1_7_R4;

import java.util.*;

public class EntitySenses
{
    EntityInsentient entity;
    List seenEntities;
    List unseenEntities;
    
    public EntitySenses(final EntityInsentient entity) {
        this.seenEntities = new ArrayList();
        this.unseenEntities = new ArrayList();
        this.entity = entity;
    }
    
    public void a() {
        this.seenEntities.clear();
        this.unseenEntities.clear();
    }
    
    public boolean canSee(final Entity entity) {
        if (this.seenEntities.contains(entity)) {
            return true;
        }
        if (this.unseenEntities.contains(entity)) {
            return false;
        }
        this.entity.world.methodProfiler.a("canSee");
        final boolean hasLineOfSight = this.entity.hasLineOfSight(entity);
        this.entity.world.methodProfiler.b();
        if (hasLineOfSight) {
            this.seenEntities.add(entity);
        }
        else {
            this.unseenEntities.add(entity);
        }
        return hasLineOfSight;
    }
}
