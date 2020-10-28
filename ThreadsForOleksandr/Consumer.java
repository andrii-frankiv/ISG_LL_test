package Threads;

import java.util.Stack;

class Consumer extends Thread{
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