package net.minecraft.server.v1_7_R4;

import java.util.concurrent.*;
import java.util.*;
import java.io.*;
import org.apache.logging.log4j.*;

class CrashReportCorruptNBTTag implements Callable
{
    final /* synthetic */ String a;
    final /* synthetic */ NBTTagCompound b;
    
    CrashReportCorruptNBTTag(final NBTTagCompound b, final String a) {
        this.b = b;
        this.a = a;
    }
    
    public String a() {
        return NBTBase.a[this.b.map.get(this.a).getTypeId()];
    }
}
