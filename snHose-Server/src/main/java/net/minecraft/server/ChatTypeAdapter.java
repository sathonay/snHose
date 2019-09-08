package net.minecraft.server.v1_7_R4;

import net.minecraft.util.com.google.gson.stream.*;
import net.minecraft.util.com.google.gson.*;
import net.minecraft.util.com.google.gson.reflect.*;
import java.util.*;

class ChatTypeAdapter extends TypeAdapter
{
    final /* synthetic */ Map a;
    final /* synthetic */ ChatTypeAdapterFactory b;
    
    ChatTypeAdapter(final ChatTypeAdapterFactory b, final Map a) {
        this.b = b;
        this.a = a;
    }
    
    @Override
    public void write(final JsonWriter jsonWriter, final Object o) {
        if (o == null) {
            jsonWriter.nullValue();
        }
        else {
            jsonWriter.value(this.b.a(o));
        }
    }
    
    @Override
    public Object read(final JsonReader jsonReader) {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        return this.a.get(jsonReader.nextString());
    }
}
