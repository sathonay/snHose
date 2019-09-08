package net.minecraft.server.v1_7_R4;

import net.minecraft.util.com.google.common.base.*;

final class ChatFunction2 implements Function
{
    public IChatBaseComponent a(final IChatBaseComponent chatBaseComponent) {
        final IChatBaseComponent f = chatBaseComponent.f();
        f.setChatModifier(f.getChatModifier().m());
        return f;
    }
}
