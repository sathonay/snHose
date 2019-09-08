package net.minecraft.server.v1_7_R4;

import java.lang.reflect.*;
import net.minecraft.util.com.google.gson.*;

public class ServerPingServerDataSerializer implements JsonDeserializer, JsonSerializer
{
    public ServerPingServerData a(final JsonElement jsonElement, final Type type, final JsonDeserializationContext jsonDeserializationContext) {
        final JsonObject l = ChatDeserializer.l(jsonElement, "version");
        return new ServerPingServerData(ChatDeserializer.h(l, "name"), ChatDeserializer.m(l, "protocol"));
    }
    
    public JsonElement a(final ServerPingServerData serverPingServerData, final Type type, final JsonSerializationContext jsonSerializationContext) {
        final JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("name", serverPingServerData.a());
        jsonObject.addProperty("protocol", serverPingServerData.b());
        return jsonObject;
    }
}
