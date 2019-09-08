package net.minecraft.server.v1_7_R4;

import java.util.*;

public interface IChatBaseComponent extends Iterable
{
    IChatBaseComponent setChatModifier(final ChatModifier p0);
    
    ChatModifier getChatModifier();
    
    IChatBaseComponent a(final String p0);
    
    IChatBaseComponent addSibling(final IChatBaseComponent p0);
    
    String e();
    
    String c();
    
    List a();
    
    IChatBaseComponent f();
}
