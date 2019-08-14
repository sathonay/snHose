package net.minecraft.server;

import java.util.*;

public class ItemPotion extends Item
{
    private Map<Integer, List<MobEffect>> a;
    private static final Map b;

    public ItemPotion() {
        this.a = new HashMap<>();
        this.e(1);
        this.a(true);
        this.setMaxDurability(0);
        this.a(CreativeModeTab.k);
    }

    public List<MobEffect> g(final ItemStack itemStack) {
        if (!itemStack.hasTag() || !itemStack.getTag().hasKeyOfType("CustomPotionEffects", 9)) {
            List<MobEffect> effects = this.a.get(itemStack.getData());
            if (effects == null) {
                effects = PotionBrewer.getEffects(itemStack.getData(), false);
                this.a.put(itemStack.getData(), effects);
            }
            return effects;
        }
        final List<MobEffect> list = new ArrayList<>();
        final NBTTagList list2 = itemStack.getTag().getList("CustomPotionEffects", 10);
        for (int i = 0; i < list2.size(); ++i) {
            final MobEffect b = MobEffect.b(list2.get(i));
            if (b != null) {
                list.add(b);
            }
        }
        return list;
    }

    public List c(final int n) {
        List<MobEffect> effects = this.a.get(n);
        if (effects == null) {
            effects = PotionBrewer.getEffects(n, false);
            this.a.put(n, effects);
        }
        return effects;
    }

    @Override
    public ItemStack b(final ItemStack itemStack, final World world, final EntityHuman entityHuman) {
        if (!entityHuman.abilities.canInstantlyBuild) {
            --itemStack.count;
        }
        if (!world.isStatic) {
            final List<MobEffect> g = this.g(itemStack);
            if (g != null) {
                final Iterator<MobEffect> iterator = g.iterator();
                while (iterator.hasNext()) {
                    entityHuman.addEffect(new MobEffect(iterator.next()));
                }
            }
        }
        if (!entityHuman.abilities.canInstantlyBuild) {
            if (itemStack.count <= 0) {
                return new ItemStack(Items.GLASS_BOTTLE);
            }
            entityHuman.inventory.pickup(new ItemStack(Items.GLASS_BOTTLE));
        }
        return itemStack;
    }

    @Override
    public int d_(final ItemStack itemStack) {
        return 32;
    }

    @Override
    public EnumAnimation d(final ItemStack itemStack) {
        return EnumAnimation.DRINK;
    }

    @Override
    public ItemStack a(final ItemStack itemStack, final World world, final EntityHuman entityHuman) {
        if (g(itemStack.getData())) {
            if (!entityHuman.abilities.canInstantlyBuild) {
                --itemStack.count;
            }
            world.makeSound(entityHuman, "random.bow", 0.5f, 0.4f / (ItemPotion.g.nextFloat() * 0.4f + 0.8f));
            if (!world.isStatic) {
                world.addEntity(new EntityPotion(world, entityHuman, itemStack));
            }
            return itemStack;
        }
        entityHuman.a(itemStack, this.d_(itemStack));
        return itemStack;
    }

    @Override
    public boolean interactWith(final ItemStack itemStack, final EntityHuman entityHuman, final World world, final int n, final int n2, final int n3, final int n4, final float n5, final float n6, final float n7) {
        return false;
    }

    public static boolean g(final int n) {
        return (n & 0x4000) != 0x0;
    }

    @Override
    public String n(final ItemStack itemstack) {
        if (itemstack.getData() == 0) {
            return LocaleI18n.get("item.emptyPotion.name").trim();
        }
        String string = "";
        if (g(itemstack.getData())) {
            string = LocaleI18n.get("potion.prefix.grenade").trim() + " ";
        }
        final List<MobEffect> g = Items.POTION.g(itemstack);
        if (g != null && !g.isEmpty()) {
            return string + LocaleI18n.get(g.get(0).f() + ".postfix").trim();
        }
        return LocaleI18n.get(PotionBrewer.c(itemstack.getData())).trim() + " " + super.n(itemstack);
    }

    static {
        b = new LinkedHashMap();
    }
}
