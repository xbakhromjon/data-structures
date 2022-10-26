package uz.bakhromjon.list;

import java.util.EmptyStackException;

/**
 * @author : Bakhromjon Khasanboyev
 * @since : 25/10/22, Tue, 16:18
 **/
public class Stack_<E> extends Vector_<E> {
    public Stack_() {
    }

    public E push(E element) {
        add(element);
        return element;
    }

    public synchronized E peek() {
        if (size() == 0)
            throw new EmptyStackException();
        return elementData(size() - 1);
    }

    public synchronized E pop() {
        if (size() == 0)
            throw new EmptyStackException();
        return remove(size() - 1);
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public synchronized int search(Object obj) {
        int i = lastIndexOf(obj);
        if (i >= 0) {
            return size() - i;
        }
        return -1;
    }
}
