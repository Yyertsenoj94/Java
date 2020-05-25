package Threads;

import static Threads.ThreadColors.*;

public class SleepyThread extends Thread{

    @Override
    public void run() {

        try {
            System.out.println(ANSI_BLUE + "I'm mr. sleepy head, and I'm going to sleep now! " + currentThread());
            sleep(3000);
            System.out.println(ANSI_BLUE + "I'm mr. sleepy head, and I'm awake now! " + currentThread());
        }catch (InterruptedException e){
            System.out.println("I was interrupted");
        }
        //this is used by the JVM during runtime, but to start it, you will write <anotherThreadInstance>.start();
        // to run this more than once from another place, you must created new instances of this class!
    }
}
