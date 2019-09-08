package net.minecraft.server.v1_7_R4;

public class ChatClickable
{
    private final EnumClickAction a;
    private final String b;
    
    public ChatClickable(final EnumClickAction a, final String b) {
        this.a = a;
        this.b = b;
    }
    
    public EnumClickAction a() {
        return this.a;
    }
    
    public String b() {
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
        final ChatClickable chatClickable = (ChatClickable)o;
        if (this.a != chatClickable.a) {
            return false;
        }
        if (this.b != null) {
            if (this.b.equals(chatClickable.b)) {
                return true;
            }
        }
        else if (chatClickable.b == null) {
            return true;
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "ClickEvent{action=" + this.a + ", value='" + this.b + '\'' + '}';
    }
    
    @Override
    public int hashCode() {
        return 31 * this.a.hashCode() + ((this.b != null) ? this.b.hashCode() : 0);
    }
}
