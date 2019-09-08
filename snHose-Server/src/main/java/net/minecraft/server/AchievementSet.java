package net.minecraft.server.v1_7_R4;

import net.minecraft.util.com.google.common.collect.*;
import net.minecraft.util.com.google.gson.*;
import java.util.*;

public class AchievementSet extends ForwardingSet implements IJsonStatistic
{
    private final Set a;
    
    public AchievementSet() {
        this.a = Sets.newHashSet();
    }
    
    @Override
    public void a(final JsonElement jsonElement) {
        if (jsonElement.isJsonArray()) {
            final Iterator<JsonElement> iterator = jsonElement.getAsJsonArray().iterator();
            while (iterator.hasNext()) {
                this.add(iterator.next().getAsString());
            }
        }
    }
    
    @Override
    public JsonElement a() {
        final JsonArray jsonArray = new JsonArray();
        final Iterator<String> iterator = this.iterator();
        while (iterator.hasNext()) {
            jsonArray.add(new JsonPrimitive(iterator.next()));
        }
        return jsonArray;
    }
    
    @Override
    protected Set delegate() {
        return this.a;
    }
}
