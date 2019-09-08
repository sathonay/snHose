package net.minecraft.server.v1_7_R4;

import java.util.*;

public class CommandEnchant extends CommandAbstract
{
    @Override
    public String getCommand() {
        return "enchant";
    }
    
    @Override
    public int a() {
        return 2;
    }
    
    @Override
    public String c(final ICommandListener commandListener) {
        return "commands.enchant.usage";
    }
    
    @Override
    public void execute(final ICommandListener commandListener, final String[] array) {
        if (array.length < 2) {
            throw new ExceptionUsage("commands.enchant.usage", new Object[0]);
        }
        final EntityPlayer d = CommandAbstract.d(commandListener, array[0]);
        final int a = CommandAbstract.a(commandListener, array[1], 0, Enchantment.byId.length - 1);
        int a2 = 1;
        final ItemStack bf = d.bF();
        if (bf == null) {
            throw new CommandException("commands.enchant.noItem", new Object[0]);
        }
        final Enchantment enchantment = Enchantment.byId[a];
        if (enchantment == null) {
            throw new ExceptionInvalidNumber("commands.enchant.notFound", new Object[] { a });
        }
        if (!enchantment.canEnchant(bf)) {
            throw new CommandException("commands.enchant.cantEnchant", new Object[0]);
        }
        if (array.length >= 3) {
            a2 = CommandAbstract.a(commandListener, array[2], enchantment.getStartLevel(), enchantment.getMaxLevel());
        }
        if (bf.hasTag()) {
            final NBTTagList enchantments = bf.getEnchantments();
            if (enchantments != null) {
                for (int i = 0; i < enchantments.size(); ++i) {
                    final short short1 = enchantments.get(i).getShort("id");
                    if (Enchantment.byId[short1] != null) {
                        final Enchantment enchantment2 = Enchantment.byId[short1];
                        if (!enchantment2.a(enchantment)) {
                            throw new CommandException("commands.enchant.cantCombine", new Object[] { enchantment.c(a2), enchantment2.c(enchantments.get(i).getShort("lvl")) });
                        }
                    }
                }
            }
        }
        bf.addEnchantment(enchantment, a2);
        CommandAbstract.a(commandListener, this, "commands.enchant.success", new Object[0]);
    }
    
    @Override
    public List tabComplete(final ICommandListener commandListener, final String[] array) {
        if (array.length == 1) {
            return CommandAbstract.a(array, this.d());
        }
        return null;
    }
    
    protected String[] d() {
        return MinecraftServer.getServer().getPlayers();
    }
    
    @Override
    public boolean isListStart(final String[] array, final int n) {
        return n == 0;
    }
}
