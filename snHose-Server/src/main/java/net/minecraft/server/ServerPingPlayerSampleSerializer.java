package net.minecraft.server.v1_7_R4;

import java.lang.reflect.*;
import net.minecraft.util.com.mojang.authlib.*;
import java.util.*;
import net.minecraft.util.com.google.gson.*;

public class ServerPingPlayerSampleSerializer implements JsonDeserializer, JsonSerializer
{
    public ServerPingPlayerSample a(final JsonElement jsonElement, final Type type, final JsonDeserializationContext jsonDeserializationContext) {
        final JsonObject l = ChatDeserializer.l(jsonElement, "players");
        final ServerPingPlayerSample serverPingPlayerSample = new ServerPingPlayerSample(ChatDeserializer.m(l, "max"), ChatDeserializer.m(l, "online"));
        if (ChatDeserializer.d(l, "sample")) {
            final JsonArray t = ChatDeserializer.t(l, "sample");
            if (t.size() > 0) {
                final GameProfile[] array = new GameProfile[t.size()];
                for (int i = 0; i < array.length; ++i) {
                    final JsonObject j = ChatDeserializer.l(t.get(i), "player[" + i + "]");
                    array[i] = new GameProfile(UUID.fromString(ChatDeserializer.h(j, "id")), ChatDeserializer.h(j, "name"));
                }
                serverPingPlayerSample.a(array);
            }
        }
        return serverPingPlayerSample;
    }
    
    public JsonElement a(final ServerPingPlayerSample serverPingPlayerSample, final Type type, final JsonSerializationContext jsonSerializationContext) {
        final JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("max", serverPingPlayerSample.a());
        jsonObject.addProperty("online", serverPingPlayerSample.b());
        if (serverPingPlayerSample.c() != null && serverPingPlayerSample.c().length > 0) {
            final JsonArray value = new JsonArray();
            for (int i = 0; i < serverPingPlayerSample.c().length; ++i) {
                final JsonObject element = new JsonObject();
                final UUID id = serverPingPlayerSample.c()[i].getId();
                element.addProperty("id", (id == null) ? "" : id.toString());
                element.addProperty("name", serverPingPlayerSample.c()[i].getName());
                value.add(element);
            }
            jsonObject.add("sample", value);
        }
        return jsonObject;
    }
}
