package net.minecraft.server;

public class RecipesWeapons
{
    private String[][] a;
    private Object[][] b;
    
    public RecipesWeapons() {
        this.a = new String[][] { { "X", "X", "#" } };
        this.b = new Object[][] { { Blocks.WOOD, Blocks.COBBLESTONE, Items.IRON_INGOT, Items.DIAMOND, Items.GOLD_INGOT }, { Items.WOOD_SWORD, Items.STONE_SWORD, Items.IRON_SWORD, Items.DIAMOND_SWORD, Items.GOLD_SWORD } };
    }
    
    public void a(final CraftingManager craftingManager) {
        for (int i = 0; i < this.b[0].length; ++i) {
            final Object o = this.b[0][i];
            for (int j = 0; j < this.b.length - 1; ++j) {
                craftingManager.registerShapedRecipe(new ItemStack((Item)this.b[j + 1][i]), this.a[j], '#', Items.STICK, 'X', o);
            }
        }
        craftingManager.registerShapedRecipe(new ItemStack(Items.BOW, 1), " #X", "# X", " #X", 'X', Items.STRING, '#', Items.STICK);
        craftingManager.registerShapedRecipe(new ItemStack(Items.ARROW, 4), "X", "#", "Y", 'Y', Items.FEATHER, 'X', Items.FLINT, '#', Items.STICK);
    }
}
