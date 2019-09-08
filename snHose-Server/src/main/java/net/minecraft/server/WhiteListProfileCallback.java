package net.minecraft.server.v1_7_R4;

import net.minecraft.util.com.mojang.authlib.*;
import net.minecraft.util.com.mojang.authlib.yggdrasil.*;

final class WhiteListProfileCallback implements ProfileLookupCallback
{
    final /* synthetic */ MinecraftServer a;
    final /* synthetic */ WhiteList b;
    
    WhiteListProfileCallback(final MinecraftServer a, final WhiteList b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public void onProfileLookupSucceeded(final GameProfile gameprofile) {
        this.a.getUserCache().a(gameprofile);
        this.b.add(new WhiteListEntry(gameprofile));
    }
    
    @Override
    public void onProfileLookupFailed(final GameProfile gameProfile, final Exception throwable) {
        NameReferencingFileConverter.a().warn("Could not lookup user whitelist entry for " + gameProfile.getName(), throwable);
        if (!(throwable instanceof ProfileNotFoundException)) {
            throw new FileConversionException("Could not request user " + gameProfile.getName() + " from backend systems", throwable, null);
        }
    }
}
