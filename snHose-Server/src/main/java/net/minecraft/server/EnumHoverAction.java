package net.minecraft.server.v1_7_R4;

import java.util.*;
import net.minecraft.util.com.google.common.collect.*;

public enum EnumHoverAction
{
    SHOW_TEXT("SHOW_TEXT", 0, "show_text", true), 
    SHOW_ACHIEVEMENT("SHOW_ACHIEVEMENT", 1, "show_achievement", true), 
    SHOW_ITEM("SHOW_ITEM", 2, "show_item", true);
    
    private static final Map d;
    private final boolean e;
    private final String f;
    
    private EnumHoverAction(final String s, final int n, final String f, final boolean e) {
        this.f = f;
        this.e = e;
    }
    
    public boolean a() {
        return this.e;
    }
    
    public String b() {
        return this.f;
    }
    
    public static EnumHoverAction a(final String s) {
        return EnumHoverAction.d.get(s);
    }
    
    static {
        d = Maps.newHashMap();
        for (final EnumHoverAction enumHoverAction : values()) {
            EnumHoverAction.d.put(enumHoverAction.b(), enumHoverAction);
        }
    }
}
