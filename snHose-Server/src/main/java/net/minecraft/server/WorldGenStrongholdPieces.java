package net.minecraft.server;

import java.util.*;

public class WorldGenStrongholdPieces
{
    private static final WorldGenStrongholdPieceWeight[] b;
    private static List<WorldGenStrongholdPieceWeight> c;
    private static Class d;
    static int a;
    private static final WorldGenStrongholdStones e;
    
    public static void a() {
        WorldGenFactory.a(WorldGenStrongholdChestCorridor.class, "SHCC");
        WorldGenFactory.a(WorldGenStrongholdCorridor.class, "SHFC");
        WorldGenFactory.a(WorldGenStrongholdCrossing.class, "SH5C");
        WorldGenFactory.a(WorldGenStrongholdLeftTurn.class, "SHLT");
        WorldGenFactory.a(WorldGenStrongholdLibrary.class, "SHLi");
        WorldGenFactory.a(WorldGenStrongholdPortalRoom.class, "SHPR");
        WorldGenFactory.a(WorldGenStrongholdPrison.class, "SHPH");
        WorldGenFactory.a(WorldGenStrongholdRightTurn.class, "SHRT");
        WorldGenFactory.a(WorldGenStrongholdRoomCrossing.class, "SHRC");
        WorldGenFactory.a(WorldGenStrongholdStairs2.class, "SHSD");
        WorldGenFactory.a(WorldGenStrongholdStart.class, "SHStart");
        WorldGenFactory.a(WorldGenStrongholdStairs.class, "SHS");
        WorldGenFactory.a(WorldGenStrongholdStairsStraight.class, "SHSSD");
    }
    
    public static void b() {
        WorldGenStrongholdPieces.c = new ArrayList();
        for (final WorldGenStrongholdPieceWeight worldGenStrongholdPieceWeight : WorldGenStrongholdPieces.b) {
            worldGenStrongholdPieceWeight.c = 0;
            WorldGenStrongholdPieces.c.add(worldGenStrongholdPieceWeight);
        }
        WorldGenStrongholdPieces.d = null;
    }
    
    private static boolean d() {
        boolean b = false;
        WorldGenStrongholdPieces.a = 0;
        for (final WorldGenStrongholdPieceWeight worldGenStrongholdPieceWeight : WorldGenStrongholdPieces.c) {
            if (worldGenStrongholdPieceWeight.d > 0 && worldGenStrongholdPieceWeight.c < worldGenStrongholdPieceWeight.d) {
                b = true;
            }
            WorldGenStrongholdPieces.a += worldGenStrongholdPieceWeight.b;
        }
        return b;
    }
    
    private static WorldGenStrongholdPiece a(final Class clazz, final List list, final Random random, final int n, final int n2, final int n3, final int n4, final int n5) {
        WorldGenStrongholdPiece worldGenStrongholdPiece = null;
        if (clazz == WorldGenStrongholdStairs.class) {
            worldGenStrongholdPiece = WorldGenStrongholdStairs.a(list, random, n, n2, n3, n4, n5);
        }
        else if (clazz == WorldGenStrongholdPrison.class) {
            worldGenStrongholdPiece = WorldGenStrongholdPrison.a(list, random, n, n2, n3, n4, n5);
        }
        else if (clazz == WorldGenStrongholdLeftTurn.class) {
            worldGenStrongholdPiece = WorldGenStrongholdLeftTurn.a(list, random, n, n2, n3, n4, n5);
        }
        else if (clazz == WorldGenStrongholdRightTurn.class) {
            worldGenStrongholdPiece = WorldGenStrongholdLeftTurn.a(list, random, n, n2, n3, n4, n5);
        }
        else if (clazz == WorldGenStrongholdRoomCrossing.class) {
            worldGenStrongholdPiece = WorldGenStrongholdRoomCrossing.a(list, random, n, n2, n3, n4, n5);
        }
        else if (clazz == WorldGenStrongholdStairsStraight.class) {
            worldGenStrongholdPiece = WorldGenStrongholdStairsStraight.a(list, random, n, n2, n3, n4, n5);
        }
        else if (clazz == WorldGenStrongholdStairs2.class) {
            worldGenStrongholdPiece = WorldGenStrongholdStairs2.a(list, random, n, n2, n3, n4, n5);
        }
        else if (clazz == WorldGenStrongholdCrossing.class) {
            worldGenStrongholdPiece = WorldGenStrongholdCrossing.a(list, random, n, n2, n3, n4, n5);
        }
        else if (clazz == WorldGenStrongholdChestCorridor.class) {
            worldGenStrongholdPiece = WorldGenStrongholdChestCorridor.a(list, random, n, n2, n3, n4, n5);
        }
        else if (clazz == WorldGenStrongholdLibrary.class) {
            worldGenStrongholdPiece = WorldGenStrongholdLibrary.a(list, random, n, n2, n3, n4, n5);
        }
        else if (clazz == WorldGenStrongholdPortalRoom.class) {
            worldGenStrongholdPiece = WorldGenStrongholdPortalRoom.a(list, random, n, n2, n3, n4, n5);
        }
        return worldGenStrongholdPiece;
    }
    
    private static WorldGenStrongholdPiece b(final WorldGenStrongholdStart worldGenStrongholdStart, final List list, final Random random, final int n, final int n2, final int n3, final int n4, final int n5) {
        if (!d()) {
            return null;
        }
        if (WorldGenStrongholdPieces.d != null) {
            final WorldGenStrongholdPiece a = a(WorldGenStrongholdPieces.d, list, random, n, n2, n3, n4, n5);
            WorldGenStrongholdPieces.d = null;
            if (a != null) {
                return a;
            }
        }
        int i = 0;
        while (i < 5) {
            ++i;
            int nextInt = random.nextInt(WorldGenStrongholdPieces.a);
            for (final WorldGenStrongholdPieceWeight a2 : WorldGenStrongholdPieces.c) {
                nextInt -= a2.b;
                if (nextInt < 0) {
                    if (!a2.a(n5)) {
                        break;
                    }
                    if (a2 == worldGenStrongholdStart.a) {
                        break;
                    }
                    final WorldGenStrongholdPiece a3 = a(a2.a, list, random, n, n2, n3, n4, n5);
                    if (a3 != null) {
                        final WorldGenStrongholdPieceWeight worldGenStrongholdPieceWeight = a2;
                        ++worldGenStrongholdPieceWeight.c;
                        worldGenStrongholdStart.a = a2;
                        if (!a2.a()) {
                            WorldGenStrongholdPieces.c.remove(a2);
                        }
                        return a3;
                    }
                    continue;
                }
            }
        }
        final StructureBoundingBox a4 = WorldGenStrongholdCorridor.a(list, random, n, n2, n3, n4);
        if (a4 != null && a4.b > 1) {
            return new WorldGenStrongholdCorridor(n5, random, a4, n4);
        }
        return null;
    }
    
    private static StructurePiece c(final WorldGenStrongholdStart worldGenStrongholdStart, final List list, final Random random, final int n, final int n2, final int n3, final int n4, final int n5) {
        if (n5 > 50) {
            return null;
        }
        if (Math.abs(n - worldGenStrongholdStart.c().a) > 112 || Math.abs(n3 - worldGenStrongholdStart.c().c) > 112) {
            return null;
        }
        final WorldGenStrongholdPiece b = b(worldGenStrongholdStart, list, random, n, n2, n3, n4, n5 + 1);
        if (b != null) {
            list.add(b);
            worldGenStrongholdStart.c.add(b);
        }
        return b;
    }
    
    static {
        b = new WorldGenStrongholdPieceWeight[] { new WorldGenStrongholdPieceWeight(WorldGenStrongholdStairs.class, 40, 0), new WorldGenStrongholdPieceWeight(WorldGenStrongholdPrison.class, 5, 5), new WorldGenStrongholdPieceWeight(WorldGenStrongholdLeftTurn.class, 20, 0), new WorldGenStrongholdPieceWeight(WorldGenStrongholdRightTurn.class, 20, 0), new WorldGenStrongholdPieceWeight(WorldGenStrongholdRoomCrossing.class, 10, 6), new WorldGenStrongholdPieceWeight(WorldGenStrongholdStairsStraight.class, 5, 5), new WorldGenStrongholdPieceWeight(WorldGenStrongholdStairs2.class, 5, 5), new WorldGenStrongholdPieceWeight(WorldGenStrongholdCrossing.class, 5, 4), new WorldGenStrongholdPieceWeight(WorldGenStrongholdChestCorridor.class, 5, 4), new WorldGenStrongholdUnknown(WorldGenStrongholdLibrary.class, 10, 2), new WorldGenStrongholdPiece2(WorldGenStrongholdPortalRoom.class, 20, 1) };
        e = new WorldGenStrongholdStones();
    }
}
