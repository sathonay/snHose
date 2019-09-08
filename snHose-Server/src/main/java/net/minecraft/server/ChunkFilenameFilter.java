package net.minecraft.server.v1_7_R4;

import java.io.*;

class ChunkFilenameFilter implements FilenameFilter
{
    final /* synthetic */ WorldLoaderServer a;
    
    ChunkFilenameFilter(final WorldLoaderServer a) {
        this.a = a;
    }
    
    @Override
    public boolean accept(final File file, final String s) {
        return s.endsWith(".mcr");
    }
}
