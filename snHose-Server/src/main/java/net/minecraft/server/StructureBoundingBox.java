package net.minecraft.server;

public class StructureBoundingBox
{
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    
    public StructureBoundingBox() {
    }
    
    public StructureBoundingBox(final int[] array) {
        if (array.length == 6) {
            this.a = array[0];
            this.b = array[1];
            this.c = array[2];
            this.d = array[3];
            this.e = array[4];
            this.f = array[5];
        }
    }
    
    public static StructureBoundingBox a() {
        return new StructureBoundingBox(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    }
    
    public static StructureBoundingBox a(final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7, final int n8, final int n9, final int n10) {
        switch (n10) {
            default: {
                return new StructureBoundingBox(n + n4, n2 + n5, n3 + n6, n + n7 - 1 + n4, n2 + n8 - 1 + n5, n3 + n9 - 1 + n6);
            }
            case 2: {
                return new StructureBoundingBox(n + n4, n2 + n5, n3 - n9 + 1 + n6, n + n7 - 1 + n4, n2 + n8 - 1 + n5, n3 + n6);
            }
            case 0: {
                return new StructureBoundingBox(n + n4, n2 + n5, n3 + n6, n + n7 - 1 + n4, n2 + n8 - 1 + n5, n3 + n9 - 1 + n6);
            }
            case 1: {
                return new StructureBoundingBox(n - n9 + 1 + n6, n2 + n5, n3 + n4, n + n6, n2 + n8 - 1 + n5, n3 + n7 - 1 + n4);
            }
            case 3: {
                return new StructureBoundingBox(n + n6, n2 + n5, n3 + n4, n + n9 - 1 + n6, n2 + n8 - 1 + n5, n3 + n7 - 1 + n4);
            }
        }
    }
    
    public StructureBoundingBox(final StructureBoundingBox structureBoundingBox) {
        this.a = structureBoundingBox.a;
        this.b = structureBoundingBox.b;
        this.c = structureBoundingBox.c;
        this.d = structureBoundingBox.d;
        this.e = structureBoundingBox.e;
        this.f = structureBoundingBox.f;
    }
    
    public StructureBoundingBox(final int a, final int b, final int c, final int d, final int e, final int f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }
    
    public StructureBoundingBox(final int a, final int c, final int d, final int f) {
        this.a = a;
        this.c = c;
        this.d = d;
        this.f = f;
        this.b = 1;
        this.e = 512;
    }
    
    public boolean a(final StructureBoundingBox structureBoundingBox) {
        return this.d >= structureBoundingBox.a && this.a <= structureBoundingBox.d && this.f >= structureBoundingBox.c && this.c <= structureBoundingBox.f && this.e >= structureBoundingBox.b && this.b <= structureBoundingBox.e;
    }
    
    public boolean a(final int n, final int n2, final int n3, final int n4) {
        return this.d >= n && this.a <= n3 && this.f >= n2 && this.c <= n4;
    }
    
    public void b(final StructureBoundingBox structureBoundingBox) {
        this.a = Math.min(this.a, structureBoundingBox.a);
        this.b = Math.min(this.b, structureBoundingBox.b);
        this.c = Math.min(this.c, structureBoundingBox.c);
        this.d = Math.max(this.d, structureBoundingBox.d);
        this.e = Math.max(this.e, structureBoundingBox.e);
        this.f = Math.max(this.f, structureBoundingBox.f);
    }
    
    public void a(final int n, final int n2, final int n3) {
        this.a += n;
        this.b += n2;
        this.c += n3;
        this.d += n;
        this.e += n2;
        this.f += n3;
    }
    
    public boolean b(final int n, final int n2, final int n3) {
        return n >= this.a && n <= this.d && n3 >= this.c && n3 <= this.f && n2 >= this.b && n2 <= this.e;
    }
    
    public int b() {
        return this.d - this.a + 1;
    }
    
    public int c() {
        return this.e - this.b + 1;
    }
    
    public int d() {
        return this.f - this.c + 1;
    }
    
    public int e() {
        return this.a + (this.d - this.a + 1) / 2;
    }
    
    public int f() {
        return this.b + (this.e - this.b + 1) / 2;
    }
    
    public int g() {
        return this.c + (this.f - this.c + 1) / 2;
    }
    
    @Override
    public String toString() {
        return "(" + this.a + ", " + this.b + ", " + this.c + "; " + this.d + ", " + this.e + ", " + this.f + ")";
    }
    
    public NBTTagIntArray h() {
        return new NBTTagIntArray(new int[] { this.a, this.b, this.c, this.d, this.e, this.f });
    }
}
