package net.minecraft.server.v1_7_R4;

public class DispenserRegistry
{
    private static boolean a;
    
    static void a() {
        BlockDispenser.a.a(Items.ARROW, new DispenseBehaviorArrow());
        BlockDispenser.a.a(Items.EGG, new DispenseBehaviorEgg());
        BlockDispenser.a.a(Items.SNOW_BALL, new DispenseBehaviorSnowBall());
        BlockDispenser.a.a(Items.EXP_BOTTLE, new DispenseBehaviorExpBottle());
        BlockDispenser.a.a(Items.POTION, new DispenseBehaviorPotion());
        BlockDispenser.a.a(Items.MONSTER_EGG, new DispenseBehaviorMonsterEgg());
        BlockDispenser.a.a(Items.FIREWORKS, new DispenseBehaviorFireworks());
        BlockDispenser.a.a(Items.FIREBALL, new DispenseBehaviorFireball());
        BlockDispenser.a.a(Items.BOAT, new DispenseBehaviorBoat());
        final DispenseBehaviorFilledBucket dispenseBehaviorFilledBucket = new DispenseBehaviorFilledBucket();
        BlockDispenser.a.a(Items.LAVA_BUCKET, dispenseBehaviorFilledBucket);
        BlockDispenser.a.a(Items.WATER_BUCKET, dispenseBehaviorFilledBucket);
        BlockDispenser.a.a(Items.BUCKET, new DispenseBehaviorEmptyBucket());
        BlockDispenser.a.a(Items.FLINT_AND_STEEL, new DispenseBehaviorFlintAndSteel());
        BlockDispenser.a.a(Items.INK_SACK, new DispenseBehaviorBonemeal());
        BlockDispenser.a.a(Item.getItemOf(Blocks.TNT), new DispenseBehaviorTNT());
    }
    
    public static void b() {
        if (DispenserRegistry.a) {
            return;
        }
        DispenserRegistry.a = true;
        Block.p();
        BlockFire.e();
        Item.l();
        StatisticList.a();
        a();
    }
    
    static {
        DispenserRegistry.a = false;
    }
}
