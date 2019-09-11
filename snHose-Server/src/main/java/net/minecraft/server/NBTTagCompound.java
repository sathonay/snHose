package net.minecraft.server;

import java.util.*;
import java.util.concurrent.*;
import java.io.*;
import org.apache.logging.log4j.*;

public class NBTTagCompound extends NBTBase
{
    private static final Logger b;
    private Map map;
    
    public NBTTagCompound() {
        this.map = new HashMap();
    }
    
    @Override
    void write(final DataOutput dataOutput) {
        for (final String s : this.map.keySet()) {
            a(s, (NBTBase)this.map.get(s), dataOutput);
        }
        dataOutput.writeByte(0);
    }
    
    @Override
    void load(final DataInput dataInput, final int n, final NBTReadLimiter nbtReadLimiter) {
        if (n > 512) {
            throw new RuntimeException("Tried to read NBT tag with too high complexity, depth > 512");
        }
        this.map.clear();
        byte a;
        while ((a = a(dataInput, nbtReadLimiter)) != 0) {
            final String b = b(dataInput, nbtReadLimiter);
            nbtReadLimiter.a(16 * b.length());
            this.map.put(b, a(a, b, dataInput, n + 1, nbtReadLimiter));
        }
    }
    
    public Set c() {
        return this.map.keySet();
    }
    
    @Override
    public byte getTypeId() {
        return 10;
    }
    
    public void set(final String s, final NBTBase nbtBase) {
        this.map.put(s, nbtBase);
    }
    
    public void setByte(final String s, final byte b) {
        this.map.put(s, new NBTTagByte(b));
    }
    
    public void setShort(final String s, final short n) {
        this.map.put(s, new NBTTagShort(n));
    }
    
    public void setInt(final String s, final int n) {
        this.map.put(s, new NBTTagInt(n));
    }
    
    public void setLong(final String s, final long n) {
        this.map.put(s, new NBTTagLong(n));
    }
    
    public void setFloat(final String s, final float n) {
        this.map.put(s, new NBTTagFloat(n));
    }
    
    public void setDouble(final String s, final double n) {
        this.map.put(s, new NBTTagDouble(n));
    }
    
    public void setString(final String s, final String s2) {
        this.map.put(s, new NBTTagString(s2));
    }
    
    public void setByteArray(final String s, final byte[] abyte) {
        this.map.put(s, new NBTTagByteArray(abyte));
    }
    
    public void setIntArray(final String s, final int[] aint) {
        this.map.put(s, new NBTTagIntArray(aint));
    }
    
    public void setBoolean(final String s, final boolean b) {
        this.setByte(s, (byte)(b ? 1 : 0));
    }
    
    public NBTBase get(final String s) {
        return this.map.get(s);
    }
    
    public byte b(final String s) {
        final NBTBase nbtBase = this.map.get(s);
        if (nbtBase != null) {
            return nbtBase.getTypeId();
        }
        return 0;
    }
    
    public boolean hasKey(final String s) {
        return this.map.containsKey(s);
    }
    
    public boolean hasKeyOfType(final String s, final int n) {
        final byte b = this.b(s);
        return b == n || (n == 99 && (b == 1 || b == 2 || b == 3 || b == 4 || b == 5 || b == 6));
    }
    
    public byte getByte(final String s) {
        try {
            if (!this.map.containsKey(s)) {
                return 0;
            }
            return this.map.get(s).f();
        }
        catch (ClassCastException ex) {
            return 0;
        }
    }
    
    public short getShort(final String s) {
        try {
            if (!this.map.containsKey(s)) {
                return 0;
            }
            return this.map.get(s).e();
        }
        catch (ClassCastException ex) {
            return 0;
        }
    }
    
    public int getInt(final String s) {
        try {
            if (!this.map.containsKey(s)) {
                return 0;
            }
            return this.map.get(s).d();
        }
        catch (ClassCastException ex) {
            return 0;
        }
    }
    
    public long getLong(final String s) {
        try {
            if (!this.map.containsKey(s)) {
                return 0L;
            }
            return this.map.get(s).c();
        }
        catch (ClassCastException ex) {
            return 0L;
        }
    }
    
    public float getFloat(final String s) {
        try {
            if (!this.map.containsKey(s)) {
                return 0.0f;
            }
            return this.map.get(s).h();
        }
        catch (ClassCastException ex) {
            return 0.0f;
        }
    }
    
    public double getDouble(final String s) {
        try {
            if (!this.map.containsKey(s)) {
                return 0.0;
            }
            return this.map.get(s).g();
        }
        catch (ClassCastException ex) {
            return 0.0;
        }
    }
    
    public String getString(final String s) {
        try {
            if (!this.map.containsKey(s)) {
                return "";
            }
            return this.map.get(s).a_();
        }
        catch (ClassCastException ex) {
            return "";
        }
    }
    
    public byte[] getByteArray(final String s) {
        try {
            if (!this.map.containsKey(s)) {
                return new byte[0];
            }
            return this.map.get(s).c();
        }
        catch (ClassCastException ex) {
            throw new ReportedException(this.a(s, 7, ex));
        }
    }
    
    public int[] getIntArray(final String s) {
        try {
            if (!this.map.containsKey(s)) {
                return new int[0];
            }
            return this.map.get(s).c();
        }
        catch (ClassCastException ex) {
            throw new ReportedException(this.a(s, 11, ex));
        }
    }
    
    public NBTTagCompound getCompound(final String s) {
        try {
            if (!this.map.containsKey(s)) {
                return new NBTTagCompound();
            }
            return this.map.get(s);
        }
        catch (ClassCastException ex) {
            throw new ReportedException(this.a(s, 10, ex));
        }
    }
    
    public NBTTagList getList(final String s, final int n) {
        try {
            if (this.b(s) != 9) {
                return new NBTTagList();
            }
            final NBTTagList list = this.map.get(s);
            if (list.size() > 0 && list.d() != n) {
                return new NBTTagList();
            }
            return list;
        }
        catch (ClassCastException ex) {
            throw new ReportedException(this.a(s, 9, ex));
        }
    }
    
    public boolean getBoolean(final String s) {
        return this.getByte(s) != 0;
    }
    
    public void remove(final String s) {
        this.map.remove(s);
    }
    
    @Override
    public String toString() {
        String string = "{";
        for (final String s : this.map.keySet()) {
            string = string + s + ':' + this.map.get(s) + ',';
        }
        return string + "}";
    }
    
    public boolean isEmpty() {
        return this.map.isEmpty();
    }
    
    private CrashReport a(final String s, final int n, final ClassCastException throwable) {
        final CrashReport a = CrashReport.a(throwable, "Reading NBT data");
        final CrashReportSystemDetails a2 = a.a("Corrupt NBT tag", 1);
        a2.a("Tag type found", new CrashReportCorruptNBTTag(this, s));
        a2.a("Tag type expected", new CrashReportCorruptNBTTag2(this, n));
        a2.a("Tag name", s);
        return a;
    }
    
    @Override
    public NBTBase clone() {
        final NBTTagCompound nbtTagCompound = new NBTTagCompound();
        for (final String s : this.map.keySet()) {
            nbtTagCompound.set(s, ((NBTBase)this.map.get(s)).clone());
        }
        return nbtTagCompound;
    }
    
    @Override
    public boolean equals(final Object object) {
        return super.equals(object) && this.map.entrySet().equals(((NBTTagCompound)object).map.entrySet());
    }
    
    @Override
    public int hashCode() {
        return super.hashCode() ^ this.map.hashCode();
    }
    
    private static void a(final String s, final NBTBase nbtBase, final DataOutput dataOutput) {
        dataOutput.writeByte(nbtBase.getTypeId());
        if (nbtBase.getTypeId() == 0) {
            return;
        }
        dataOutput.writeUTF(s);
        nbtBase.write(dataOutput);
    }
    
    private static byte a(final DataInput dataInput, final NBTReadLimiter nbtReadLimiter) {
        return dataInput.readByte();
    }
    
    private static String b(final DataInput dataInput, final NBTReadLimiter nbtReadLimiter) {
        return dataInput.readUTF();
    }
    
    static NBTBase a(final byte b0, final String s, final DataInput dataInput, final int n, final NBTReadLimiter nbtReadLimiter) {
        final NBTBase tag = NBTBase.createTag(b0);
        try {
            tag.load(dataInput, n, nbtReadLimiter);
        }
        catch (IOException throwable) {
            final CrashReport a = CrashReport.a(throwable, "Loading NBT data");
            final CrashReportSystemDetails a2 = a.a("NBT Tag");
            a2.a("Tag name", s);
            a2.a("Tag type", b0);
            throw new ReportedException(a);
        }
        return tag;
    }
    
    static {
        b = LogManager.getLogger();
    }
}
