package net.minecraft.server.v1_7_R4;

import java.io.*;

final class DatFilenameFilter implements FilenameFilter
{
    @Override
    public boolean accept(final File file, final String s) {
        return s.endsWith(".dat");
    }
}
