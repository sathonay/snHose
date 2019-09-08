package net.minecraft.server.v1_7_R4;

import java.awt.event.*;
import java.text.*;
import javax.swing.*;
import java.awt.*;

class GuiStatsListener implements ActionListener
{
    final /* synthetic */ GuiStatsComponent a;
    
    GuiStatsListener(final GuiStatsComponent a) {
        this.a = a;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        this.a.a();
    }
}
