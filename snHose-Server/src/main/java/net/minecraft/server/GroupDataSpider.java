package net.minecraft.server;

import java.util.*;

public class GroupDataSpider implements GroupDataEntity
{
    public int a;
    
    public void a(final Random random) {
        final int nextInt = random.nextInt(5);
        if (nextInt <= 1) {
            this.a = MobEffectList.FASTER_MOVEMENT.id;
        }
        else if (nextInt <= 2) {
            this.a = MobEffectList.INCREASE_DAMAGE.id;
        }
        else if (nextInt <= 3) {
            this.a = MobEffectList.REGENERATION.id;
        }
        else if (nextInt <= 4) {
            this.a = MobEffectList.INVISIBILITY.id;
        }
    }
}
