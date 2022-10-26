package uz.bakhromjon.queue;

import jdk.internal.util.ArraysSupport;
import uz.bakhromjon.base.Queue_;
import uz.bakhromjon.exceptions.IndexOutOfBoundsException_;
import uz.bakhromjon.support.ArraysSupport_;
import uz.bakhromjon.support.Arrays_;
import uz.bakhromjon.support.System_;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

/**
 * @author : Bakhromjon Khasanboyev
 * @since : 26/10/22, Wed, 19:48
 **/
public class PriorityQueue_<E> implements Queue_<E> {
    private static final int DEFAULT_INITIAL_CAPACITY = 11;

    transient Object[] queue;

    int size;

    private final Comparator<? super E> comparator;

    public PriorityQueue_() {
        this(DEFAULT_INITIAL_CAPACITY, null);
    }


    public PriorityQueue_(int initialCapacity) {
        this(initialCapacity, null);
    }


    public PriorityQueue_(int initialCapacity, Comparator<? super E> comparator) {
        if (initialCapacity < 1)
            throw new IllegalArgumentException();
        this.queue = new Object[initialCapacity];
        this.comparator = comparator;
    }

    public boolean add(E element) {
        if (element == null)
            throw new NullPointerException();
        if (size == queue.length) {
            grow();
        }
        queue[size] = element;
        size++;
        return true;
    }


    private void grow() {
        int oldCapacity = queue.length;
        int newCapacity = ArraysSupport_.newLength(oldCapacity,
                oldCapacity < 64 ? oldCapacity + 2 : oldCapacity >> 1);
        queue = Arrays.copyOf(queue, newCapacity);
    }


    public void checkElementIndex(int index) {
        if (!isElementIndex(index)) {
            throw new IndexOutOfBoundsException_(outOfBoundsMsg(index));
        }
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }


    public E poll() {
        if (size == 0)
            throw new NoSuchElementException();
        E val = queue(0);
        Object[] newQueue = new Object[queue.length - 1];
        System_.arrayCopy(queue, 1, queue.length, newQueue, 0);
        queue = newQueue;
        size--;
        return val;
    }


    public E peek() {
        if (size == 0)
            throw new NoSuchElementException();

        return queue(0);
    }

    public E element() {
        return peek();
    }

    public E remove() {
        return poll();
    }

    public int size() {
        return size;
    }

    public boolean contains(E obj) {
        for (int i = 0; i < size; i++) {
            if (queue[i].equals(obj)) return true;
        }
        return false;
    }

    private E queue(int index) {
        return (E) queue[index];
    }
}
