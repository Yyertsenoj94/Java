package CodeWarriors;

import java.util.ArrayList;

public class LongestConsecutive {

    public static void main(String[] args) {
        String[] test = {"JohnandJim", "two", "three", "four"};
        System.out.println(longestConsec(test , 2));

        System.out.println(solution(10));
    }

    public static int solution(int number) {
        ArrayList<Integer> multiples = new ArrayList<Integer>();
        int sum = 0;
        for(int i = 3; i < number; i++){
            if(i % 3 == 0 || i % 5 == 0){
                multiples.add(i);
            }
        }
        for(int i: multiples){
            sum += i;
        }
        return sum;
    }

    public static String longestConsec(String[] strarr, int k) {
        String[] list = strarr;
        String tempString = "";
        int size = strarr.length;
        int max = 0;

        if(size == 0 || k == 0 || k > size){
            return tempString;
        }

        for(int i = 0; i + k <= size; i++){
            String loopString = ""; //reset loop string.
            for(int j = i; j < i+k; j++){
                loopString += strarr[j];
            }
            if(loopString.length() > max){
                max = loopString.length();
                tempString = loopString;
            }
        }
        return tempString;
    }

}
