package net.minecraft.server;

class ContainerSheepBreed extends Container
{
    final /* synthetic */ EntitySheep a;
    
    ContainerSheepBreed(final EntitySheep a) {
        this.a = a;
    }
    
    @Override
    public boolean a(final EntityHuman entityHuman) {
        return false;
    }
}
