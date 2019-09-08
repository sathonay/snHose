package net.minecraft.server.v1_7_R4;

import java.net.*;
import java.io.*;
import org.apache.logging.log4j.*;

public class RemoteControlSession extends RemoteConnectionThread
{
    private static final Logger h;
    private boolean i;
    private Socket j;
    private byte[] k;
    private String l;
    
    RemoteControlSession(final IMinecraftServer minecraftServer, final Socket j) {
        super(minecraftServer, "RCON Client");
        this.k = new byte[1460];
        this.j = j;
        try {
            this.j.setSoTimeout(0);
        }
        catch (Exception ex) {
            this.running = false;
        }
        this.l = minecraftServer.a("rcon.password", "");
        this.info("Rcon connection from: " + j.getInetAddress());
    }
    
    @Override
    public void run() {
        try {
            while (this.running) {
                final int read = new BufferedInputStream(this.j.getInputStream()).read(this.k, 0, 1460);
                if (10 > read) {
                    return;
                }
                int n = 0;
                if (StatusChallengeUtils.b(this.k, 0, read) != read - 4) {
                    return;
                }
                n += 4;
                final int b = StatusChallengeUtils.b(this.k, n, read);
                n += 4;
                final int b2 = StatusChallengeUtils.b(this.k, n);
                n += 4;
                switch (b2) {
                    case 3: {
                        final String a = StatusChallengeUtils.a(this.k, n, read);
                        final int n2 = n + a.length();
                        if (0 != a.length() && a.equals(this.l)) {
                            this.i = true;
                            this.a(b, 2, "");
                            continue;
                        }
                        this.i = false;
                        this.f();
                        continue;
                    }
                    case 2: {
                        if (this.i) {
                            final String a2 = StatusChallengeUtils.a(this.k, n, read);
                            try {
                                this.a(b, this.server.g(a2));
                            }
                            catch (Exception ex) {
                                this.a(b, "Error executing: " + a2 + " (" + ex.getMessage() + ")");
                            }
                            continue;
                        }
                        this.f();
                        continue;
                    }
                    default: {
                        this.a(b, String.format("Unknown request %s", Integer.toHexString(b2)));
                        continue;
                    }
                }
            }
        }
        catch (SocketTimeoutException ex3) {}
        catch (IOException ex4) {}
        catch (Exception ex2) {
            RemoteControlSession.h.error("Exception whilst parsing RCON input", ex2);
        }
        finally {
            this.g();
        }
    }
    
    private void a(final int n, final int n2, final String s) {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(1248);
        final DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        final byte[] bytes = s.getBytes("UTF-8");
        dataOutputStream.writeInt(Integer.reverseBytes(bytes.length + 10));
        dataOutputStream.writeInt(Integer.reverseBytes(n));
        dataOutputStream.writeInt(Integer.reverseBytes(n2));
        dataOutputStream.write(bytes);
        dataOutputStream.write(0);
        dataOutputStream.write(0);
        this.j.getOutputStream().write(byteArrayOutputStream.toByteArray());
    }
    
    private void f() {
        this.a(-1, 2, "");
    }
    
    private void a(final int n, String substring) {
        int n2 = substring.length();
        do {
            final int n3 = (4096 <= n2) ? 4096 : n2;
            this.a(n, 0, substring.substring(0, n3));
            substring = substring.substring(n3);
            n2 = substring.length();
        } while (n2);
    }
    
    private void g() {
        if (null == this.j) {
            return;
        }
        try {
            this.j.close();
        }
        catch (IOException ex) {
            this.warning("IO: " + ex.getMessage());
        }
        this.j = null;
    }
    
    static {
        h = LogManager.getLogger();
    }
}
