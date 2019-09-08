package net.minecraft.server.v1_7_R4;

import java.io.*;
import org.apache.logging.log4j.*;

public class WorldLoader implements Convertable
{
    private static final Logger b;
    protected final File a;
    
    public WorldLoader(final File a) {
        if (!a.exists()) {
            a.mkdirs();
        }
        this.a = a;
    }
    
    @Override
    public void d() {
    }
    
    public WorldData c(final String s) {
        final File file = new File(this.a, s);
        if (!file.exists()) {
            return null;
        }
        final File file2 = new File(file, "level.dat");
        if (file2.exists()) {
            try {
                return new WorldData(NBTCompressedStreamTools.a(new FileInputStream(file2)).getCompound("Data"));
            }
            catch (Exception ex) {
                WorldLoader.b.error("Exception reading " + file2, ex);
            }
        }
        final File file3 = new File(file, "level.dat_old");
        if (file3.exists()) {
            try {
                return new WorldData(NBTCompressedStreamTools.a(new FileInputStream(file3)).getCompound("Data"));
            }
            catch (Exception ex2) {
                WorldLoader.b.error("Exception reading " + file3, ex2);
            }
        }
        return null;
    }
    
    @Override
    public boolean e(final String s) {
        final File file = new File(this.a, s);
        if (!file.exists()) {
            return true;
        }
        WorldLoader.b.info("Deleting level " + s);
        for (int i = 1; i <= 5; ++i) {
            WorldLoader.b.info("Attempt " + i + "...");
            if (a(file.listFiles())) {
                break;
            }
            WorldLoader.b.warn("Unsuccessful in deleting contents.");
            if (i < 5) {
                try {
                    Thread.sleep(500L);
                }
                catch (InterruptedException ex) {}
            }
        }
        return file.delete();
    }
    
    protected static boolean a(final File[] array) {
        for (int i = 0; i < array.length; ++i) {
            final File file = array[i];
            WorldLoader.b.debug("Deleting " + file);
            if (file.isDirectory() && !a(file.listFiles())) {
                WorldLoader.b.warn("Couldn't delete directory " + file);
                return false;
            }
            if (!file.delete()) {
                WorldLoader.b.warn("Couldn't delete file " + file);
                return false;
            }
        }
        return true;
    }
    
    @Override
    public IDataManager a(final String s, final boolean flag) {
        return new WorldNBTStorage(this.a, s, flag);
    }
    
    @Override
    public boolean isConvertable(final String s) {
        return false;
    }
    
    @Override
    public boolean convert(final String s, final IProgressUpdate progressUpdate) {
        return false;
    }
    
    static {
        b = LogManager.getLogger();
    }
}
