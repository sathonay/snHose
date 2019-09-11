package net.minecraft.server;

import net.minecraft.util.com.google.common.base.*;

final class PredicateEmptyList implements Predicate
{
    public boolean a(final String s) {
        return !UtilColor.b(s);
    }
}
