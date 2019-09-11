package net.minecraft.server;

import java.util.*;

public class BiomeBaseSub extends BiomeBase
{
    protected BiomeBase aD;
    
    public BiomeBaseSub(final int i, final BiomeBase ad) {
        super(i);
        this.aD = ad;
        this.a(ad.ag, true);
        this.af = ad.af + " M";
        this.ai = ad.ai;
        this.ak = ad.ak;
        this.al = ad.al;
        this.am = ad.am;
        this.an = ad.an;
        this.temperature = ad.temperature;
        this.humidity = ad.humidity;
        this.aq = ad.aq;
        this.aw = ad.aw;
        this.ax = ad.ax;
        this.at = new ArrayList(ad.at);
        this.as = new ArrayList(ad.as);
        this.av = new ArrayList(ad.av);
        this.au = new ArrayList(ad.au);
        this.temperature = ad.temperature;
        this.humidity = ad.humidity;
        this.am = ad.am + 0.1f;
        this.an = ad.an + 0.2f;
    }
    
    @Override
    public void a(final World world, final Random random, final int i, final int j) {
        this.aD.ar.a(world, random, this, i, j);
    }
    
    @Override
    public void a(final World world, final Random random, final Block[] ablock, final byte[] abyte, final int i, final int j, final double d0) {
        this.aD.a(world, random, ablock, abyte, i, j, d0);
    }
    
    @Override
    public float g() {
        return this.aD.g();
    }
    
    @Override
    public WorldGenTreeAbstract a(final Random random) {
        return this.aD.a(random);
    }
    
    @Override
    public Class l() {
        return this.aD.l();
    }
    
    @Override
    public boolean a(final BiomeBase biomebase) {
        return this.aD.a(biomebase);
    }
    
    @Override
    public EnumTemperature m() {
        return this.aD.m();
    }
}
