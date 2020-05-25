package Playground;
public class udemyPracticals_printStar {
    public static void main(String[] args) {

        printSquareStar(32);

    }

    public static void printSquareStar(int number){

        if(number < 5){
            System.out.println("Cannot be less than five");
        }else {

            int rowCount = number;

            for (int x = 0; x < rowCount; x++) {

                System.out.println("");

                for (int y = 0; y < rowCount; y++) {

                    boolean rowEqualsColumn = (x == y);
                    boolean firstRow = (x == 0);
                    boolean lastRow = (x == rowCount - 1);
                    boolean firstColumn = (y == 0);
                    boolean lastColumn = (y == rowCount - 1);
                    boolean columnEqualsReverse = (y == (rowCount - x - 1));

                    boolean printStar = (rowEqualsColumn || firstRow || lastRow || firstColumn || lastColumn || columnEqualsReverse);

                    if (printStar) {
                        System.out.print(" * ");
                    } else {
                        System.out.print("   ");
                    }


                }

            }
        }
    }
}
