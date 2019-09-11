package net.minecraft.server;

import net.minecraft.util.com.mojang.authlib.*;
import net.minecraft.util.com.mojang.authlib.properties.*;
import java.util.*;
import net.minecraft.util.com.google.common.collect.*;

public final class GameProfileSerializer
{
    public static GameProfile deserialize(final NBTTagCompound nbtTagCompound) {
        String string = null;
        String string2 = null;
        if (nbtTagCompound.hasKeyOfType("Name", 8)) {
            string = nbtTagCompound.getString("Name");
        }
        if (nbtTagCompound.hasKeyOfType("Id", 8)) {
            string2 = nbtTagCompound.getString("Id");
        }
        if (UtilColor.b(string)) {
            if (UtilColor.b(string2)) {
                return null;
            }
        }
        UUID fromString;
        try {
            fromString = UUID.fromString(string2);
        }
        catch (Throwable t) {
            fromString = null;
        }
        final GameProfile gameProfile = new GameProfile(fromString, string);
        if (nbtTagCompound.hasKeyOfType("Properties", 10)) {
            final NBTTagCompound compound = nbtTagCompound.getCompound("Properties");
            for (final String s : compound.c()) {
                final NBTTagList list = compound.getList(s, 10);
                for (int i = 0; i < list.size(); ++i) {
                    final NBTTagCompound value = list.get(i);
                    final String string3 = value.getString("Value");
                    if (value.hasKeyOfType("Signature", 8)) {
                        gameProfile.getProperties().put(s, new Property(s, string3, value.getString("Signature")));
                    }
                    else {
                        gameProfile.getProperties().put(s, new Property(s, string3));
                    }
                }
            }
        }
        return gameProfile;
    }
    
    public static void serialize(final NBTTagCompound nbtTagCompound, final GameProfile gameProfile) {
        if (!UtilColor.b(gameProfile.getName())) {
            nbtTagCompound.setString("Name", gameProfile.getName());
        }
        if (gameProfile.getId() != null) {
            nbtTagCompound.setString("Id", gameProfile.getId().toString());
        }
        if (!gameProfile.getProperties().isEmpty()) {
            final NBTTagCompound nbtTagCompound2 = new NBTTagCompound();
            for (final String key : ((ForwardingMultimap<String, V>)gameProfile.getProperties()).keySet()) {
                final NBTTagList list = new NBTTagList();
                for (final Property property : gameProfile.getProperties().get(key)) {
                    final NBTTagCompound nbtbase = new NBTTagCompound();
                    nbtbase.setString("Value", property.getValue());
                    if (property.hasSignature()) {
                        nbtbase.setString("Signature", property.getSignature());
                    }
                    list.add(nbtbase);
                }
                nbtTagCompound2.set(key, list);
            }
            nbtTagCompound.set("Properties", nbtTagCompound2);
        }
    }
}
