package net.minecraft.server;

import java.lang.reflect.*;
import java.util.*;

final class UserCacheEntryType implements ParameterizedType
{
    @Override
    public Type[] getActualTypeArguments() {
        return new Type[] { UserCacheEntry.class };
    }
    
    @Override
    public Type getRawType() {
        return List.class;
    }
    
    @Override
    public Type getOwnerType() {
        return null;
    }
}
