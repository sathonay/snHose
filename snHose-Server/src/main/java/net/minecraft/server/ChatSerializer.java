package net.minecraft.server.v1_7_R4;

import java.lang.reflect.*;
import java.util.*;
import net.minecraft.util.com.google.gson.*;

public class ChatSerializer implements JsonDeserializer, JsonSerializer
{
    private static final Gson a;
    
    public IChatBaseComponent a(final JsonElement jsonElement, final Type type, final JsonDeserializationContext jsonDeserializationContext) {
        if (jsonElement.isJsonPrimitive()) {
            return new ChatComponentText(jsonElement.getAsString());
        }
        if (jsonElement.isJsonObject()) {
            final JsonObject asJsonObject = jsonElement.getAsJsonObject();
            ChatBaseComponent chatBaseComponent;
            if (asJsonObject.has("text")) {
                chatBaseComponent = new ChatComponentText(asJsonObject.get("text").getAsString());
            }
            else {
                if (!asJsonObject.has("translate")) {
                    throw new JsonParseException("Don't know how to turn " + jsonElement.toString() + " into a Component");
                }
                final String asString = asJsonObject.get("translate").getAsString();
                if (asJsonObject.has("with")) {
                    final JsonArray asJsonArray = asJsonObject.getAsJsonArray("with");
                    final Object[] array = new Object[asJsonArray.size()];
                    for (int i = 0; i < array.length; ++i) {
                        array[i] = this.a(asJsonArray.get(i), type, jsonDeserializationContext);
                        if (array[i] instanceof ChatComponentText) {
                            final ChatComponentText chatComponentText = (ChatComponentText)array[i];
                            if (chatComponentText.getChatModifier().g() && chatComponentText.a().isEmpty()) {
                                array[i] = chatComponentText.g();
                            }
                        }
                    }
                    chatBaseComponent = new ChatMessage(asString, array);
                }
                else {
                    chatBaseComponent = new ChatMessage(asString, new Object[0]);
                }
            }
            if (asJsonObject.has("extra")) {
                final JsonArray asJsonArray2 = asJsonObject.getAsJsonArray("extra");
                if (asJsonArray2.size() <= 0) {
                    throw new JsonParseException("Unexpected empty array of components");
                }
                for (int j = 0; j < asJsonArray2.size(); ++j) {
                    chatBaseComponent.addSibling(this.a(asJsonArray2.get(j), type, jsonDeserializationContext));
                }
            }
            chatBaseComponent.setChatModifier(jsonDeserializationContext.deserialize(jsonElement, ChatModifier.class));
            return chatBaseComponent;
        }
        if (jsonElement.isJsonArray()) {
            final JsonArray asJsonArray3 = jsonElement.getAsJsonArray();
            IChatBaseComponent chatBaseComponent2 = null;
            for (final JsonElement jsonElement2 : asJsonArray3) {
                final IChatBaseComponent a = this.a(jsonElement2, jsonElement2.getClass(), jsonDeserializationContext);
                if (chatBaseComponent2 == null) {
                    chatBaseComponent2 = a;
                }
                else {
                    chatBaseComponent2.addSibling(a);
                }
            }
            return chatBaseComponent2;
        }
        throw new JsonParseException("Don't know how to turn " + jsonElement.toString() + " into a Component");
    }
    
    private void a(final ChatModifier chatModifier, final JsonObject jsonObject, final JsonSerializationContext jsonSerializationContext) {
        final JsonElement serialize = jsonSerializationContext.serialize(chatModifier);
        if (serialize.isJsonObject()) {
            for (final Map.Entry<String, JsonElement> entry : ((JsonObject)serialize).entrySet()) {
                jsonObject.add(entry.getKey(), entry.getValue());
            }
        }
    }
    
    public JsonElement a(final IChatBaseComponent chatBaseComponent, final Type type, final JsonSerializationContext jsonSerializationContext) {
        if (chatBaseComponent instanceof ChatComponentText && chatBaseComponent.getChatModifier().g() && chatBaseComponent.a().isEmpty()) {
            return new JsonPrimitive(((ChatComponentText)chatBaseComponent).g());
        }
        final JsonObject jsonObject = new JsonObject();
        if (!chatBaseComponent.getChatModifier().g()) {
            this.a(chatBaseComponent.getChatModifier(), jsonObject, jsonSerializationContext);
        }
        if (!chatBaseComponent.a().isEmpty()) {
            final JsonArray value = new JsonArray();
            for (final IChatBaseComponent chatBaseComponent2 : chatBaseComponent.a()) {
                value.add(this.a(chatBaseComponent2, chatBaseComponent2.getClass(), jsonSerializationContext));
            }
            jsonObject.add("extra", value);
        }
        if (chatBaseComponent instanceof ChatComponentText) {
            jsonObject.addProperty("text", ((ChatComponentText)chatBaseComponent).g());
        }
        else {
            if (!(chatBaseComponent instanceof ChatMessage)) {
                throw new IllegalArgumentException("Don't know how to serialize " + chatBaseComponent + " as a Component");
            }
            final ChatMessage chatMessage = (ChatMessage)chatBaseComponent;
            jsonObject.addProperty("translate", chatMessage.i());
            if (chatMessage.j() != null && chatMessage.j().length > 0) {
                final JsonArray value2 = new JsonArray();
                for (final Object o : chatMessage.j()) {
                    if (o instanceof IChatBaseComponent) {
                        value2.add(this.a((IChatBaseComponent)o, ((IChatBaseComponent)o).getClass(), jsonSerializationContext));
                    }
                    else {
                        value2.add(new JsonPrimitive(String.valueOf(o)));
                    }
                }
                jsonObject.add("with", value2);
            }
        }
        return jsonObject;
    }
    
    public static String a(final IChatBaseComponent src) {
        return ChatSerializer.a.toJson(src);
    }
    
    public static IChatBaseComponent a(final String json) {
        return ChatSerializer.a.fromJson(json, IChatBaseComponent.class);
    }
    
    static {
        final GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeHierarchyAdapter(IChatBaseComponent.class, new ChatSerializer());
        gsonBuilder.registerTypeHierarchyAdapter(ChatModifier.class, new ChatModifierSerializer());
        gsonBuilder.registerTypeAdapterFactory(new ChatTypeAdapterFactory());
        a = gsonBuilder.create();
    }
}
