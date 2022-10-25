package uz.bakhromjon.exceptions;

/**
 * @author : Bakhromjon Khasanboyev
 * @since : 25/10/22, Tue, 16:38
 **/
public class ArrayIndexOutOfBoundsException_ extends IndexOutOfBoundsException_ {
    public ArrayIndexOutOfBoundsException_() {
        super();
    }
    public ArrayIndexOutOfBoundsException_(String s) {
        super(s);
    }
    public ArrayIndexOutOfBoundsException_(int index) {
        super("Array index out of range: " + index);
    }
}
