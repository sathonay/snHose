package net.minecraft.server.v1_7_R4;

import java.util.*;
import net.minecraft.util.com.google.common.collect.*;
import net.minecraft.util.com.google.common.base.*;

public abstract class ChatBaseComponent implements IChatBaseComponent
{
    protected List a;
    private ChatModifier b;
    
    public ChatBaseComponent() {
        this.a = Lists.newArrayList();
    }
    
    @Override
    public IChatBaseComponent addSibling(final IChatBaseComponent chatBaseComponent) {
        chatBaseComponent.getChatModifier().a(this.getChatModifier());
        this.a.add(chatBaseComponent);
        return this;
    }
    
    @Override
    public List a() {
        return this.a;
    }
    
    @Override
    public IChatBaseComponent a(final String s) {
        return this.addSibling(new ChatComponentText(s));
    }
    
    @Override
    public IChatBaseComponent setChatModifier(final ChatModifier b) {
        this.b = b;
        final Iterator<IChatBaseComponent> iterator = this.a.iterator();
        while (iterator.hasNext()) {
            iterator.next().getChatModifier().a(this.getChatModifier());
        }
        return this;
    }
    
    @Override
    public ChatModifier getChatModifier() {
        if (this.b == null) {
            this.b = new ChatModifier();
            final Iterator<IChatBaseComponent> iterator = this.a.iterator();
            while (iterator.hasNext()) {
                iterator.next().getChatModifier().a(this.b);
            }
        }
        return this.b;
    }
    
    @Override
    public Iterator iterator() {
        return Iterators.concat((Iterator<?>)Iterators.forArray(this), (Iterator<?>)a(this.a));
    }
    
    @Override
    public final String c() {
        final StringBuilder sb = new StringBuilder();
        final Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next().e());
        }
        return sb.toString();
    }
    
    public static Iterator a(final Iterable iterable) {
        return Iterators.transform(Iterators.concat(Iterators.transform((Iterator<Object>)iterable.iterator(), (Function<? super Object, ? extends Iterator<?>>)new ChatFunction1())), (Function<? super Object, ?>)new ChatFunction2());
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof ChatBaseComponent) {
            final ChatBaseComponent chatBaseComponent = (ChatBaseComponent)o;
            return this.a.equals(chatBaseComponent.a) && this.getChatModifier().equals(chatBaseComponent.getChatModifier());
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return 31 * this.b.hashCode() + this.a.hashCode();
    }
    
    @Override
    public String toString() {
        return "BaseComponent{style=" + this.b + ", siblings=" + this.a + '}';
    }
}
