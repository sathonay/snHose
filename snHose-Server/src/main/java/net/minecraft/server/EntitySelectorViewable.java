package net.minecraft.server.v1_7_R4;

import java.util.*;

class EntitySelectorViewable implements IEntitySelector
{
    final /* synthetic */ PathfinderGoalAvoidPlayer d;
    
    EntitySelectorViewable(final PathfinderGoalAvoidPlayer d) {
        this.d = d;
    }
    
    @Override
    public boolean a(final Entity entity) {
        return entity.isAlive() && this.d.b.getEntitySenses().canSee(entity);
    }
}
