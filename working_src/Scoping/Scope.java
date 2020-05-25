package Scoping;

import java.util.Scanner;

public class Scope {

    private Scanner x = new Scanner(System.in);

    public Scope(){
        System.out.println("Please input an integer");

        X x = new X(this.x.nextInt());
    }


    public class X{
        private int x;
        public X(int x){
            this.x = x;
            x(this.x);
        }

        private void x(int x){
            for(x = 1; x < 12; x++){
                System.out.println(this.x + " times " + x + " is:  | " + (this.x * x));
            }
        }

    }


}
