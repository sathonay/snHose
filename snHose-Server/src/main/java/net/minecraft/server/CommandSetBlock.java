package net.minecraft.server.v1_7_R4;

import java.util.*;

public class CommandSetBlock extends CommandAbstract
{
    @Override
    public String getCommand() {
        return "setblock";
    }
    
    @Override
    public int a() {
        return 2;
    }
    
    @Override
    public String c(final ICommandListener commandListener) {
        return "commands.setblock.usage";
    }
    
    @Override
    public void execute(final ICommandListener commandListener, final String[] array) {
        if (array.length < 4) {
            throw new ExceptionUsage("commands.setblock.usage", new Object[0]);
        }
        final int x = commandListener.getChunkCoordinates().x;
        final int y = commandListener.getChunkCoordinates().y;
        final int z = commandListener.getChunkCoordinates().z;
        final int floor = MathHelper.floor(CommandAbstract.a(commandListener, x, array[0]));
        final int floor2 = MathHelper.floor(CommandAbstract.a(commandListener, y, array[1]));
        final int floor3 = MathHelper.floor(CommandAbstract.a(commandListener, z, array[2]));
        final Block g = CommandAbstract.g(commandListener, array[3]);
        int a = 0;
        if (array.length >= 5) {
            a = CommandAbstract.a(commandListener, array[4], 0, 15);
        }
        final World world = commandListener.getWorld();
        if (!world.isLoaded(floor, floor2, floor3)) {
            throw new CommandException("commands.setblock.outOfWorld", new Object[0]);
        }
        NBTTagCompound nbttagcompound = new NBTTagCompound();
        boolean b = false;
        if (array.length >= 7 && g.isTileEntity()) {
            final String c = CommandAbstract.a(commandListener, array, 6).c();
            try {
                final NBTBase parse = MojangsonParser.parse(c);
                if (!(parse instanceof NBTTagCompound)) {
                    throw new CommandException("commands.setblock.tagError", new Object[] { "Not a valid tag" });
                }
                nbttagcompound = (NBTTagCompound)parse;
                b = true;
            }
            catch (MojangsonParseException ex) {
                throw new CommandException("commands.setblock.tagError", new Object[] { ex.getMessage() });
            }
        }
        if (array.length >= 6) {
            if (array[5].equals("destroy")) {
                world.setAir(floor, floor2, floor3, true);
            }
            else if (array[5].equals("keep") && !world.isEmpty(floor, floor2, floor3)) {
                throw new CommandException("commands.setblock.noChange", new Object[0]);
            }
        }
        if (!world.setTypeAndData(floor, floor2, floor3, g, a, 3)) {
            throw new CommandException("commands.setblock.noChange", new Object[0]);
        }
        if (b) {
            final TileEntity tileEntity = world.getTileEntity(floor, floor2, floor3);
            if (tileEntity != null) {
                nbttagcompound.setInt("x", floor);
                nbttagcompound.setInt("y", floor2);
                nbttagcompound.setInt("z", floor3);
                tileEntity.a(nbttagcompound);
            }
        }
        CommandAbstract.a(commandListener, this, "commands.setblock.success", new Object[0]);
    }
    
    @Override
    public List tabComplete(final ICommandListener commandListener, final String[] array) {
        if (array.length == 4) {
            return CommandAbstract.a(array, Block.REGISTRY.keySet());
        }
        if (array.length == 6) {
            return CommandAbstract.a(array, "replace", "destroy", "keep");
        }
        return null;
    }
}
