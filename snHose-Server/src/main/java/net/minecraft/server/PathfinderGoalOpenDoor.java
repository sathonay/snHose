package net.minecraft.server;

public class PathfinderGoalOpenDoor extends PathfinderGoalDoorInteract
{
    boolean i;
    int j;
    
    public PathfinderGoalOpenDoor(final EntityInsentient a, final boolean i) {
        super(a);
        this.a = a;
        this.i = i;
    }
    
    @Override
    public boolean b() {
        return this.i && this.j > 0 && super.b();
    }
    
    @Override
    public void c() {
        this.j = 20;
        this.e.setDoor(this.a.world, this.b, this.c, this.d, true);
    }
    
    @Override
    public void d() {
        if (this.i) {
            this.e.setDoor(this.a.world, this.b, this.c, this.d, false);
        }
    }
    
    @Override
    public void e() {
        --this.j;
        super.e();
    }
}
