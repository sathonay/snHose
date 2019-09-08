package net.minecraft.server.v1_7_R4;

import net.minecraft.util.com.mojang.authlib.*;
import java.util.*;
import net.minecraft.util.com.mojang.authlib.yggdrasil.*;

final class GameProfileBanListEntryConverter implements ProfileLookupCallback
{
    final /* synthetic */ MinecraftServer a;
    final /* synthetic */ Map b;
    final /* synthetic */ GameProfileBanList c;
    
    GameProfileBanListEntryConverter(final MinecraftServer a, final Map b, final GameProfileBanList c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    @Override
    public void onProfileLookupSucceeded(final GameProfile gameProfile) {
        this.a.getUserCache().a(gameProfile);
        final String[] array = this.b.get(gameProfile.getName().toLowerCase(Locale.ROOT));
        if (array == null) {
            NameReferencingFileConverter.a().warn("Could not convert user banlist entry for " + gameProfile.getName());
            throw new FileConversionException("Profile not in the conversionlist", (PredicateEmptyList)null);
        }
        this.c.add(new GameProfileBanEntry(gameProfile, (array.length > 1) ? NameReferencingFileConverter.a(array[1], null) : null, (array.length > 2) ? array[2] : null, (array.length > 3) ? NameReferencingFileConverter.a(array[3], null) : null, (array.length > 4) ? array[4] : null));
    }
    
    @Override
    public void onProfileLookupFailed(final GameProfile gameProfile, final Exception throwable) {
        NameReferencingFileConverter.a().warn("Could not lookup user banlist entry for " + gameProfile.getName(), throwable);
        if (!(throwable instanceof ProfileNotFoundException)) {
            throw new FileConversionException("Could not request user " + gameProfile.getName() + " from backend systems", throwable, null);
        }
    }
}
