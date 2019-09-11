package net.minecraft.server;

public class ChatModifier
{
    private ChatModifier a;
    private EnumChatFormat b;
    private Boolean c;
    private Boolean d;
    private Boolean e;
    private Boolean f;
    private Boolean g;
    private ChatClickable h;
    private ChatHoverable i;
    private static final ChatModifier j;
    
    public EnumChatFormat a() {
        return (this.b == null) ? this.n().a() : this.b;
    }
    
    public boolean b() {
        return (this.c == null) ? this.n().b() : this.c;
    }
    
    public boolean c() {
        return (this.d == null) ? this.n().c() : this.d;
    }
    
    public boolean d() {
        return (this.f == null) ? this.n().d() : this.f;
    }
    
    public boolean e() {
        return (this.e == null) ? this.n().e() : this.e;
    }
    
    public boolean f() {
        return (this.g == null) ? this.n().f() : this.g;
    }
    
    public boolean g() {
        return this.c == null && this.d == null && this.f == null && this.e == null && this.g == null && this.b == null && this.h == null && this.i == null;
    }
    
    public ChatClickable h() {
        return (this.h == null) ? this.n().h() : this.h;
    }
    
    public ChatHoverable i() {
        return (this.i == null) ? this.n().i() : this.i;
    }
    
    public ChatModifier setColor(final EnumChatFormat b) {
        this.b = b;
        return this;
    }
    
    public ChatModifier setBold(final Boolean c) {
        this.c = c;
        return this;
    }
    
    public ChatModifier setItalic(final Boolean d) {
        this.d = d;
        return this;
    }
    
    public ChatModifier setStrikethrough(final Boolean f) {
        this.f = f;
        return this;
    }
    
    public ChatModifier setUnderline(final Boolean e) {
        this.e = e;
        return this;
    }
    
    public ChatModifier setRandom(final Boolean g) {
        this.g = g;
        return this;
    }
    
    public ChatModifier setChatClickable(final ChatClickable h) {
        this.h = h;
        return this;
    }
    
    public ChatModifier a(final ChatHoverable i) {
        this.i = i;
        return this;
    }
    
    public ChatModifier a(final ChatModifier a) {
        this.a = a;
        return this;
    }
    
    private ChatModifier n() {
        return (this.a == null) ? ChatModifier.j : this.a;
    }
    
    @Override
    public String toString() {
        return "Style{hasParent=" + (this.a != null) + ", color=" + this.b + ", bold=" + this.c + ", italic=" + this.d + ", underlined=" + this.e + ", obfuscated=" + this.g + ", clickEvent=" + this.h() + ", hoverEvent=" + this.i() + '}';
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof ChatModifier) {
            final ChatModifier chatModifier = (ChatModifier)o;
            if (this.b() == chatModifier.b() && this.a() == chatModifier.a() && this.c() == chatModifier.c() && this.f() == chatModifier.f() && this.d() == chatModifier.d() && this.e() == chatModifier.e()) {
                if (this.h() != null) {
                    if (!this.h().equals(chatModifier.h())) {
                        return false;
                    }
                }
                else if (chatModifier.h() != null) {
                    return false;
                }
                if ((this.i() == null) ? (chatModifier.i() == null) : this.i().equals(chatModifier.i())) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return 31 * (31 * (31 * (31 * (31 * (31 * (31 * this.b.hashCode() + this.c.hashCode()) + this.d.hashCode()) + this.e.hashCode()) + this.f.hashCode()) + this.g.hashCode()) + this.h.hashCode()) + this.i.hashCode();
    }
    
    public ChatModifier clone() {
        final ChatModifier chatModifier = new ChatModifier();
        chatModifier.c = this.c;
        chatModifier.d = this.d;
        chatModifier.f = this.f;
        chatModifier.e = this.e;
        chatModifier.g = this.g;
        chatModifier.b = this.b;
        chatModifier.h = this.h;
        chatModifier.i = this.i;
        chatModifier.a = this.a;
        return chatModifier;
    }
    
    public ChatModifier m() {
        final ChatModifier chatModifier = new ChatModifier();
        chatModifier.setBold(this.b());
        chatModifier.setItalic(this.c());
        chatModifier.setStrikethrough(this.d());
        chatModifier.setUnderline(this.e());
        chatModifier.setRandom(this.f());
        chatModifier.setColor(this.a());
        chatModifier.setChatClickable(this.h());
        chatModifier.a(this.i());
        return chatModifier;
    }
    
    static {
        j = new ChatStyleRoot();
    }
}
