package net.minecraft.server.v1_7_R4;

public class BlockNote extends BlockContainer
{
    public BlockNote() {
        super(Material.WOOD);
        this.a(CreativeModeTab.d);
    }
    
    @Override
    public void doPhysics(final World world, final int i, final int j, final int k, final Block block) {
        final boolean blockIndirectlyPowered = world.isBlockIndirectlyPowered(i, j, k);
        final TileEntityNote tileEntityNote = (TileEntityNote)world.getTileEntity(i, j, k);
        if (tileEntityNote != null && tileEntityNote.i != blockIndirectlyPowered) {
            if (blockIndirectlyPowered) {
                tileEntityNote.play(world, i, j, k);
            }
            tileEntityNote.i = blockIndirectlyPowered;
        }
    }
    
    @Override
    public boolean interact(final World world, final int n, final int n2, final int n3, final EntityHuman entityHuman, final int n4, final float n5, final float n6, final float n7) {
        if (world.isStatic) {
            return true;
        }
        final TileEntityNote tileEntityNote = (TileEntityNote)world.getTileEntity(n, n2, n3);
        if (tileEntityNote != null) {
            tileEntityNote.a();
            tileEntityNote.play(world, n, n2, n3);
        }
        return true;
    }
    
    @Override
    public void attack(final World world, final int n, final int n2, final int n3, final EntityHuman entityHuman) {
        if (world.isStatic) {
            return;
        }
        final TileEntityNote tileEntityNote = (TileEntityNote)world.getTileEntity(n, n2, n3);
        if (tileEntityNote != null) {
            tileEntityNote.play(world, n, n2, n3);
        }
    }
    
    @Override
    public TileEntity a(final World world, final int n) {
        return new TileEntityNote();
    }
    
    @Override
    public boolean a(final World world, final int n, final int n2, final int n3, final int n4, final int n5) {
        final float f1 = (float)Math.pow(2.0, (n5 - 12) / 12.0);
        String s = "harp";
        if (n4 == 1) {
            s = "bd";
        }
        if (n4 == 2) {
            s = "snare";
        }
        if (n4 == 3) {
            s = "hat";
        }
        if (n4 == 4) {
            s = "bassattack";
        }
        world.makeSound(n + 0.5, n2 + 0.5, n3 + 0.5, "note." + s, 3.0f, f1);
        world.addParticle("note", n + 0.5, n2 + 1.2, n3 + 0.5, n5 / 24.0, 0.0, 0.0);
        return true;
    }
}
