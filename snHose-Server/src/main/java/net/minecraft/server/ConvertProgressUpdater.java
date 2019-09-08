package net.minecraft.server.v1_7_R4;

public class ConvertProgressUpdater implements IProgressUpdate
{
    private long b;
    final /* synthetic */ MinecraftServer a;
    
    public ConvertProgressUpdater(final MinecraftServer a) {
        this.a = a;
        this.b = MinecraftServer.ar();
    }
    
    @Override
    public void a(final String s) {
    }
    
    @Override
    public void a(final int n) {
        if (MinecraftServer.ar() - this.b >= 1000L) {
            this.b = MinecraftServer.ar();
            MinecraftServer.getLogger().info("Converting... " + n + "%");
        }
    }
    
    @Override
    public void c(final String s) {
    }
}
