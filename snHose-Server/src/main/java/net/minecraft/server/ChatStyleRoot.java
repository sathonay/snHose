package net.minecraft.server;

final class ChatStyleRoot extends ChatModifier
{
    @Override
    public EnumChatFormat a() {
        return null;
    }
    
    @Override
    public boolean b() {
        return false;
    }
    
    @Override
    public boolean c() {
        return false;
    }
    
    @Override
    public boolean d() {
        return false;
    }
    
    @Override
    public boolean e() {
        return false;
    }
    
    @Override
    public boolean f() {
        return false;
    }
    
    @Override
    public ChatClickable h() {
        return null;
    }
    
    @Override
    public ChatHoverable i() {
        return null;
    }
    
    @Override
    public ChatModifier setColor(final EnumChatFormat enumChatFormat) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public ChatModifier setBold(final Boolean b) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public ChatModifier setItalic(final Boolean b) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public ChatModifier setStrikethrough(final Boolean b) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public ChatModifier setUnderline(final Boolean b) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public ChatModifier setRandom(final Boolean b) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public ChatModifier setChatClickable(final ChatClickable chatClickable) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public ChatModifier a(final ChatHoverable chatHoverable) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public ChatModifier a(final ChatModifier chatModifier) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public String toString() {
        return "Style.ROOT";
    }
    
    @Override
    public ChatModifier clone() {
        return this;
    }
    
    @Override
    public ChatModifier m() {
        return this;
    }
}
