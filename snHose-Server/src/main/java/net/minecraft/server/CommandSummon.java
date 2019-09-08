package net.minecraft.server.v1_7_R4;

import java.util.*;

public class CommandSummon extends CommandAbstract
{
    @Override
    public String getCommand() {
        return "summon";
    }
    
    @Override
    public int a() {
        return 2;
    }
    
    @Override
    public String c(final ICommandListener commandListener) {
        return "commands.summon.usage";
    }
    
    @Override
    public void execute(final ICommandListener commandListener, final String[] array) {
        if (array.length < 1) {
            throw new ExceptionUsage("commands.summon.usage", new Object[0]);
        }
        final String s = array[0];
        double a = commandListener.getChunkCoordinates().x + 0.5;
        double a2 = commandListener.getChunkCoordinates().y;
        double a3 = commandListener.getChunkCoordinates().z + 0.5;
        if (array.length >= 4) {
            a = CommandAbstract.a(commandListener, a, array[1]);
            a2 = CommandAbstract.a(commandListener, a2, array[2]);
            a3 = CommandAbstract.a(commandListener, a3, array[3]);
        }
        final World world = commandListener.getWorld();
        if (!world.isLoaded((int)a, (int)a2, (int)a3)) {
            CommandAbstract.a(commandListener, this, "commands.summon.outOfWorld", new Object[0]);
            return;
        }
        NBTTagCompound nbtTagCompound = new NBTTagCompound();
        boolean b = false;
        if (array.length >= 5) {
            final IChatBaseComponent a4 = CommandAbstract.a(commandListener, array, 4);
            try {
                final NBTBase parse = MojangsonParser.parse(a4.c());
                if (!(parse instanceof NBTTagCompound)) {
                    CommandAbstract.a(commandListener, this, "commands.summon.tagError", "Not a valid tag");
                    return;
                }
                nbtTagCompound = (NBTTagCompound)parse;
                b = true;
            }
            catch (MojangsonParseException ex) {
                CommandAbstract.a(commandListener, this, "commands.summon.tagError", ex.getMessage());
                return;
            }
        }
        nbtTagCompound.setString("id", s);
        final Entity a5 = EntityTypes.a(nbtTagCompound, world);
        if (a5 != null) {
            a5.setPositionRotation(a, a2, a3, a5.yaw, a5.pitch);
            if (!b && a5 instanceof EntityInsentient) {
                ((EntityInsentient)a5).prepare(null);
            }
            world.addEntity(a5);
            Entity entity = a5;
            Entity a6;
            for (NBTTagCompound compound = nbtTagCompound; entity != null && compound.hasKeyOfType("Riding", 10); entity = a6, compound = compound.getCompound("Riding")) {
                a6 = EntityTypes.a(compound.getCompound("Riding"), world);
                if (a6 != null) {
                    a6.setPositionRotation(a, a2, a3, a6.yaw, a6.pitch);
                    world.addEntity(a6);
                    entity.mount(a6);
                }
            }
            CommandAbstract.a(commandListener, this, "commands.summon.success", new Object[0]);
            return;
        }
        CommandAbstract.a(commandListener, this, "commands.summon.failed", new Object[0]);
    }
    
    @Override
    public List tabComplete(final ICommandListener commandListener, final String[] array) {
        if (array.length == 1) {
            return CommandAbstract.a(array, this.d());
        }
        return null;
    }
    
    protected String[] d() {
        return EntityTypes.b().toArray(new String[0]);
    }
}
