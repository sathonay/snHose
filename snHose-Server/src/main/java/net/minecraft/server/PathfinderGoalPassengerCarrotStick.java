package net.minecraft.server;

public class PathfinderGoalPassengerCarrotStick extends PathfinderGoal
{
    private final EntityInsentient a;
    private final float b;
    private float c;
    private boolean d;
    private int e;
    private int f;
    
    public PathfinderGoalPassengerCarrotStick(final EntityInsentient a, final float b) {
        this.a = a;
        this.b = b;
        this.a(7);
    }
    
    @Override
    public void c() {
        this.c = 0.0f;
    }
    
    @Override
    public void d() {
        this.d = false;
        this.c = 0.0f;
    }
    
    @Override
    public boolean a() {
        return this.a.isAlive() && this.a.passenger != null && this.a.passenger instanceof EntityHuman && (this.d || this.a.bE());
    }
    
    @Override
    public void e() {
        final EntityHuman entityliving = (EntityHuman)this.a.passenger;
        final EntityCreature entityCreature = (EntityCreature)this.a;
        float n = MathHelper.g(entityliving.yaw - this.a.yaw) * 0.5f;
        if (n > 5.0f) {
            n = 5.0f;
        }
        if (n < -5.0f) {
            n = -5.0f;
        }
        this.a.yaw = MathHelper.g(this.a.yaw + n);
        if (this.c < this.b) {
            this.c += (this.b - this.c) * 0.01f;
        }
        if (this.c > this.b) {
            this.c = this.b;
        }
        final int floor = MathHelper.floor(this.a.locX);
        final int floor2 = MathHelper.floor(this.a.locY);
        final int floor3 = MathHelper.floor(this.a.locZ);
        float c = this.c;
        if (this.d) {
            if (this.e++ > this.f) {
                this.d = false;
            }
            c += c * 1.15f * MathHelper.sin(this.e / this.f * 3.1415927f);
        }
        float n2 = 0.91f;
        if (this.a.onGround) {
            n2 = this.a.world.getType(MathHelper.d(floor), MathHelper.d(floor2) - 1, MathHelper.d(floor3)).frictionFactor * 0.91f;
        }
        final float n3 = 0.16277136f / (n2 * n2 * n2);
        final float sin = MathHelper.sin(entityCreature.yaw * 3.1415927f / 180.0f);
        final float cos = MathHelper.cos(entityCreature.yaw * 3.1415927f / 180.0f);
        final float n4 = c * (entityCreature.bl() * n3 / Math.max(c, 1.0f));
        float var0 = -(n4 * sin);
        float var2 = n4 * cos;
        if (MathHelper.abs(var0) > MathHelper.abs(var2)) {
            if (var0 < 0.0f) {
                var0 -= this.a.width / 2.0f;
            }
            if (var0 > 0.0f) {
                var0 += this.a.width / 2.0f;
            }
            var2 = 0.0f;
        }
        else {
            var0 = 0.0f;
            if (var2 < 0.0f) {
                var2 -= this.a.width / 2.0f;
            }
            if (var2 > 0.0f) {
                var2 += this.a.width / 2.0f;
            }
        }
        final int floor4 = MathHelper.floor(this.a.locX + var0);
        final int floor5 = MathHelper.floor(this.a.locZ + var2);
        final PathPoint pathPoint = new PathPoint(MathHelper.d(this.a.width + 1.0f), MathHelper.d(this.a.length + entityliving.length + 1.0f), MathHelper.d(this.a.width + 1.0f));
        if (floor != floor4 || floor3 != floor5) {
            final Block type = this.a.world.getType(floor, floor2, floor3);
            if (!this.a(type) && (type.getMaterial() != Material.AIR || !this.a(this.a.world.getType(floor, floor2 - 1, floor3))) && Pathfinder.a(this.a, floor4, floor2, floor5, pathPoint, false, false, true) == 0 && Pathfinder.a(this.a, floor, floor2 + 1, floor3, pathPoint, false, false, true) == 1 && Pathfinder.a(this.a, floor4, floor2 + 1, floor5, pathPoint, false, false, true) == 1) {
                entityCreature.getControllerJump().a();
            }
        }
        if (!entityliving.abilities.canInstantlyBuild && this.c >= this.b * 0.5f && this.a.aI().nextFloat() < 0.006f && !this.d) {
            final ItemStack be = entityliving.be();
            if (be != null && be.getItem() == Items.CARROT_STICK) {
                be.damage(1, entityliving);
                if (be.count == 0) {
                    final ItemStack itemStack = new ItemStack(Items.FISHING_ROD);
                    itemStack.setTag(be.tag);
                    entityliving.inventory.items[entityliving.inventory.itemInHandIndex] = itemStack;
                }
            }
        }
        this.a.e(0.0f, c);
    }
    
    private boolean a(final Block block) {
        return block.b() == 10 || block instanceof BlockStepAbstract;
    }
    
    public boolean f() {
        return this.d;
    }
    
    public void g() {
        this.d = true;
        this.e = 0;
        this.f = this.a.aI().nextInt(841) + 140;
    }
    
    public boolean h() {
        return !this.f() && this.c > this.b * 0.3f;
    }
}
