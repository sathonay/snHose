package net.minecraft.server.v1_7_R4;

import javax.swing.*;
import java.util.*;

public class PlayerListBox extends JList implements IUpdatePlayerListBox
{
    private MinecraftServer a;
    private int b;
    
    public PlayerListBox(final MinecraftServer a) {
        (this.a = a).a(this);
    }
    
    @Override
    public void a() {
        if (this.b++ % 20 == 0) {
            final Vector<String> listData = new Vector<String>();
            for (int i = 0; i < this.a.getPlayerList().players.size(); ++i) {
                listData.add(this.a.getPlayerList().players.get(i).getName());
            }
            this.setListData(listData);
        }
    }
}
