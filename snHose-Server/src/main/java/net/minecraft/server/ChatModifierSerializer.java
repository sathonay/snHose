package net.minecraft.server;

import java.lang.reflect.*;
import net.minecraft.util.com.google.gson.*;

public class ChatModifierSerializer implements JsonDeserializer<ChatModifier>, JsonSerializer<ChatModifier>
{
    public ChatModifier a(final JsonElement jsonElement, final Type type, final JsonDeserializationContext jsonDeserializationContext) {
        if (!jsonElement.isJsonObject()) {
            return null;
        }
        final ChatModifier chatModifier = new ChatModifier();
        final JsonObject asJsonObject = jsonElement.getAsJsonObject();
        if (asJsonObject == null) {
            return null;
        }
        if (asJsonObject.has("bold")) {
            chatModifier.setBold(Boolean.valueOf(asJsonObject.get("bold").getAsBoolean()));
        }
        if (asJsonObject.has("italic")) {
            chatModifier.setItalic(asJsonObject.get("italic").getAsBoolean());
        }
        if (asJsonObject.has("underlined")) {
            chatModifier.setUnderline(asJsonObject.get("underlined").getAsBoolean());
        }
        if (asJsonObject.has("strikethrough")) {
            chatModifier.setStrikethrough(asJsonObject.get("strikethrough").getAsBoolean());
        }
        if (asJsonObject.has("obfuscated")) {
            chatModifier.setRandom(asJsonObject.get("obfuscated").getAsBoolean());
        }
        if (asJsonObject.has("color")) {
            chatModifier.setColor(jsonDeserializationContext.deserialize(asJsonObject.get("color"), EnumChatFormat.class));
        }
        if (asJsonObject.has("clickEvent")) {
            final JsonObject asJsonObject2 = asJsonObject.getAsJsonObject("clickEvent");
            if (asJsonObject2 != null) {
                final JsonPrimitive asJsonPrimitive = asJsonObject2.getAsJsonPrimitive("action");
                final EnumClickAction enumClickAction = (asJsonPrimitive == null) ? null : EnumClickAction.a(asJsonPrimitive.getAsString());
                final JsonPrimitive asJsonPrimitive2 = asJsonObject2.getAsJsonPrimitive("value");
                final String s = (asJsonPrimitive2 == null) ? null : asJsonPrimitive2.getAsString();
                if (enumClickAction != null && s != null && enumClickAction.a()) {
                    chatModifier.setChatClickable(new ChatClickable(enumClickAction, s));
                }
            }
        }
        if (asJsonObject.has("hoverEvent")) {
            final JsonObject asJsonObject3 = asJsonObject.getAsJsonObject("hoverEvent");
            if (asJsonObject3 != null) {
                final JsonPrimitive asJsonPrimitive3 = asJsonObject3.getAsJsonPrimitive("action");
                final EnumHoverAction enumHoverAction = (asJsonPrimitive3 == null) ? null : EnumHoverAction.a(asJsonPrimitive3.getAsString());
                final IChatBaseComponent chatBaseComponent = jsonDeserializationContext.deserialize(asJsonObject3.get("value"), IChatBaseComponent.class);
                if (enumHoverAction != null && chatBaseComponent != null && enumHoverAction.a()) {
                    chatModifier.a(new ChatHoverable(enumHoverAction, chatBaseComponent));
                }
            }
        }
        return chatModifier;
    }
    
    public JsonElement a(final ChatModifier chatModifier, final Type type, final JsonSerializationContext jsonSerializationContext) {
        if (chatModifier.g()) {
            return null;
        }
        final JsonObject jsonObject = new JsonObject();
        if (chatModifier.c() != null) {
            jsonObject.addProperty("bold", chatModifier.c());
        }
        if (chatModifier.d() != null) {
            jsonObject.addProperty("italic", chatModifier.d());
        }
        if (chatModifier.e() != null) {
            jsonObject.addProperty("underlined", chatModifier.e());
        }
        if (chatModifier.f() != null) {
            jsonObject.addProperty("strikethrough", chatModifier.f());
        }
        if (chatModifier.g() != null) {
            jsonObject.addProperty("obfuscated", chatModifier.g());
        }
        if (chatModifier.b() != null) {
            jsonObject.add("color", jsonSerializationContext.serialize(chatModifier.b()));
        }
        if (chatModifier.h() != null) {
            final JsonObject value = new JsonObject();
            value.addProperty("action", chatModifier.h().a().b());
            value.addProperty("value", chatModifier.h().b());
            jsonObject.add("clickEvent", value);
        }
        ChatHoverable hoverable = chatModifier.i();
        if (hoverable != null) {
            final JsonObject value2 = new JsonObject();
            value2.addProperty("action", hoverable.a().b());
            value2.add("value", jsonSerializationContext.serialize(hoverable.b()));
            jsonObject.add("hoverEvent", value2);
        }
        return jsonObject;
    }

    @Override
    public ChatModifier deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return this.a(jsonElement, type, jsonDeserializationContext);
    }

    @Override
    public JsonElement serialize(ChatModifier chatModifier, Type type, JsonSerializationContext jsonSerializationContext) {
        return this.a(chatModifier, type, jsonSerializationContext);
    }
}
