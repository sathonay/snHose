package net.minecraft.server;

import net.minecraft.util.com.google.common.base.*;

final class ChatFunction2 implements Function
{
    public IChatBaseComponent a(final IChatBaseComponent chatBaseComponent) {
        final IChatBaseComponent f = chatBaseComponent.f();
        f.setChatModifier(f.getChatModifier().m());
        return f;
    }
}
