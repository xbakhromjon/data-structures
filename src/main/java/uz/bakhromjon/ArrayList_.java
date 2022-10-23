package uz.bakhromjon;

import uz.bakhromjon.base.Collection_;
import uz.bakhromjon.support.ArraysSupport_;
import uz.bakhromjon.support.Arrays_;
import uz.bakhromjon.support.System_;

import java.util.Arrays;

/**
 * @author : Bakhromjon Khasanboyev
 * @since : 21/10/22, Fri, 13:39
 **/
public class ArrayList_<E> {
    private static final int DEFAULT_CAPACITY = 10;
    transient Object[] elementData;
    private int size = 0;

    public ArrayList_(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = new Object[]{};
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
    }


    public ArrayList_() {
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    public ArrayList_(Collection_ c) {

    }

    public boolean add(E e) {
        if (size == elementData.length) elementData = grow();
        elementData[size] = e;
        size++;
        return true;
    }

    public void add(int index, E element) {
        rangeCheck(index);
        Object[] newElementData;
        if (size == this.elementData.length) this.elementData = grow();
        newElementData = new Object[this.elementData.length];
        System_.arrayCopy(elementData, 0, index, newElementData, 0);
        System_.arrayCopy(elementData, index, size, newElementData, index + 1);
        newElementData[index] = element;
        this.elementData = newElementData;
        size = size + 1;
    }

    private void rangeCheck(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    public Object[] grow() {
        int oldCapacity = elementData.length;
        int newCapacity = ArraysSupport_.newLength(oldCapacity, oldCapacity >> 1);
        return elementData = Arrays.copyOf(elementData, newCapacity);
    }

    public E get(int index) {
        rangeCheck(index);
        return elementData(index);
    }

    E elementData(int index) {
        return (E) elementData[index];
    }


    public E remove(int index) {
        rangeCheck(index);
        Object[] newElementData = new Object[this.elementData.length - 1];
        System_.arrayCopy(elementData, 0, index, newElementData, 0);
        System_.arrayCopy(elementData, index + 1, size, newElementData, index);
        E removedValue = elementData(index);
        this.elementData = newElementData;
        size--;
        return removedValue;
    }

    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (o == null && elementData[i] == null) {
                remove(i);
                return true;
            }

            if (elementData[i].equals(o)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    public E set(int index, E element) {
        rangeCheck(index);
        E oldValue = elementData(index);
        elementData[index] = element;
        return oldValue;
    }

    public void clear() {
        for (int to = size, i = size = 0; i < to; i++)
            elementData[i] = null;
    }

    public int indexOf(E element) {
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(E element) {
        for (int i = size - 1; i >= 0; i--) {
            if (elementData[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(E element) {
        return indexOf(element) >= 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public Object[] toArray() {
        return Arrays_.copyOff(elementData, size);
    }

    public <T> T[] toArray(T[] a) {
        return (T[]) Arrays_.copyOff(elementData, size, a.getClass());
    }
}
