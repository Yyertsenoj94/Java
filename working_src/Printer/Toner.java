package Printer;
import java.util.Scanner;

public class Toner {



                            private double level;

                            private double tonerCapacity;

                            public Toner(double tonerCapacity){
                                this.tonerCapacity = tonerCapacity;
                                this.level = tonerCapacity;


                            }

                            public void drainToner(double amount){

                                //check to see if level is low.
                                checkLevel();

                                if(level >= amount){
                                    level -= amount;
                                }else{
                                    System.out.println("Toner is empty");
                                    refillLevel();
                                }

                            }

                            private void refillLevel(){
                                System.out.println("Current toner level is " + level);
                                System.out.println("Refilling toner level by...." + (tonerCapacity - level));
                                level += (tonerCapacity -level);
                                System.out.println("Toner refill is complete");
                                System.out.println("Toner level is now at: " + level + " out of a total capacity of " + tonerCapacity);

                            }

                            private void checkLevel(){

                                if(level < 15) {

                                    boolean validResponse = false;

                                    System.out.println("Toner level is low. Current level is: " + level + ". Would you like to replace toner now?");
                                    System.out.println("Please enter Y for 'Yes' and N for 'No'");

                                    Scanner scanner = new Scanner(System.in);
                                    String userResponse;

                                    while(!validResponse) {

                                        userResponse = scanner.nextLine();
                                        if (userResponse.equals("Y") || userResponse.equals("N")) {

                                            if (userResponse.equals("Y")) {
                                                refillLevel();
                                                validResponse = true;
                                            }{
                                                validResponse = true;
                                            }

                                        } else {
                                            System.out.println("Invalid Response");
                                            System.out.println("Please enter Y for 'Yes' and N for 'No'");
                                        }

                                    }

                                }else{
                                    System.out.println("Current toner level is: " + level);
                                }

                            }

}
