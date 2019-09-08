package net.minecraft.server.v1_7_R4;

import net.minecraft.util.com.mojang.authlib.*;

final class GameProfileLookup implements ProfileLookupCallback
{
    final /* synthetic */ GameProfile[] a;
    
    GameProfileLookup(final GameProfile[] a) {
        this.a = a;
    }
    
    @Override
    public void onProfileLookupSucceeded(final GameProfile gameProfile) {
        this.a[0] = gameProfile;
    }
    
    @Override
    public void onProfileLookupFailed(final GameProfile gameProfile, final Exception ex) {
        this.a[0] = null;
    }
}
