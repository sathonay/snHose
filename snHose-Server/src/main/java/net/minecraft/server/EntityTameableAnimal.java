package net.minecraft.server;

import java.util.*;

public abstract class EntityTameableAnimal extends EntityAnimal implements EntityOwnable
{
    protected PathfinderGoalSit bp;
    
    public EntityTameableAnimal(final World world) {
        super(world);
        this.bp = new PathfinderGoalSit(this);
    }
    
    @Override
    protected void c() {
        super.c();
        this.datawatcher.a(16, (byte)0);
        this.datawatcher.a(17, "");
    }
    
    @Override
    public void b(final NBTTagCompound nbtTagCompound) {
        super.b(nbtTagCompound);
        if (this.getOwnerUUID() == null) {
            nbtTagCompound.setString("OwnerUUID", "");
        }
        else {
            nbtTagCompound.setString("OwnerUUID", this.getOwnerUUID());
        }
        nbtTagCompound.setBoolean("Sitting", this.isSitting());
    }
    
    @Override
    public void a(final NBTTagCompound nbtTagCompound) {
        super.a(nbtTagCompound);
        String ownerUUID;
        if (nbtTagCompound.hasKeyOfType("OwnerUUID", 8)) {
            ownerUUID = nbtTagCompound.getString("OwnerUUID");
        }
        else {
            ownerUUID = NameReferencingFileConverter.a(nbtTagCompound.getString("Owner"));
        }
        if (ownerUUID.length() > 0) {
            this.setOwnerUUID(ownerUUID);
            this.setTamed(true);
        }
        this.bp.setSitting(nbtTagCompound.getBoolean("Sitting"));
        this.setSitting(nbtTagCompound.getBoolean("Sitting"));
    }
    
    protected void i(final boolean b) {
        String s = "heart";
        if (!b) {
            s = "smoke";
        }
        for (int i = 0; i < 7; ++i) {
            this.world.addParticle(s, this.locX + this.random.nextFloat() * this.width * 2.0f - this.width, this.locY + 0.5 + this.random.nextFloat() * this.length, this.locZ + this.random.nextFloat() * this.width * 2.0f - this.width, this.random.nextGaussian() * 0.02, this.random.nextGaussian() * 0.02, this.random.nextGaussian() * 0.02);
        }
    }
    
    public boolean isTamed() {
        return (this.datawatcher.getByte(16) & 0x4) != 0x0;
    }
    
    public void setTamed(final boolean b) {
        final byte byte1 = this.datawatcher.getByte(16);
        if (b) {
            this.datawatcher.watch(16, (byte)(byte1 | 0x4));
        }
        else {
            this.datawatcher.watch(16, (byte)(byte1 & 0xFFFFFFFB));
        }
    }
    
    public boolean isSitting() {
        return (this.datawatcher.getByte(16) & 0x1) != 0x0;
    }
    
    public void setSitting(final boolean b) {
        final byte byte1 = this.datawatcher.getByte(16);
        if (b) {
            this.datawatcher.watch(16, (byte)(byte1 | 0x1));
        }
        else {
            this.datawatcher.watch(16, (byte)(byte1 & 0xFFFFFFFE));
        }
    }
    
    @Override
    public String getOwnerUUID() {
        return this.datawatcher.getString(17);
    }
    
    public void setOwnerUUID(final String object) {
        this.datawatcher.watch(17, object);
    }
    
    @Override
    public EntityLiving getOwner() {
        try {
            final UUID fromString = UUID.fromString(this.getOwnerUUID());
            if (fromString == null) {
                return null;
            }
            return this.world.a(fromString);
        }
        catch (IllegalArgumentException ex) {
            return null;
        }
    }
    
    public boolean e(final EntityLiving entityLiving) {
        return entityLiving == this.getOwner();
    }
    
    public PathfinderGoalSit getGoalSit() {
        return this.bp;
    }
    
    public boolean a(final EntityLiving entityLiving, final EntityLiving entityLiving2) {
        return true;
    }
    
    @Override
    public ScoreboardTeamBase getScoreboardTeam() {
        if (this.isTamed()) {
            final EntityLiving owner = this.getOwner();
            if (owner != null) {
                return owner.getScoreboardTeam();
            }
        }
        return super.getScoreboardTeam();
    }
    
    @Override
    public boolean c(final EntityLiving entityLiving) {
        if (this.isTamed()) {
            final EntityLiving owner = this.getOwner();
            if (entityLiving == owner) {
                return true;
            }
            if (owner != null) {
                return owner.c(entityLiving);
            }
        }
        return super.c(entityLiving);
    }
}
