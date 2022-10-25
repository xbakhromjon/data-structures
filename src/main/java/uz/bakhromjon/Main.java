package uz.bakhromjon;


import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> os = new Stack<>();
        os.push(12);
        os.push(13);
        os.push(14);
        os.push(15);
        System.out.println(os.search(15));
        Stack_<Integer> ms = new Stack_<>();
        ms.push(12);
        ms.push(13);
        ms.push(14);
        ms.push(15);
        System.out.println(ms.search(15));
    }
}

