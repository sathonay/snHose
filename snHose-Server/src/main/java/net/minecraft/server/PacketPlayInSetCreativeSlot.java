package net.minecraft.server.v1_7_R4;

public class PacketPlayInSetCreativeSlot extends Packet
{
    private int slot;
    private ItemStack b;
    
    public void a(final PacketPlayInListener packetPlayInListener) {
        packetPlayInListener.a(this);
    }
    
    @Override
    public void a(final PacketDataSerializer packetDataSerializer) {
        this.slot = packetDataSerializer.readShort();
        this.b = packetDataSerializer.c();
    }
    
    @Override
    public void b(final PacketDataSerializer packetDataSerializer) {
        packetDataSerializer.writeShort(this.slot);
        packetDataSerializer.a(this.b);
    }
    
    public int c() {
        return this.slot;
    }
    
    public ItemStack getItemStack() {
        return this.b;
    }
}
