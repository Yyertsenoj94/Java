package Threads;

import static Threads.ThreadColors.*;

public class Test{

    public static void main(String[] args) {

            SleepyThread sleepyThread = new SleepyThread(); //this is a concrete class of runnable.
            Thread myRunnableThread = new Thread(new MyRunnable(ANSI_CYAN)); //this is a class that implements the interface runnable

            System.out.println(ANSI_PURPLE + "Hello from main thread. " + Thread.currentThread());


            //could also make anonymous inner class of Thread
            new Thread(){
                public void run(){
                    System.out.println(ANSI_RED + "I'm waiting until my sleepy friend wakes up. " + Thread.currentThread());
                    try {
                        sleepyThread.join();
                        System.out.println("My friend woke me up. " + currentThread());
                    }catch (InterruptedException e){
                        System.out.println("I was interrupted");
                    }
                }
            }.start();


            sleepyThread.start();

            myRunnableThread.start(); //this will run the class run method on the interfaced runnable





            //NOTE that the order of threads being run is completely up to the system here, you cannot predict sequence of these starting.
    }
}
