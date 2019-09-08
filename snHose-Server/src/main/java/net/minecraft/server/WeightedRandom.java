package net.minecraft.server.v1_7_R4;

import java.util.*;

public class WeightedRandom
{
    public static int a(final Collection collection) {
        int n = 0;
        final Iterator<WeightedRandomChoice> iterator = collection.iterator();
        while (iterator.hasNext()) {
            n += iterator.next().a;
        }
        return n;
    }
    
    public static WeightedRandomChoice a(final Random random, final Collection collection, final int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        int nextInt = random.nextInt(n);
        for (final WeightedRandomChoice weightedRandomChoice : collection) {
            nextInt -= weightedRandomChoice.a;
            if (nextInt < 0) {
                return weightedRandomChoice;
            }
        }
        return null;
    }
    
    public static WeightedRandomChoice a(final Random random, final Collection collection) {
        return a(random, collection, a(collection));
    }
    
    public static int a(final WeightedRandomChoice[] array) {
        int n = 0;
        for (int length = array.length, i = 0; i < length; ++i) {
            n += array[i].a;
        }
        return n;
    }
    
    public static WeightedRandomChoice a(final Random random, final WeightedRandomChoice[] array, final int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        int nextInt = random.nextInt(n);
        for (final WeightedRandomChoice weightedRandomChoice : array) {
            nextInt -= weightedRandomChoice.a;
            if (nextInt < 0) {
                return weightedRandomChoice;
            }
        }
        return null;
    }
    
    public static WeightedRandomChoice a(final Random random, final WeightedRandomChoice[] array) {
        return a(random, array, a(array));
    }
}
