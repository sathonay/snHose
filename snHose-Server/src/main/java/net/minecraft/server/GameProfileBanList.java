package net.minecraft.server;

import java.io.*;
import net.minecraft.util.com.google.gson.*;
import net.minecraft.util.com.mojang.authlib.*;
import java.util.*;

public class GameProfileBanList extends JsonList
{
    public GameProfileBanList(final File file1) {
        super(file1);
    }
    
    @Override
    protected JsonListEntry a(final JsonObject jsonobject) {
        return new GameProfileBanEntry(jsonobject);
    }
    
    public boolean isBanned(final GameProfile object) {
        return this.d(object);
    }
    
    @Override
    public String[] getEntries() {
        final String[] array = new String[this.e().size()];
        int n = 0;
        final Iterator<GameProfileBanEntry> iterator = this.e().values().iterator();
        while (iterator.hasNext()) {
            array[n++] = ((GameProfile)iterator.next().getKey()).getName();
        }
        return array;
    }
    
    protected String b(final GameProfile gameProfile) {
        return gameProfile.getId().toString();
    }
    
    public GameProfile a(final String s) {
        for (final GameProfileBanEntry gameProfileBanEntry : this.e().values()) {
            if (s.equalsIgnoreCase(((GameProfile)gameProfileBanEntry.getKey()).getName())) {
                return (GameProfile)gameProfileBanEntry.getKey();
            }
        }
        return null;
    }
}
