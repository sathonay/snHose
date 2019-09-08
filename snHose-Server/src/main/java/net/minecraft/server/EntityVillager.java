package net.minecraft.server.v1_7_R4;

import java.util.*;

public class EntityVillager extends EntityAgeable implements IMerchant, NPC
{
    private int profession;
    private boolean br;
    private boolean bs;
    Village village;
    private EntityHuman tradingPlayer;
    private MerchantRecipeList bu;
    private int bv;
    private boolean bw;
    private int riches;
    private String by;
    private boolean bz;
    private float bA;
    private static final Map bB;
    private static final Map bC;
    
    public EntityVillager(final World world) {
        this(world, 0);
    }
    
    public EntityVillager(final World world, final int profession) {
        super(world);
        this.setProfession(profession);
        this.a(0.6f, 1.8f);
        this.getNavigation().b(true);
        this.getNavigation().a(true);
        this.goalSelector.a(0, new PathfinderGoalFloat(this));
        this.goalSelector.a(1, new PathfinderGoalAvoidPlayer(this, EntityZombie.class, 8.0f, 0.6, 0.6));
        this.goalSelector.a(1, new PathfinderGoalTradeWithPlayer(this));
        this.goalSelector.a(1, new PathfinderGoalLookAtTradingPlayer(this));
        this.goalSelector.a(2, new PathfinderGoalMoveIndoors(this));
        this.goalSelector.a(3, new PathfinderGoalRestrictOpenDoor(this));
        this.goalSelector.a(4, new PathfinderGoalOpenDoor(this, true));
        this.goalSelector.a(5, new PathfinderGoalMoveTowardsRestriction(this, 0.6));
        this.goalSelector.a(6, new PathfinderGoalMakeLove(this));
        this.goalSelector.a(7, new PathfinderGoalTakeFlower(this));
        this.goalSelector.a(8, new PathfinderGoalPlay(this, 0.32));
        this.goalSelector.a(9, new PathfinderGoalInteract(this, EntityHuman.class, 3.0f, 1.0f));
        this.goalSelector.a(9, new PathfinderGoalInteract(this, EntityVillager.class, 5.0f, 0.02f));
        this.goalSelector.a(9, new PathfinderGoalRandomStroll(this, 0.6));
        this.goalSelector.a(10, new PathfinderGoalLookAtPlayer(this, EntityInsentient.class, 8.0f));
    }
    
    @Override
    protected void aD() {
        super.aD();
        this.getAttributeInstance(GenericAttributes.d).setValue(0.5);
    }
    
    public boolean bk() {
        return true;
    }
    
    @Override
    protected void bp() {
        final int profession = this.profession - 1;
        this.profession = profession;
        if (profession <= 0) {
            this.world.villages.a(MathHelper.floor(this.locX), MathHelper.floor(this.locY), MathHelper.floor(this.locZ));
            this.profession = 70 + this.random.nextInt(50);
            this.village = this.world.villages.getClosestVillage(MathHelper.floor(this.locX), MathHelper.floor(this.locY), MathHelper.floor(this.locZ), 32);
            if (this.village == null) {
                this.bX();
            }
            else {
                final ChunkCoordinates center = this.village.getCenter();
                this.a(center.x, center.y, center.z, (int)(this.village.getSize() * 0.6f));
                if (this.bz) {
                    this.bz = false;
                    this.village.b(5);
                }
            }
        }
        if (!this.cc() && this.bv > 0) {
            --this.bv;
            if (this.bv <= 0) {
                if (this.bw) {
                    if (this.bu.size() > 1) {
                        for (final MerchantRecipe merchantRecipe : this.bu) {
                            if (merchantRecipe.g()) {
                                merchantRecipe.a(this.random.nextInt(6) + this.random.nextInt(6) + 2);
                            }
                        }
                    }
                    this.t(1);
                    this.bw = false;
                    if (this.village != null && this.by != null) {
                        this.world.broadcastEntityEffect(this, (byte)14);
                        this.village.a(this.by, 1);
                    }
                }
                this.addEffect(new MobEffect(MobEffectList.REGENERATION.id, 200, 0));
            }
        }
        super.bp();
    }
    
    @Override
    public boolean a(final EntityHuman entityhuman) {
        final ItemStack itemInHand = entityhuman.inventory.getItemInHand();
        if ((itemInHand == null || itemInHand.getItem() != Items.MONSTER_EGG) && this.isAlive() && !this.cc() && !this.isBaby()) {
            if (!this.world.isStatic) {
                this.a_(entityhuman);
                entityhuman.openTrade(this, this.getCustomName());
            }
            return true;
        }
        return super.a(entityhuman);
    }
    
    @Override
    protected void c() {
        super.c();
        this.datawatcher.a(16, 0);
    }
    
    @Override
    public void b(final NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
        nbttagcompound.setInt("Profession", this.getProfession());
        nbttagcompound.setInt("Riches", this.riches);
        if (this.bu != null) {
            nbttagcompound.set("Offers", this.bu.a());
        }
    }
    
    @Override
    public void a(final NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
        this.setProfession(nbttagcompound.getInt("Profession"));
        this.riches = nbttagcompound.getInt("Riches");
        if (nbttagcompound.hasKeyOfType("Offers", 10)) {
            this.bu = new MerchantRecipeList(nbttagcompound.getCompound("Offers"));
        }
    }
    
    @Override
    protected boolean isTypeNotPersistent() {
        return false;
    }
    
    @Override
    protected String t() {
        if (this.cc()) {
            return "mob.villager.haggle";
        }
        return "mob.villager.idle";
    }
    
    @Override
    protected String aT() {
        return "mob.villager.hit";
    }
    
    @Override
    protected String aU() {
        return "mob.villager.death";
    }
    
    public void setProfession(final int n) {
        this.datawatcher.watch(16, n);
    }
    
    public int getProfession() {
        return this.datawatcher.getInt(16);
    }
    
    public boolean ca() {
        return this.br;
    }
    
    public void i(final boolean br) {
        this.br = br;
    }
    
    public void j(final boolean bs) {
        this.bs = bs;
    }
    
    public boolean cb() {
        return this.bs;
    }
    
    @Override
    public void b(final EntityLiving entityLiving) {
        super.b(entityLiving);
        if (this.village != null && entityLiving != null) {
            this.village.a(entityLiving);
            if (entityLiving instanceof EntityHuman) {
                int i = -1;
                if (this.isBaby()) {
                    i = -3;
                }
                this.village.a(entityLiving.getName(), i);
                if (this.isAlive()) {
                    this.world.broadcastEntityEffect(this, (byte)13);
                }
            }
        }
    }
    
    @Override
    public void die(final DamageSource damagesource) {
        if (this.village != null) {
            final Entity entity = damagesource.getEntity();
            if (entity != null) {
                if (entity instanceof EntityHuman) {
                    this.village.a(entity.getName(), -2);
                }
                else if (entity instanceof IMonster) {
                    this.village.h();
                }
            }
            else if (entity == null && this.world.findNearbyPlayer(this, 16.0) != null) {
                this.village.h();
            }
        }
        super.die(damagesource);
    }
    
    @Override
    public void a_(final EntityHuman tradingPlayer) {
        this.tradingPlayer = tradingPlayer;
    }
    
    @Override
    public EntityHuman b() {
        return this.tradingPlayer;
    }
    
    public boolean cc() {
        return this.tradingPlayer != null;
    }
    
    @Override
    public void a(final MerchantRecipe merchantRecipe) {
        merchantRecipe.f();
        this.a_ = -this.q();
        this.makeSound("mob.villager.yes", this.bf(), this.bg());
        if (merchantRecipe.a(this.bu.get(this.bu.size() - 1))) {
            this.bv = 40;
            this.bw = true;
            if (this.tradingPlayer != null) {
                this.by = this.tradingPlayer.getName();
            }
            else {
                this.by = null;
            }
        }
        if (merchantRecipe.getBuyItem1().getItem() == Items.EMERALD) {
            this.riches += merchantRecipe.getBuyItem1().count;
        }
    }
    
    @Override
    public void a_(final ItemStack itemStack) {
        if (!this.world.isStatic && this.a_ > -this.q() + 20) {
            this.a_ = -this.q();
            if (itemStack != null) {
                this.makeSound("mob.villager.yes", this.bf(), this.bg());
            }
            else {
                this.makeSound("mob.villager.no", this.bf(), this.bg());
            }
        }
    }
    
    @Override
    public MerchantRecipeList getOffers(final EntityHuman entityHuman) {
        if (this.bu == null) {
            this.t(1);
        }
        return this.bu;
    }
    
    private float p(final float n) {
        final float n2 = n + this.bA;
        if (n2 > 0.9f) {
            return 0.9f - (n2 - 0.9f);
        }
        return n2;
    }
    
    private void t(final int n) {
        if (this.bu != null) {
            this.bA = MathHelper.c(this.bu.size()) * 0.2f;
        }
        else {
            this.bA = 0.0f;
        }
        final MerchantRecipeList list = new MerchantRecipeList();
        switch (this.getProfession()) {
            case 0: {
                a(list, Items.WHEAT, this.random, this.p(0.9f));
                a(list, Item.getItemOf(Blocks.WOOL), this.random, this.p(0.5f));
                a(list, Items.RAW_CHICKEN, this.random, this.p(0.5f));
                a(list, Items.COOKED_FISH, this.random, this.p(0.4f));
                b(list, Items.BREAD, this.random, this.p(0.9f));
                b(list, Items.MELON, this.random, this.p(0.3f));
                b(list, Items.APPLE, this.random, this.p(0.3f));
                b(list, Items.COOKIE, this.random, this.p(0.3f));
                b(list, Items.SHEARS, this.random, this.p(0.3f));
                b(list, Items.FLINT_AND_STEEL, this.random, this.p(0.3f));
                b(list, Items.COOKED_CHICKEN, this.random, this.p(0.3f));
                b(list, Items.ARROW, this.random, this.p(0.5f));
                if (this.random.nextFloat() < this.p(0.5f)) {
                    list.add(new MerchantRecipe(new ItemStack(Blocks.GRAVEL, 10), new ItemStack(Items.EMERALD), new ItemStack(Items.FLINT, 4 + this.random.nextInt(2), 0)));
                    break;
                }
                break;
            }
            case 4: {
                a(list, Items.COAL, this.random, this.p(0.7f));
                a(list, Items.PORK, this.random, this.p(0.5f));
                a(list, Items.RAW_BEEF, this.random, this.p(0.5f));
                b(list, Items.SADDLE, this.random, this.p(0.1f));
                b(list, Items.LEATHER_CHESTPLATE, this.random, this.p(0.3f));
                b(list, Items.LEATHER_BOOTS, this.random, this.p(0.3f));
                b(list, Items.LEATHER_HELMET, this.random, this.p(0.3f));
                b(list, Items.LEATHER_LEGGINGS, this.random, this.p(0.3f));
                b(list, Items.GRILLED_PORK, this.random, this.p(0.3f));
                b(list, Items.COOKED_BEEF, this.random, this.p(0.3f));
                break;
            }
            case 3: {
                a(list, Items.COAL, this.random, this.p(0.7f));
                a(list, Items.IRON_INGOT, this.random, this.p(0.5f));
                a(list, Items.GOLD_INGOT, this.random, this.p(0.5f));
                a(list, Items.DIAMOND, this.random, this.p(0.5f));
                b(list, Items.IRON_SWORD, this.random, this.p(0.5f));
                b(list, Items.DIAMOND_SWORD, this.random, this.p(0.5f));
                b(list, Items.IRON_AXE, this.random, this.p(0.3f));
                b(list, Items.DIAMOND_AXE, this.random, this.p(0.3f));
                b(list, Items.IRON_PICKAXE, this.random, this.p(0.5f));
                b(list, Items.DIAMOND_PICKAXE, this.random, this.p(0.5f));
                b(list, Items.IRON_SPADE, this.random, this.p(0.2f));
                b(list, Items.DIAMOND_SPADE, this.random, this.p(0.2f));
                b(list, Items.IRON_HOE, this.random, this.p(0.2f));
                b(list, Items.DIAMOND_HOE, this.random, this.p(0.2f));
                b(list, Items.IRON_BOOTS, this.random, this.p(0.2f));
                b(list, Items.DIAMOND_BOOTS, this.random, this.p(0.2f));
                b(list, Items.IRON_HELMET, this.random, this.p(0.2f));
                b(list, Items.DIAMOND_HELMET, this.random, this.p(0.2f));
                b(list, Items.IRON_CHESTPLATE, this.random, this.p(0.2f));
                b(list, Items.DIAMOND_CHESTPLATE, this.random, this.p(0.2f));
                b(list, Items.IRON_LEGGINGS, this.random, this.p(0.2f));
                b(list, Items.DIAMOND_LEGGINGS, this.random, this.p(0.2f));
                b(list, Items.CHAINMAIL_BOOTS, this.random, this.p(0.1f));
                b(list, Items.CHAINMAIL_HELMET, this.random, this.p(0.1f));
                b(list, Items.CHAINMAIL_CHESTPLATE, this.random, this.p(0.1f));
                b(list, Items.CHAINMAIL_LEGGINGS, this.random, this.p(0.1f));
                break;
            }
            case 1: {
                a(list, Items.PAPER, this.random, this.p(0.8f));
                a(list, Items.BOOK, this.random, this.p(0.8f));
                a(list, Items.WRITTEN_BOOK, this.random, this.p(0.3f));
                b(list, Item.getItemOf(Blocks.BOOKSHELF), this.random, this.p(0.8f));
                b(list, Item.getItemOf(Blocks.GLASS), this.random, this.p(0.2f));
                b(list, Items.COMPASS, this.random, this.p(0.2f));
                b(list, Items.WATCH, this.random, this.p(0.2f));
                if (this.random.nextFloat() < this.p(0.07f)) {
                    final Enchantment enchantment = Enchantment.c[this.random.nextInt(Enchantment.c.length)];
                    final int nextInt = MathHelper.nextInt(this.random, enchantment.getStartLevel(), enchantment.getMaxLevel());
                    list.add(new MerchantRecipe(new ItemStack(Items.BOOK), new ItemStack(Items.EMERALD, 2 + this.random.nextInt(5 + nextInt * 10) + 3 * nextInt), Items.ENCHANTED_BOOK.a(new EnchantmentInstance(enchantment, nextInt))));
                    break;
                }
                break;
            }
            case 2: {
                b(list, Items.EYE_OF_ENDER, this.random, this.p(0.3f));
                b(list, Items.EXP_BOTTLE, this.random, this.p(0.2f));
                b(list, Items.REDSTONE, this.random, this.p(0.4f));
                b(list, Item.getItemOf(Blocks.GLOWSTONE), this.random, this.p(0.3f));
                for (final Item item : new Item[] { Items.IRON_SWORD, Items.DIAMOND_SWORD, Items.IRON_CHESTPLATE, Items.DIAMOND_CHESTPLATE, Items.IRON_AXE, Items.DIAMOND_AXE, Items.IRON_PICKAXE, Items.DIAMOND_PICKAXE }) {
                    if (this.random.nextFloat() < this.p(0.05f)) {
                        list.add(new MerchantRecipe(new ItemStack(item, 1, 0), new ItemStack(Items.EMERALD, 2 + this.random.nextInt(3), 0), EnchantmentManager.a(this.random, new ItemStack(item, 1, 0), 5 + this.random.nextInt(15))));
                    }
                }
                break;
            }
        }
        if (list.isEmpty()) {
            a(list, Items.GOLD_INGOT, this.random, 1.0f);
        }
        Collections.shuffle(list);
        if (this.bu == null) {
            this.bu = new MerchantRecipeList();
        }
        for (int n2 = 0; n2 < n && n2 < list.size(); ++n2) {
            this.bu.a(list.get(n2));
        }
    }
    
    private static void a(final MerchantRecipeList list, final Item item, final Random random, final float n) {
        if (random.nextFloat() < n) {
            list.add(new MerchantRecipe(a(item, random), Items.EMERALD));
        }
    }
    
    private static ItemStack a(final Item item, final Random random) {
        return new ItemStack(item, b(item, random), 0);
    }
    
    private static int b(final Item item, final Random random) {
        final Tuple tuple = EntityVillager.bB.get(item);
        if (tuple == null) {
            return 1;
        }
        if ((int)tuple.a() >= (int)tuple.b()) {
            return (int)tuple.a();
        }
        return (int)tuple.a() + random.nextInt((int)tuple.b() - (int)tuple.a());
    }
    
    private static void b(final MerchantRecipeList list, final Item item, final Random random, final float n) {
        if (random.nextFloat() < n) {
            final int c = c(item, random);
            ItemStack itemstack;
            ItemStack itemstack2;
            if (c < 0) {
                itemstack = new ItemStack(Items.EMERALD, 1, 0);
                itemstack2 = new ItemStack(item, -c, 0);
            }
            else {
                itemstack = new ItemStack(Items.EMERALD, c, 0);
                itemstack2 = new ItemStack(item, 1, 0);
            }
            list.add(new MerchantRecipe(itemstack, itemstack2));
        }
    }
    
    private static int c(final Item item, final Random random) {
        final Tuple tuple = EntityVillager.bC.get(item);
        if (tuple == null) {
            return 1;
        }
        if ((int)tuple.a() >= (int)tuple.b()) {
            return (int)tuple.a();
        }
        return (int)tuple.a() + random.nextInt((int)tuple.b() - (int)tuple.a());
    }
    
    @Override
    public GroupDataEntity prepare(GroupDataEntity prepare) {
        prepare = super.prepare(prepare);
        this.setProfession(this.world.random.nextInt(5));
        return prepare;
    }
    
    public void cd() {
        this.bz = true;
    }
    
    public EntityVillager b(final EntityAgeable entityAgeable) {
        final EntityVillager entityVillager = new EntityVillager(this.world);
        entityVillager.prepare(null);
        return entityVillager;
    }
    
    @Override
    public boolean bM() {
        return false;
    }
    
    static {
        bB = new HashMap();
        bC = new HashMap();
        EntityVillager.bB.put(Items.COAL, new Tuple(16, 24));
        EntityVillager.bB.put(Items.IRON_INGOT, new Tuple(8, 10));
        EntityVillager.bB.put(Items.GOLD_INGOT, new Tuple(8, 10));
        EntityVillager.bB.put(Items.DIAMOND, new Tuple(4, 6));
        EntityVillager.bB.put(Items.PAPER, new Tuple(24, 36));
        EntityVillager.bB.put(Items.BOOK, new Tuple(11, 13));
        EntityVillager.bB.put(Items.WRITTEN_BOOK, new Tuple(1, 1));
        EntityVillager.bB.put(Items.ENDER_PEARL, new Tuple(3, 4));
        EntityVillager.bB.put(Items.EYE_OF_ENDER, new Tuple(2, 3));
        EntityVillager.bB.put(Items.PORK, new Tuple(14, 18));
        EntityVillager.bB.put(Items.RAW_BEEF, new Tuple(14, 18));
        EntityVillager.bB.put(Items.RAW_CHICKEN, new Tuple(14, 18));
        EntityVillager.bB.put(Items.COOKED_FISH, new Tuple(9, 13));
        EntityVillager.bB.put(Items.SEEDS, new Tuple(34, 48));
        EntityVillager.bB.put(Items.MELON_SEEDS, new Tuple(30, 38));
        EntityVillager.bB.put(Items.PUMPKIN_SEEDS, new Tuple(30, 38));
        EntityVillager.bB.put(Items.WHEAT, new Tuple(18, 22));
        EntityVillager.bB.put(Item.getItemOf(Blocks.WOOL), new Tuple(14, 22));
        EntityVillager.bB.put(Items.ROTTEN_FLESH, new Tuple(36, 64));
        EntityVillager.bC.put(Items.FLINT_AND_STEEL, new Tuple(3, 4));
        EntityVillager.bC.put(Items.SHEARS, new Tuple(3, 4));
        EntityVillager.bC.put(Items.IRON_SWORD, new Tuple(7, 11));
        EntityVillager.bC.put(Items.DIAMOND_SWORD, new Tuple(12, 14));
        EntityVillager.bC.put(Items.IRON_AXE, new Tuple(6, 8));
        EntityVillager.bC.put(Items.DIAMOND_AXE, new Tuple(9, 12));
        EntityVillager.bC.put(Items.IRON_PICKAXE, new Tuple(7, 9));
        EntityVillager.bC.put(Items.DIAMOND_PICKAXE, new Tuple(10, 12));
        EntityVillager.bC.put(Items.IRON_SPADE, new Tuple(4, 6));
        EntityVillager.bC.put(Items.DIAMOND_SPADE, new Tuple(7, 8));
        EntityVillager.bC.put(Items.IRON_HOE, new Tuple(4, 6));
        EntityVillager.bC.put(Items.DIAMOND_HOE, new Tuple(7, 8));
        EntityVillager.bC.put(Items.IRON_BOOTS, new Tuple(4, 6));
        EntityVillager.bC.put(Items.DIAMOND_BOOTS, new Tuple(7, 8));
        EntityVillager.bC.put(Items.IRON_HELMET, new Tuple(4, 6));
        EntityVillager.bC.put(Items.DIAMOND_HELMET, new Tuple(7, 8));
        EntityVillager.bC.put(Items.IRON_CHESTPLATE, new Tuple(10, 14));
        EntityVillager.bC.put(Items.DIAMOND_CHESTPLATE, new Tuple(16, 19));
        EntityVillager.bC.put(Items.IRON_LEGGINGS, new Tuple(8, 10));
        EntityVillager.bC.put(Items.DIAMOND_LEGGINGS, new Tuple(11, 14));
        EntityVillager.bC.put(Items.CHAINMAIL_BOOTS, new Tuple(5, 7));
        EntityVillager.bC.put(Items.CHAINMAIL_HELMET, new Tuple(5, 7));
        EntityVillager.bC.put(Items.CHAINMAIL_CHESTPLATE, new Tuple(11, 15));
        EntityVillager.bC.put(Items.CHAINMAIL_LEGGINGS, new Tuple(9, 11));
        EntityVillager.bC.put(Items.BREAD, new Tuple(-4, -2));
        EntityVillager.bC.put(Items.MELON, new Tuple(-8, -4));
        EntityVillager.bC.put(Items.APPLE, new Tuple(-8, -4));
        EntityVillager.bC.put(Items.COOKIE, new Tuple(-10, -7));
        EntityVillager.bC.put(Item.getItemOf(Blocks.GLASS), new Tuple(-5, -3));
        EntityVillager.bC.put(Item.getItemOf(Blocks.BOOKSHELF), new Tuple(3, 4));
        EntityVillager.bC.put(Items.LEATHER_CHESTPLATE, new Tuple(4, 5));
        EntityVillager.bC.put(Items.LEATHER_BOOTS, new Tuple(2, 4));
        EntityVillager.bC.put(Items.LEATHER_HELMET, new Tuple(2, 4));
        EntityVillager.bC.put(Items.LEATHER_LEGGINGS, new Tuple(2, 4));
        EntityVillager.bC.put(Items.SADDLE, new Tuple(6, 8));
        EntityVillager.bC.put(Items.EXP_BOTTLE, new Tuple(-4, -1));
        EntityVillager.bC.put(Items.REDSTONE, new Tuple(-4, -1));
        EntityVillager.bC.put(Items.COMPASS, new Tuple(10, 12));
        EntityVillager.bC.put(Items.WATCH, new Tuple(10, 12));
        EntityVillager.bC.put(Item.getItemOf(Blocks.GLOWSTONE), new Tuple(-3, -1));
        EntityVillager.bC.put(Items.GRILLED_PORK, new Tuple(-7, -5));
        EntityVillager.bC.put(Items.COOKED_BEEF, new Tuple(-7, -5));
        EntityVillager.bC.put(Items.COOKED_CHICKEN, new Tuple(-8, -6));
        EntityVillager.bC.put(Items.EYE_OF_ENDER, new Tuple(7, 11));
        EntityVillager.bC.put(Items.ARROW, new Tuple(-12, -8));
    }
}
