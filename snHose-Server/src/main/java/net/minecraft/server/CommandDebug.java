package net.minecraft.server;

import java.text.*;
import java.io.*;
import java.util.*;
import org.apache.logging.log4j.*;

public class CommandDebug extends CommandAbstract
{
    private static final Logger a;
    private long b;
    private int c;
    
    @Override
    public String getCommand() {
        return "debug";
    }
    
    @Override
    public int a() {
        return 3;
    }
    
    @Override
    public String c(final ICommandListener commandListener) {
        return "commands.debug.usage";
    }
    
    @Override
    public void execute(final ICommandListener commandListener, final String[] array) {
        if (array.length == 1) {
            if (array[0].equals("start")) {
                CommandAbstract.a(commandListener, this, "commands.debug.start", new Object[0]);
                MinecraftServer.getServer().am();
                this.b = MinecraftServer.ar();
                this.c = MinecraftServer.getServer().al();
                return;
            }
            if (array[0].equals("stop")) {
                if (!MinecraftServer.getServer().methodProfiler.a) {
                    throw new CommandException("commands.debug.notStarted", new Object[0]);
                }
                final long ar = MinecraftServer.ar();
                final int al = MinecraftServer.getServer().al();
                final long n = ar - this.b;
                final int n2 = al - this.c;
                this.a(n, n2);
                MinecraftServer.getServer().methodProfiler.a = false;
                CommandAbstract.a(commandListener, this, "commands.debug.stop", n / 1000.0f, n2);
                return;
            }
        }
        throw new ExceptionUsage("commands.debug.usage", new Object[0]);
    }
    
    private void a(final long n, final int n2) {
        final File file = new File(MinecraftServer.getServer().d("debug"), "profile-results-" + new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss").format(new Date()) + ".txt");
        file.getParentFile().mkdirs();
        try {
            final FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(this.b(n, n2));
            fileWriter.close();
        }
        catch (Throwable t) {
            CommandDebug.a.error("Could not save profiler results to " + file, t);
        }
    }
    
    private String b(final long n, final int n2) {
        final StringBuilder sb = new StringBuilder();
        sb.append("---- Minecraft Profiler Results ----\n");
        sb.append("// ");
        sb.append(d());
        sb.append("\n\n");
        sb.append("Time span: ").append(n).append(" ms\n");
        sb.append("Tick span: ").append(n2).append(" ticks\n");
        sb.append("// This is approximately ").append(String.format("%.2f", n2 / (n / 1000.0f))).append(" ticks per second. It should be ").append(20).append(" ticks per second\n\n");
        sb.append("--- BEGIN PROFILE DUMP ---\n\n");
        this.a(0, "root", sb);
        sb.append("--- END PROFILE DUMP ---\n\n");
        return sb.toString();
    }
    
    private void a(final int n, final String s, final StringBuilder sb) {
        final List b = MinecraftServer.getServer().methodProfiler.b(s);
        if (b == null || b.size() < 3) {
            return;
        }
        for (int i = 1; i < b.size(); ++i) {
            final ProfilerInfo profilerInfo = (ProfilerInfo) b.get(i);
            sb.append(String.format("[%02d] ", n));
            for (int j = 0; j < n; ++j) {
                sb.append(" ");
            }
            sb.append(profilerInfo.c);
            sb.append(" - ");
            sb.append(String.format("%.2f", profilerInfo.a));
            sb.append("%/");
            sb.append(String.format("%.2f", profilerInfo.b));
            sb.append("%\n");
            if (!profilerInfo.c.equals("unspecified")) {
                try {
                    this.a(n + 1, s + "." + profilerInfo.c, sb);
                }
                catch (Exception ex) {
                    sb.append("[[ EXCEPTION " + ex + " ]]");
                }
            }
        }
    }
    
    private static String d() {
        final String[] array = { "Shiny numbers!", "Am I not running fast enough? :(", "I'm working as hard as I can!", "Will I ever be good enough for you? :(", "Speedy. Zoooooom!", "Hello world", "40% better than a crash report.", "Now with extra numbers", "Now with less numbers", "Now with the same numbers", "You should add flames to things, it makes them go faster!", "Do you feel the need for... optimization?", "*cracks redstone whip*", "Maybe if you treated it better then it'll have more motivation to work faster! Poor server." };
        try {
            return array[(int)(System.nanoTime() % array.length)];
        }
        catch (Throwable t) {
            return "Witty comment unavailable :(";
        }
    }
    
    @Override
    public List tabComplete(final ICommandListener commandListener, final String[] array) {
        if (array.length == 1) {
            return CommandAbstract.a(array, "start", "stop");
        }
        return null;
    }
    
    static {
        a = LogManager.getLogger();
    }
}
