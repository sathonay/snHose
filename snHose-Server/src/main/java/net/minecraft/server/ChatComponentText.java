package net.minecraft.server;

import java.util.*;

public class ChatComponentText extends ChatBaseComponent
{
    private final String b;
    
    public ChatComponentText(final String b) {
        this.b = b;
    }
    
    public String g() {
        return this.b;
    }
    
    @Override
    public String e() {
        return this.b;
    }
    
    public ChatComponentText h() {
        final ChatComponentText chatComponentText = new ChatComponentText(this.b);
        chatComponentText.setChatModifier(this.getChatModifier().clone());
        final Iterator<IChatBaseComponent> iterator = this.a().iterator();
        while (iterator.hasNext()) {
            chatComponentText.addSibling(iterator.next().f());
        }
        return chatComponentText;
    }
    
    @Override
    public boolean equals(final Object o) {
        return this == o || (o instanceof ChatComponentText && this.b.equals(((ChatComponentText)o).g()) && super.equals(o));
    }
    
    @Override
    public String toString() {
        return "TextComponent{text='" + this.b + '\'' + ", siblings=" + this.a + ", style=" + this.getChatModifier() + '}';
    }
}
