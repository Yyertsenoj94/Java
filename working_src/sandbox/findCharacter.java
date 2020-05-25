package sandbox;

import java.util.Scanner;

public class findCharacter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int character;
        int numWords = scanner.nextInt();
        String[] strArray = new String[numWords];

        for(int i = 0; i < numWords; i++){
            strArray[i] = scanner.next();
        }

        character = scanner.next().charAt(0);

        for(String s: strArray){
            for(int i = 0; i < s.length(); i++){
                if(character == s.charAt(i)) {
                    System.out.println(s);
                    break;
                }
            }
        }
    }
}
