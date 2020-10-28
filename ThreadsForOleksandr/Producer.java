package Threads;

import java.util.Random;
import java.util.Stack;

class Producer extends Thread{
    Stack stack;

    public Producer(Stack<Integer> stack) {
        this.stack = stack;
    }

    public void run(){
        int stackSize = 10000;
        while(true){
            Random rand = new Random();
            if(stack.size() >= stackSize){
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            stack.push(rand.nextInt(stackSize));
            System.out.println(stack);
            System.out.println("Producer produced" + rand.nextInt(stackSize));
        }
    }
}