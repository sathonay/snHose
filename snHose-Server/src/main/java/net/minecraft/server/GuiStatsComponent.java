package net.minecraft.server;

import java.text.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class GuiStatsComponent extends JComponent
{
    private static final DecimalFormat a;
    private int[] b;
    private int c;
    private String[] d;
    private final MinecraftServer e;
    
    public GuiStatsComponent(final MinecraftServer e) {
        this.b = new int[256];
        this.d = new String[11];
        this.e = e;
        this.setPreferredSize(new Dimension(456, 246));
        this.setMinimumSize(new Dimension(456, 246));
        this.setMaximumSize(new Dimension(456, 246));
        new Timer(500, new GuiStatsListener(this)).start();
        this.setBackground(Color.BLACK);
    }
    
    private void a() {
        final long n = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.gc();
        this.d[0] = "Memory use: " + n / 1024L / 1024L + " mb (" + Runtime.getRuntime().freeMemory() * 100L / Runtime.getRuntime().maxMemory() + "% free)";
        this.d[1] = "Avg tick: " + GuiStatsComponent.a.format(this.a(this.e.g) * 1.0E-6) + " ms";
        this.repaint();
    }
    
    private double a(final long[] array) {
        long n = 0L;
        for (int i = 0; i < array.length; ++i) {
            n += array[i];
        }
        return n / array.length;
    }
    
    @Override
    public void paint(final Graphics graphics) {
        graphics.setColor(new Color(16777215));
        graphics.fillRect(0, 0, 456, 246);
        for (int i = 0; i < 256; ++i) {
            final int n = this.b[i + this.c & 0xFF];
            graphics.setColor(new Color(n + 28 << 16));
            graphics.fillRect(i, 100 - n, 1, n);
        }
        graphics.setColor(Color.BLACK);
        for (int j = 0; j < this.d.length; ++j) {
            final String s = this.d[j];
            if (s != null) {
                graphics.drawString(s, 32, 116 + j * 16);
            }
        }
    }
    
    static {
        a = new DecimalFormat("########0.000");
    }
}
