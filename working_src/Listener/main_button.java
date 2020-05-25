package Listener;

import java.util.Scanner;

public class main_button {

    //implement scanner for user input.
    static Scanner scanner = new Scanner(System.in);
    static Button btnPrint = new Button("Button");

    public static void main(String[] args) {
        //implement button


        //implement local class of OnClickListener that implements the OnClickListener interface of the Button Class.
        class ClickListener implements Button.OnClickListener{

            public ClickListener(){
                System.out.println("I've been attached!");
            }

            @Override
            public void onClick(String name) {
                System.out.println(name + " was clicked");
            }

        }

        btnPrint.setOnClickListener(new ClickListener());
        listen();

    }


    public static void listen(){
        boolean quit = false;

        while(!quit){
            System.out.println("Listen again?? [1 - Yes / 0 - No]");
            int choice = scanner.nextInt();
            scanner.nextLine();

                switch (choice){
                    case 0:
                        quit = true;
                        break;
                    case 1:
                        btnPrint.onClick();
                }

        }

    }



}
