package net.minecraft.server;

import net.minecraft.util.com.google.common.base.*;
import java.util.*;

final class ChatFunction1 implements Function
{
    public Iterator a(final IChatBaseComponent chatBaseComponent) {
        return chatBaseComponent.iterator();
    }
}
