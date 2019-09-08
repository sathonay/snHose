package net.minecraft.server.v1_7_R4;

import java.util.*;

public abstract class EntityAnimal extends EntityAgeable implements IAnimal
{
    private int love;
    private int bq;
    private EntityHuman br;
    
    public EntityAnimal(final World world) {
        super(world);
    }
    
    @Override
    protected void bp() {
        if (this.getAge() != 0) {
            this.love = 0;
        }
        super.bp();
    }
    
    @Override
    public void e() {
        super.e();
        if (this.getAge() != 0) {
            this.love = 0;
        }
        if (this.love > 0) {
            --this.love;
            final String s = "heart";
            if (this.love % 10 == 0) {
                this.world.addParticle(s, this.locX + this.random.nextFloat() * this.width * 2.0f - this.width, this.locY + 0.5 + this.random.nextFloat() * this.length, this.locZ + this.random.nextFloat() * this.width * 2.0f - this.width, this.random.nextGaussian() * 0.02, this.random.nextGaussian() * 0.02, this.random.nextGaussian() * 0.02);
            }
        }
        else {
            this.bq = 0;
        }
    }
    
    @Override
    protected void a(final Entity entity, final float n) {
        if (entity instanceof EntityHuman) {
            if (n < 3.0f) {
                this.yaw = (float)(Math.atan2(entity.locZ - this.locZ, entity.locX - this.locX) * 180.0 / 3.1415927410125732) - 90.0f;
                this.bn = true;
            }
            final EntityHuman entityHuman = (EntityHuman)entity;
            if (entityHuman.bF() == null || !this.c(entityHuman.bF())) {
                this.target = null;
            }
        }
        else if (entity instanceof EntityAnimal) {
            final EntityAnimal entityAnimal = (EntityAnimal)entity;
            if (this.getAge() > 0 && entityAnimal.getAge() < 0) {
                if (n < 2.5) {
                    this.bn = true;
                }
            }
            else if (this.love > 0 && entityAnimal.love > 0) {
                if (entityAnimal.target == null) {
                    entityAnimal.target = this;
                }
                if (entityAnimal.target == this && n < 3.5) {
                    final EntityAnimal entityAnimal2 = entityAnimal;
                    ++entityAnimal2.love;
                    ++this.love;
                    ++this.bq;
                    if (this.bq % 4 == 0) {
                        this.world.addParticle("heart", this.locX + this.random.nextFloat() * this.width * 2.0f - this.width, this.locY + 0.5 + this.random.nextFloat() * this.length, this.locZ + this.random.nextFloat() * this.width * 2.0f - this.width, 0.0, 0.0, 0.0);
                    }
                    if (this.bq == 60) {
                        this.b((EntityAnimal)entity);
                    }
                }
                else {
                    this.bq = 0;
                }
            }
            else {
                this.bq = 0;
                this.target = null;
            }
        }
    }
    
    private void b(final EntityAnimal entityAnimal) {
        final EntityAgeable child = this.createChild(entityAnimal);
        if (child != null) {
            if (this.br == null && entityAnimal.cd() != null) {
                this.br = entityAnimal.cd();
            }
            if (this.br != null) {
                this.br.a(StatisticList.x);
                if (this instanceof EntityCow) {
                    this.br.a(AchievementList.H);
                }
            }
            this.setAge(6000);
            entityAnimal.setAge(6000);
            this.love = 0;
            this.bq = 0;
            this.target = null;
            entityAnimal.target = null;
            entityAnimal.bq = 0;
            entityAnimal.love = 0;
            child.setAge(-24000);
            child.setPositionRotation(this.locX, this.locY, this.locZ, this.yaw, this.pitch);
            for (int i = 0; i < 7; ++i) {
                this.world.addParticle("heart", this.locX + this.random.nextFloat() * this.width * 2.0f - this.width, this.locY + 0.5 + this.random.nextFloat() * this.length, this.locZ + this.random.nextFloat() * this.width * 2.0f - this.width, this.random.nextGaussian() * 0.02, this.random.nextGaussian() * 0.02, this.random.nextGaussian() * 0.02);
            }
            this.world.addEntity(child);
        }
    }
    
    @Override
    public boolean damageEntity(final DamageSource damagesource, final float f) {
        if (this.isInvulnerable()) {
            return false;
        }
        this.bo = 60;
        if (!this.bk()) {
            final AttributeInstance attributeInstance = this.getAttributeInstance(GenericAttributes.d);
            if (attributeInstance.a(EntityAnimal.h) == null) {
                attributeInstance.a(EntityAnimal.i);
            }
        }
        this.target = null;
        this.love = 0;
        return super.damageEntity(damagesource, f);
    }
    
    @Override
    public float a(final int n, final int j, final int n2) {
        if (this.world.getType(n, j - 1, n2) == Blocks.GRASS) {
            return 10.0f;
        }
        return this.world.n(n, j, n2) - 0.5f;
    }
    
    @Override
    public void b(final NBTTagCompound nbttagcompound) {
        super.b(nbttagcompound);
        nbttagcompound.setInt("InLove", this.love);
    }
    
    @Override
    public void a(final NBTTagCompound nbttagcompound) {
        super.a(nbttagcompound);
        this.love = nbttagcompound.getInt("InLove");
    }
    
    @Override
    protected Entity findTarget() {
        if (this.bo > 0) {
            return null;
        }
        final float n = 8.0f;
        if (this.love > 0) {
            final List a = this.world.a(this.getClass(), this.boundingBox.grow(n, n, n));
            for (int i = 0; i < a.size(); ++i) {
                final EntityAnimal entityAnimal = a.get(i);
                if (entityAnimal != this && entityAnimal.love > 0) {
                    return entityAnimal;
                }
            }
        }
        else if (this.getAge() == 0) {
            final List a2 = this.world.a(EntityHuman.class, this.boundingBox.grow(n, n, n));
            for (int j = 0; j < a2.size(); ++j) {
                final EntityHuman entityHuman = a2.get(j);
                if (entityHuman.bF() != null && this.c(entityHuman.bF())) {
                    return entityHuman;
                }
            }
        }
        else if (this.getAge() > 0) {
            final List a3 = this.world.a(this.getClass(), this.boundingBox.grow(n, n, n));
            for (int k = 0; k < a3.size(); ++k) {
                final EntityAnimal entityAnimal2 = a3.get(k);
                if (entityAnimal2 != this && entityAnimal2.getAge() < 0) {
                    return entityAnimal2;
                }
            }
        }
        return null;
    }
    
    @Override
    public boolean canSpawn() {
        final int floor = MathHelper.floor(this.locX);
        final int floor2 = MathHelper.floor(this.boundingBox.b);
        final int floor3 = MathHelper.floor(this.locZ);
        return this.world.getType(floor, floor2 - 1, floor3) == Blocks.GRASS && this.world.j(floor, floor2, floor3) > 8 && super.canSpawn();
    }
    
    @Override
    public int q() {
        return 120;
    }
    
    @Override
    protected boolean isTypeNotPersistent() {
        return false;
    }
    
    @Override
    protected int getExpValue(final EntityHuman entityHuman) {
        return 1 + this.world.random.nextInt(3);
    }
    
    public boolean c(final ItemStack itemStack) {
        return itemStack.getItem() == Items.WHEAT;
    }
    
    @Override
    public boolean a(final EntityHuman entityhuman) {
        final ItemStack itemInHand = entityhuman.inventory.getItemInHand();
        if (itemInHand != null && this.c(itemInHand) && this.getAge() == 0 && this.love <= 0) {
            if (!entityhuman.abilities.canInstantlyBuild) {
                final ItemStack itemStack = itemInHand;
                --itemStack.count;
                if (itemInHand.count <= 0) {
                    entityhuman.inventory.setItem(entityhuman.inventory.itemInHandIndex, null);
                }
            }
            this.f(entityhuman);
            return true;
        }
        return super.a(entityhuman);
    }
    
    public void f(final EntityHuman br) {
        this.love = 600;
        this.br = br;
        this.target = null;
        this.world.broadcastEntityEffect(this, (byte)18);
    }
    
    public EntityHuman cd() {
        return this.br;
    }
    
    public boolean ce() {
        return this.love > 0;
    }
    
    public void cf() {
        this.love = 0;
    }
    
    public boolean mate(final EntityAnimal entityAnimal) {
        return entityAnimal != this && entityAnimal.getClass() == this.getClass() && this.ce() && entityAnimal.ce();
    }
}
