package net.minecraft.server.v1_7_R4;

import java.util.*;
import net.minecraft.util.com.google.common.collect.*;

public enum EnumClickAction
{
    OPEN_URL("OPEN_URL", 0, "open_url", true), 
    OPEN_FILE("OPEN_FILE", 1, "open_file", false), 
    RUN_COMMAND("RUN_COMMAND", 2, "run_command", true), 
    TWITCH_USER_INFO("TWITCH_USER_INFO", 3, "twitch_user_info", false), 
    SUGGEST_COMMAND("SUGGEST_COMMAND", 4, "suggest_command", true);
    
    private static final Map f;
    private final boolean g;
    private final String h;
    
    private EnumClickAction(final String s, final int n, final String h, final boolean g) {
        this.h = h;
        this.g = g;
    }
    
    public boolean a() {
        return this.g;
    }
    
    public String b() {
        return this.h;
    }
    
    public static EnumClickAction a(final String s) {
        return EnumClickAction.f.get(s);
    }
    
    static {
        f = Maps.newHashMap();
        for (final EnumClickAction enumClickAction : values()) {
            EnumClickAction.f.put(enumClickAction.b(), enumClickAction);
        }
    }
}
