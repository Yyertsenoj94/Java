/*
TO DO:

Rubric

    [80 Points] If your program correctly prompts for the age, retirement age, rate of interest, initial, and monthly contributions and prints the coorresponding table in the correct format.
    [20 Points] Five points for each of the following:
        If the main method of your program prints "Spring 2020 - CS1083 - Section 00X - Project 1 - written by YOURNAME".
        If your submission was a Zip file named project1.zip containing two files called RetirementForecast.java and RetirementForecastOutput.txt.
        If your program contains a comment that describes what the program does and contains.
        If your program is indented properly.

The 80 points of your program working properly are determined as follows:

    [5 Points] For printing the table's title, initial values, and headers. Be sure to print the dollar signs and percent sign as in the examples, even though these were not entered.
    [20 Points] For prompting the user for the required values.
    [5 Points] For properly formatting into columns using tabs.
    [10 Point] For properly formatting the values with the right decimal numbers.
    [25 Points] For a for the nested loop that performs the calculations that prints the right values for each row of the table.
        [5 Points] for Age and Year calculations
        [5 Points] for the Interest Rate calculation
        [15 Points] for the Interest and Accumulated calculations
    [20 Points] For properly showing the values in the table.
 */

/*

RetirementForecast (Purpose):
The following program....



 */

package Projects;
import java.util.Scanner;

public class RetirementForecast {
    public static final Scanner CONSOLE = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Spring 2020 -  CS1083 - Section 002 - Project 1 - written by Trey Jones");
        System.out.println("Retirement Forecast");

        //declare and initialize all user input variables
        int age = 0;
        int retirementAge = 0;
        double averageRate = 0.0;
        double initialContribution = 0.0;
        double monthlyContribution = 0.0;

        //declare and initialize all other variables (except loop variables -> being stored within the loop constructor)
        int currentYear = 2020; //FIXME if you want to add a function for the actual current year based on the system date.
        double monthlyRate = 0.0;
        double balance = 0.0;
        double interest = 0.0;
        double accumulatedInterest = 0.0;
        double adjustedRate = 0.0;

        //obtain necessary values from user
        System.out.print("How old are you?");
        age = CONSOLE.nextInt();
        System.out.print("At what age would you like to retire?");
        retirementAge = CONSOLE.nextInt();
        System.out.print("What is the expected average rate of interest in % (e.g. 8%)?");
        averageRate = CONSOLE.nextDouble();
        System.out.print("What amount do you have now as initial contribution?");
        initialContribution = CONSOLE.nextDouble();
        System.out.print("What would be your monthly contribution?");
        monthlyContribution = CONSOLE.nextDouble();

        //prior to loop, set balance = initial contribution
        balance = initialContribution;

        //print header row for the table
        System.out.println("------------------------Retirement Forecast Table------------------------");
        System.out.println("Age\tYear\tRate\t\tInterest\t\tAccumulated");
        System.out.println("-------------------------------------------------------------------------");


        //begin the year loop (given the number of years between current age and
        for(int i = age; i <= retirementAge; i++){

            //determine the adjusted rate based on the current year
            if(currentYear % 10 == 0){
                averageRate += .05*averageRate;
            }
            else if(currentYear % 3 == 0){
                averageRate += .01*averageRate;
            }
            else if(currentYear % 4 == 0){
                averageRate -= .03*averageRate;
            }
            else{
                averageRate += .005 * averageRate;
            }

            //change averageRate entered into a percentage
            adjustedRate = averageRate / 100;

            //calculate month rate based on the adjusted rate.
            monthlyRate = adjustedRate / 12;

            //begin monthly loop
            for(int j = 0; j < 12; j++){

                //add monthly contribution to the balance
                //calculate interest based on current balance
                balance += monthlyContribution;
                interest = (balance) * monthlyRate;

                //add interest calculated to total accumulated interest
                //add interest to the current balance
                accumulatedInterest += interest;
                balance += interest;

            }
            //print out results into a row for the current year.
            System.out.print(age + "\t");
            System.out.print(currentYear +"\t");
            System.out.printf("%.4f%%\t\t", averageRate);
            System.out.printf("$%.2f\t\t", accumulatedInterest); //FIXME add $ signs prior to the final output.
            System.out.printf("$%.2f", balance); //FIXME add $ signs prior to the final output.
            System.out.println("");

            //increase year, age for the next iteration
            currentYear++;
            age++;
        }
    }
}
