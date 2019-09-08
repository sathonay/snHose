package net.minecraft.server;

import javax.swing.*;
import java.util.*;

public class PlayerListBox extends JList implements IUpdatePlayerListBox {
    private MinecraftServer a;
    private int b;
    
    public PlayerListBox(final MinecraftServer a) {
        (this.a = a).a(this);
    }
    
    @Override
    public void a() {
        if (this.b++ % 20 == 0) {
            final Vector<String> listData = new Vector<String>();
            for (EntityPlayer entityplayer : this.a.getPlayerList().players) {
                listData.add(entityplayer.getName());
            }
            this.setListData(listData);
        }
    }
}
