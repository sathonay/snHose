package net.minecraft.server;

public class ChatHoverable
{
    private final EnumHoverAction a;
    private final IChatBaseComponent b;
    
    public ChatHoverable(final EnumHoverAction a, final IChatBaseComponent b) {
        this.a = a;
        this.b = b;
    }
    
    public EnumHoverAction a() {
        return this.a;
    }
    
    public IChatBaseComponent b() {
        return this.b;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final ChatHoverable chatHoverable = (ChatHoverable)o;
        if (this.a != chatHoverable.a) {
            return false;
        }
        if (this.b != null) {
            if (this.b.equals(chatHoverable.b)) {
                return true;
            }
        }
        else if (chatHoverable.b == null) {
            return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "HoverEvent{action=" + this.a + ", value='" + this.b + '\'' + '}';
    }
    
    @Override
    public int hashCode() {
        return 31 * this.a.hashCode() + ((this.b != null) ? this.b.hashCode() : 0);
    }
}
