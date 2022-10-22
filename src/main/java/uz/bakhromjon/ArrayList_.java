package uz.bakhromjon;

import uz.bakhromjon.base.Collection_;


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
            throw new IllegalArgumentException("Illegal Capacity: " +
                    initialCapacity);
        }
    }


    public ArrayList_() {
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    public ArrayList_(Collection_ c) {

    }

    public boolean add(E e) {
        if (size == elementData.length)
            elementData = grow();

        elementData[size] = e;
        size++;
        return true;
    }

    public void add(int index, E element) {
        rangeCheck(index);
        Object[] elementData;
        if (size == (elementData = this.elementData).length)
            elementData = grow();
        System.arraycopy(elementData, index,
                elementData, index + 1,
                size - index);
        elementData[index] = element;
        size = size + 1;
    }

    private void rangeCheck(int index) {
        if (index > size || index < 0) {
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
        Object[] elementData = new Object[this.elementData.length - 1];
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (i != index) {
                elementData[j] = this.elementData[i];
                j++;
            }
        }
        E removedValue = elementData(index);
        this.elementData = elementData;
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
}
