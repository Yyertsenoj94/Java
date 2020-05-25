package sandbox;
import java.util.Scanner;

public class Tests {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean test = (1 < 2 && 2 < 3);

        System.out.printf("%e", 12345678912345.0);

        System.out.printf("%s %s %8.3s %02d, \'%2d %s", "Today", "is", "October", 9, 2014, "Happy Halloweeen");
        //Today is October 31 '2014HappyHalloween
        System.out.printf("%.2s", "Test");

        System.out.println("Enter a sample text:\n");
        String input = scanner.nextLine();
        System.out.println("You entered: " + input + "\n");

        String decision = "";
        while(!decision.equals("q")){
            decision = printMenu();
            switch (decision){
                case "c":
                    System.out.println("Number of non-whitespace characters: " + getNumOfNonWSCharacters(input));
                    break;
                case "w":
                    System.out.println("Number of words: " + getNumOfWords(input));
                    break;
                case "f":
                    System.out.println("Enter a word or phrase to be found:");
                    String search = scanner.nextLine();
                    int instances = findText(input, search);
                    System.out.println("\"" + search + "\" instances: " + instances);
                    break;
                case "r":
                    input = replaceExclamation(input);
                    System.out.println("Edited text: " + input);
                    break;
                case "s":
                    input = shortenSpace(input);
                    System.out.println("Edited text: " + input);
                    break;
                case "q":
                    break;
            }
        }

    }

    public static String printMenu(){
        String decision = "";
        System.out.println("MENU");
        System.out.println("c - Number of non-whitespace characters");
        System.out.println("w - Number of words");
        System.out.println("f - Find text");
        System.out.println("r - Replace all !'s");
        System.out.println("s - Shorten spaces");
        System.out.println("q - Quit\n");
        System.out.println("Choose an option:");
        decision = scanner.nextLine();
        return decision;
    }

    public static int getNumOfNonWSCharacters(String text){
        String nonWsText = text;
        while(nonWsText.indexOf(" ")!= -1) {
            nonWsText = nonWsText.replace(" ", "");
        }

        return nonWsText.length();
    }

    public static String shortenSpace(String text){
        String shortenedSpace = text;
        while(shortenedSpace.indexOf("  ")!= -1){
            shortenedSpace = shortenedSpace.replace("  ", " ");
        }

        return shortenedSpace;
    }

    public static String replaceExclamation(String text){
        String replacedExclamation = text;
        replacedExclamation = replacedExclamation.replace("!", ".");
        return replacedExclamation;
    }

    public static int findText(String text, String searchText){
        int place = 0;
        int searchCount = 0;
        int searchPlace = 0;
        String tempString = "";
        while(place < text.length()){

            if(searchPlace != searchText.length() && text.charAt(place) == searchText.charAt(searchPlace)){
                tempString += text.charAt(place);
                searchPlace ++;

            }else{
                if(tempString.equals(searchText)){
                    searchPlace = 0;
                    searchCount++;
                    tempString = "";
                }
            }

            place++;
        }

        return searchCount;
    }

    public static int getNumOfWords(String text){
        String[] array = text.split(" ");
        return array.length;
    }
}
