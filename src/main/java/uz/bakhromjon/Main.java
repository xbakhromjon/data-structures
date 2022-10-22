package uz.bakhromjon;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        ArrayList_<Integer> list = new ArrayList_<>();
        list.add(1);
        list.add(1);
        list.add(0, 10);
        list.set(0, null);
        list.remove(null);
        System.out.println(list.get(0));
        System.out.println("Hello world!");
    }
}

