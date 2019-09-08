package net.minecraft.server.v1_7_R4;

public class ControllerJump
{
    private EntityInsentient a;
    private boolean b;
    
    public ControllerJump(final EntityInsentient a) {
        this.a = a;
    }
    
    public void a() {
        this.b = true;
    }
    
    public void b() {
        this.a.f(this.b);
        this.b = false;
    }
}
