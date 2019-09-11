package net.minecraft.server;

import java.util.regex.*;
import net.minecraft.util.com.google.common.base.*;
import net.minecraft.util.org.apache.commons.io.*;
import net.minecraft.util.com.google.common.collect.*;
import java.io.*;
import java.util.*;

public class LocaleLanguage
{
    private static final Pattern a;
    private static final Splitter b;
    private static LocaleLanguage c;
    private final Map d;
    private long e;
    
    public LocaleLanguage() {
        this.d = Maps.newHashMap();
        try {
            for (final String sequence : IOUtils.readLines(LocaleLanguage.class.getResourceAsStream("/assets/minecraft/lang/en_US.lang"), Charsets.UTF_8)) {
                if (!sequence.isEmpty()) {
                    if (sequence.charAt(0) == '#') {
                        continue;
                    }
                    final String[] array = Iterables.toArray(LocaleLanguage.b.split(sequence), String.class);
                    if (array == null) {
                        continue;
                    }
                    if (array.length != 2) {
                        continue;
                    }
                    this.d.put(array[0], LocaleLanguage.a.matcher(array[1]).replaceAll("%$1s"));
                }
            }
            this.e = System.currentTimeMillis();
        }
        catch (IOException ex) {}
    }
    
    static LocaleLanguage a() {
        return LocaleLanguage.c;
    }
    
    public synchronized String a(final String s) {
        return this.c(s);
    }
    
    public synchronized String a(final String s, final Object... array) {
        final String c = this.c(s);
        try {
            return String.format(c, array);
        }
        catch (IllegalFormatException ex) {
            return "Format error: " + c;
        }
    }
    
    private String c(final String s) {
        final String s2 = this.d.get(s);
        return (s2 == null) ? s : s2;
    }
    
    public synchronized boolean b(final String s) {
        return this.d.containsKey(s);
    }
    
    public long c() {
        return this.e;
    }
    
    static {
        a = Pattern.compile("%(\\d+\\$)?[\\d\\.]*[df]");
        b = Splitter.on('=').limit(2);
        LocaleLanguage.c = new LocaleLanguage();
    }
}
