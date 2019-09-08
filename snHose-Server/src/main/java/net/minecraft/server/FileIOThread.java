package net.minecraft.server.v1_7_R4;

import java.util.*;

public class FileIOThread implements Runnable
{
    public static final FileIOThread a;
    private List b;
    private volatile long c;
    private volatile long d;
    private volatile boolean e;
    
    private FileIOThread() {
        this.b = Collections.synchronizedList(new ArrayList<Object>());
        final Thread thread = new Thread(this, "File IO Thread");
        thread.setPriority(1);
        thread.start();
    }
    
    @Override
    public void run() {
        while (true) {
            this.b();
        }
    }
    
    private void b() {
        for (int i = 0; i < this.b.size(); ++i) {
            if (!((IAsyncChunkSaver)this.b.get(i)).c()) {
                this.b.remove(i--);
                ++this.d;
            }
            try {
                Thread.sleep(this.e ? 0L : 10L);
            }
            catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        if (this.b.isEmpty()) {
            try {
                Thread.sleep(25L);
            }
            catch (InterruptedException ex2) {
                ex2.printStackTrace();
            }
        }
    }
    
    public void a(final IAsyncChunkSaver asyncChunkSaver) {
        if (this.b.contains(asyncChunkSaver)) {
            return;
        }
        ++this.c;
        this.b.add(asyncChunkSaver);
    }
    
    public void a() {
        this.e = true;
        while (this.c != this.d) {
            Thread.sleep(10L);
        }
        this.e = false;
    }
    
    static {
        a = new FileIOThread();
    }
}
