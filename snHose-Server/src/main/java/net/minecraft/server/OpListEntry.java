package net.minecraft.server;

import net.minecraft.util.com.mojang.authlib.*;
import net.minecraft.util.com.google.gson.*;
import java.util.*;

public class OpListEntry extends JsonListEntry
{
    private final int a;
    
    public OpListEntry(final GameProfile object, final int a) {
        super(object);
        this.a = a;
    }
    
    public OpListEntry(final JsonObject jsonobject) {
        super(b(jsonobject), jsonobject);
        this.a = (jsonobject.has("level") ? jsonobject.get("level").getAsInt() : 0);
    }
    
    public int a() {
        return this.a;
    }
    
    @Override
    protected void a(final JsonObject jsonobject) {
        if (this.getKey() == null) {
            return;
        }
        jsonobject.addProperty("uuid", (((GameProfile)this.getKey()).getId() == null) ? "" : ((GameProfile)this.getKey()).getId().toString());
        jsonobject.addProperty("name", ((GameProfile)this.getKey()).getName());
        super.a(jsonobject);
        jsonobject.addProperty("level", this.a);
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
