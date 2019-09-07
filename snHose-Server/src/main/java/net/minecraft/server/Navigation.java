package net.minecraft.server;

public class Navigation
{
    private EntityInsentient a;
    private World b;
    private PathEntity c;
    private double d;
    private AttributeInstance e;
    private boolean f;
    private int g;
    private int h;
    private Vec3D i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;

    public Navigation(final EntityInsentient a, final World b) {
        this.i = Vec3D.a(0.0, 0.0, 0.0);
        this.j = true;
        this.a = a;
        this.b = b;
        this.e = a.getAttributeInstance(GenericAttributes.b);
    }

    public void a(final boolean l) {
        this.l = l;
    }

    public boolean a() {
        return this.l;
    }

    public void b(final boolean k) {
        this.k = k;
    }

    public void c(final boolean j) {
        this.j = j;
    }

    public boolean c() {
        return this.k;
    }

    public void d(final boolean f) {
        this.f = f;
    }

    public void a(final double d) {
        this.d = d;
    }

    public void e(final boolean m) {
        this.m = m;
    }

    public float d() {
        return (float)this.e.getValue();
    }

    public PathEntity a(final double var0, final double n, final double var2) {
        if (!this.l()) {
            return null;
        }
        return this.b.a(this.a, MathHelper.floor(var0), (int)n, MathHelper.floor(var2), this.d(), this.j, this.k, this.l, this.m);
    }

    public boolean a(final double var0, final double n, final double var2, final double n2) {
        return this.a(this.a(MathHelper.floor(var0), (int)n, MathHelper.floor(var2)), n2);
    }

    public PathEntity a(final Entity entity1) {
        if (!this.l()) {
            return null;
        }
        return this.b.findPath(this.a, entity1, this.d(), this.j, this.k, this.l, this.m);
    }

    public boolean a(final Entity entity, final double n) {
        final PathEntity a = this.a(entity);
        return a != null && this.a(a, n);
    }

    public boolean a(final PathEntity c, final double d) {
        if (c == null) {
            this.c = null;
            return false;
        }
        if (!c.a(this.c)) {
            this.c = c;
        }
        if (this.f) {
            this.n();
        }
        if (this.c.d() == 0) {
            return false;
        }
        this.d = d;
        final Vec3D j = this.j();
        this.h = this.g;
        this.i.a = j.a;
        this.i.b = j.b;
        this.i.c = j.c;
        return true;
    }

    public PathEntity e() {
        return this.c;
    }

    public void f() {
        ++this.g;
        if (this.g()) {
            return;
        }
        if (this.l()) {
            this.i();
        }
        if (this.g()) {
            return;
        }
        final Vec3D a = this.c.a(this.a);
        if (a == null) {
            return;
        }
        this.a.getControllerMove().a(a.a, a.b, a.c, this.d);
    }

    private void i() {
        final Vec3D j = this.j();
        int d = this.c.d();
        for (int i = this.c.e(); i < this.c.d(); ++i) {
            if (this.c.a(i).b != (int)j.b) {
                d = i;
                break;
            }
        }
        final float n = this.a.width * this.a.width;
        for (int k = this.c.e(); k < d; ++k) {
            if (j.distanceSquared(this.c.a(this.a, k)) < n) {
                this.c.c(k + 1);
            }
        }
        final int f = MathHelper.f(this.a.width);
        final int n2 = (int)this.a.length + 1;
        final int n3 = f;
        for (int l = d - 1; l >= this.c.e(); --l) {
            if (this.a(j, this.c.a(this.a, l), f, n2, n3)) {
                this.c.c(l);
                break;
            }
        }
        if (this.g - this.h > 100) {
            if (j.distanceSquared(this.i) < 2.25) {
                this.h();
            }
            this.h = this.g;
            this.i.a = j.a;
            this.i.b = j.b;
            this.i.c = j.c;
        }
    }

    public boolean g() {
        return this.c == null || this.c.b();
    }

    public void h() {
        this.c = null;
    }

    private Vec3D j() {
        return Vec3D.a(this.a.locX, this.k(), this.a.locZ);
    }

    private int k() {
        if (!this.a.M() || !this.m) {
            return (int)(this.a.boundingBox.b + 0.5);
        }
        int n = (int)this.a.boundingBox.b;
        Block block = this.b.getType(MathHelper.floor(this.a.locX), n, MathHelper.floor(this.a.locZ));
        int n2 = 0;
        while (block == Blocks.WATER || block == Blocks.STATIONARY_WATER) {
            ++n;
            block = this.b.getType(MathHelper.floor(this.a.locX), n, MathHelper.floor(this.a.locZ));
            if (++n2 > 16) {
                return (int)this.a.boundingBox.b;
            }
        }
        return n;
    }

    private boolean l() {
        return this.a.onGround || (this.m && this.m()) || (this.a.am() && this.a instanceof EntityZombie && this.a.vehicle instanceof EntityChicken);
    }

    private boolean m() {
        return this.a.M() || this.a.P();
    }

    private void n() {
        if (this.b.i(MathHelper.floor(this.a.locX), (int)(this.a.boundingBox.b + 0.5), MathHelper.floor(this.a.locZ))) {
            return;
        }
        for (int i = 0; i < this.c.d(); ++i) {
            final PathPoint a = this.c.a(i);
            if (this.b.i(a.a, a.b, a.c)) {
                this.c.b(i - 1);
                return;
            }
        }
    }

    private boolean a(final Vec3D vec3D, final Vec3D vec3D2, int n, final int n2, int n3) {
        int floor = MathHelper.floor(vec3D.a);
        int floor2 = MathHelper.floor(vec3D.c);
        final double n4 = vec3D2.a - vec3D.a;
        final double n5 = vec3D2.c - vec3D.c;
        final double n6 = n4 * n4 + n5 * n5;
        if (n6 < 1.0E-8) {
            return false;
        }
        final double n7 = 1.0 / Math.sqrt(n6);
        final double n8 = n4 * n7;
        final double n9 = n5 * n7;
        n += 2;
        n3 += 2;
        if (!this.a(floor, (int)vec3D.b, floor2, n, n2, n3, vec3D, n8, n9)) {
            return false;
        }
        n -= 2;
        n3 -= 2;
        final double n10 = 1.0 / Math.abs(n8);
        final double n11 = 1.0 / Math.abs(n9);
        double n12 = floor * 1 - vec3D.a;
        double n13 = floor2 * 1 - vec3D.c;
        if (n8 >= 0.0) {
            ++n12;
        }
        if (n9 >= 0.0) {
            ++n13;
        }
        double n14 = n12 / n8;
        double n15 = n13 / n9;
        final int n16 = (n8 < 0.0) ? -1 : 1;
        final int n17 = (n9 < 0.0) ? -1 : 1;
        final int floor3 = MathHelper.floor(vec3D2.a);
        final int floor4 = MathHelper.floor(vec3D2.c);
        int n18 = floor3 - floor;
        int n19 = floor4 - floor2;
        while (n18 * n16 > 0 || n19 * n17 > 0) {
            if (n14 < n15) {
                n14 += n10;
                floor += n16;
                n18 = floor3 - floor;
            }
            else {
                n15 += n11;
                floor2 += n17;
                n19 = floor4 - floor2;
            }
            if (!this.a(floor, (int)vec3D.b, floor2, n, n2, n3, vec3D, n8, n9)) {
                return false;
            }
        }
        return true;
    }

    private boolean a(final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final Vec3D vec3D, final double n7, final double n8) {
        final int n9 = n - n4 / 2;
        final int n10 = n3 - n6 / 2;
        if (!this.b(n9, n2, n10, n4, n5, n6, vec3D, n7, n8)) {
            return false;
        }
        for (int i = n9; i < n9 + n4; ++i) {
            for (int j = n10; j < n10 + n6; ++j) {
                if ((i + 0.5 - vec3D.a) * n7 + (j + 0.5 - vec3D.c) * n8 >= 0.0) {
                    final Material material = this.b.getType(i, n2 - 1, j).getMaterial();
                    if (material == Material.AIR) {
                        return false;
                    }
                    if (material == Material.WATER && !this.a.M()) {
                        return false;
                    }
                    if (material == Material.LAVA) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean b(final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final Vec3D vec3D, final double n7, final double n8) {
        for (int i = n; i < n + n4; ++i) {
            for (int j = n2; j < n2 + n5; ++j) {
                for (int k = n3; k < n3 + n6; ++k) {
                    if ((i + 0.5 - vec3D.a) * n7 + (k + 0.5 - vec3D.c) * n8 >= 0.0) {
                        if (!this.b.getType(i, j, k).b(this.b, i, j, k)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
