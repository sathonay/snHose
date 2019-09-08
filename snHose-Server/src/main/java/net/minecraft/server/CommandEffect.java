package net.minecraft.server.v1_7_R4;

import java.util.*;

public class CommandEffect extends CommandAbstract
{
    @Override
    public String getCommand() {
        return "effect";
    }
    
    @Override
    public int a() {
        return 2;
    }
    
    @Override
    public String c(final ICommandListener commandListener) {
        return "commands.effect.usage";
    }
    
    @Override
    public void execute(final ICommandListener commandListener, final String[] array) {
        if (array.length >= 2) {
            final EntityPlayer d = CommandAbstract.d(commandListener, array[0]);
            if (array[1].equals("clear")) {
                if (d.getEffects().isEmpty()) {
                    throw new CommandException("commands.effect.failure.notActive.all", new Object[] { d.getName() });
                }
                d.removeAllEffects();
                CommandAbstract.a(commandListener, this, "commands.effect.success.removed.all", d.getName());
            }
            else {
                final int a = CommandAbstract.a(commandListener, array[1], 1);
                int n = 600;
                int a2 = 30;
                int a3 = 0;
                if (a < 0 || a >= MobEffectList.byId.length || MobEffectList.byId[a] == null) {
                    throw new ExceptionInvalidNumber("commands.effect.notFound", new Object[] { a });
                }
                if (array.length >= 3) {
                    a2 = CommandAbstract.a(commandListener, array[2], 0, 1000000);
                    if (MobEffectList.byId[a].isInstant()) {
                        n = a2;
                    }
                    else {
                        n = a2 * 20;
                    }
                }
                else if (MobEffectList.byId[a].isInstant()) {
                    n = 1;
                }
                if (array.length >= 4) {
                    a3 = CommandAbstract.a(commandListener, array[3], 0, 255);
                }
                if (a2 == 0) {
                    if (!d.hasEffect(a)) {
                        throw new CommandException("commands.effect.failure.notActive", new Object[] { new ChatMessage(MobEffectList.byId[a].a(), new Object[0]), d.getName() });
                    }
                    d.removeEffect(a);
                    CommandAbstract.a(commandListener, this, "commands.effect.success.removed", new ChatMessage(MobEffectList.byId[a].a(), new Object[0]), d.getName());
                }
                else {
                    final MobEffect mobeffect = new MobEffect(a, n, a3);
                    d.addEffect(mobeffect);
                    CommandAbstract.a(commandListener, this, "commands.effect.success", new ChatMessage(mobeffect.f(), new Object[0]), a, a3, d.getName(), a2);
                }
            }
            return;
        }
        throw new ExceptionUsage("commands.effect.usage", new Object[0]);
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
