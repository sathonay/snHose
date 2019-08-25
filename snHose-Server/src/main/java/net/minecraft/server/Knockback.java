package net.minecraft.server;

public class Knockback {
    private final double sprintForce;
    private final double sprintHeight;
    private final double friction;
    private final double maxHeight;
    private final double force;

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
