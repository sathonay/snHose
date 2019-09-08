package net.minecraft.server.v1_7_R4;

import net.minecraft.util.com.google.common.collect.*;
import java.net.*;
import java.lang.management.*;
import java.util.*;

class MojangStatisticsTask extends TimerTask
{
    final /* synthetic */ MojangStatisticsGenerator a;
    
    MojangStatisticsTask(final MojangStatisticsGenerator a) {
        this.a = a;
    }
    
    @Override
    public void run() {
        if (!this.a.e.getSnooperEnabled()) {
            return;
        }
        final HashMap<String, String> hashMap;
        synchronized (this.a.g) {
            hashMap = new HashMap<String, String>(this.a.b);
            if (this.a.j == 0) {
                hashMap.putAll((Map<?, ?>)this.a.a);
            }
            hashMap.put("snooper_count", (String)(this.a.j++));
            hashMap.put("snooper_token", this.a.c);
        }
        HttpUtilities.a(this.a.d, hashMap, true);
    }
}
