package net.minecraft.server.v1_7_R4;

import java.util.*;

class MojangsonCompoundParser extends MojangsonTypeParser
{
    protected ArrayList b;
    
    public MojangsonCompoundParser(final String a) {
        this.b = new ArrayList();
        this.a = a;
    }
    
    @Override
    public NBTBase a() {
        final NBTTagCompound nbtTagCompound = new NBTTagCompound();
        for (final MojangsonTypeParser mojangsonTypeParser : this.b) {
            nbtTagCompound.set(mojangsonTypeParser.a, mojangsonTypeParser.a());
        }
        return nbtTagCompound;
    }
}
