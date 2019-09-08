package net.minecraft.server.v1_7_R4;

import java.util.*;

public class StatisticList
{
    protected static Map a;
    public static List stats;
    public static List c;
    public static List d;
    public static List e;
    public static Statistic f;
    public static Statistic g;
    public static Statistic h;
    public static Statistic i;
    public static Statistic j;
    public static Statistic k;
    public static Statistic l;
    public static Statistic m;
    public static Statistic n;
    public static Statistic o;
    public static Statistic p;
    public static Statistic q;
    public static Statistic r;
    public static Statistic s;
    public static Statistic t;
    public static Statistic u;
    public static Statistic v;
    public static Statistic w;
    public static Statistic x;
    public static Statistic y;
    public static Statistic z;
    public static Statistic A;
    public static Statistic B;
    public static final Statistic[] MINE_BLOCK_COUNT;
    public static final Statistic[] CRAFT_BLOCK_COUNT;
    public static final Statistic[] USE_ITEM_COUNT;
    public static final Statistic[] BREAK_ITEM_COUNT;
    
    public static void a() {
        c();
        d();
        e();
        b();
        AchievementList.a();
        EntityTypes.a();
    }
    
    private static void b() {
        final HashSet<Item> set = new HashSet<Item>();
        for (final IRecipe recipe : CraftingManager.getInstance().getRecipes()) {
            if (recipe.b() == null) {
                continue;
            }
            set.add(recipe.b().getItem());
        }
        final Iterator<ItemStack> iterator2 = RecipesFurnace.getInstance().getRecipes().values().iterator();
        while (iterator2.hasNext()) {
            set.add(iterator2.next().getItem());
        }
        for (final Item item : set) {
            if (item == null) {
                continue;
            }
            final int id = Item.getId(item);
            StatisticList.CRAFT_BLOCK_COUNT[id] = new CraftingStatistic("stat.craftItem." + id, new ChatMessage("stat.craftItem", new Object[] { new ItemStack(item).E() }), item).h();
        }
        a(StatisticList.CRAFT_BLOCK_COUNT);
    }
    
    private static void c() {
        for (final Block block : Block.REGISTRY) {
            if (Item.getItemOf(block) == null) {
                continue;
            }
            final int id = Block.getId(block);
            if (!block.G()) {
                continue;
            }
            StatisticList.MINE_BLOCK_COUNT[id] = new CraftingStatistic("stat.mineBlock." + id, new ChatMessage("stat.mineBlock", new Object[] { new ItemStack(block).E() }), Item.getItemOf(block)).h();
            StatisticList.e.add(StatisticList.MINE_BLOCK_COUNT[id]);
        }
        a(StatisticList.MINE_BLOCK_COUNT);
    }
    
    private static void d() {
        for (final Item item : Item.REGISTRY) {
            if (item == null) {
                continue;
            }
            final int id = Item.getId(item);
            StatisticList.USE_ITEM_COUNT[id] = new CraftingStatistic("stat.useItem." + id, new ChatMessage("stat.useItem", new Object[] { new ItemStack(item).E() }), item).h();
            if (item instanceof ItemBlock) {
                continue;
            }
            StatisticList.d.add(StatisticList.USE_ITEM_COUNT[id]);
        }
        a(StatisticList.USE_ITEM_COUNT);
    }
    
    private static void e() {
        for (final Item item : Item.REGISTRY) {
            if (item == null) {
                continue;
            }
            final int id = Item.getId(item);
            if (!item.usesDurability()) {
                continue;
            }
            StatisticList.BREAK_ITEM_COUNT[id] = new CraftingStatistic("stat.breakItem." + id, new ChatMessage("stat.breakItem", new Object[] { new ItemStack(item).E() }), item).h();
        }
        a(StatisticList.BREAK_ITEM_COUNT);
    }
    
    private static void a(final Statistic[] array) {
        a(array, Blocks.STATIONARY_WATER, Blocks.WATER);
        a(array, Blocks.STATIONARY_LAVA, Blocks.LAVA);
        a(array, Blocks.JACK_O_LANTERN, Blocks.PUMPKIN);
        a(array, Blocks.BURNING_FURNACE, Blocks.FURNACE);
        a(array, Blocks.GLOWING_REDSTONE_ORE, Blocks.REDSTONE_ORE);
        a(array, Blocks.DIODE_ON, Blocks.DIODE_OFF);
        a(array, Blocks.REDSTONE_COMPARATOR_ON, Blocks.REDSTONE_COMPARATOR_OFF);
        a(array, Blocks.REDSTONE_TORCH_ON, Blocks.REDSTONE_TORCH_OFF);
        a(array, Blocks.REDSTONE_LAMP_ON, Blocks.REDSTONE_LAMP_OFF);
        a(array, Blocks.RED_MUSHROOM, Blocks.BROWN_MUSHROOM);
        a(array, Blocks.DOUBLE_STEP, Blocks.STEP);
        a(array, Blocks.WOOD_DOUBLE_STEP, Blocks.WOOD_STEP);
        a(array, Blocks.GRASS, Blocks.DIRT);
        a(array, Blocks.SOIL, Blocks.DIRT);
    }
    
    private static void a(final Statistic[] array, final Block block, final Block block2) {
        final int id = Block.getId(block);
        final int id2 = Block.getId(block2);
        if (array[id] != null && array[id2] == null) {
            array[id2] = array[id];
            return;
        }
        StatisticList.stats.remove(array[id]);
        StatisticList.e.remove(array[id]);
        StatisticList.c.remove(array[id]);
        array[id] = array[id2];
    }
    
    public static Statistic a(final MonsterEggInfo monsterEggInfo) {
        final String b = EntityTypes.b(monsterEggInfo.a);
        if (b == null) {
            return null;
        }
        return new Statistic("stat.killEntity." + b, new ChatMessage("stat.entityKill", new Object[] { new ChatMessage("entity." + b + ".name", new Object[0]) })).h();
    }
    
    public static Statistic b(final MonsterEggInfo monsterEggInfo) {
        final String b = EntityTypes.b(monsterEggInfo.a);
        if (b == null) {
            return null;
        }
        return new Statistic("stat.entityKilledBy." + b, new ChatMessage("stat.entityKilledBy", new Object[] { new ChatMessage("entity." + b + ".name", new Object[0]) })).h();
    }
    
    public static Statistic getStatistic(final String s) {
        return StatisticList.a.get(s);
    }
    
    static {
        StatisticList.a = new HashMap();
        StatisticList.stats = new ArrayList();
        StatisticList.c = new ArrayList();
        StatisticList.d = new ArrayList();
        StatisticList.e = new ArrayList();
        StatisticList.f = new CounterStatistic("stat.leaveGame", new ChatMessage("stat.leaveGame", new Object[0])).i().h();
        StatisticList.g = new CounterStatistic("stat.playOneMinute", new ChatMessage("stat.playOneMinute", new Object[0]), Statistic.h).i().h();
        StatisticList.h = new CounterStatistic("stat.walkOneCm", new ChatMessage("stat.walkOneCm", new Object[0]), Statistic.i).i().h();
        StatisticList.i = new CounterStatistic("stat.swimOneCm", new ChatMessage("stat.swimOneCm", new Object[0]), Statistic.i).i().h();
        StatisticList.j = new CounterStatistic("stat.fallOneCm", new ChatMessage("stat.fallOneCm", new Object[0]), Statistic.i).i().h();
        StatisticList.k = new CounterStatistic("stat.climbOneCm", new ChatMessage("stat.climbOneCm", new Object[0]), Statistic.i).i().h();
        StatisticList.l = new CounterStatistic("stat.flyOneCm", new ChatMessage("stat.flyOneCm", new Object[0]), Statistic.i).i().h();
        StatisticList.m = new CounterStatistic("stat.diveOneCm", new ChatMessage("stat.diveOneCm", new Object[0]), Statistic.i).i().h();
        StatisticList.n = new CounterStatistic("stat.minecartOneCm", new ChatMessage("stat.minecartOneCm", new Object[0]), Statistic.i).i().h();
        StatisticList.o = new CounterStatistic("stat.boatOneCm", new ChatMessage("stat.boatOneCm", new Object[0]), Statistic.i).i().h();
        StatisticList.p = new CounterStatistic("stat.pigOneCm", new ChatMessage("stat.pigOneCm", new Object[0]), Statistic.i).i().h();
        StatisticList.q = new CounterStatistic("stat.horseOneCm", new ChatMessage("stat.horseOneCm", new Object[0]), Statistic.i).i().h();
        StatisticList.r = new CounterStatistic("stat.jump", new ChatMessage("stat.jump", new Object[0])).i().h();
        StatisticList.s = new CounterStatistic("stat.drop", new ChatMessage("stat.drop", new Object[0])).i().h();
        StatisticList.t = new CounterStatistic("stat.damageDealt", new ChatMessage("stat.damageDealt", new Object[0]), Statistic.j).h();
        StatisticList.u = new CounterStatistic("stat.damageTaken", new ChatMessage("stat.damageTaken", new Object[0]), Statistic.j).h();
        StatisticList.v = new CounterStatistic("stat.deaths", new ChatMessage("stat.deaths", new Object[0])).h();
        StatisticList.w = new CounterStatistic("stat.mobKills", new ChatMessage("stat.mobKills", new Object[0])).h();
        StatisticList.x = new CounterStatistic("stat.animalsBred", new ChatMessage("stat.animalsBred", new Object[0])).h();
        StatisticList.y = new CounterStatistic("stat.playerKills", new ChatMessage("stat.playerKills", new Object[0])).h();
        StatisticList.z = new CounterStatistic("stat.fishCaught", new ChatMessage("stat.fishCaught", new Object[0])).h();
        StatisticList.A = new CounterStatistic("stat.junkFished", new ChatMessage("stat.junkFished", new Object[0])).h();
        StatisticList.B = new CounterStatistic("stat.treasureFished", new ChatMessage("stat.treasureFished", new Object[0])).h();
        MINE_BLOCK_COUNT = new Statistic[4096];
        CRAFT_BLOCK_COUNT = new Statistic[32000];
        USE_ITEM_COUNT = new Statistic[32000];
        BREAK_ITEM_COUNT = new Statistic[32000];
    }
}
