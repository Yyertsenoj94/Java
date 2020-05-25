package Threads2;

import static Threads2.ThreadColors.*;

public class Main {
    public static void main(String[] args) {
        CountDown sharedCountDownInstance = new CountDown(); //this is being passed to both threads to run.

        Thread thread1 = new ClassThread(sharedCountDownInstance);
        Thread thread2 = new ClassThread(sharedCountDownInstance);
        thread1.setName("Thread1");
        thread2.setName("Thread2");

        thread1.start();
        thread2.start();
    }
}

class CountDown {
    String color;
    private int i; //this variable is created on the heap. Since both threads share this value, when one thread changes it, it's also changed for the other thread.
        //this is known as thread interference. or "Race condition"
    public void countDown(){

        switch (Thread.currentThread().getName()) {
            case "Thread1" -> color = ANSI_CYAN;
            case "Thread2" -> color = ANSI_PURPLE;
            default -> color = ANSI_GREEN;
        }


        for(i = 10; i > 0; i--){
            System.out.println(color + Thread.currentThread() + ": " + i);
        }

    }



}

class ClassThread extends Thread{
    CountDown countDown;

    public ClassThread(CountDown countDown){
        this.countDown = countDown;
    }
    @Override
    public void run() {
        countDown.countDown();
    }
}
