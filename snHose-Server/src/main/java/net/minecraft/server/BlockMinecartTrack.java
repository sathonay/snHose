package net.minecraft.server.v1_7_R4;

public class BlockMinecartTrack extends BlockMinecartTrackAbstract
{
    protected BlockMinecartTrack() {
        super(false);
    }
    
    @Override
    protected void a(final World world, final int i, final int j, final int k, final int n, final int n2, final Block block) {
        if (block.isPowerSource() && new MinecartTrackLogic(this, world, i, j, k).a() == 3) {
            this.a(world, i, j, k, false);
        }
    }
}
