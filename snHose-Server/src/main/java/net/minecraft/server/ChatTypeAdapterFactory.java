package net.minecraft.server.v1_7_R4;

import net.minecraft.util.com.google.gson.reflect.*;
import net.minecraft.util.com.google.gson.*;
import java.util.*;

public class ChatTypeAdapterFactory implements TypeAdapterFactory
{
    @Override
    public TypeAdapter create(final Gson gson, final TypeToken typeToken) {
        final Class rawType = typeToken.getRawType();
        if (!rawType.isEnum()) {
            return null;
        }
        final HashMap<String, Object> hashMap = new HashMap<String, Object>();
        for (final Object o : rawType.getEnumConstants()) {
            hashMap.put(this.a(o), o);
        }
        return new ChatTypeAdapter(this, hashMap);
    }
    
    private String a(final Object o) {
        if (o instanceof Enum) {
            return ((Enum)o).name().toLowerCase(Locale.US);
        }
        return o.toString().toLowerCase(Locale.US);
    }
}
