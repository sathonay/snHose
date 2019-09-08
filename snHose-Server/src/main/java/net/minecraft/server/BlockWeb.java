package net.minecraft.server.v1_7_R4;

import java.util.*;

public class BlockWeb extends Block
{
    public BlockWeb() {
        super(Material.WEB);
        this.a(CreativeModeTab.c);
    }
    
    @Override
    public void a(final World world, final int n, final int n2, final int n3, final Entity entity) {
        entity.as();
    }
    
    @Override
    public boolean c() {
        return false;
    }
    
    @Override
    public AxisAlignedBB a(final World world, final int n, final int n2, final int n3) {
        return null;
    }
    
    @Override
    public int b() {
        return 1;
    }
    
    @Override
    public boolean d() {
        return false;
    }
    
    @Override
    public Item getDropType(final int n, final Random random, final int n2) {
        return Items.STRING;
    }
    
    @Override
    protected boolean E() {
        return true;
    }
}
