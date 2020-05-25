package Playground;
public class udemyPracticals_secondsToHoursMinutesSeconds {

    public static void main(String[] args) {

        System.out.println(getDurationString(65, 45));
        System.out.println(getDurationString(3945));
        System.out.println(getDurationString(-41));
        System.out.println(getDurationString(65, 9));
    }

    //how to create a constant variable
    private static final String INVALID_MESSAGE = "Invalid Value";

    public static String getDurationString(double  minutes, double seconds){

        //validate
        if((minutes < 0) || (seconds < 0 || seconds > 59)){
            return  INVALID_MESSAGE;
        }


        int locHours = (int) minutes / 60;
        int locMinutes = (int) minutes % 60;
        int locSeconds = (int) seconds;

        String zeroHour = "";
        String zeroMinute = "";
        String zeroSecond = "";

        if(locHours < 10){
            zeroHour = "0";
        }
        if(locMinutes < 10){
            zeroMinute = "0";
        }
        if(locSeconds < 10){
            zeroSecond = "0";
        }

        return zeroHour + locHours + "h " + zeroMinute + locMinutes + "m " + zeroSecond + locSeconds + "s";

    }

    public static String getDurationString(double seconds){

        if(seconds < 0){
            return INVALID_MESSAGE;
        }

        int minutes = (int) seconds / 60;

        int secondsRemainder = (int) seconds % 60;

        return getDurationString(minutes, secondsRemainder);

    }

}
