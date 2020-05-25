package ThreadConcurrency;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Message message = new Message();
        new Thread(new Writer(message)).start();
        new Thread(new Reader(message)).start();
    }
}

class Message {

    private String message;
    private boolean empty = true;

    public Message(){
    }

    public synchronized String read(){ //this method will be controlled by the Reader class, that runs on one thread.
        while(empty){
            try{
                wait(); //causes current thread to sleep UNTIL alerted.
            }catch (InterruptedException e){
                //once alerted, it will check the while condition to see if it should go (always put these waits in a loop,
                // because they may be woken by other processes not related to the function it needs to be alerted by.
                //it will then check the condition to see if it should run.
            }
        }
        empty = true;
        notifyAll();
        return message;
    }

    public synchronized void write(String message){ //this method is controlled by the writer class that is on another thread.
        while(!empty){
            try{
                wait(); //causes current thread to sleep UNTIL alerted.
            }catch (InterruptedException e){
                //once alerted, it will check the while condition to see if it should go (always put these waits in a loop,
                // because they may be woken by other processes not related to the function it needs to be alerted by.
                //it will then check the condition to see if it should run.
            }
        }
        empty = false; //if you do not put a notify after this, it will maintain a lock on the empty boolean variable, and the other program cannot change it.
        this.message = message;
        notifyAll(); //relinquishes the lock on this entire object (including the empty boolean variable).
        notify();
    }
}

class Reader implements Runnable{

    private Message message;

    public Reader(Message message){
        this.message = message;
    }

    @Override
    public void run() {
        Random random = new Random();
        for(String latestMessage = message.read(); !latestMessage.equals("Finished");
            latestMessage = message.read()){
            System.out.println(latestMessage);
//            try{
//                Thread.sleep(random.nextInt(2000));
//            }catch (InterruptedException e){
//
//            }
        }
    }
}

class Writer implements Runnable{

    private Message message;

    public Writer(Message message){
        this.message = message;
    }

    @Override
    public void run() {
        Random random = new Random();
        String[] strArray = {
          "This little piggy went to market",
                "This little piggy went to town",
                "This little piggy wants roast beef",
                "This little piggy went Weeeeee all the way home"
        };

        for(int i = 0; i < strArray.length; i++){
            message.write(strArray[i]);
//            try {
//                Thread.sleep(random.nextInt(2000));
//            }catch(InterruptedException e){
//
//            }
        }
        message.write("Finished writing the message");
    }
}

