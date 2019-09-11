package net.minecraft.server;

public class TileEntityDropper extends TileEntityDispenser
{
    @Override
    public String getInventoryName() {
        return this.k_() ? this.a : "container.dropper";
    }
}
