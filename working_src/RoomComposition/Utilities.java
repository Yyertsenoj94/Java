package RoomComposition;
public class Utilities {

    private Light light;
    private int lights;
    private boolean ac;
    private int temperature;


    public Utilities(){

        this(new Light(), 5, false,66);

    }


    public Utilities(Light light, int lights, boolean ac, int temperature){

        this.lights = lights;
        this.light= light;
        this.temperature = temperature;
        this.ac = ac;

    }


    public void automateAC(){

        while(getTemperature() > 74 || getTemperature() < 67) {
            if (temperature < 67) {
                System.out.println("Temperature: " + temperature);
                System.out.println("Temperature is too low");
                acOff();

            } else if (temperature > 74) {
                System.out.println("Temperature: " + temperature);
                System.out.println("Temperature is too high");
                acOn();
            }


        }

        System.out.println("the temperature is within the acceptable range of 74 to 67");

    }

    private void acOn(){
        System.out.println("turning AC on....");
        ac = true;
        adjustTemperature(ac);
        System.out.println("The temperature is now: " + getTemperature());

    }

    private void acOff(){
        System.out.println("turning AC off....");
        ac = false;
        adjustTemperature(ac);
        System.out.println("The temperature is now: " + getTemperature());
    }

    private void adjustTemperature(boolean ac){
        if(ac){
            System.out.println("Temperature of " + temperature + " is decreasing");
            temperature -= 5;
        }else{
            System.out.println("Temperature of " + temperature + " is increasing");
            temperature += 5;
        }

    }

    private int getTemperature()
    {
        return temperature;

    }


    public void turnLightOn() {

        light.lightSwitch(true);

    }

    public void turnLightOff() {

        light.lightSwitch(false);

    }
}

