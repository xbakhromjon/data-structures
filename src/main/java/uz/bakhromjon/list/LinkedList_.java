package uz.bakhromjon.list;

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

    public E peek() {
        return (first == null) ? null : first.item;
    }

    public E poll() {
        if (first == null) {
            return null;
        }
        E item = first.item;
        first = first.next;
        return item;
    }

    public E set(int index, E element) {
        checkElementIndex(index);
        Node<E> target = node(index);
        E oldVal = target.item;
        target.item = element;
        return oldVal;
    }

    private Node<E> node(int index) {
        Node<E> target = first;
        int i = 0;
        while (i != index) {
            target = first.next;
            i++;
        }
        return target;
    }

    public E remove(int index) {
        checkElementIndex(index);
        Node<E> removed = node(index);
        if (index == 0) {
            first = first.next;
            if (first != null) {
                first.prev = null;
            }
        } else if (index == size - 1) {
            last.prev.next = null;
            last = last.prev;
        } else {
            Node<E> prev = node(index - 1);
            prev.next = node(index + 1);
        }
        size--;
        return removed.item;
    }
}
