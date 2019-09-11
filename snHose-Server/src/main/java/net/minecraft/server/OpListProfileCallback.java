package net.minecraft.server;

import net.minecraft.util.com.mojang.authlib.*;
import net.minecraft.util.com.mojang.authlib.yggdrasil.*;

final class OpListProfileCallback implements ProfileLookupCallback
{
    final /* synthetic */ MinecraftServer a;
    final /* synthetic */ OpList b;
    
    OpListProfileCallback(final MinecraftServer a, final OpList b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public void onProfileLookupSucceeded(final GameProfile gameprofile) {
        this.a.getUserCache().a(gameprofile);
        this.b.add(new OpListEntry(gameprofile, this.a.l()));
    }
    
    @Override
    public void onProfileLookupFailed(final GameProfile gameProfile, final Exception throwable) {
        NameReferencingFileConverter.a().warn("Could not lookup oplist entry for " + gameProfile.getName(), throwable);
        if (!(throwable instanceof ProfileNotFoundException)) {
            throw new FileConversionException("Could not request user " + gameProfile.getName() + " from backend systems", throwable, null);
        }
    }
}
