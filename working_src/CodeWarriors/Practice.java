package CodeWarriors;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.security.spec.RSAOtherPrimeInfo;

public class Practice {
    public static void main(String[] args) {

        System.out.println(spinWords("Hello There"));

    }

    public static String spinWords(String sentence) {
        String[] sentenceArray = new String[sentence.length()];
        String newSentence = "";
        int words = 0;
        for(int i = 0; i < sentence.length(); i++){
            if(sentence.charAt(i) == ' '){
                words++;
            }
        }

        for(int i = words; i <= 0; i--){
            //while()
        }

        return newSentence;
    }

}

