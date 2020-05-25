package Playground;
public class udemyPracticals_inchesToCentimeters {

    public static void main(String[] args) {

        System.out.println(calcFeetAndInchesToCentimeters(85));

    }



    public static double calcFeetAndInchesToCentimeters(double feet, double inches){

        double totalCentimeters = (feet * 12 * 2.54) + (inches * 2.54);

        if(feet < 0 || (inches < 0 || inches > 12)){

            return  -1;

        }


        return totalCentimeters;
    }

    public static double calcFeetAndInchesToCentimeters(double inches){


        //validation
        if(inches < 0){
            return -1;
        }

        double feet = (int) inches / 12;
        System.out.println("feet is " + feet);
        double inchesRemainder = inches % 12;
        System.out.println("remainder of inches is " + inchesRemainder);

        double centimetersResult = calcFeetAndInchesToCentimeters(feet, inchesRemainder);


        return centimetersResult;
    }
}
