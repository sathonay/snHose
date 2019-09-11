package net.minecraft.server;

import java.util.*;

public class WorldGenFlatInfo
{
    private final List layers;
    private final Map structures;
    private int c;
    
    public WorldGenFlatInfo() {
        this.layers = new ArrayList();
        this.structures = new HashMap();
    }
    
    public int a() {
        return this.c;
    }
    
    public void a(final int c) {
        this.c = c;
    }
    
    public Map b() {
        return this.structures;
    }
    
    public List c() {
        return this.layers;
    }
    
    public void d() {
        int n = 0;
        for (final WorldGenFlatLayerInfo worldGenFlatLayerInfo : this.layers) {
            worldGenFlatLayerInfo.c(n);
            n += worldGenFlatLayerInfo.a();
        }
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(2);
        sb.append(";");
        for (int i = 0; i < this.layers.size(); ++i) {
            if (i > 0) {
                sb.append(",");
            }
            sb.append(((WorldGenFlatLayerInfo)this.layers.get(i)).toString());
        }
        sb.append(";");
        sb.append(this.c);
        if (!this.structures.isEmpty()) {
            sb.append(";");
            int n = 0;
            for (final Map.Entry<String, V> entry : this.structures.entrySet()) {
                if (n++ > 0) {
                    sb.append(",");
                }
                sb.append(entry.getKey().toLowerCase());
                final Map map = (Map)entry.getValue();
                if (!map.isEmpty()) {
                    sb.append("(");
                    int n2 = 0;
                    for (final Map.Entry<String, V> entry2 : map.entrySet()) {
                        if (n2++ > 0) {
                            sb.append(" ");
                        }
                        sb.append(entry2.getKey());
                        sb.append("=");
                        sb.append((String)entry2.getValue());
                    }
                    sb.append(")");
                }
            }
        }
        else {
            sb.append(";");
        }
        return sb.toString();
    }
    
    private static WorldGenFlatLayerInfo a(final String s, final int n) {
        final String[] split = s.split("x", 2);
        int int1 = 1;
        int int2 = 0;
        if (split.length == 2) {
            try {
                int1 = Integer.parseInt(split[0]);
                if (n + int1 >= 256) {
                    int1 = 256 - n;
                }
                if (int1 < 0) {
                    int1 = 0;
                }
            }
            catch (Throwable t) {
                return null;
            }
        }
        int int3;
        try {
            final String[] split2 = split[split.length - 1].split(":", 2);
            int3 = Integer.parseInt(split2[0]);
            if (split2.length > 1) {
                int2 = Integer.parseInt(split2[1]);
            }
            if (Block.getById(int3) == Blocks.AIR) {
                int3 = 0;
                int2 = 0;
            }
            if (int2 < 0 || int2 > 15) {
                int2 = 0;
            }
        }
        catch (Throwable t2) {
            return null;
        }
        final WorldGenFlatLayerInfo worldGenFlatLayerInfo = new WorldGenFlatLayerInfo(int1, Block.getById(int3), int2);
        worldGenFlatLayerInfo.c(n);
        return worldGenFlatLayerInfo;
    }
    
    private static List b(final String s) {
        if (s == null || s.length() < 1) {
            return null;
        }
        final ArrayList<WorldGenFlatLayerInfo> list = new ArrayList<WorldGenFlatLayerInfo>();
        final String[] split = s.split(",");
        int n = 0;
        final String[] array = split;
        for (int length = array.length, i = 0; i < length; ++i) {
            final WorldGenFlatLayerInfo a = a(array[i], n);
            if (a == null) {
                return null;
            }
            list.add(a);
            n += a.a();
        }
        return list;
    }
    
    public static WorldGenFlatInfo a(final String s) {
        if (s == null) {
            return e();
        }
        final String[] split = s.split(";", -1);
        final int n = (split.length == 1) ? 0 : MathHelper.a(split[0], 0);
        if (n < 0 || n > 2) {
            return e();
        }
        final WorldGenFlatInfo worldGenFlatInfo = new WorldGenFlatInfo();
        int n2 = (split.length != 1) ? 1 : 0;
        final List b = b(split[n2++]);
        if (b == null || b.isEmpty()) {
            return e();
        }
        worldGenFlatInfo.c().addAll(b);
        worldGenFlatInfo.d();
        int var1 = BiomeBase.PLAINS.id;
        if (n > 0 && split.length > n2) {
            var1 = MathHelper.a(split[n2++], var1);
        }
        worldGenFlatInfo.a(var1);
        if (n > 0 && split.length > n2) {
            final String[] split2 = split[n2++].toLowerCase().split(",");
            for (int length = split2.length, i = 0; i < length; ++i) {
                final String[] split3 = split2[i].split("\\(", 2);
                final HashMap<String, String> hashMap = new HashMap<String, String>();
                if (split3[0].length() > 0) {
                    worldGenFlatInfo.b().put(split3[0], hashMap);
                    if (split3.length > 1 && split3[1].endsWith(")") && split3[1].length() > 1) {
                        final String[] split4 = split3[1].substring(0, split3[1].length() - 1).split(" ");
                        for (int j = 0; j < split4.length; ++j) {
                            final String[] split5 = split4[j].split("=", 2);
                            if (split5.length == 2) {
                                hashMap.put(split5[0], split5[1]);
                            }
                        }
                    }
                }
            }
        }
        else {
            worldGenFlatInfo.b().put("village", new HashMap());
        }
        return worldGenFlatInfo;
    }
    
    public static WorldGenFlatInfo e() {
        final WorldGenFlatInfo worldGenFlatInfo = new WorldGenFlatInfo();
        worldGenFlatInfo.a(BiomeBase.PLAINS.id);
        worldGenFlatInfo.c().add(new WorldGenFlatLayerInfo(1, Blocks.BEDROCK));
        worldGenFlatInfo.c().add(new WorldGenFlatLayerInfo(2, Blocks.DIRT));
        worldGenFlatInfo.c().add(new WorldGenFlatLayerInfo(1, Blocks.GRASS));
        worldGenFlatInfo.d();
        worldGenFlatInfo.b().put("village", new HashMap());
        return worldGenFlatInfo;
    }
}
