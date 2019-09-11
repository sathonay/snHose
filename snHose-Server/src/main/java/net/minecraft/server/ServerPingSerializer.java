package net.minecraft.server;

import java.lang.reflect.*;
import net.minecraft.util.com.google.gson.*;

public class ServerPingSerializer implements JsonDeserializer, JsonSerializer
{
    public ServerPing a(final JsonElement jsonElement, final Type type, final JsonDeserializationContext jsonDeserializationContext) {
        final JsonObject l = ChatDeserializer.l(jsonElement, "status");
        final ServerPing serverPing = new ServerPing();
        if (l.has("description")) {
            serverPing.setMOTD(jsonDeserializationContext.deserialize(l.get("description"), IChatBaseComponent.class));
        }
        if (l.has("players")) {
            serverPing.setPlayerSample(jsonDeserializationContext.deserialize(l.get("players"), ServerPingPlayerSample.class));
        }
        if (l.has("version")) {
            serverPing.setServerInfo(jsonDeserializationContext.deserialize(l.get("version"), ServerPingServerData.class));
        }
        if (l.has("favicon")) {
            serverPing.setFavicon(ChatDeserializer.h(l, "favicon"));
        }
        return serverPing;
    }
    
    public JsonElement a(final ServerPing serverPing, final Type type, final JsonSerializationContext jsonSerializationContext) {
        final JsonObject jsonObject = new JsonObject();
        if (serverPing.a() != null) {
            jsonObject.add("description", jsonSerializationContext.serialize(serverPing.a()));
        }
        if (serverPing.b() != null) {
            jsonObject.add("players", jsonSerializationContext.serialize(serverPing.b()));
        }
        if (serverPing.c() != null) {
            jsonObject.add("version", jsonSerializationContext.serialize(serverPing.c()));
        }
        if (serverPing.d() != null) {
            jsonObject.addProperty("favicon", serverPing.d());
        }
        return jsonObject;
    }
}
