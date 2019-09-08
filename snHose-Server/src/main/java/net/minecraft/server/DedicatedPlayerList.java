package net.minecraft.server.v1_7_R4;

import net.minecraft.util.com.mojang.authlib.*;
import java.io.*;
import org.apache.logging.log4j.*;

public class DedicatedPlayerList extends PlayerList
{
    private static final Logger g;
    
    public DedicatedPlayerList(final DedicatedServer minecraftserver) {
        super(minecraftserver);
        this.a(minecraftserver.a("view-distance", 10));
        this.maxPlayers = minecraftserver.a("max-players", 20);
        this.setHasWhitelist(minecraftserver.a("white-list", false));
        if (!minecraftserver.N()) {
            this.getProfileBans().a(true);
            this.getIPBans().a(true);
        }
        this.y();
        this.w();
        this.x();
        this.v();
        this.z();
        this.B();
        this.A();
        if (!this.getWhitelist().c().exists()) {
            this.C();
        }
    }
    
    @Override
    public void setHasWhitelist(final boolean hasWhitelist) {
        super.setHasWhitelist(hasWhitelist);
        this.getServer().a("white-list", (Object)hasWhitelist);
        this.getServer().a();
    }
    
    @Override
    public void addOp(final GameProfile gameprofile) {
        super.addOp(gameprofile);
        this.A();
    }
    
    @Override
    public void removeOp(final GameProfile gameprofile) {
        super.removeOp(gameprofile);
        this.A();
    }
    
    @Override
    public void removeWhitelist(final GameProfile gameprofile) {
        super.removeWhitelist(gameprofile);
        this.C();
    }
    
    @Override
    public void addWhitelist(final GameProfile gameprofile) {
        super.addWhitelist(gameprofile);
        this.C();
    }
    
    @Override
    public void reloadWhitelist() {
        this.B();
    }
    
    private void v() {
        try {
            this.getIPBans().save();
        }
        catch (IOException ex) {
            DedicatedPlayerList.g.warn("Failed to save ip banlist: ", ex);
        }
    }
    
    private void w() {
        try {
            this.getProfileBans().save();
        }
        catch (IOException ex) {
            DedicatedPlayerList.g.warn("Failed to save user banlist: ", ex);
        }
    }
    
    private void x() {
        try {
            this.getIPBans().load();
        }
        catch (IOException ex) {
            DedicatedPlayerList.g.warn("Failed to load ip banlist: ", ex);
        }
    }
    
    private void y() {
        try {
            this.getProfileBans().load();
        }
        catch (IOException ex) {
            DedicatedPlayerList.g.warn("Failed to load user banlist: ", ex);
        }
    }
    
    private void z() {
        try {
            this.getOPs().load();
        }
        catch (Exception ex) {
            DedicatedPlayerList.g.warn("Failed to load operators list: ", ex);
        }
    }
    
    private void A() {
        try {
            this.getOPs().save();
        }
        catch (Exception ex) {
            DedicatedPlayerList.g.warn("Failed to save operators list: ", ex);
        }
    }
    
    private void B() {
        try {
            this.getWhitelist().load();
        }
        catch (Exception ex) {
            DedicatedPlayerList.g.warn("Failed to load white-list: ", ex);
        }
    }
    
    private void C() {
        try {
            this.getWhitelist().save();
        }
        catch (Exception ex) {
            DedicatedPlayerList.g.warn("Failed to save white-list: ", ex);
        }
    }
    
    @Override
    public boolean isWhitelisted(final GameProfile gameprofile) {
        return !this.getHasWhitelist() || this.isOp(gameprofile) || this.getWhitelist().isWhitelisted(gameprofile);
    }
    
    @Override
    public DedicatedServer getServer() {
        return (DedicatedServer)super.getServer();
    }
    
    static {
        g = LogManager.getLogger();
    }
}
