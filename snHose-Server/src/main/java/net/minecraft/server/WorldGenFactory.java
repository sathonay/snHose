package net.minecraft.server;

import org.apache.logging.log4j.*;
import java.util.*;

public class WorldGenFactory
{
    private static final Logger a;
    private static Map b;
    private static Map c;
    private static Map d;
    private static Map e;
    
    private static void b(final Class clazz, final String s) {
        WorldGenFactory.b.put(s, clazz);
        WorldGenFactory.c.put(clazz, s);
    }
    
    static void a(final Class clazz, final String s) {
        WorldGenFactory.d.put(s, clazz);
        WorldGenFactory.e.put(clazz, s);
    }
    
    public static String a(final StructureStart structureStart) {
        return WorldGenFactory.c.get(structureStart.getClass());
    }
    
    public static String a(final StructurePiece structurePiece) {
        return WorldGenFactory.e.get(structurePiece.getClass());
    }
    
    public static StructureStart a(final NBTTagCompound nbtTagCompound, final World world) {
        StructureStart structureStart = null;
        try {
            final Class<StructureStart> clazz = WorldGenFactory.b.get(nbtTagCompound.getString("id"));
            if (clazz != null) {
                structureStart = clazz.newInstance();
            }
        }
        catch (Exception ex) {
            WorldGenFactory.a.warn("Failed Start with id " + nbtTagCompound.getString("id"));
            ex.printStackTrace();
        }
        if (structureStart != null) {
            structureStart.a(world, nbtTagCompound);
        }
        else {
            WorldGenFactory.a.warn("Skipping Structure with id " + nbtTagCompound.getString("id"));
        }
        return structureStart;
    }
    
    public static StructurePiece b(final NBTTagCompound nbtTagCompound, final World world) {
        StructurePiece structurePiece = null;
        try {
            final Class<StructurePiece> clazz = WorldGenFactory.d.get(nbtTagCompound.getString("id"));
            if (clazz != null) {
                structurePiece = clazz.newInstance();
            }
        }
        catch (Exception ex) {
            WorldGenFactory.a.warn("Failed Piece with id " + nbtTagCompound.getString("id"));
            ex.printStackTrace();
        }
        if (structurePiece != null) {
            structurePiece.a(world, nbtTagCompound);
        }
        else {
            WorldGenFactory.a.warn("Skipping Piece with id " + nbtTagCompound.getString("id"));
        }
        return structurePiece;
    }
    
    static {
        a = LogManager.getLogger();
        WorldGenFactory.b = new HashMap();
        WorldGenFactory.c = new HashMap();
        WorldGenFactory.d = new HashMap();
        WorldGenFactory.e = new HashMap();
        b(WorldGenMineshaftStart.class, "Mineshaft");
        b(WorldGenVillageStart.class, "Village");
        b(WorldGenNetherStart.class, "Fortress");
        b(WorldGenStronghold2Start.class, "Stronghold");
        b(WorldGenLargeFeatureStart.class, "Temple");
        WorldGenMineshaftPieces.a();
        WorldGenVillagePieces.a();
        WorldGenNetherPieces.a();
        WorldGenStrongholdPieces.a();
        WorldGenRegistration.a();
    }
}
