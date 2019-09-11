package net.minecraft.server;

public class PacketPlayOutScoreboardDisplayObjective extends Packet
{
    private int a;
    private String b;
    
    public PacketPlayOutScoreboardDisplayObjective() {
    }
    
    public PacketPlayOutScoreboardDisplayObjective(final int a, final ScoreboardObjective scoreboardObjective) {
        this.a = a;
        if (scoreboardObjective == null) {
            this.b = "";
        }
        else {
            this.b = scoreboardObjective.getName();
        }
    }
    
    @Override
    public void a(final PacketDataSerializer packetDataSerializer) {
        this.a = packetDataSerializer.readByte();
        this.b = packetDataSerializer.c(16);
    }
    
    @Override
    public void b(final PacketDataSerializer packetDataSerializer) {
        packetDataSerializer.writeByte(this.a);
        packetDataSerializer.a(this.b);
    }
    
    public void a(final PacketPlayOutListener packetPlayOutListener) {
        packetPlayOutListener.a(this);
    }
}
