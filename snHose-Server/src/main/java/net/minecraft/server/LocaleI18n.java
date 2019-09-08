package net.minecraft.server.v1_7_R4;

public class LocaleI18n
{
    private static LocaleLanguage a;
    private static LocaleLanguage b;
    
    public static String get(final String s) {
        return LocaleI18n.a.a(s);
    }
    
    public static String get(final String s, final Object... array) {
        return LocaleI18n.a.a(s, array);
    }
    
    public static String b(final String s) {
        return LocaleI18n.b.a(s);
    }
    
    public static boolean c(final String s) {
        return LocaleI18n.a.b(s);
    }
    
    public static long a() {
        return LocaleI18n.a.c();
    }
    
    static {
        LocaleI18n.a = LocaleLanguage.a();
        LocaleI18n.b = new LocaleLanguage();
    }
}
