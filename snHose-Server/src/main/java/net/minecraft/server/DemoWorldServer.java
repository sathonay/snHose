package net.minecraft.server;

public class DemoWorldServer extends WorldServer
{
    private static final long J;
    public static final WorldSettings a;
    
    public DemoWorldServer(final MinecraftServer minecraftServer, final IDataManager dataManager, final String s, final int n, final MethodProfiler methodProfiler) {
        super(minecraftServer, dataManager, s, n, DemoWorldServer.a, methodProfiler);
    }
    
    static {
        J = "North Carolina".hashCode();
        a = new WorldSettings(DemoWorldServer.J, EnumGamemode.SURVIVAL, true, false, WorldType.NORMAL).a();
    }
}
