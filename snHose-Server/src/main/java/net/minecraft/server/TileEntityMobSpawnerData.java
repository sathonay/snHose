package net.minecraft.server.v1_7_R4;

public class TileEntityMobSpawnerData extends WeightedRandomChoice
{
    public final NBTTagCompound b;
    public final String c;
    final /* synthetic */ MobSpawnerAbstract d;
    
    public TileEntityMobSpawnerData(final MobSpawnerAbstract d, final NBTTagCompound nbtTagCompound) {
        this.d = d;
        super(nbtTagCompound.getInt("Weight"));
        final NBTTagCompound compound = nbtTagCompound.getCompound("Properties");
        String string = nbtTagCompound.getString("Type");
        if (string.equals("Minecart")) {
            if (compound != null) {
                switch (compound.getInt("Type")) {
                    case 1: {
                        string = "MinecartChest";
                        break;
                    }
                    case 2: {
                        string = "MinecartFurnace";
                        break;
                    }
                    case 0: {
                        string = "MinecartRideable";
                        break;
                    }
                }
            }
            else {
                string = "MinecartRideable";
            }
        }
        this.b = compound;
        this.c = string;
    }
    
    public TileEntityMobSpawnerData(final MobSpawnerAbstract d, final NBTTagCompound b, String c) {
        this.d = d;
        super(1);
        if (c.equals("Minecart")) {
            if (b != null) {
                switch (b.getInt("Type")) {
                    case 1: {
                        c = "MinecartChest";
                        break;
                    }
                    case 2: {
                        c = "MinecartFurnace";
                        break;
                    }
                    case 0: {
                        c = "MinecartRideable";
                        break;
                    }
                }
            }
            else {
                c = "MinecartRideable";
            }
        }
        this.b = b;
        this.c = c;
    }
    
    public NBTTagCompound a() {
        final NBTTagCompound nbtTagCompound = new NBTTagCompound();
        nbtTagCompound.set("Properties", this.b);
        nbtTagCompound.setString("Type", this.c);
        nbtTagCompound.setInt("Weight", this.a);
        return nbtTagCompound;
    }
}
