package net.minecraft.server.v1_7_R4;

public class PathfinderGoalJumpOnBlock extends PathfinderGoal
{
    private final EntityOcelot a;
    private final double b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    
    public PathfinderGoalJumpOnBlock(final EntityOcelot a, final double b) {
        this.a = a;
        this.b = b;
        this.a(5);
    }
    
    @Override
    public boolean a() {
        return this.a.isTamed() && !this.a.isSitting() && this.a.aI().nextDouble() <= 0.006500000134110451 && this.f();
    }
    
    @Override
    public boolean b() {
        return this.c <= this.e && this.d <= 60 && this.a(this.a.world, this.f, this.g, this.h);
    }
    
    @Override
    public void c() {
        this.a.getNavigation().a(this.f + 0.5, this.g + 1, this.h + 0.5, this.b);
        this.c = 0;
        this.d = 0;
        this.e = this.a.aI().nextInt(this.a.aI().nextInt(1200) + 1200) + 1200;
        this.a.getGoalSit().setSitting(false);
    }
    
    @Override
    public void d() {
        this.a.setSitting(false);
    }
    
    @Override
    public void e() {
        ++this.c;
        this.a.getGoalSit().setSitting(false);
        if (this.a.e(this.f, this.g + 1, this.h) > 1.0) {
            this.a.setSitting(false);
            this.a.getNavigation().a(this.f + 0.5, this.g + 1, this.h + 0.5, this.b);
            ++this.d;
        }
        else if (!this.a.isSitting()) {
            this.a.setSitting(true);
        }
        else {
            --this.d;
        }
    }
    
    private boolean f() {
        final int g = (int)this.a.locY;
        double n = 2.147483647E9;
        for (int n2 = (int)this.a.locX - 8; n2 < this.a.locX + 8.0; ++n2) {
            for (int n3 = (int)this.a.locZ - 8; n3 < this.a.locZ + 8.0; ++n3) {
                if (this.a(this.a.world, n2, g, n3) && this.a.world.isEmpty(n2, g + 1, n3)) {
                    final double e = this.a.e(n2, g, n3);
                    if (e < n) {
                        this.f = n2;
                        this.g = g;
                        this.h = n3;
                        n = e;
                    }
                }
            }
        }
        return n < 2.147483647E9;
    }
    
    private boolean a(final World world, final int i, final int j, final int k) {
        final Block type = world.getType(i, j, k);
        final int data = world.getData(i, j, k);
        if (type == Blocks.CHEST) {
            if (((TileEntityChest)world.getTileEntity(i, j, k)).o < 1) {
                return true;
            }
        }
        else {
            if (type == Blocks.BURNING_FURNACE) {
                return true;
            }
            if (type == Blocks.BED && !BlockBed.b(data)) {
                return true;
            }
        }
        return false;
    }
}
