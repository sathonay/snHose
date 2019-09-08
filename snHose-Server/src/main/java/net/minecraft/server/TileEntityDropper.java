package net.minecraft.server.v1_7_R4;

public class TileEntityDropper extends TileEntityDispenser
{
    @Override
    public String getInventoryName() {
        return this.k_() ? this.a : "container.dropper";
    }
}
