package CodeWarriors;
//TODO need to figure out a better way of doing this, but need to implement the dictionary for morse decoding.
public class Morse {

    public static String decode(String morseCode) {
        String morseSentence = "";
        int spaceCount = 0;
        String tempWord = "";
        int start;
        int end;

        //find start and end of the actual morse code.
        for (start = 0; morseCode.charAt(start) == ' '; start++) {
        }
        for (end = morseCode.length() - 1; morseCode.charAt(end) == ' '; end--) {
        }

        for (int i = start; i <= end; i++) {
            char current = morseCode.charAt(i);

            if (current == ' ') {
                if (tempWord.isEmpty()) {
                    spaceCount++;
                    if (spaceCount == 2) {
                        morseSentence += " ";
                        spaceCount = 0;
                    }
                } else {
                   // morseSentence += MorseCode.get(tempWord);
                    tempWord = "";
                }

            } else {
                tempWord += current;
            }

            if (i == end) {
               // morseSentence += MorseCode.get(tempWord);
            }

        }

        return morseSentence;
    }
}

