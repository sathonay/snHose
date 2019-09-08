package net.minecraft.server.v1_7_R4;

import net.minecraft.util.org.apache.commons.lang3.*;
import net.minecraft.util.com.google.gson.*;

public class ChatDeserializer
{
    public static boolean d(final JsonObject jsonObject, final String memberName) {
        return g(jsonObject, memberName) && jsonObject.get(memberName).isJsonArray();
    }
    
    public static boolean g(final JsonObject jsonObject, final String memberName) {
        return jsonObject != null && jsonObject.get(memberName) != null;
    }
    
    public static String a(final JsonElement jsonElement, final String s) {
        if (jsonElement.isJsonPrimitive()) {
            return jsonElement.getAsString();
        }
        throw new JsonSyntaxException("Expected " + s + " to be a string, was " + d(jsonElement));
    }
    
    public static String h(final JsonObject jsonObject, final String s) {
        if (jsonObject.has(s)) {
            return a(jsonObject.get(s), s);
        }
        throw new JsonSyntaxException("Missing " + s + ", expected to find a string");
    }
    
    public static int f(final JsonElement jsonElement, final String s) {
        if (jsonElement.isJsonPrimitive() && jsonElement.getAsJsonPrimitive().isNumber()) {
            return jsonElement.getAsInt();
        }
        throw new JsonSyntaxException("Expected " + s + " to be a Int, was " + d(jsonElement));
    }
    
    public static int m(final JsonObject jsonObject, final String s) {
        if (jsonObject.has(s)) {
            return f(jsonObject.get(s), s);
        }
        throw new JsonSyntaxException("Missing " + s + ", expected to find a Int");
    }
    
    public static JsonObject l(final JsonElement jsonElement, final String s) {
        if (jsonElement.isJsonObject()) {
            return jsonElement.getAsJsonObject();
        }
        throw new JsonSyntaxException("Expected " + s + " to be a JsonObject, was " + d(jsonElement));
    }
    
    public static JsonArray m(final JsonElement jsonElement, final String s) {
        if (jsonElement.isJsonArray()) {
            return jsonElement.getAsJsonArray();
        }
        throw new JsonSyntaxException("Expected " + s + " to be a JsonArray, was " + d(jsonElement));
    }
    
    public static JsonArray t(final JsonObject jsonObject, final String s) {
        if (jsonObject.has(s)) {
            return m(jsonObject.get(s), s);
        }
        throw new JsonSyntaxException("Missing " + s + ", expected to find a JsonArray");
    }
    
    public static String d(final JsonElement jsonElement) {
        final String abbreviateMiddle = StringUtils.abbreviateMiddle(String.valueOf(jsonElement), "...", 10);
        if (jsonElement == null) {
            return "null (missing)";
        }
        if (jsonElement.isJsonNull()) {
            return "null (json)";
        }
        if (jsonElement.isJsonArray()) {
            return "an array (" + abbreviateMiddle + ")";
        }
        if (jsonElement.isJsonObject()) {
            return "an object (" + abbreviateMiddle + ")";
        }
        if (jsonElement.isJsonPrimitive()) {
            final JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
            if (asJsonPrimitive.isNumber()) {
                return "a number (" + abbreviateMiddle + ")";
            }
            if (asJsonPrimitive.isBoolean()) {
                return "a boolean (" + abbreviateMiddle + ")";
            }
        }
        return abbreviateMiddle;
    }
}
