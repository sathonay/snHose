package net.minecraft.server.v1_7_R4;

public class SecondaryWorldData extends WorldData
{
    private final WorldData a;
    
    public SecondaryWorldData(final WorldData a) {
        this.a = a;
    }
    
    @Override
    public NBTTagCompound a() {
        return this.a.a();
    }
    
    @Override
    public NBTTagCompound a(final NBTTagCompound nbtTagCompound) {
        return this.a.a(nbtTagCompound);
    }
    
    @Override
    public long getSeed() {
        return this.a.getSeed();
    }
    
    @Override
    public int c() {
        return this.a.c();
    }
    
    @Override
    public int d() {
        return this.a.d();
    }
    
    @Override
    public int e() {
        return this.a.e();
    }
    
    @Override
    public long getTime() {
        return this.a.getTime();
    }
    
    @Override
    public long getDayTime() {
        return this.a.getDayTime();
    }
    
    @Override
    public NBTTagCompound i() {
        return this.a.i();
    }
    
    @Override
    public int j() {
        return this.a.j();
    }
    
    @Override
    public String getName() {
        return this.a.getName();
    }
    
    @Override
    public int l() {
        return this.a.l();
    }
    
    @Override
    public boolean isThundering() {
        return this.a.isThundering();
    }
    
    @Override
    public int getThunderDuration() {
        return this.a.getThunderDuration();
    }
    
    @Override
    public boolean hasStorm() {
        return this.a.hasStorm();
    }
    
    @Override
    public int getWeatherDuration() {
        return this.a.getWeatherDuration();
    }
    
    @Override
    public EnumGamemode getGameType() {
        return this.a.getGameType();
    }
    
    @Override
    public void setTime(final long n) {
    }
    
    @Override
    public void setDayTime(final long n) {
    }
    
    @Override
    public void setSpawn(final int n, final int n2, final int n3) {
    }
    
    @Override
    public void setName(final String s) {
    }
    
    @Override
    public void e(final int n) {
    }
    
    @Override
    public void setThundering(final boolean b) {
    }
    
    @Override
    public void setThunderDuration(final int n) {
    }
    
    @Override
    public void setStorm(final boolean b) {
    }
    
    @Override
    public void setWeatherDuration(final int n) {
    }
    
    @Override
    public boolean shouldGenerateMapFeatures() {
        return this.a.shouldGenerateMapFeatures();
    }
    
    @Override
    public boolean isHardcore() {
        return this.a.isHardcore();
    }
    
    @Override
    public WorldType getType() {
        return this.a.getType();
    }
    
    @Override
    public void setType(final WorldType worldType) {
    }
    
    @Override
    public boolean allowCommands() {
        return this.a.allowCommands();
    }
    
    @Override
    public boolean isInitialized() {
        return this.a.isInitialized();
    }
    
    @Override
    public void d(final boolean b) {
    }
    
    @Override
    public GameRules getGameRules() {
        return this.a.getGameRules();
    }
}
