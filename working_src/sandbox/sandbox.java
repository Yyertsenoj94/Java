package sandbox;
public class sandbox {

    public static void main(String[] args) {

        int Row = 'A' + 12;
        System.out.println(Row);

        AnObject One = new AnObject("A");
        AnObject Two = new AnObject("B");

        System.out.println(One.getValue().compareTo(Two.getValue()));



    }



}

class AnObject{
    String value;

    public AnObject(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
