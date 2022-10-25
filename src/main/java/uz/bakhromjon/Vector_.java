package uz.bakhromjon;

import uz.bakhromjon.exceptions.ArrayIndexOutOfBoundsException_;
import uz.bakhromjon.exceptions.IndexOutOfBoundsException_;
import uz.bakhromjon.support.ArraysSupport_;
import uz.bakhromjon.support.System_;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * @author : Bakhromjon Khasanboyev
 * @since : 25/10/22, Tue, 16:21
 **/
public class Vector_<E> {
    protected Object[] elementData;
    private int elementCount = 0;
    protected int capacityIncrement;

    public Vector_(int initialCapacity, int capacityIncrement) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal capacity: " +
                    initialCapacity);
        }
        this.elementData = new Object[initialCapacity];
        this.capacityIncrement = capacityIncrement;
    }

    public Vector_() {
        this(10);
    }

    public Vector_(int initialCapacity) {
        this(initialCapacity, 0);
    }

    public synchronized boolean add(E element) {
        if (elementCount == elementData.length) grow();
        elementData[elementCount] = element;
        elementCount++;
        return true;
    }

    public Object[] grow() {
        int oldCapacity = elementData.length;
        int newCapacity = ArraysSupport_.newLength(oldCapacity, (capacityIncrement > 0) ?
                capacityIncrement : oldCapacity);
        return elementData = Arrays.copyOf(elementData, newCapacity);
    }

    public synchronized E get(int index) {
        if (index >= elementCount) {
            throw new ArrayIndexOutOfBoundsException_(index);
        }
        return elementData(index);
    }

    public void checkElementIndex(int index) {
        if (!isElementIndex(index)) {
            throw new IndexOutOfBoundsException_(outOfBoundsMsg(index));
        }
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < elementCount;
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + elementCount;
    }

    public E elementData(int index) {
        return (E) elementData[index];
    }

    public synchronized E set(int index, E element) {
        if (index >= elementCount) {
            throw new IndexOutOfBoundsException_(outOfBoundsMsg(index));
        }
        E oldVal = elementData(index);
        elementData[index] = element;
        return oldVal;
    }

    public synchronized E remove(int index) {
        if (index >= elementCount)
            throw new ArrayIndexOutOfBoundsException_(index);

        Object[] newElementData = new Object[this.elementData.length - 1];
        System_.arrayCopy(elementData, 0, index, newElementData, 0);
        System_.arrayCopy(elementData, index + 1, elementCount, newElementData, index);
        E removedValue = elementData(index);
        this.elementData = newElementData;
        elementCount--;
        return removedValue;
    }

    public E firstElement() {
        if (elementCount == 0)
            throw new NoSuchElementException();
        return elementData(0);
    }

    public int size() {
        return elementCount;
    }

    public synchronized int lastIndexOf(Object obj) {
        for (int i = elementCount - 1; i >= 0; i--) {
            if (elementData[i].equals(obj)) {
                return i;
            }
        }
        return -1;
    }
}
