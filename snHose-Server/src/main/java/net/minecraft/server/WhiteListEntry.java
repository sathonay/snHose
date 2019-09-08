package net.minecraft.server.v1_7_R4;

import net.minecraft.util.com.mojang.authlib.*;
import net.minecraft.util.com.google.gson.*;
import java.util.*;

public class WhiteListEntry extends JsonListEntry
{
    public WhiteListEntry(final GameProfile object) {
        super(object);
    }
    
    public WhiteListEntry(final JsonObject jsonobject) {
        super(b(jsonobject), jsonobject);
    }
    
    @Override
    protected void a(final JsonObject jsonobject) {
        if (this.getKey() == null) {
            return;
        }
        jsonobject.addProperty("uuid", (((GameProfile)this.getKey()).getId() == null) ? "" : ((GameProfile)this.getKey()).getId().toString());
        jsonobject.addProperty("name", ((GameProfile)this.getKey()).getName());
        super.a(jsonobject);
    }
    
    private static GameProfile b(final JsonObject jsonObject) {
        if (!jsonObject.has("uuid") || !jsonObject.has("name")) {
            return null;
        }
        final String asString = jsonObject.get("uuid").getAsString();
        UUID fromString;
        try {
            fromString = UUID.fromString(asString);
        }
        catch (Throwable t) {
            return null;
        }
        return new GameProfile(fromString, jsonObject.get("name").getAsString());
    }
}
