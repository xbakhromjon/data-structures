package uz.bakhromjon.queue;

import uz.bakhromjon.base.Deque_;

import java.util.Arrays;

/**
 * @author : Bakhromjon Khasanboyev
 * @since : 26/10/22, Wed, 20:34
 **/
public class ArrayDeque_<E> implements Deque_<E> {
    transient Object[] elements;
    transient int head;
    transient int tail;
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    public ArrayDeque_() {
        elements = new Object[17];
    }


    public ArrayDeque_(int numElements) {
        elements = new Object[(numElements < 1) ? 1 : (numElements == Integer.MAX_VALUE)
                ? Integer.MAX_VALUE : numElements + 1];
    }

    public void addFirst(E element) {
        if (element == null)
            throw new NullPointerException();
        head = dec(head, elements.length);
        elements[head] = element;
        if (head == tail)
            grow(1);
    }

    public void addLast(E element) {
        if (element == null)
            throw new NullPointerException();
        elements[tail] = element;
        if (head == (tail = inc(tail, elements.length)))
            grow(1);
    }

    static final int inc(int i, int modulus) {
        if (++i >= modulus) i = 0;
        return i;
    }

    static final int dec(int i, int modulus) {
        if (--i < 0) i = modulus - 1;
        return i;
    }


    private void grow(int needed) {
        final int oldCapacity = elements.length;
        int newCapacity;
        int jump = (oldCapacity < 64) ? (oldCapacity + 2) : (oldCapacity >> 1);
        if (jump < needed
                || (newCapacity = (oldCapacity + jump)) - MAX_ARRAY_SIZE > 0)
            newCapacity = newCapacity(needed, jump);
        final Object[] es = elements = Arrays.copyOf(elements, newCapacity);
        if (tail < head || (tail == head && es[head] != null)) {
            int newSpace = newCapacity - oldCapacity;
            System.arraycopy(es, head,
                    es, head + newSpace,
                    oldCapacity - head);
            for (int i = head, to = (head += newSpace); i < to; i++)
                es[i] = null;
        }
    }

    private int newCapacity(int needed, int jump) {
        final int oldCapacity = elements.length, minCapacity;
        if ((minCapacity = oldCapacity + needed) - MAX_ARRAY_SIZE > 0) {
            if (minCapacity < 0)
                throw new IllegalStateException("Sorry, deque too big");
            return Integer.MAX_VALUE;
        }
        if (needed > jump)
            return minCapacity;
        return (oldCapacity + jump - MAX_ARRAY_SIZE < 0)
                ? oldCapacity + jump
                : MAX_ARRAY_SIZE;
    }

    public E peek() {
        return peekFirst();
    }


    public E peekFirst() {
        return elementAt(head);
    }

    public E peekLast() {
        return elementAt(dec(tail, elements.length));
    }
    public E elementAt(int index) {
        return (E) elements[index];
    }
}
