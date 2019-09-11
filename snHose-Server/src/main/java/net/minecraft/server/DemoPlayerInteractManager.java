package net.minecraft.server;

public class DemoPlayerInteractManager extends PlayerInteractManager
{
    private boolean c;
    private boolean d;
    private int e;
    private int f;
    
    public DemoPlayerInteractManager(final World world) {
        super(world);
    }
    
    @Override
    public void a() {
        super.a();
        ++this.f;
        final long time = this.world.getTime();
        final long n = time / 24000L + 1L;
        if (!this.c && this.f > 20) {
            this.c = true;
            this.player.playerConnection.sendPacket(new PacketPlayOutGameStateChange(5, 0.0f));
        }
        this.d = (time > 120500L);
        if (this.d) {
            ++this.e;
        }
        if (time % 24000L == 500L) {
            if (n <= 6L) {
                this.player.sendMessage(new ChatMessage("demo.day." + n, new Object[0]));
            }
        }
        else if (n == 1L) {
            if (time == 100L) {
                this.player.playerConnection.sendPacket(new PacketPlayOutGameStateChange(5, 101.0f));
            }
            else if (time == 175L) {
                this.player.playerConnection.sendPacket(new PacketPlayOutGameStateChange(5, 102.0f));
            }
            else if (time == 250L) {
                this.player.playerConnection.sendPacket(new PacketPlayOutGameStateChange(5, 103.0f));
            }
        }
        else if (n == 5L && time % 24000L == 22000L) {
            this.player.sendMessage(new ChatMessage("demo.day.warning", new Object[0]));
        }
    }
    
    private void e() {
        if (this.e > 100) {
            this.player.sendMessage(new ChatMessage("demo.reminder", new Object[0]));
            this.e = 0;
        }
    }
    
    @Override
    public void dig(final int i, final int j, final int k, final int l) {
        if (this.d) {
            this.e();
            return;
        }
        super.dig(i, j, k, l);
    }
    
    @Override
    public void a(final int i, final int j, final int k) {
        if (this.d) {
            return;
        }
        super.a(i, j, k);
    }
    
    @Override
    public boolean breakBlock(final int i, final int j, final int k) {
        return !this.d && super.breakBlock(i, j, k);
    }
    
    @Override
    public boolean useItem(final EntityHuman entityhuman, final World world, final ItemStack itemstack) {
        if (this.d) {
            this.e();
            return false;
        }
        return super.useItem(entityhuman, world, itemstack);
    }
    
    @Override
    public boolean interact(final EntityHuman entityhuman, final World world, final ItemStack itemstack, final int i, final int j, final int k, final int l, final float f, final float f2, final float f3) {
        if (this.d) {
            this.e();
            return false;
        }
        return super.interact(entityhuman, world, itemstack, i, j, k, l, f, f2, f3);
    }
}
