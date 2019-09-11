package net.minecraft.server;

public class EntityMinecartCommandBlock extends EntityMinecartAbstract
{
    private final CommandBlockListenerAbstract a;
    private int b;
    
    public EntityMinecartCommandBlock(final World world) {
        super(world);
        this.a = new EntityMinecartCommandBlockListener(this);
        this.b = 0;
    }
    
    public EntityMinecartCommandBlock(final World world, final double d0, final double d2, final double d3) {
        super(world, d0, d2, d3);
        this.a = new EntityMinecartCommandBlockListener(this);
        this.b = 0;
    }
    
    @Override
    protected void c() {
        super.c();
        this.getDataWatcher().a(23, "");
        this.getDataWatcher().a(24, "");
    }
    
    @Override
    protected void a(final NBTTagCompound nbtTagCompound) {
        super.a(nbtTagCompound);
        this.a.b(nbtTagCompound);
        this.getDataWatcher().watch(23, this.getCommandBlock().getCommand());
        this.getDataWatcher().watch(24, ChatSerializer.a(this.getCommandBlock().h()));
    }
    
    @Override
    protected void b(final NBTTagCompound nbtTagCompound) {
        super.b(nbtTagCompound);
        this.a.a(nbtTagCompound);
    }
    
    @Override
    public int m() {
        return 6;
    }
    
    @Override
    public Block o() {
        return Blocks.COMMAND;
    }
    
    public CommandBlockListenerAbstract getCommandBlock() {
        return this.a;
    }
    
    @Override
    public void a(final int n, final int n2, final int n3, final boolean b) {
        if (b && this.ticksLived - this.b >= 4) {
            this.getCommandBlock().a(this.world);
            this.b = this.ticksLived;
        }
    }
    
    @Override
    public boolean c(final EntityHuman entityhuman) {
        if (this.world.isStatic) {
            entityhuman.a(this.getCommandBlock());
        }
        return super.c(entityhuman);
    }
    
    @Override
    public void i(final int i) {
        super.i(i);
        if (i == 24) {
            try {
                this.a.b(ChatSerializer.a(this.getDataWatcher().getString(24)));
            }
            catch (Throwable t) {}
        }
        else if (i == 23) {
            this.a.setCommand(this.getDataWatcher().getString(23));
        }
    }
}
