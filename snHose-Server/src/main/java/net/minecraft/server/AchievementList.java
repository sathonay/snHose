package net.minecraft.server.v1_7_R4;

import java.util.*;

public class AchievementList
{
    public static int a;
    public static int b;
    public static int c;
    public static int d;
    public static List e;
    public static Achievement f;
    public static Achievement g;
    public static Achievement h;
    public static Achievement i;
    public static Achievement j;
    public static Achievement k;
    public static Achievement l;
    public static Achievement m;
    public static Achievement n;
    public static Achievement o;
    public static Achievement p;
    public static Achievement q;
    public static Achievement r;
    public static Achievement s;
    public static Achievement t;
    public static Achievement u;
    public static Achievement v;
    public static Achievement w;
    public static Achievement x;
    public static Achievement y;
    public static Achievement z;
    public static Achievement A;
    public static Achievement B;
    public static Achievement C;
    public static Achievement D;
    public static Achievement E;
    public static Achievement F;
    public static Achievement G;
    public static Achievement H;
    public static Achievement I;
    public static Achievement J;
    public static Achievement K;
    public static Achievement L;
    
    public static void a() {
    }
    
    static {
        AchievementList.e = new ArrayList();
        AchievementList.f = new Achievement("achievement.openInventory", "openInventory", 0, 0, Items.BOOK, null).a().c();
        AchievementList.g = new Achievement("achievement.mineWood", "mineWood", 2, 1, Blocks.LOG, AchievementList.f).c();
        AchievementList.h = new Achievement("achievement.buildWorkBench", "buildWorkBench", 4, -1, Blocks.WORKBENCH, AchievementList.g).c();
        AchievementList.i = new Achievement("achievement.buildPickaxe", "buildPickaxe", 4, 2, Items.WOOD_PICKAXE, AchievementList.h).c();
        AchievementList.j = new Achievement("achievement.buildFurnace", "buildFurnace", 3, 4, Blocks.FURNACE, AchievementList.i).c();
        AchievementList.k = new Achievement("achievement.acquireIron", "acquireIron", 1, 4, Items.IRON_INGOT, AchievementList.j).c();
        AchievementList.l = new Achievement("achievement.buildHoe", "buildHoe", 2, -3, Items.WOOD_HOE, AchievementList.h).c();
        AchievementList.m = new Achievement("achievement.makeBread", "makeBread", -1, -3, Items.BREAD, AchievementList.l).c();
        AchievementList.n = new Achievement("achievement.bakeCake", "bakeCake", 0, -5, Items.CAKE, AchievementList.l).c();
        AchievementList.o = new Achievement("achievement.buildBetterPickaxe", "buildBetterPickaxe", 6, 2, Items.STONE_PICKAXE, AchievementList.i).c();
        AchievementList.p = new Achievement("achievement.cookFish", "cookFish", 2, 6, Items.COOKED_FISH, AchievementList.j).c();
        AchievementList.q = new Achievement("achievement.onARail", "onARail", 2, 3, Blocks.RAILS, AchievementList.k).b().c();
        AchievementList.r = new Achievement("achievement.buildSword", "buildSword", 6, -1, Items.WOOD_SWORD, AchievementList.h).c();
        AchievementList.s = new Achievement("achievement.killEnemy", "killEnemy", 8, -1, Items.BONE, AchievementList.r).c();
        AchievementList.t = new Achievement("achievement.killCow", "killCow", 7, -3, Items.LEATHER, AchievementList.r).c();
        AchievementList.u = new Achievement("achievement.flyPig", "flyPig", 9, -3, Items.SADDLE, AchievementList.t).b().c();
        AchievementList.v = new Achievement("achievement.snipeSkeleton", "snipeSkeleton", 7, 0, Items.BOW, AchievementList.s).b().c();
        AchievementList.w = new Achievement("achievement.diamonds", "diamonds", -1, 5, Blocks.DIAMOND_ORE, AchievementList.k).c();
        AchievementList.x = new Achievement("achievement.diamondsToYou", "diamondsToYou", -1, 2, Items.DIAMOND, AchievementList.w).c();
        AchievementList.y = new Achievement("achievement.portal", "portal", -1, 7, Blocks.OBSIDIAN, AchievementList.w).c();
        AchievementList.z = new Achievement("achievement.ghast", "ghast", -4, 8, Items.GHAST_TEAR, AchievementList.y).b().c();
        AchievementList.A = new Achievement("achievement.blazeRod", "blazeRod", 0, 9, Items.BLAZE_ROD, AchievementList.y).c();
        AchievementList.B = new Achievement("achievement.potion", "potion", 2, 8, Items.POTION, AchievementList.A).c();
        AchievementList.C = new Achievement("achievement.theEnd", "theEnd", 3, 10, Items.EYE_OF_ENDER, AchievementList.A).b().c();
        AchievementList.D = new Achievement("achievement.theEnd2", "theEnd2", 4, 13, Blocks.DRAGON_EGG, AchievementList.C).b().c();
        AchievementList.E = new Achievement("achievement.enchantments", "enchantments", -4, 4, Blocks.ENCHANTMENT_TABLE, AchievementList.w).c();
        AchievementList.F = new Achievement("achievement.overkill", "overkill", -4, 1, Items.DIAMOND_SWORD, AchievementList.E).b().c();
        AchievementList.G = new Achievement("achievement.bookcase", "bookcase", -3, 6, Blocks.BOOKSHELF, AchievementList.E).c();
        AchievementList.H = new Achievement("achievement.breedCow", "breedCow", 7, -5, Items.WHEAT, AchievementList.t).c();
        AchievementList.I = new Achievement("achievement.spawnWither", "spawnWither", 7, 12, new ItemStack(Items.SKULL, 1, 1), AchievementList.D).c();
        AchievementList.J = new Achievement("achievement.killWither", "killWither", 7, 10, Items.NETHER_STAR, AchievementList.I).c();
        AchievementList.K = new Achievement("achievement.fullBeacon", "fullBeacon", 7, 8, Blocks.BEACON, AchievementList.J).b().c();
        AchievementList.L = new Achievement("achievement.exploreAllBiomes", "exploreAllBiomes", 4, 8, Items.DIAMOND_BOOTS, AchievementList.C).a(AchievementSet.class).b().c();
    }
}
