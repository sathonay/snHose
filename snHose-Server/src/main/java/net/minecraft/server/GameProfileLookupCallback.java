package net.minecraft.server;

import java.util.*;
import net.minecraft.util.com.mojang.authlib.*;

final class GameProfileLookupCallback implements ProfileLookupCallback
{
    final /* synthetic */ MinecraftServer a;
    final /* synthetic */ List b;
    
    GameProfileLookupCallback(final MinecraftServer a, final List b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public void onProfileLookupSucceeded(final GameProfile gameprofile) {
        this.a.getUserCache().a(gameprofile);
        this.b.add(gameprofile);
    }
    
    @Override
    public void onProfileLookupFailed(final GameProfile gameProfile, final Exception ex) {
        NameReferencingFileConverter.a().warn("Could not lookup user whitelist entry for " + gameProfile.getName(), ex);
    }
}
