package net.minecraft.server;

public class Knockback {
    private double sprintForce = 0.5D;
    private double sprintHeight = 0.1D;
    private double friction = 2.0D;
    private double maxHeight = 0.4D;
    private double force = 0.4D;
    
    public Knockback(double sprintForce, double sprintHeight, double friction, double maxHeight, double force) {
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
