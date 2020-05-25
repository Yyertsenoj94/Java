package Threads;

import static Threads.ThreadColors.*;

public class MyRunnable implements Runnable {
    String threadColor;
    public MyRunnable(String threadColor){
        this.threadColor = threadColor;
    }

    @Override
    public void run() {
        System.out.println(threadColor + "Hello from MyRunnable Instance" + Thread.currentThread());
    }
}
