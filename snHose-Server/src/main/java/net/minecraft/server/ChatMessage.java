package net.minecraft.server;

import java.util.regex.*;
import net.minecraft.util.com.google.common.collect.*;
import java.util.*;

public class ChatMessage extends ChatBaseComponent
{
    private final String d;
    private final Object[] e;
    private final Object f;
    private long g;
    List b;
    public static final Pattern c;
    
    public ChatMessage(final String d, final Object... e) {
        this.f = new Object();
        this.g = -1L;
        this.b = Lists.newArrayList();
        this.d = d;
        this.e = e;
        for (final Object o : e) {
            if (o instanceof IChatBaseComponent) {
                ((IChatBaseComponent)o).getChatModifier().a(this.getChatModifier());
            }
        }
    }
    
    synchronized void g() {
        synchronized (this.f) {
            final long a = LocaleI18n.a();
            if (a == this.g) {
                return;
            }
            this.g = a;
            this.b.clear();
        }
        try {
            this.b(LocaleI18n.get(this.d));
        }
        catch (ChatMessageException ex) {
            this.b.clear();
            try {
                this.b(LocaleI18n.b(this.d));
            }
            catch (ChatMessageException ex2) {
                throw ex;
            }
        }
    }
    
    protected void b(final String s) {
        final Matcher matcher = ChatMessage.c.matcher(s);
        int n = 0;
        int n2 = 0;
        try {
            while (matcher.find(n2)) {
                final int start = matcher.start();
                final int end = matcher.end();
                if (start > n2) {
                    final ChatComponentText chatComponentText = new ChatComponentText(String.format(s.substring(n2, start), new Object[0]));
                    chatComponentText.getChatModifier().a(this.getChatModifier());
                    this.b.add(chatComponentText);
                }
                final String group = matcher.group(2);
                final String substring = s.substring(start, end);
                if ("%".equals(group) && "%%".equals(substring)) {
                    final ChatComponentText chatComponentText2 = new ChatComponentText("%");
                    chatComponentText2.getChatModifier().a(this.getChatModifier());
                    this.b.add(chatComponentText2);
                }
                else {
                    if (!"s".equals(group)) {
                        throw new ChatMessageException(this, "Unsupported format: '" + substring + "'");
                    }
                    final String group2 = matcher.group(1);
                    this.b.add(this.a((group2 != null) ? (Integer.parseInt(group2) - 1) : n++));
                }
                n2 = end;
            }
            if (n2 < s.length()) {
                final ChatComponentText chatComponentText3 = new ChatComponentText(String.format(s.substring(n2), new Object[0]));
                chatComponentText3.getChatModifier().a(this.getChatModifier());
                this.b.add(chatComponentText3);
            }
        }
        catch (IllegalFormatException ex) {
            throw new ChatMessageException(this, ex);
        }
    }
    
    private IChatBaseComponent a(final int n) {
        if (n >= this.e.length) {
            throw new ChatMessageException(this, n);
        }
        final Object o = this.e[n];
        IChatBaseComponent chatBaseComponent;
        if (o instanceof IChatBaseComponent) {
            chatBaseComponent = (IChatBaseComponent)o;
        }
        else {
            chatBaseComponent = new ChatComponentText((o == null) ? "null" : o.toString());
            chatBaseComponent.getChatModifier().a(this.getChatModifier());
        }
        return chatBaseComponent;
    }
    
    @Override
    public IChatBaseComponent setChatModifier(final ChatModifier chatModifier) {
        super.setChatModifier(chatModifier);
        for (final Object o : this.e) {
            if (o instanceof IChatBaseComponent) {
                ((IChatBaseComponent)o).getChatModifier().a(this.getChatModifier());
            }
        }
        if (this.g > -1L) {
            final Iterator<IChatBaseComponent> iterator = (Iterator<IChatBaseComponent>)this.b.iterator();
            while (iterator.hasNext()) {
                iterator.next().getChatModifier().a(chatModifier);
            }
        }
        return this;
    }
    
    @Override
    public Iterator iterator() {
        this.g();
        return Iterators.concat((Iterator<?>)ChatBaseComponent.a(this.b), (Iterator<?>)ChatBaseComponent.a(this.a));
    }
    
    @Override
    public String e() {
        this.g();
        final StringBuilder sb = new StringBuilder();
        final Iterator<IChatBaseComponent> iterator = this.b.iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next().e());
        }
        return sb.toString();
    }
    
    public ChatMessage h() {
        final Object[] array = new Object[this.e.length];
        for (int i = 0; i < this.e.length; ++i) {
            if (this.e[i] instanceof IChatBaseComponent) {
                array[i] = ((IChatBaseComponent)this.e[i]).f();
            }
            else {
                array[i] = this.e[i];
            }
        }
        final ChatMessage chatMessage = new ChatMessage(this.d, array);
        chatMessage.setChatModifier(this.getChatModifier().clone());
        final Iterator<IChatBaseComponent> iterator = this.a().iterator();
        while (iterator.hasNext()) {
            chatMessage.addSibling(iterator.next().f());
        }
        return chatMessage;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof ChatMessage) {
            final ChatMessage chatMessage = (ChatMessage)o;
            return Arrays.equals(this.e, chatMessage.e) && this.d.equals(chatMessage.d) && super.equals(o);
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return 31 * (31 * super.hashCode() + this.d.hashCode()) + Arrays.hashCode(this.e);
    }
    
    @Override
    public String toString() {
        return "TranslatableComponent{key='" + this.d + '\'' + ", args=" + Arrays.toString(this.e) + ", siblings=" + this.a + ", style=" + this.getChatModifier() + '}';
    }
    
    public String i() {
        return this.d;
    }
    
    public Object[] j() {
        return this.e;
    }
    
    static {
        c = Pattern.compile("%(?:(\\d+)\\$)?([A-Za-z%]|$)");
    }
}
