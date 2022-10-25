package uz.bakhromjon.exceptions;

/**
 * @author : Bakhromjon Khasanboyev
 * @since : 25/10/22, Tue, 16:39
 **/
public class IndexOutOfBoundsException_ extends RuntimeException {
    public IndexOutOfBoundsException_() {
        super();
    }

    public IndexOutOfBoundsException_(String s) {
        super(s);
    }

    public IndexOutOfBoundsException_(int index) {
        super("Index out of range: " + index);
    }

    public IndexOutOfBoundsException_(long index) {
        super("Index out of range: " + index);
    }
}
