package CodeWarriors;

public class pinLength {

    //put this into your function library
    public static void main(String[] args) {
        boolean result = validatePin("1234..");
        System.out.println(result);
    }

    public static boolean validatePin(String pin) {
        int count = 0;
        char[] array = pin.toCharArray();
        for(char a: array){
            switch (a){
                case '1':
                        count++;
                        break;
                case '2':
                    count++;
                    break;
                case '3':
                    count++;
                    break;
                case '4':

                case '5':
                    count++;
                    break;
                case '6':
                    count++;
                    break;
                case '7':
                    count++;
                    break;
                case '8':
                    count++;
                    break;
                case '9':
                    count++;
                    break;
                case '0':
                    count++;
                    break;
            }
        }
        if((count == 4 || count == 6) && (pin.length() == 4 || pin.length() == 6)){
            return true;
        }else{
            return false;
        }
    }

}
