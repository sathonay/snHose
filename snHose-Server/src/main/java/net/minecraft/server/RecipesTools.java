package net.minecraft.server.v1_7_R4;

public class RecipesTools
{
    private String[][] a;
    private Object[][] b;
    
    public RecipesTools() {
        this.a = new String[][] { { "XXX", " # ", " # " }, { "X", "#", "#" }, { "XX", "X#", " #" }, { "XX", " #", " #" } };
        this.b = new Object[][] { { Blocks.WOOD, Blocks.COBBLESTONE, Items.IRON_INGOT, Items.DIAMOND, Items.GOLD_INGOT }, { Items.WOOD_PICKAXE, Items.STONE_PICKAXE, Items.IRON_PICKAXE, Items.DIAMOND_PICKAXE, Items.GOLD_PICKAXE }, { Items.WOOD_SPADE, Items.STONE_SPADE, Items.IRON_SPADE, Items.DIAMOND_SPADE, Items.GOLD_SPADE }, { Items.WOOD_AXE, Items.STONE_AXE, Items.IRON_AXE, Items.DIAMOND_AXE, Items.GOLD_AXE }, { Items.WOOD_HOE, Items.STONE_HOE, Items.IRON_HOE, Items.DIAMOND_HOE, Items.GOLD_HOE } };
    }
    
    public void a(final CraftingManager craftingManager) {
        for (int i = 0; i < this.b[0].length; ++i) {
            final Object o = this.b[0][i];
            for (int j = 0; j < this.b.length - 1; ++j) {
                craftingManager.registerShapedRecipe(new ItemStack((Item)this.b[j + 1][i]), this.a[j], '#', Items.STICK, 'X', o);
            }
        }
        craftingManager.registerShapedRecipe(new ItemStack(Items.SHEARS), " #", "# ", '#', Items.IRON_INGOT);
    }
}
