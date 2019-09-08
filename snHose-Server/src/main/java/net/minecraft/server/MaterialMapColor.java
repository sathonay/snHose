package net.minecraft.server.v1_7_R4;

public class MaterialMapColor
{
    public static final MaterialMapColor[] a;
    public static final MaterialMapColor b;
    public static final MaterialMapColor c;
    public static final MaterialMapColor d;
    public static final MaterialMapColor e;
    public static final MaterialMapColor f;
    public static final MaterialMapColor g;
    public static final MaterialMapColor h;
    public static final MaterialMapColor i;
    public static final MaterialMapColor j;
    public static final MaterialMapColor k;
    public static final MaterialMapColor l;
    public static final MaterialMapColor m;
    public static final MaterialMapColor n;
    public static final MaterialMapColor o;
    public static final MaterialMapColor p;
    public static final MaterialMapColor q;
    public static final MaterialMapColor r;
    public static final MaterialMapColor s;
    public static final MaterialMapColor t;
    public static final MaterialMapColor u;
    public static final MaterialMapColor v;
    public static final MaterialMapColor w;
    public static final MaterialMapColor x;
    public static final MaterialMapColor y;
    public static final MaterialMapColor z;
    public static final MaterialMapColor A;
    public static final MaterialMapColor B;
    public static final MaterialMapColor C;
    public static final MaterialMapColor D;
    public static final MaterialMapColor E;
    public static final MaterialMapColor F;
    public static final MaterialMapColor G;
    public static final MaterialMapColor H;
    public static final MaterialMapColor I;
    public static final MaterialMapColor J;
    public static final MaterialMapColor K;
    public final int L;
    public final int M;
    
    private MaterialMapColor(final int m, final int l) {
        if (m < 0 || m > 63) {
            throw new IndexOutOfBoundsException("Map colour ID must be between 0 and 63 (inclusive)");
        }
        this.M = m;
        this.L = l;
        MaterialMapColor.a[m] = this;
    }
    
    public static MaterialMapColor a(final int n) {
        switch (BlockCloth.c(n)) {
            case 0: {
                return MaterialMapColor.E;
            }
            case 1: {
                return MaterialMapColor.D;
            }
            case 2: {
                return MaterialMapColor.C;
            }
            case 3: {
                return MaterialMapColor.B;
            }
            case 4: {
                return MaterialMapColor.A;
            }
            case 5: {
                return MaterialMapColor.z;
            }
            case 6: {
                return MaterialMapColor.y;
            }
            case 7: {
                return MaterialMapColor.x;
            }
            case 8: {
                return MaterialMapColor.w;
            }
            case 9: {
                return MaterialMapColor.v;
            }
            case 10: {
                return MaterialMapColor.u;
            }
            case 11: {
                return MaterialMapColor.t;
            }
            case 12: {
                return MaterialMapColor.s;
            }
            case 13: {
                return MaterialMapColor.r;
            }
            case 14: {
                return MaterialMapColor.q;
            }
            case 15: {
                return MaterialMapColor.j;
            }
            default: {
                return MaterialMapColor.b;
            }
        }
    }
    
    static {
        a = new MaterialMapColor[64];
        b = new MaterialMapColor(0, 0);
        c = new MaterialMapColor(1, 8368696);
        d = new MaterialMapColor(2, 16247203);
        e = new MaterialMapColor(3, 10987431);
        f = new MaterialMapColor(4, 16711680);
        g = new MaterialMapColor(5, 10526975);
        h = new MaterialMapColor(6, 10987431);
        i = new MaterialMapColor(7, 31744);
        j = new MaterialMapColor(8, 16777215);
        k = new MaterialMapColor(9, 10791096);
        l = new MaterialMapColor(10, 12020271);
        m = new MaterialMapColor(11, 7368816);
        n = new MaterialMapColor(12, 4210943);
        o = new MaterialMapColor(13, 6837042);
        p = new MaterialMapColor(14, 16776437);
        q = new MaterialMapColor(15, 14188339);
        r = new MaterialMapColor(16, 11685080);
        s = new MaterialMapColor(17, 6724056);
        t = new MaterialMapColor(18, 15066419);
        u = new MaterialMapColor(19, 8375321);
        v = new MaterialMapColor(20, 15892389);
        w = new MaterialMapColor(21, 5000268);
        x = new MaterialMapColor(22, 10066329);
        y = new MaterialMapColor(23, 5013401);
        z = new MaterialMapColor(24, 8339378);
        A = new MaterialMapColor(25, 3361970);
        B = new MaterialMapColor(26, 6704179);
        C = new MaterialMapColor(27, 6717235);
        D = new MaterialMapColor(28, 10040115);
        E = new MaterialMapColor(29, 1644825);
        F = new MaterialMapColor(30, 16445005);
        G = new MaterialMapColor(31, 6085589);
        H = new MaterialMapColor(32, 4882687);
        I = new MaterialMapColor(33, 55610);
        J = new MaterialMapColor(34, 1381407);
        K = new MaterialMapColor(35, 7340544);
    }
}
