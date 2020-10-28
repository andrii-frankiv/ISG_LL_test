package Threads;

import java.util.Random;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        Thread test1 = new Producer(stack);
        Thread test2 = new Consumer(stack);

        test1.start();
        test2.start();
    }

}
