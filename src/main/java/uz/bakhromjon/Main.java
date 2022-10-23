package uz.bakhromjon;


import uz.bakhromjon.support.LinkedList_;

import java.util.Iterator;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
//        ll.get(12);
        LinkedList_<Integer> mll = new LinkedList_<>();
        mll.add(12);
        mll.add(14);
        mll.add(124);
        mll.add(123);
        System.out.println(mll.get(21));
    }
}

