package net.minecraft.server;

import java.util.*;

public class GameRules
{
    private TreeMap<String, GameRuleValue> a;

    public GameRules() {
        this.a = Maps.newLinkedHashMap();
        this.a("doFireTick", "true");
        this.a("mobGriefing", "true");
        this.a("keepInventory", "false");
        this.a("doMobSpawning", "true");
        this.a("doMobLoot", "true");
        this.a("doTileDrops", "true");
        this.a("commandBlockOutput", "true");
        this.a("naturalRegeneration", "true");
        this.a("doDaylightCycle", "true");
    }

    public void a(final String s, final String s2) {
        this.a.put(s, new GameRuleValue(s2));
    }

    public void set(final String s, final String s2) {
        final GameRuleValue gameRuleValue = this.a.get(s);
        if (gameRuleValue != null) {
            gameRuleValue.a(s2);
        }
        else {
            this.a(s, s2);
        }
    }

    public String get(final String s) {
        final GameRuleValue gameRuleValue = this.a.get(s);
        if (gameRuleValue != null) {
            return gameRuleValue.a();
        }
        return "";
    }

    public boolean getBoolean(final String s) {
        final GameRuleValue gameRuleValue = this.a.get(s);
        return gameRuleValue != null && gameRuleValue.b();
    }

    public NBTTagCompound a() {
        final NBTTagCompound nbtTagCompound = new NBTTagCompound();
        for (final String s : this.a.keySet()) {
            nbtTagCompound.setString(s, ((GameRuleValue)this.a.get(s)).a());
        }
        return nbtTagCompound;
    }

    public void a(final NBTTagCompound nbtTagCompound) {
        for (final Object s : nbtTagCompound.c()) {
            if (s instanceof String) this.set((String) s, nbtTagCompound.getString((String) s));
        }
    }

    public String[] getGameRules() {
        return (String[])this.a.keySet().toArray(new String[0]);
    }

    public boolean contains(final String s) {
        return this.a.containsKey(s);
    }
}
