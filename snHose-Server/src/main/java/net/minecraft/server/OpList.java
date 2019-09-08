package net.minecraft.server.v1_7_R4;

import java.io.*;
import net.minecraft.util.com.google.gson.*;
import net.minecraft.util.com.mojang.authlib.*;
import java.util.*;

public class OpList extends JsonList
{
    public OpList(final File file1) {
        super(file1);
    }
    
    @Override
    protected JsonListEntry a(final JsonObject jsonObject) {
        return new OpListEntry(jsonObject);
    }
    
    @Override
    public String[] getEntries() {
        final String[] array = new String[this.e().size()];
        int n = 0;
        final Iterator<OpListEntry> iterator = this.e().values().iterator();
        while (iterator.hasNext()) {
            array[n++] = ((GameProfile)iterator.next().getKey()).getName();
        }
        return array;
    }
    
    protected String b(final GameProfile gameProfile) {
        return gameProfile.getId().toString();
    }
    
    public GameProfile a(final String s) {
        for (final OpListEntry opListEntry : this.e().values()) {
            if (s.equalsIgnoreCase(((GameProfile)opListEntry.getKey()).getName())) {
                return (GameProfile)opListEntry.getKey();
            }
        }
        return null;
    }
}
