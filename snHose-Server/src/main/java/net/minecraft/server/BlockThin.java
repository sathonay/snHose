package net.minecraft.server.v1_7_R4;

import java.util.*;

public class BlockThin extends Block
{
    private final String a;
    private final boolean b;
    private final String M;
    
    protected BlockThin(final String m, final String a, final Material material, final boolean b) {
        super(material);
        this.a = a;
        this.b = b;
        this.M = m;
        this.a(CreativeModeTab.c);
    }
    
    @Override
    public Item getDropType(final int i, final Random random, final int j) {
        if (!this.b) {
            return null;
        }
        return super.getDropType(i, random, j);
    }
    
    @Override
    public boolean c() {
        return false;
    }
    
    @Override
    public boolean d() {
        return false;
    }
    
    @Override
    public int b() {
        return (this.material == Material.SHATTERABLE) ? 41 : 18;
    }
    
    @Override
    public void a(final World world, final int n, final int n2, final int n3, final AxisAlignedBB axisAlignedBB, final List list, final Entity entity) {
        final boolean a = this.a(world.getType(n, n2, n3 - 1));
        final boolean a2 = this.a(world.getType(n, n2, n3 + 1));
        final boolean a3 = this.a(world.getType(n - 1, n2, n3));
        final boolean a4 = this.a(world.getType(n + 1, n2, n3));
        if ((a3 && a4) || (!a3 && !a4 && !a && !a2)) {
            this.a(0.0f, 0.0f, 0.4375f, 1.0f, 1.0f, 0.5625f);
            super.a(world, n, n2, n3, axisAlignedBB, list, entity);
        }
        else if (a3 && !a4) {
            this.a(0.0f, 0.0f, 0.4375f, 0.5f, 1.0f, 0.5625f);
            super.a(world, n, n2, n3, axisAlignedBB, list, entity);
        }
        else if (!a3 && a4) {
            this.a(0.5f, 0.0f, 0.4375f, 1.0f, 1.0f, 0.5625f);
            super.a(world, n, n2, n3, axisAlignedBB, list, entity);
        }
        if ((a && a2) || (!a3 && !a4 && !a && !a2)) {
            this.a(0.4375f, 0.0f, 0.0f, 0.5625f, 1.0f, 1.0f);
            super.a(world, n, n2, n3, axisAlignedBB, list, entity);
        }
        else if (a && !a2) {
            this.a(0.4375f, 0.0f, 0.0f, 0.5625f, 1.0f, 0.5f);
            super.a(world, n, n2, n3, axisAlignedBB, list, entity);
        }
        else if (!a && a2) {
            this.a(0.4375f, 0.0f, 0.5f, 0.5625f, 1.0f, 1.0f);
            super.a(world, n, n2, n3, axisAlignedBB, list, entity);
        }
    }
    
    @Override
    public void g() {
        this.a(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
    }
    
    @Override
    public void updateShape(final IBlockAccess blockAccess, final int n, final int n2, final int n3) {
        float f = 0.4375f;
        float f2 = 0.5625f;
        float f3 = 0.4375f;
        float f4 = 0.5625f;
        final boolean a = this.a(blockAccess.getType(n, n2, n3 - 1));
        final boolean a2 = this.a(blockAccess.getType(n, n2, n3 + 1));
        final boolean a3 = this.a(blockAccess.getType(n - 1, n2, n3));
        final boolean a4 = this.a(blockAccess.getType(n + 1, n2, n3));
        if ((a3 && a4) || (!a3 && !a4 && !a && !a2)) {
            f = 0.0f;
            f2 = 1.0f;
        }
        else if (a3 && !a4) {
            f = 0.0f;
        }
        else if (!a3 && a4) {
            f2 = 1.0f;
        }
        if ((a && a2) || (!a3 && !a4 && !a && !a2)) {
            f3 = 0.0f;
            f4 = 1.0f;
        }
        else if (a && !a2) {
            f3 = 0.0f;
        }
        else if (!a && a2) {
            f4 = 1.0f;
        }
        this.a(f, 0.0f, f3, f2, 1.0f, f4);
    }
    
    public final boolean a(final Block block) {
        return block.j() || block == this || block == Blocks.GLASS || block == Blocks.STAINED_GLASS || block == Blocks.STAINED_GLASS_PANE || block instanceof BlockThin;
    }
    
    @Override
    protected boolean E() {
        return true;
    }
    
    @Override
    protected ItemStack j(final int j) {
        return new ItemStack(Item.getItemOf(this), 1, j);
    }
}
