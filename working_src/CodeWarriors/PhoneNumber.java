package CodeWarriors;

public class PhoneNumber {

    public static void main(String[] args) {
        int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(createPhoneNumber(numbers));

    }

    public static String createPhoneNumber(int[] arr){
        String phoneNumber = "(";
        int count = 0;
        for(int integer: arr){
            if(count == 3){
                phoneNumber += ") ";
            }else if(count == 6){
                phoneNumber+= "-";
            }
            phoneNumber += integer;
            count++;
        }
        return phoneNumber;
    }
}
