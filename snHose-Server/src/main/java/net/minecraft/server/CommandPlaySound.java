package net.minecraft.server.v1_7_R4;

public class CommandPlaySound extends CommandAbstract
{
    @Override
    public String getCommand() {
        return "playsound";
    }
    
    @Override
    public int a() {
        return 2;
    }
    
    @Override
    public String c(final ICommandListener commandListener) {
        return "commands.playsound.usage";
    }
    
    @Override
    public void execute(final ICommandListener commandListener, final String[] array) {
        if (array.length < 2) {
            throw new ExceptionUsage(this.c(commandListener), new Object[0]);
        }
        int n = 0;
        final String s = array[n++];
        final EntityPlayer d = CommandAbstract.d(commandListener, array[n++]);
        double a = d.getChunkCoordinates().x;
        double a2 = d.getChunkCoordinates().y;
        double a3 = d.getChunkCoordinates().z;
        double a4 = 1.0;
        double a5 = 1.0;
        double a6 = 0.0;
        if (array.length > n) {
            a = CommandAbstract.a(commandListener, a, array[n++]);
        }
        if (array.length > n) {
            a2 = CommandAbstract.a(commandListener, a2, array[n++], 0, 0);
        }
        if (array.length > n) {
            a3 = CommandAbstract.a(commandListener, a3, array[n++]);
        }
        if (array.length > n) {
            a4 = CommandAbstract.a(commandListener, array[n++], 0.0, 3.4028234663852886E38);
        }
        if (array.length > n) {
            a5 = CommandAbstract.a(commandListener, array[n++], 0.0, 2.0);
        }
        if (array.length > n) {
            a6 = CommandAbstract.a(commandListener, array[n++], 0.0, 1.0);
        }
        if (d.f(a, a2, a3) > ((a4 > 1.0) ? (a4 * 16.0) : 16.0)) {
            if (a6 <= 0.0) {
                throw new CommandException("commands.playsound.playerTooFar", new Object[] { d.getName() });
            }
            final double n2 = a - d.locX;
            final double n3 = a2 - d.locY;
            final double n4 = a3 - d.locZ;
            final double sqrt = Math.sqrt(n2 * n2 + n3 * n3 + n4 * n4);
            double locX = d.locX;
            double locY = d.locY;
            double locZ = d.locZ;
            if (sqrt > 0.0) {
                locX += n2 / sqrt * 2.0;
                locY += n3 / sqrt * 2.0;
                locZ += n4 / sqrt * 2.0;
            }
            d.playerConnection.sendPacket(new PacketPlayOutNamedSoundEffect(s, locX, locY, locZ, (float)a6, (float)a5));
        }
        else {
            d.playerConnection.sendPacket(new PacketPlayOutNamedSoundEffect(s, a, a2, a3, (float)a4, (float)a5));
        }
        CommandAbstract.a(commandListener, this, "commands.playsound.success", s, d.getName());
    }
    
    @Override
    public boolean isListStart(final String[] array, final int n) {
        return n == 1;
    }
}
