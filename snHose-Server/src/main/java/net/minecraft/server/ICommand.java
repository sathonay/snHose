package net.minecraft.server.v1_7_R4;

import java.util.*;

public interface ICommand extends Comparable
{
    String getCommand();
    
    String c(final ICommandListener p0);
    
    List b();
    
    void execute(final ICommandListener p0, final String[] p1);
    
    boolean canUse(final ICommandListener p0);
    
    List tabComplete(final ICommandListener p0, final String[] p1);
    
    boolean isListStart(final String[] p0, final int p1);
}
