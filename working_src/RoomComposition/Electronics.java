package RoomComposition;
public class Electronics {
    private String computer;
    private String phone;
    private String speaker;
    private String tv;

    public Electronics(){
        this("Dell", "Iphone", "logitech", "Samsung");
    }

    public Electronics(String computer, String phone, String speaker, String tv) {
        this.computer = computer;
        this.phone = phone;
        this.speaker = speaker;
        this.tv = tv;
    }

    public String getComputer() {
        return computer;
    }

    public String getPhone() {
        return phone;
    }

    public String getSpeaker() {
        return speaker;
    }

    public String getTv() {
        return tv;
    }

}
