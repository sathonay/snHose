package org.bukkit.event.server;

import org.bukkit.Bukkit;
import org.bukkit.event.Event;

/**
 * Miscellaneous server events
 */
public abstract class ServerEvent extends Event {
    public ServerEvent(boolean isAsync) {
        super(isAsync);
    }

    public ServerEvent() {
        super(!Bukkit.isPrimaryThread());
    }
}
