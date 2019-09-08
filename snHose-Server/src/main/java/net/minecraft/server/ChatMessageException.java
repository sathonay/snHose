package net.minecraft.server.v1_7_R4;

public class ChatMessageException extends IllegalArgumentException
{
    public ChatMessageException(final ChatMessage chatMessage, final String s) {
        super(String.format("Error parsing: %s: %s", chatMessage, s));
    }
    
    public ChatMessageException(final ChatMessage chatMessage, final int n) {
        super(String.format("Invalid index %d requested for %s", n, chatMessage));
    }
    
    public ChatMessageException(final ChatMessage chatMessage, final Throwable t) {
        super(String.format("Error while parsing: %s", chatMessage), t);
    }
}
