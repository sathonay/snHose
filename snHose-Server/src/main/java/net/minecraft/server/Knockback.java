package net.minecraft.server;

public class Knockback {
    private final double sprintForce = 0.5D;
    private final double sprintHeight = 0.1D;
    private final double friction = 2.0D;
    private final double maxHeight = 0.4D;
    private final double force = 0.4D;
    
    public Knockback() {}
    public Knockback(final double sprintForce, final double sprintHeight, final double friction, final double maxHeight, final double force) {
        this.sprintForce = sprintForce;
        this.sprintHeight = sprintHeight;
        this.friction = friction;
        this.maxHeight = maxHeight;
        this.force = force;
    }
    
    public double getSprintForce() {
        return this.sprintForce;
    }
    
    public double getSprintHeight() {
        return this.sprintHeight;
    }
    
    public double getFriction() {
        return this.friction;
    }
    
    public double getMaxHeight() {
        return this.maxHeight;
    }
    
    public double getForce() {
        return this.force;
    }
}
