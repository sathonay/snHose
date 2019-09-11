package net.minecraft.server;

import java.io.*;

final class DatFilenameFilter implements FilenameFilter
{
    @Override
    public boolean accept(final File file, final String s) {
        return s.endsWith(".dat");
    }
}
