package net.minecraft.server;

import java.util.*;
import net.minecraft.util.org.apache.commons.io.*;
import java.io.*;
import org.apache.logging.log4j.*;

public class EULA
{
    private static final Logger a;
    private final File b;
    private final boolean c;
    
    public EULA(final File b) {
        this.b = b;
        this.c = this.a(b);
    }
    
    private boolean a(final File file) {
        InputStream input = null;
        boolean boolean1 = false;
        try {
            final Properties properties = new Properties();
            input = new FileInputStream(file);
            properties.load(input);
            boolean1 = Boolean.parseBoolean(properties.getProperty("eula", "false"));
        }
        catch (Exception ex) {
            EULA.a.warn("Failed to load " + file);
            this.b();
        }
        finally {
            IOUtils.closeQuietly(input);
        }
        return boolean1;
    }
    
    public boolean a() {
        return this.c;
    }
    
    public void b() {
        OutputStream output = null;
        try {
            final Properties properties = new Properties();
            output = new FileOutputStream(this.b);
            properties.setProperty("eula", "false");
            properties.store(output, "By changing the setting below to TRUE you are indicating your agreement to our EULA (https://account.mojang.com/documents/minecraft_eula).");
        }
        catch (Exception ex) {
            EULA.a.warn("Failed to save " + this.b, ex);
        }
        finally {
            IOUtils.closeQuietly(output);
        }
    }
    
    static {
        a = LogManager.getLogger();
    }
}
