package uz.bakhromjon.support;

import java.lang.reflect.Array;

/**
 * @author : Bakhromjon Khasanboyev
 * @since : 23/10/22, Sun, 15:06
 **/
public class Arrays_ {
    public static Object[] copyOff(Object[] original, int newLength) {
        Object[] copy = new Object[newLength];
        for (int i = 0; i < newLength; i++) {
            copy[i] = original[i];
        }
        return copy;
    }

    public static <T> T[] copyOff(Object[] original, int newLength, Class<? extends T[]> newType) {
        T[] copy = ((Object) newType == (Object) Object[].class)
                ? (T[]) new Object[newLength]
                : (T[]) Array.newInstance(newType.getComponentType(), newLength);
        for (int i = 0; i < newLength; i++) {
            copy[i] = (T) original[i];
        }
        return copy;
    }

}
