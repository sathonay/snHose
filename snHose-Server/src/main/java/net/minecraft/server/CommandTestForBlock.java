package net.minecraft.server.v1_7_R4;

import java.util.*;

public class CommandTestForBlock extends CommandAbstract
{
    @Override
    public String getCommand() {
        return "testforblock";
    }
    
    @Override
    public int a() {
        return 2;
    }
    
    @Override
    public String c(final ICommandListener commandListener) {
        return "commands.testforblock.usage";
    }
    
    @Override
    public void execute(final ICommandListener commandListener, final String[] array) {
        if (array.length < 4) {
            throw new ExceptionUsage("commands.testforblock.usage", new Object[0]);
        }
        final int x = commandListener.getChunkCoordinates().x;
        final int y = commandListener.getChunkCoordinates().y;
        final int z = commandListener.getChunkCoordinates().z;
        final int floor = MathHelper.floor(CommandAbstract.a(commandListener, x, array[0]));
        final int floor2 = MathHelper.floor(CommandAbstract.a(commandListener, y, array[1]));
        final int floor3 = MathHelper.floor(CommandAbstract.a(commandListener, z, array[2]));
        final Block b = Block.b(array[3]);
        if (b == null) {
            throw new ExceptionInvalidNumber("commands.setblock.notFound", new Object[] { array[3] });
        }
        int a = -1;
        if (array.length >= 5) {
            a = CommandAbstract.a(commandListener, array[4], -1, 15);
        }
        final World world = commandListener.getWorld();
        if (!world.isLoaded(floor, floor2, floor3)) {
            throw new CommandException("commands.testforblock.outOfWorld", new Object[0]);
        }
        NBTTagCompound nbtTagCompound = new NBTTagCompound();
        boolean b2 = false;
        if (array.length >= 6 && b.isTileEntity()) {
            final String c = CommandAbstract.a(commandListener, array, 5).c();
            try {
                final NBTBase parse = MojangsonParser.parse(c);
                if (!(parse instanceof NBTTagCompound)) {
                    throw new CommandException("commands.setblock.tagError", new Object[] { "Not a valid tag" });
                }
                nbtTagCompound = (NBTTagCompound)parse;
                b2 = true;
            }
            catch (MojangsonParseException ex) {
                throw new CommandException("commands.setblock.tagError", new Object[] { ex.getMessage() });
            }
        }
        final Block type = world.getType(floor, floor2, floor3);
        if (type != b) {
            throw new CommandException("commands.testforblock.failed.tile", new Object[] { floor, floor2, floor3, type.getName(), b.getName() });
        }
        if (a > -1) {
            final int data = world.getData(floor, floor2, floor3);
            if (data != a) {
                throw new CommandException("commands.testforblock.failed.data", new Object[] { floor, floor2, floor3, data, a });
            }
        }
        if (b2) {
            final TileEntity tileEntity = world.getTileEntity(floor, floor2, floor3);
            if (tileEntity == null) {
                throw new CommandException("commands.testforblock.failed.tileEntity", new Object[] { floor, floor2, floor3 });
            }
            final NBTTagCompound nbttagcompound = new NBTTagCompound();
            tileEntity.b(nbttagcompound);
            if (!this.a(nbtTagCompound, nbttagcompound)) {
                throw new CommandException("commands.testforblock.failed.nbt", new Object[] { floor, floor2, floor3 });
            }
        }
        commandListener.sendMessage(new ChatMessage("commands.testforblock.success", new Object[] { floor, floor2, floor3 }));
    }
    
    public boolean a(final NBTBase nbtBase, final NBTBase object) {
        if (nbtBase == object) {
            return true;
        }
        if (nbtBase == null) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (!nbtBase.getClass().equals(object.getClass())) {
            return false;
        }
        if (nbtBase instanceof NBTTagCompound) {
            final NBTTagCompound nbtTagCompound = (NBTTagCompound)nbtBase;
            final NBTTagCompound nbtTagCompound2 = (NBTTagCompound)object;
            for (final String s : nbtTagCompound.c()) {
                if (!this.a(nbtTagCompound.get(s), nbtTagCompound2.get(s))) {
                    return false;
                }
            }
            return true;
        }
        return nbtBase.equals(object);
    }
    
    @Override
    public List tabComplete(final ICommandListener commandListener, final String[] array) {
        if (array.length == 4) {
            return CommandAbstract.a(array, Block.REGISTRY.keySet());
        }
        return null;
    }
}
