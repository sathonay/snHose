package net.minecraft.server;

import java.net.*;
import java.util.*;

class RemoteStatusChallenge
{
    private long time;
    private int token;
    private byte[] identity;
    private byte[] response;
    private String f;
    final /* synthetic */ RemoteStatusListener a;
    
    public RemoteStatusChallenge(final RemoteStatusListener a, final DatagramPacket datagramPacket) {
        this.a = a;
        this.time = new Date().getTime();
        final byte[] data = datagramPacket.getData();
        (this.identity = new byte[4])[0] = data[3];
        this.identity[1] = data[4];
        this.identity[2] = data[5];
        this.identity[3] = data[6];
        this.f = new String(this.identity);
        this.token = new Random().nextInt(16777216);
        this.response = String.format("\t%s%d\u0000", this.f, this.token).getBytes();
    }
    
    public Boolean isExpired(final long n) {
        return this.time < n;
    }
    
    public int getToken() {
        return this.token;
    }
    
    public byte[] getChallengeResponse() {
        return this.response;
    }
    
    public byte[] getIdentityToken() {
        return this.identity;
    }
}
