package Strings;

public class StringFormatter {

    public static void main(String[] args) {
        int[] phoneNumber = {8, 3, 0, 3, 8, 8, 9, 2, 5, 9};

        String formatter = String.format("(%1$s%2$s%3$s) %4$s%5$s%6$s-%7$s%8$s%9$s%10$s", phoneNumber[0], phoneNumber[1], phoneNumber[2], phoneNumber[3], phoneNumber[4], phoneNumber[5], phoneNumber[6], phoneNumber[7], phoneNumber[8], phoneNumber[9]);
        System.out.println(formatter);
    }

}
