package net.minecraft.server.v1_7_R4;

import java.util.*;
import java.io.*;
import java.net.*;

public class RemoteStatusListener extends RemoteConnectionThread
{
    private long clearedTime;
    private int bindPort;
    private int serverPort;
    private int maxPlayers;
    private String localAddress;
    private String worldName;
    private DatagramSocket socket;
    private byte[] o;
    private DatagramPacket p;
    private Map q;
    private String hostname;
    private String motd;
    private Map challenges;
    private long u;
    private RemoteStatusReply cachedReply;
    private long cacheTime;
    
    public RemoteStatusListener(final IMinecraftServer minecraftServer) {
        super(minecraftServer, "Query Listener");
        this.o = new byte[1460];
        this.bindPort = minecraftServer.a("query.port", 0);
        this.motd = minecraftServer.y();
        this.serverPort = minecraftServer.z();
        this.localAddress = minecraftServer.A();
        this.maxPlayers = minecraftServer.D();
        this.worldName = minecraftServer.O();
        this.cacheTime = 0L;
        this.hostname = "0.0.0.0";
        if (0 == this.motd.length() || this.hostname.equals(this.motd)) {
            this.motd = "0.0.0.0";
            try {
                this.hostname = InetAddress.getLocalHost().getHostAddress();
            }
            catch (UnknownHostException ex) {
                this.warning("Unable to determine local host IP, please set server-ip in '" + minecraftServer.b() + "' : " + ex.getMessage());
            }
        }
        else {
            this.hostname = this.motd;
        }
        if (0 == this.bindPort) {
            this.bindPort = this.serverPort;
            this.info("Setting default query port to " + this.bindPort);
            minecraftServer.a("query.port", (Object)this.bindPort);
            minecraftServer.a("debug", (Object)false);
            minecraftServer.a();
        }
        this.q = new HashMap();
        this.cachedReply = new RemoteStatusReply(1460);
        this.challenges = new HashMap();
        this.u = new Date().getTime();
    }
    
    private void send(final byte[] array, final DatagramPacket datagramPacket) {
        this.socket.send(new DatagramPacket(array, array.length, datagramPacket.getSocketAddress()));
    }
    
    private boolean parsePacket(final DatagramPacket datagramPacket) {
        final byte[] data = datagramPacket.getData();
        final int length = datagramPacket.getLength();
        final SocketAddress socketAddress = datagramPacket.getSocketAddress();
        this.debug("Packet len " + length + " [" + socketAddress + "]");
        if (3 > length || -2 != data[0] || -3 != data[1]) {
            this.debug("Invalid packet [" + socketAddress + "]");
            return false;
        }
        this.debug("Packet '" + StatusChallengeUtils.a(data[2]) + "' [" + socketAddress + "]");
        switch (data[2]) {
            case 9: {
                this.createChallenge(datagramPacket);
                this.debug("Challenge [" + socketAddress + "]");
                return true;
            }
            case 0: {
                if (!this.hasChallenged(datagramPacket)) {
                    this.debug("Invalid challenge [" + socketAddress + "]");
                    return false;
                }
                if (15 == length) {
                    this.send(this.getFullReply(datagramPacket), datagramPacket);
                    this.debug("Rules [" + socketAddress + "]");
                    break;
                }
                final RemoteStatusReply remoteStatusReply = new RemoteStatusReply(1460);
                remoteStatusReply.write(0);
                remoteStatusReply.write(this.getIdentityToken(datagramPacket.getSocketAddress()));
                remoteStatusReply.write(this.localAddress);
                remoteStatusReply.write("SMP");
                remoteStatusReply.write(this.worldName);
                remoteStatusReply.write(Integer.toString(this.d()));
                remoteStatusReply.write(Integer.toString(this.maxPlayers));
                remoteStatusReply.write((short)this.serverPort);
                remoteStatusReply.write(this.hostname);
                this.send(remoteStatusReply.getBytes(), datagramPacket);
                this.debug("Status [" + socketAddress + "]");
                break;
            }
        }
        return true;
    }
    
    private byte[] getFullReply(final DatagramPacket datagramPacket) {
        final long ar = MinecraftServer.ar();
        if (ar < this.cacheTime + 5000L) {
            final byte[] bytes = this.cachedReply.getBytes();
            final byte[] identityToken = this.getIdentityToken(datagramPacket.getSocketAddress());
            bytes[1] = identityToken[0];
            bytes[2] = identityToken[1];
            bytes[3] = identityToken[2];
            bytes[4] = identityToken[3];
            return bytes;
        }
        this.cacheTime = ar;
        this.cachedReply.reset();
        this.cachedReply.write(0);
        this.cachedReply.write(this.getIdentityToken(datagramPacket.getSocketAddress()));
        this.cachedReply.write("splitnum");
        this.cachedReply.write(128);
        this.cachedReply.write(0);
        this.cachedReply.write("hostname");
        this.cachedReply.write(this.localAddress);
        this.cachedReply.write("gametype");
        this.cachedReply.write("SMP");
        this.cachedReply.write("game_id");
        this.cachedReply.write("MINECRAFT");
        this.cachedReply.write("version");
        this.cachedReply.write(this.server.getVersion());
        this.cachedReply.write("plugins");
        this.cachedReply.write(this.server.getPlugins());
        this.cachedReply.write("map");
        this.cachedReply.write(this.worldName);
        this.cachedReply.write("numplayers");
        this.cachedReply.write("" + this.d());
        this.cachedReply.write("maxplayers");
        this.cachedReply.write("" + this.maxPlayers);
        this.cachedReply.write("hostport");
        this.cachedReply.write("" + this.serverPort);
        this.cachedReply.write("hostip");
        this.cachedReply.write(this.hostname);
        this.cachedReply.write(0);
        this.cachedReply.write(1);
        this.cachedReply.write("player_");
        this.cachedReply.write(0);
        final String[] players = this.server.getPlayers();
        for (int length = players.length, i = 0; i < length; ++i) {
            this.cachedReply.write(players[i]);
        }
        this.cachedReply.write(0);
        return this.cachedReply.getBytes();
    }
    
    private byte[] getIdentityToken(final SocketAddress socketAddress) {
        return this.challenges.get(socketAddress).getIdentityToken();
    }
    
    private Boolean hasChallenged(final DatagramPacket datagramPacket) {
        final SocketAddress socketAddress = datagramPacket.getSocketAddress();
        if (!this.challenges.containsKey(socketAddress)) {
            return false;
        }
        if (((RemoteStatusChallenge)this.challenges.get(socketAddress)).getToken() != StatusChallengeUtils.c(datagramPacket.getData(), 7, datagramPacket.getLength())) {
            return false;
        }
        return true;
    }
    
    private void createChallenge(final DatagramPacket datagramPacket) {
        final RemoteStatusChallenge remoteStatusChallenge = new RemoteStatusChallenge(this, datagramPacket);
        this.challenges.put(datagramPacket.getSocketAddress(), remoteStatusChallenge);
        this.send(remoteStatusChallenge.getChallengeResponse(), datagramPacket);
    }
    
    private void cleanChallenges() {
        if (!this.running) {
            return;
        }
        final long ar = MinecraftServer.ar();
        if (ar < this.clearedTime + 30000L) {
            return;
        }
        this.clearedTime = ar;
        final Iterator<Map.Entry<K, RemoteStatusChallenge>> iterator = this.challenges.entrySet().iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getValue().isExpired(ar)) {
                iterator.remove();
            }
        }
    }
    
    @Override
    public void run() {
        this.info("Query running on " + this.motd + ":" + this.bindPort);
        this.clearedTime = MinecraftServer.ar();
        this.p = new DatagramPacket(this.o, this.o.length);
        try {
            while (this.running) {
                try {
                    this.socket.receive(this.p);
                    this.cleanChallenges();
                    this.parsePacket(this.p);
                }
                catch (SocketTimeoutException ex2) {
                    this.cleanChallenges();
                }
                catch (PortUnreachableException ex3) {}
                catch (IOException ex) {
                    this.a(ex);
                }
            }
        }
        finally {
            this.e();
        }
    }
    
    @Override
    public void a() {
        if (this.running) {
            return;
        }
        if (0 >= this.bindPort || 65535 < this.bindPort) {
            this.warning("Invalid query port " + this.bindPort + " found in '" + this.server.b() + "' (queries disabled)");
            return;
        }
        if (this.g()) {
            super.a();
        }
    }
    
    private void a(final Exception ex) {
        if (!this.running) {
            return;
        }
        this.warning("Unexpected exception, buggy JRE? (" + ex.toString() + ")");
        if (!this.g()) {
            this.error("Failed to recover from buggy JRE, shutting down!");
            this.running = false;
        }
    }
    
    private boolean g() {
        try {
            this.a(this.socket = new DatagramSocket(this.bindPort, InetAddress.getByName(this.motd)));
            this.socket.setSoTimeout(500);
            return true;
        }
        catch (SocketException ex) {
            this.warning("Unable to initialise query system on " + this.motd + ":" + this.bindPort + " (Socket): " + ex.getMessage());
        }
        catch (UnknownHostException ex2) {
            this.warning("Unable to initialise query system on " + this.motd + ":" + this.bindPort + " (Unknown Host): " + ex2.getMessage());
        }
        catch (Exception ex3) {
            this.warning("Unable to initialise query system on " + this.motd + ":" + this.bindPort + " (E): " + ex3.getMessage());
        }
        return false;
    }
}
