package net.minecraft.server;

import java.util.*;

class MojangsonListParser extends MojangsonTypeParser
{
    protected ArrayList b;
    
    public MojangsonListParser(final String a) {
        this.b = new ArrayList();
        this.a = a;
    }
    
    @Override
    public NBTBase a() {
        final NBTTagList list = new NBTTagList();
        final Iterator<MojangsonTypeParser> iterator = this.b.iterator();
        while (iterator.hasNext()) {
            list.add(iterator.next().a());
        }
        return list;
    }
}
