package ProgrammingI;

   import java.util.Scanner;

    public class MilesPerGallon{

        /* Define your method here */
        public static double drivingCost(double drivenMiles, double milesPerGallon, double dollarsPerGallon){
            double cost;

            cost = (drivenMiles / milesPerGallon) * dollarsPerGallon;

            return  cost;
        }

        public static double mpg (){

            return 0.00;
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            double totalCost;
            double miles;
            double mpg;
            double dpg;

            miles = scanner.nextDouble();
            mpg = scanner.nextDouble();
            dpg = scanner.nextDouble();

            totalCost = drivingCost(miles, mpg, dpg);
            System.out.printf("%.2f", totalCost);

        }
    }

