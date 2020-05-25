package RoomComposition;
public class Light {
    private boolean onOff;

    public Light(){

        this(false);

    }

    public Light(boolean onOff){

        this.onOff = onOff;

    }

    public void lightSwitch(boolean lightSwitch){
        if(lightSwitch){
            turnLightOn();
        }else{
            turnLightOff();
        }

        getLightStatus(onOff);
    }

    private void turnLightOn(){

        System.out.println("Turning Lights on...");
        onOff = true;

    }

    private void turnLightOff() {
        System.out.println("Turning lights off..");
        onOff = false;
    }

    private void getLightStatus(boolean onOff){
        if(onOff){
            System.out.println("Light is now: ON");
        }else{
            System.out.println("Light is now: OFF");
        }
    }

}
