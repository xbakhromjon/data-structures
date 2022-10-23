package uz.bakhromjon.support;

import java.util.NoSuchElementException;

/**
 * @author : Bakhromjon Khasanboyev
 * @since : 23/10/22, Sun, 15:53
 **/
public class LinkedList_<E> {
    transient int size = 0;
    transient Node<E> first;
    transient Node<E> last;

    public LinkedList_() {
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    public boolean add(E element) {
        if (first == null) {
            first = new Node<>(null, element, last);
        } else if (last == null) {
            last = new Node<>(first, element, null);
            first.next = last;
        } else {
            last.next = new Node<>(last, element, null);
            last = last.next;
        }
        size++;
        return true;
    }

    public E getFirst() {
        if (first == null) throw new NoSuchElementException("");
        return first.item;
    }

    public E getLast() {
        if (last == null) throw new NoSuchElementException();
        return last.item;
    }

    public E get(int index) {
        checkElementIndex(index);
        int i = 0;
        Node<E> current = first;
        while (i != index) {
            i++;
            current = current.next;
        }
        return current.item;
    }

    public void checkElementIndex(int index) {
        if (!isElementIndex(index)) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }
}
