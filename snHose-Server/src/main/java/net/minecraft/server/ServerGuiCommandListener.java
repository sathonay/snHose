package net.minecraft.server;

import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import javax.swing.text.*;
import javax.swing.*;
import org.apache.logging.log4j.*;

class ServerGuiCommandListener implements ActionListener
{
    final /* synthetic */ JTextField a;
    final /* synthetic */ ServerGUI b;
    
    ServerGuiCommandListener(final ServerGUI b, final JTextField a) {
        this.b = b;
        this.a = a;
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        final String trim = this.a.getText().trim();
        if (trim.length() > 0) {
            this.b.c.issueCommand(trim, MinecraftServer.getServer());
        }
        this.a.setText("");
    }
}
