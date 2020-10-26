package trial;

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

    static class Producer extends Thread{
        Stack stack;

        public Producer(Stack<Integer> stack) {
            this.stack = stack;
        }

        public void run(){
            int stackSize = 10000;
            for(int i = 0; ; i++){
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
    static class Consumer extends Thread{
        Stack stack;

        public Consumer(Stack<Integer> stack) {
            this.stack = stack;
        }

        public void run(){
            for(int i = 1; ; i++){
                if(stack.size() < 1){
                    try {
                       Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                stack.pop();
                System.out.println("Consumer consume" + i);
            }
        }
    }
}
