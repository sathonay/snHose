package net.minecraft.server.v1_7_R4;

import java.io.*;
import java.util.*;
import org.apache.logging.log4j.*;

public class WorldLoaderServer extends WorldLoader
{
    private static final Logger b;
    
    public WorldLoaderServer(final File file) {
        super(file);
    }
    
    protected int c() {
        return 19133;
    }
    
    @Override
    public void d() {
        RegionFileCache.a();
    }
    
    @Override
    public IDataManager a(final String s, final boolean b) {
        return new ServerNBTManager(this.a, s, b);
    }
    
    @Override
    public boolean isConvertable(final String s) {
        final WorldData c = this.c(s);
        return c != null && c.l() != this.c();
    }
    
    @Override
    public boolean convert(final String s, final IProgressUpdate progressUpdate) {
        progressUpdate.a(0);
        final ArrayList list = new ArrayList();
        final ArrayList list2 = new ArrayList();
        final ArrayList list3 = new ArrayList();
        final File file = new File(this.a, s);
        final File file2 = new File(file, "DIM-1");
        final File file3 = new File(file, "DIM1");
        WorldLoaderServer.b.info("Scanning folders...");
        this.a(file, list);
        if (file2.exists()) {
            this.a(file2, list2);
        }
        if (file3.exists()) {
            this.a(file3, list3);
        }
        final int n = list.size() + list2.size() + list3.size();
        WorldLoaderServer.b.info("Total conversion count is " + n);
        final WorldData c = this.c(s);
        WorldChunkManager worldChunkManager;
        if (c.getType() == WorldType.FLAT) {
            worldChunkManager = new WorldChunkManagerHell(BiomeBase.PLAINS, 0.5f);
        }
        else {
            worldChunkManager = new WorldChunkManager(c.getSeed(), c.getType());
        }
        this.a(new File(file, "region"), list, worldChunkManager, 0, n, progressUpdate);
        this.a(new File(file2, "region"), list2, new WorldChunkManagerHell(BiomeBase.HELL, 0.0f), list.size(), n, progressUpdate);
        this.a(new File(file3, "region"), list3, new WorldChunkManagerHell(BiomeBase.SKY, 0.0f), list.size() + list2.size(), n, progressUpdate);
        c.e(19133);
        if (c.getType() == WorldType.NORMAL_1_1) {
            c.setType(WorldType.NORMAL);
        }
        this.g(s);
        this.a(s, false).saveWorldData(c);
        return true;
    }
    
    private void g(final String s) {
        final File file = new File(this.a, s);
        if (!file.exists()) {
            WorldLoaderServer.b.warn("Unable to create level.dat_mcr backup");
            return;
        }
        final File file2 = new File(file, "level.dat");
        if (!file2.exists()) {
            WorldLoaderServer.b.warn("Unable to create level.dat_mcr backup");
            return;
        }
        if (!file2.renameTo(new File(file, "level.dat_mcr"))) {
            WorldLoaderServer.b.warn("Unable to create level.dat_mcr backup");
        }
    }
    
    private void a(final File file, final Iterable iterable, final WorldChunkManager worldChunkManager, int n, final int n2, final IProgressUpdate progressUpdate) {
        final Iterator<File> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            this.a(file, iterator.next(), worldChunkManager, n, n2, progressUpdate);
            ++n;
            progressUpdate.a((int)Math.round(100.0 * n / n2));
        }
    }
    
    private void a(final File file, final File file2, final WorldChunkManager worldchunkmanager, final int n, final int n2, final IProgressUpdate progressUpdate) {
        try {
            final String name = file2.getName();
            final RegionFile regionFile = new RegionFile(file2);
            final RegionFile regionFile2 = new RegionFile(new File(file, name.substring(0, name.length() - ".mcr".length()) + ".mca"));
            for (int i = 0; i < 32; ++i) {
                for (int j = 0; j < 32; ++j) {
                    if (regionFile.c(i, j) && !regionFile2.c(i, j)) {
                        final DataInputStream a = regionFile.a(i, j);
                        if (a == null) {
                            WorldLoaderServer.b.warn("Failed to fetch input stream");
                        }
                        else {
                            final NBTTagCompound a2 = NBTCompressedStreamTools.a(a);
                            a.close();
                            final OldChunk a3 = OldChunkLoader.a(a2.getCompound("Level"));
                            final NBTTagCompound nbttagcompound = new NBTTagCompound();
                            final NBTTagCompound nbttagcompound2 = new NBTTagCompound();
                            nbttagcompound.set("Level", nbttagcompound2);
                            OldChunkLoader.a(a3, nbttagcompound2, worldchunkmanager);
                            final DataOutputStream b = regionFile2.b(i, j);
                            NBTCompressedStreamTools.a(nbttagcompound, (DataOutput)b);
                            b.close();
                        }
                    }
                }
                final int n3 = (int)Math.round(100.0 * (n * 1024) / (n2 * 1024));
                final int n4 = (int)Math.round(100.0 * ((i + 1) * 32 + n * 1024) / (n2 * 1024));
                if (n4 > n3) {
                    progressUpdate.a(n4);
                }
            }
            regionFile.c();
            regionFile2.c();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private void a(final File file, final Collection collection) {
        final File[] listFiles = new File(file, "region").listFiles(new ChunkFilenameFilter(this));
        if (listFiles != null) {
            Collections.addAll(collection, listFiles);
        }
    }
    
    static {
        b = LogManager.getLogger();
    }
}
