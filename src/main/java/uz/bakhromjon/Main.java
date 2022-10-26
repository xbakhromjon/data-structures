package uz.bakhromjon;


import uz.bakhromjon.queue.ArrayDeque_;

import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) {
        ArrayDeque<Integer> oad = new ArrayDeque<>(-12);
        oad.addFirst(12);
        oad.addLast(13);
        System.out.println(oad.pollFirst());
        System.out.println(oad.peekLast());
        ArrayDeque_<Integer> mad = new ArrayDeque_<>();
        mad.addFirst(12);
        mad.addLast(13);
        System.out.println(mad.peekLast());
    }
}

