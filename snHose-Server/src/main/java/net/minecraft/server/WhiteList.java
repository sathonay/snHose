package net.minecraft.server;

import java.io.*;
import net.minecraft.util.com.google.gson.*;
import net.minecraft.util.com.mojang.authlib.*;
import java.util.*;

public class WhiteList extends JsonList
{
    public WhiteList(final File file1) {
        super(file1);
    }
    
    @Override
    protected JsonListEntry a(final JsonObject jsonObject) {
        return new WhiteListEntry(jsonObject);
    }
    
    public boolean isWhitelisted(final GameProfile object) {
        return this.d(object);
    }
    
    @Override
    public String[] getEntries() {
        final String[] array = new String[this.e().size()];
        int n = 0;
        final Iterator<WhiteListEntry> iterator = this.e().values().iterator();
        while (iterator.hasNext()) {
            array[n++] = ((GameProfile)iterator.next().getKey()).getName();
        }
        return array;
    }
    
    protected String b(final GameProfile gameProfile) {
        return gameProfile.getId().toString();
    }
    
    public GameProfile a(final String s) {
        for (final WhiteListEntry whiteListEntry : (Set<WhiteListEntry>)this.e().values()) {
            if (s.equalsIgnoreCase(((GameProfile)whiteListEntry.getKey()).getName())) {
                return (GameProfile)whiteListEntry.getKey();
            }
        }
        return null;
    }
}
