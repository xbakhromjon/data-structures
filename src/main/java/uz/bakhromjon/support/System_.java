package uz.bakhromjon.support;

/**
 * @author : Bakhromjon Khasanboyev
 * @since : 23/10/22, Sun, 14:03
 **/
public class System_ {
    public static void arrayCopy(Object[] src, int srcStartPos, int srsEndPos, Object[] des, int desStartPos) {
        int j = desStartPos;
        for (int i = srcStartPos; i < srsEndPos; i++) {
            des[j] = src[i];
            j++;
        }
    }
}
