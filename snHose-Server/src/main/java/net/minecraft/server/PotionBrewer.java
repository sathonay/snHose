package net.minecraft.server;

import java.util.*;

public class PotionBrewer
{
    public static final String a;
    public static final String b;
    public static final String c;
    public static final String d;
    public static final String e;
    public static final String f;
    public static final String g;
    public static final String h;
    public static final String i;
    public static final String j;
    public static final String k;
    public static final String l;
    public static final String m;
    private static final HashMap effectDurations;
    private static final HashMap effectAmplifiers;
    private static final HashMap p;
    private static final String[] appearances;
    
    public static boolean a(final int n, final int n2) {
        return (n & 1 << n2) != 0x0;
    }
    
    private static int c(final int n, final int n2) {
        return a(n, n2) ? 1 : 0;
    }
    
    private static int d(final int n, final int n2) {
        return a(n, n2) ? 0 : 1;
    }
    
    public static int a(final int n) {
        return a(n, 5, 4, 3, 2, 1);
    }
    
    public static int a(final Collection collection) {
        final int n = 3694022;
        if (collection == null || collection.isEmpty()) {
            return n;
        }
        float n2 = 0.0f;
        float n3 = 0.0f;
        float n4 = 0.0f;
        float n5 = 0.0f;
        for (final MobEffect mobEffect : collection) {
            final int j = MobEffectList.byId[mobEffect.getEffectId()].j();
            for (int i = 0; i <= mobEffect.getAmplifier(); ++i) {
                n2 += (j >> 16 & 0xFF) / 255.0f;
                n3 += (j >> 8 & 0xFF) / 255.0f;
                n4 += (j >> 0 & 0xFF) / 255.0f;
                ++n5;
            }
        }
        return (int)(n2 / n5 * 255.0f) << 16 | (int)(n3 / n5 * 255.0f) << 8 | (int)(n4 / n5 * 255.0f);
    }
    
    public static boolean b(final Collection collection) {
        final Iterator<MobEffect> iterator = collection.iterator();
        while (iterator.hasNext()) {
            if (!iterator.next().isAmbient()) {
                return false;
            }
        }
        return true;
    }
    
    public static String c(final int n) {
        return PotionBrewer.appearances[a(n)];
    }
    
    private static int a(final boolean b, final boolean b2, final boolean b3, final int n, final int n2, final int n3, final int n4) {
        int n5 = 0;
        if (b) {
            n5 = d(n4, n2);
        }
        else if (n != -1) {
            if (n == 0 && h(n4) == n2) {
                n5 = 1;
            }
            else if (n == 1 && h(n4) > n2) {
                n5 = 1;
            }
            else if (n == 2 && h(n4) < n2) {
                n5 = 1;
            }
        }
        else {
            n5 = c(n4, n2);
        }
        if (b2) {
            n5 *= n3;
        }
        if (b3) {
            n5 *= -1;
        }
        return n5;
    }
    
    private static int h(int i) {
        int n;
        for (n = 0; i > 0; i &= i - 1, ++n) {}
        return n;
    }
    
    private static int a(final String s, final int n, final int n2, final int n3) {
        if (n >= s.length() || n2 < 0 || n >= n2) {
            return 0;
        }
        final int index = s.indexOf(124, n);
        if (index >= 0 && index < n2) {
            final int a = a(s, n, index - 1, n3);
            if (a > 0) {
                return a;
            }
            final int a2 = a(s, index + 1, n2, n3);
            if (a2 > 0) {
                return a2;
            }
            return 0;
        }
        else {
            final int index2 = s.indexOf(38, n);
            if (index2 < 0 || index2 >= n2) {
                int n4 = 0;
                boolean b = false;
                boolean b2 = false;
                boolean b3 = false;
                boolean b4 = false;
                int n5 = -1;
                int n6 = 0;
                int n7 = 0;
                int n8 = 0;
                for (int i = n; i < n2; ++i) {
                    final char char1 = s.charAt(i);
                    if (char1 >= '0' && char1 <= '9') {
                        if (n4 != 0) {
                            n7 = char1 - '0';
                            b = true;
                        }
                        else {
                            n6 = n6 * 10 + (char1 - '0');
                            b2 = true;
                        }
                    }
                    else if (char1 == '*') {
                        n4 = 1;
                    }
                    else if (char1 == '!') {
                        if (b2) {
                            n8 += a(b3, b, b4, n5, n6, n7, n3);
                            b = (b2 = ((n4 = ((b4 = false) ? 1 : 0)) != 0));
                            n7 = (n6 = 0);
                            n5 = -1;
                        }
                        b3 = true;
                    }
                    else if (char1 == '-') {
                        if (b2) {
                            n8 += a(b3, b, b4, n5, n6, n7, n3);
                            b = (b2 = ((n4 = ((b3 = false) ? 1 : 0)) != 0));
                            n7 = (n6 = 0);
                            n5 = -1;
                        }
                        b4 = true;
                    }
                    else if (char1 == '=' || char1 == '<' || char1 == '>') {
                        if (b2) {
                            n8 += a(b3, b, b4, n5, n6, n7, n3);
                            b = (b2 = ((n4 = ((b4 = (b3 = false)) ? 1 : 0)) != 0));
                            n7 = (n6 = 0);
                            n5 = -1;
                        }
                        if (char1 == '=') {
                            n5 = 0;
                        }
                        else if (char1 == '<') {
                            n5 = 2;
                        }
                        else if (char1 == '>') {
                            n5 = 1;
                        }
                    }
                    else if (char1 == '+' && b2) {
                        n8 += a(b3, b, b4, n5, n6, n7, n3);
                        b = (b2 = ((n4 = ((b4 = (b3 = false)) ? 1 : 0)) != 0));
                        n7 = (n6 = 0);
                        n5 = -1;
                    }
                }
                if (b2) {
                    n8 += a(b3, b, b4, n5, n6, n7, n3);
                }
                return n8;
            }
            final int a3 = a(s, n, index2 - 1, n3);
            if (a3 <= 0) {
                return 0;
            }
            final int a4 = a(s, index2 + 1, n2, n3);
            if (a4 <= 0) {
                return 0;
            }
            if (a3 > a4) {
                return a3;
            }
            return a4;
        }
    }
    
    public static List getEffects(final int n, final boolean b) {
        List<MobEffect> list = null;
        for (final MobEffectList list2 : MobEffectList.byId) {
            if (list2 != null) {
                if (!list2.i() || b) {
                    final String s = PotionBrewer.effectDurations.get(list2.getId());
                    if (s != null) {
                        final int a = a(s, 0, s.length(), n);
                        if (a > 0) {
                            int a2 = 0;
                            final String s2 = PotionBrewer.effectAmplifiers.get(list2.getId());
                            if (s2 != null) {
                                a2 = a(s2, 0, s2.length(), n);
                                if (a2 < 0) {
                                    a2 = 0;
                                }
                            }
                            int n2;
                            if (list2.isInstant()) {
                                n2 = 1;
                            }
                            else {
                                n2 = (int)Math.round((1200 * (a * 3 + (a - 1) * 2) >> a2) * list2.getDurationModifier());
                                if ((n & 0x4000) != 0x0) {
                                    n2 = (int)Math.round(n2 * 0.75 + 0.5);
                                }
                            }
                            if (list == null) {
                                list = new ArrayList<MobEffect>();
                            }
                            final MobEffect mobEffect = new MobEffect(list2.getId(), n2, a2);
                            if ((n & 0x4000) != 0x0) {
                                mobEffect.setSplash(true);
                            }
                            list.add(mobEffect);
                        }
                    }
                }
            }
        }
        return list;
    }
    
    private static int a(int n, final int n2, final boolean b, final boolean b2, final boolean b3) {
        if (b3) {
            if (!a(n, n2)) {
                return 0;
            }
        }
        else if (b) {
            n &= ~(1 << n2);
        }
        else if (b2) {
            if ((n & 1 << n2) == 0x0) {
                n |= 1 << n2;
            }
            else {
                n &= ~(1 << n2);
            }
        }
        else {
            n |= 1 << n2;
        }
        return n;
    }
    
    public static int a(int n, final String s) {
        final int n2 = 0;
        final int length = s.length();
        boolean b = false;
        boolean b2 = false;
        boolean b3 = false;
        boolean b4 = false;
        int n3 = 0;
        for (int i = n2; i < length; ++i) {
            final char char1 = s.charAt(i);
            if (char1 >= '0' && char1 <= '9') {
                n3 = n3 * 10 + (char1 - '0');
                b = true;
            }
            else if (char1 == '!') {
                if (b) {
                    n = a(n, n3, b3, b2, b4);
                    b3 = (b = (b4 = false));
                    n3 = 0;
                }
                b2 = true;
            }
            else if (char1 == '-') {
                if (b) {
                    n = a(n, n3, b3, b2, b4);
                    b2 = (b = (b4 = false));
                    n3 = 0;
                }
                b3 = true;
            }
            else if (char1 == '+') {
                if (b) {
                    n = a(n, n3, b3, b2, b4);
                    b3 = (b = (b2 = (b4 = false)));
                    n3 = 0;
                }
            }
            else if (char1 == '&') {
                if (b) {
                    n = a(n, n3, b3, b2, b4);
                    b3 = (b = (b2 = false));
                    n3 = 0;
                }
                b4 = true;
            }
        }
        if (b) {
            n = a(n, n3, b3, b2, b4);
        }
        return n & 0x7FFF;
    }
    
    public static int a(final int n, final int n2, final int n3, final int n4, final int n5, final int n6) {
        return (a(n, n2) ? 16 : 0) | (a(n, n3) ? 8 : 0) | (a(n, n4) ? 4 : 0) | (a(n, n5) ? 2 : 0) | (a(n, n6) ? 1 : 0);
    }
    
    static {
        effectDurations = new HashMap();
        effectAmplifiers = new HashMap();
        a = null;
        c = "+0-1-2-3&4-4+13";
        PotionBrewer.effectDurations.put(MobEffectList.REGENERATION.getId(), "0 & !1 & !2 & !3 & 0+6");
        b = "-0+1-2-3&4-4+13";
        PotionBrewer.effectDurations.put(MobEffectList.FASTER_MOVEMENT.getId(), "!0 & 1 & !2 & !3 & 1+6");
        h = "+0+1-2-3&4-4+13";
        PotionBrewer.effectDurations.put(MobEffectList.FIRE_RESISTANCE.getId(), "0 & 1 & !2 & !3 & 0+6");
        f = "+0-1+2-3&4-4+13";
        PotionBrewer.effectDurations.put(MobEffectList.HEAL.getId(), "0 & !1 & 2 & !3");
        d = "-0-1+2-3&4-4+13";
        PotionBrewer.effectDurations.put(MobEffectList.POISON.getId(), "!0 & !1 & 2 & !3 & 2+6");
        e = "-0+3-4+13";
        PotionBrewer.effectDurations.put(MobEffectList.WEAKNESS.getId(), "!0 & !1 & !2 & 3 & 3+6");
        PotionBrewer.effectDurations.put(MobEffectList.HARM.getId(), "!0 & !1 & 2 & 3");
        PotionBrewer.effectDurations.put(MobEffectList.SLOWER_MOVEMENT.getId(), "!0 & 1 & !2 & 3 & 3+6");
        g = "+0-1-2+3&4-4+13";
        PotionBrewer.effectDurations.put(MobEffectList.INCREASE_DAMAGE.getId(), "0 & !1 & !2 & 3 & 3+6");
        l = "-0+1+2-3+13&4-4";
        PotionBrewer.effectDurations.put(MobEffectList.NIGHT_VISION.getId(), "!0 & 1 & 2 & !3 & 2+6");
        PotionBrewer.effectDurations.put(MobEffectList.INVISIBILITY.getId(), "!0 & 1 & 2 & 3 & 2+6");
        m = "+0-1+2+3+13&4-4";
        PotionBrewer.effectDurations.put(MobEffectList.WATER_BREATHING.getId(), "0 & !1 & 2 & 3 & 2+6");
        j = "+5-6-7";
        PotionBrewer.effectAmplifiers.put(MobEffectList.FASTER_MOVEMENT.getId(), "5");
        PotionBrewer.effectAmplifiers.put(MobEffectList.FASTER_DIG.getId(), "5");
        PotionBrewer.effectAmplifiers.put(MobEffectList.INCREASE_DAMAGE.getId(), "5");
        PotionBrewer.effectAmplifiers.put(MobEffectList.REGENERATION.getId(), "5");
        PotionBrewer.effectAmplifiers.put(MobEffectList.HARM.getId(), "5");
        PotionBrewer.effectAmplifiers.put(MobEffectList.HEAL.getId(), "5");
        PotionBrewer.effectAmplifiers.put(MobEffectList.RESISTANCE.getId(), "5");
        PotionBrewer.effectAmplifiers.put(MobEffectList.POISON.getId(), "5");
        i = "-5+6-7";
        k = "+14&13-13";
        p = new HashMap();
        appearances = new String[] { "potion.prefix.mundane", "potion.prefix.uninteresting", "potion.prefix.bland", "potion.prefix.clear", "potion.prefix.milky", "potion.prefix.diffuse", "potion.prefix.artless", "potion.prefix.thin", "potion.prefix.awkward", "potion.prefix.flat", "potion.prefix.bulky", "potion.prefix.bungling", "potion.prefix.buttered", "potion.prefix.smooth", "potion.prefix.suave", "potion.prefix.debonair", "potion.prefix.thick", "potion.prefix.elegant", "potion.prefix.fancy", "potion.prefix.charming", "potion.prefix.dashing", "potion.prefix.refined", "potion.prefix.cordial", "potion.prefix.sparkling", "potion.prefix.potent", "potion.prefix.foul", "potion.prefix.odorless", "potion.prefix.rank", "potion.prefix.harsh", "potion.prefix.acrid", "potion.prefix.gross", "potion.prefix.stinky" };
    }
}
