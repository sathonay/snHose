package net.minecraft.server.v1_7_R4;

import java.util.*;
import net.minecraft.util.com.google.gson.*;

public class IpBanEntry extends ExpirableListEntry
{
    public IpBanEntry(final String s) {
        this(s, null, null, null, null);
    }
    
    public IpBanEntry(final String object, final Date date, final String s, final Date date2, final String s2) {
        super(object, date, s, date2, s2);
    }
    
    public IpBanEntry(final JsonObject jsonobject) {
        super(b(jsonobject), jsonobject);
    }
    
    private static String b(final JsonObject jsonObject) {
        return jsonObject.has("ip") ? jsonObject.get("ip").getAsString() : null;
    }
    
    @Override
    protected void a(final JsonObject jsonobject) {
        if (this.getKey() == null) {
            return;
        }
        jsonobject.addProperty("ip", (String)this.getKey());
        super.a(jsonobject);
    }
}
