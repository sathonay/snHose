package net.minecraft.server.v1_7_R4;

import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import javax.swing.text.*;
import javax.swing.*;
import org.apache.logging.log4j.*;

public class ServerGUI extends JComponent
{
    private static final Font a;
    private static final Logger b;
    private DedicatedServer c;
    
    public static void a(final DedicatedServer dedicatedServer) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception ex) {}
        final ServerGUI serverGUI = new ServerGUI(dedicatedServer);
        final JFrame frame = new JFrame("Minecraft server");
        frame.add(serverGUI);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addWindowListener(new ServerWindowAdapter(dedicatedServer));
    }
    
    public ServerGUI(final DedicatedServer c) {
        this.c = c;
        this.setPreferredSize(new Dimension(854, 480));
        this.setLayout(new BorderLayout());
        try {
            this.add(this.c(), "Center");
            this.add(this.a(), "West");
        }
        catch (Exception ex) {
            ServerGUI.b.error("Couldn't build server GUI", ex);
        }
    }
    
    private JComponent a() {
        final JPanel panel = new JPanel(new BorderLayout());
        panel.add(new GuiStatsComponent(this.c), "North");
        panel.add(this.b(), "Center");
        panel.setBorder(new TitledBorder(new EtchedBorder(), "Stats"));
        return panel;
    }
    
    private JComponent b() {
        final JScrollPane scrollPane = new JScrollPane(new PlayerListBox(this.c), 22, 30);
        scrollPane.setBorder(new TitledBorder(new EtchedBorder(), "Players"));
        return scrollPane;
    }
    
    private JComponent c() {
        final JPanel panel = new JPanel(new BorderLayout());
        final JTextArea textArea = new JTextArea();
        final JScrollPane scrollPane = new JScrollPane(textArea, 22, 30);
        textArea.setEditable(false);
        textArea.setFont(ServerGUI.a);
        final JTextField textField = new JTextField();
        textField.addActionListener(new ServerGuiCommandListener(this, textField));
        textArea.addFocusListener(new ServerGuiFocusAdapter(this));
        panel.add(scrollPane, "Center");
        panel.add(textField, "South");
        panel.setBorder(new TitledBorder(new EtchedBorder(), "Log and chat"));
        final Thread thread = new Thread(new ServerGuiThreadRunnable(this, textArea, scrollPane));
        thread.setDaemon(true);
        thread.start();
        return panel;
    }
    
    public void a(final JTextArea textArea, final JScrollPane scrollPane, final String s) {
        if (!SwingUtilities.isEventDispatchThread()) {
            SwingUtilities.invokeLater(new ServerGuiInvokeRunnable(this, textArea, scrollPane, s));
            return;
        }
        final Document document = textArea.getDocument();
        final JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
        int n = 0;
        if (scrollPane.getViewport().getView() == textArea) {
            n = ((verticalScrollBar.getValue() + verticalScrollBar.getSize().getHeight() + ServerGUI.a.getSize() * 4 > verticalScrollBar.getMaximum()) ? 1 : 0);
        }
        try {
            document.insertString(document.getLength(), s, null);
        }
        catch (BadLocationException ex) {}
        if (n != 0) {
            verticalScrollBar.setValue(Integer.MAX_VALUE);
        }
    }
    
    static {
        a = new Font("Monospaced", 0, 12);
        b = LogManager.getLogger();
    }
}
