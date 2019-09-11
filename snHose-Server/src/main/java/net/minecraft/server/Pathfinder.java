package net.minecraft.server;

public class Pathfinder
{
    private IBlockAccess a;
    private Path b;
    private IntHashMap c;
    private PathPoint[] d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    
    public Pathfinder(final IBlockAccess a, final boolean e, final boolean f, final boolean g, final boolean h) {
        this.b = new Path();
        this.c = new IntHashMap();
        this.d = new PathPoint[32];
        this.a = a;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
    }
    
    public PathEntity a(final Entity entity, final Entity entity2, final float n) {
        return this.a(entity, entity2.locX, entity2.boundingBox.b, entity2.locZ, n);
    }
    
    public PathEntity a(final Entity entity, final int n, final int n2, final int n3, final float n4) {
        return this.a(entity, n + 0.5f, n2 + 0.5f, n3 + 0.5f, n4);
    }
    
    private PathEntity a(final Entity entity, final double n, final double var0, final double n2, final float n3) {
        this.b.a();
        this.c.c();
        boolean g = this.g;
        MathHelper.floor(entity.boundingBox.b + 0.5);
        int floor;
        if (this.h && entity.M()) {
            floor = (int)entity.boundingBox.b;
            for (Block block = this.a.getType(MathHelper.floor(entity.locX), floor, MathHelper.floor(entity.locZ)); block == Blocks.WATER || block == Blocks.STATIONARY_WATER; block = this.a.getType(MathHelper.floor(entity.locX), floor, MathHelper.floor(entity.locZ))) {
                ++floor;
            }
            g = this.g;
            this.g = false;
        }
        else {
            floor = MathHelper.floor(entity.boundingBox.b + 0.5);
        }
        final PathEntity a = this.a(entity, this.a(MathHelper.floor(entity.boundingBox.a), floor, MathHelper.floor(entity.boundingBox.c)), this.a(MathHelper.floor(n - entity.width / 2.0f), MathHelper.floor(var0), MathHelper.floor(n2 - entity.width / 2.0f)), new PathPoint(MathHelper.d(entity.width + 1.0f), MathHelper.d(entity.length + 1.0f), MathHelper.d(entity.width + 1.0f)), n3);
        this.g = g;
        return a;
    }
    
    private PathEntity a(final Entity entity, final PathPoint pathpoint, final PathPoint pathPoint, final PathPoint pathPoint2, final float n) {
        pathpoint.e = 0.0f;
        pathpoint.f = pathpoint.b(pathPoint);
        pathpoint.g = pathpoint.f;
        this.b.a();
        this.b.a(pathpoint);
        PathPoint pathPoint3 = pathpoint;
        while (!this.b.e()) {
            final PathPoint c = this.b.c();
            if (c.equals(pathPoint)) {
                return this.a(pathpoint, pathPoint);
            }
            if (c.b(pathPoint) < pathPoint3.b(pathPoint)) {
                pathPoint3 = c;
            }
            c.i = true;
            for (int b = this.b(entity, c, pathPoint2, pathPoint, n), i = 0; i < b; ++i) {
                final PathPoint pathPoint4 = this.d[i];
                final float e = c.e + c.b(pathPoint4);
                if (!pathPoint4.a() || e < pathPoint4.e) {
                    pathPoint4.h = c;
                    pathPoint4.e = e;
                    pathPoint4.f = pathPoint4.b(pathPoint);
                    if (pathPoint4.a()) {
                        this.b.a(pathPoint4, pathPoint4.e + pathPoint4.f);
                    }
                    else {
                        pathPoint4.g = pathPoint4.e + pathPoint4.f;
                        this.b.a(pathPoint4);
                    }
                }
            }
        }
        if (pathPoint3 == pathpoint) {
            return null;
        }
        return this.a(pathpoint, pathPoint3);
    }
    
    private int b(final Entity entity, final PathPoint pathPoint, final PathPoint pathPoint2, final PathPoint pathPoint3, final float n) {
        int n2 = 0;
        int n3 = 0;
        if (this.a(entity, pathPoint.a, pathPoint.b + 1, pathPoint.c, pathPoint2) == 1) {
            n3 = 1;
        }
        final PathPoint a = this.a(entity, pathPoint.a, pathPoint.b, pathPoint.c + 1, pathPoint2, n3);
        final PathPoint a2 = this.a(entity, pathPoint.a - 1, pathPoint.b, pathPoint.c, pathPoint2, n3);
        final PathPoint a3 = this.a(entity, pathPoint.a + 1, pathPoint.b, pathPoint.c, pathPoint2, n3);
        final PathPoint a4 = this.a(entity, pathPoint.a, pathPoint.b, pathPoint.c - 1, pathPoint2, n3);
        if (a != null && !a.i && a.a(pathPoint3) < n) {
            this.d[n2++] = a;
        }
        if (a2 != null && !a2.i && a2.a(pathPoint3) < n) {
            this.d[n2++] = a2;
        }
        if (a3 != null && !a3.i && a3.a(pathPoint3) < n) {
            this.d[n2++] = a3;
        }
        if (a4 != null && !a4.i && a4.a(pathPoint3) < n) {
            this.d[n2++] = a4;
        }
        return n2;
    }
    
    private PathPoint a(final Entity entity, final int n, int i, final int n2, final PathPoint pathPoint, final int n3) {
        PathPoint pathPoint2 = null;
        final int a = this.a(entity, n, i, n2, pathPoint);
        if (a == 2) {
            return this.a(n, i, n2);
        }
        if (a == 1) {
            pathPoint2 = this.a(n, i, n2);
        }
        if (pathPoint2 == null && n3 > 0 && a != -3 && a != -4 && this.a(entity, n, i + n3, n2, pathPoint) == 1) {
            pathPoint2 = this.a(n, i + n3, n2);
            i += n3;
        }
        if (pathPoint2 != null) {
            int n4 = 0;
            int a2 = 0;
            while (i > 0) {
                a2 = this.a(entity, n, i - 1, n2, pathPoint);
                if (this.g && a2 == -1) {
                    return null;
                }
                if (a2 != 1) {
                    break;
                }
                if (n4++ >= entity.ax()) {
                    return null;
                }
                if (--i <= 0) {
                    continue;
                }
                pathPoint2 = this.a(n, i, n2);
            }
            if (a2 == -2) {
                return null;
            }
        }
        return pathPoint2;
    }
    
    private final PathPoint a(final int n, final int n2, final int n3) {
        final int a = PathPoint.a(n, n2, n3);
        PathPoint object = (PathPoint)this.c.get(a);
        if (object == null) {
            object = new PathPoint(n, n2, n3);
            this.c.a(a, object);
        }
        return object;
    }
    
    public int a(final Entity entity, final int n, final int n2, final int n3, final PathPoint pathPoint) {
        return a(entity, n, n2, n3, pathPoint, this.g, this.f, this.e);
    }
    
    public static int a(final Entity entity, final int n, final int n2, final int n3, final PathPoint pathPoint, final boolean b, final boolean b2, final boolean b3) {
        boolean b4 = false;
        for (int i = n; i < n + pathPoint.a; ++i) {
            for (int j = n2; j < n2 + pathPoint.b; ++j) {
                for (int k = n3; k < n3 + pathPoint.c; ++k) {
                    final Block type = entity.world.getType(i, j, k);
                    if (type.getMaterial() != Material.AIR) {
                        if (type == Blocks.TRAP_DOOR) {
                            b4 = true;
                        }
                        else if (type == Blocks.WATER || type == Blocks.STATIONARY_WATER) {
                            if (b) {
                                return -1;
                            }
                            b4 = true;
                        }
                        else if (!b3 && type == Blocks.WOODEN_DOOR) {
                            return 0;
                        }
                        final int b5 = type.b();
                        if (entity.world.getType(i, j, k).b() == 9) {
                            final int floor = MathHelper.floor(entity.locX);
                            final int floor2 = MathHelper.floor(entity.locY);
                            final int floor3 = MathHelper.floor(entity.locZ);
                            if (entity.world.getType(floor, floor2, floor3).b() != 9) {
                                if (entity.world.getType(floor, floor2 - 1, floor3).b() != 9) {
                                    return -3;
                                }
                            }
                        }
                        else if (!type.b(entity.world, i, j, k)) {
                            if (!b2 || type != Blocks.WOODEN_DOOR) {
                                if (b5 == 11 || type == Blocks.FENCE_GATE || b5 == 32) {
                                    return -3;
                                }
                                if (type == Blocks.TRAP_DOOR) {
                                    return -4;
                                }
                                if (type.getMaterial() != Material.LAVA) {
                                    return 0;
                                }
                                if (!entity.P()) {
                                    return -2;
                                }
                            }
                        }
                    }
                }
            }
        }
        return b4 ? 2 : 1;
    }
    
    private PathEntity a(final PathPoint pathPoint, final PathPoint pathPoint2) {
        int n = 1;
        for (PathPoint h = pathPoint2; h.h != null; h = h.h) {
            ++n;
        }
        final PathPoint[] array = new PathPoint[n];
        PathPoint h2 = pathPoint2;
        array[--n] = h2;
        while (h2.h != null) {
            h2 = h2.h;
            array[--n] = h2;
        }
        return new PathEntity(array);
    }
}
