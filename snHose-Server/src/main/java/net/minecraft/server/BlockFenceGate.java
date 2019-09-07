//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package net.minecraft.server;

public class BlockFenceGate extends BlockDirectional {
    public BlockFenceGate() {
        super(Material.WOOD);
        this.a(CreativeModeTab.d);
    }

    public boolean canPlace(World var1, int var2, int var3, int var4) {
        return !var1.getType(var2, var3 - 1, var4).getMaterial().isBuildable() ? false : super.canPlace(var1, var2, var3, var4);
    }

    public AxisAlignedBB a(World var1, int var2, int var3, int var4) {
        int var5 = var1.getData(var2, var3, var4);
        if (b(var5)) {
            return null;
        } else {
            return var5 != 2 && var5 != 0 ? AxisAlignedBB.a((double)((float)var2 + 0.375F), (double)var3, (double)var4, (double)((float)var2 + 0.625F), (double)((float)var3 + 1.5F), (double)(var4 + 1)) : AxisAlignedBB.a((double)var2, (double)var3, (double)((float)var4 + 0.375F), (double)(var2 + 1), (double)((float)var3 + 1.5F), (double)((float)var4 + 0.625F));
        }
    }

    public void updateShape(IBlockAccess var1, int var2, int var3, int var4) {
        int var5 = l(var1.getData(var2, var3, var4));
        if (var5 != 2 && var5 != 0) {
            this.a(0.375F, 0.0F, 0.0F, 0.625F, 1.0F, 1.0F);
        } else {
            this.a(0.0F, 0.0F, 0.375F, 1.0F, 1.0F, 0.625F);
        }

    }

    public boolean c() {
        return false;
    }

    public boolean d() {
        return false;
    }

    public boolean b(IBlockAccess var1, int var2, int var3, int var4) {
        return b(var1.getData(var2, var3, var4));
    }

    public int b() {
        return 21;
    }

    public void postPlace(World var1, int var2, int var3, int var4, EntityLiving var5, ItemStack var6) {
        int var7 = (MathHelper.floor((double)(var5.yaw * 4.0F / 360.0F) + 0.5D) & 3) % 4;
        var1.setData(var2, var3, var4, var7, 2);
    }

    public boolean interact(World var1, int var2, int var3, int var4, EntityHuman var5, int var6, float var7, float var8, float var9) {
        int var10 = var1.getData(var2, var3, var4);
        if (b(var10)) {
            var1.setData(var2, var3, var4, var10 & -5, 2);
        } else {
            int var11 = (MathHelper.floor((double)(var5.yaw * 4.0F / 360.0F) + 0.5D) & 3) % 4;
            int var12 = l(var10);
            if (var12 == (var11 + 2) % 4) {
                var10 = var11;
            }

            var1.setData(var2, var3, var4, var10 | 4, 2);
        }

        var1.a(var5, 2001, var2, var3, var4, 0);
        return true;
    }

    public void doPhysics(World var1, int var2, int var3, int var4, Block var5) {
        if (!var1.isStatic) {
            int var6 = var1.getData(var2, var3, var4);
            boolean var7 = var1.isBlockIndirectlyPowered(var2, var3, var4);
            if (var7 || var5.isPowerSource()) {
                if (var7 && !b(var6)) {
                    var1.setData(var2, var3, var4, var6 | 4, 2);
                    var1.a((EntityHuman)null, 1003, var2, var3, var4, 0);
                } else if (!var7 && b(var6)) {
                    var1.setData(var2, var3, var4, var6 & -5, 2);
                    var1.a((EntityHuman)null, 1003, var2, var3, var4, 0);
                }
            }

        }
    }

    public static boolean b(int var0) {
        return (var0 & 4) != 0;
    }
}
