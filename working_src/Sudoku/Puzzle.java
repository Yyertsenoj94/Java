package Sudoku;

public class Puzzle {
    //array for demo purpose only (level - easy)

    static final int SIZE = 9;

    public static void main(String[] args) {

        int[][] grid = new int[SIZE][SIZE];

        grid = initialization(grid);

        Matrix matrix = new Matrix(grid);

        matrix.printBoxes();

        matrix.solveArray();

        matrix.printBoxes();

    }

    public static int[][] initialization(int [][] grid){
        //array for demo purpose only (level - easy)
        grid = new int[][]{
        {0, 8, 0, 3, 0, 7, 0, 9, 0},
        {9, 0, 0, 0, 6, 0, 0, 0, 7},
        {0, 0, 1, 0, 0, 0, 4, 0, 0},
        {4, 0, 0, 0, 0, 0, 0, 0, 3},
        {0, 9, 0, 0, 1, 0, 0, 2, 0},
        {6, 0, 0, 0, 0, 0, 0, 0, 1},
        {0, 0, 9, 0, 0, 0, 3, 0, 0},
        {5, 0, 0, 0, 2, 0, 0, 0, 9},
        {0, 4, 0, 7, 0, 8, 0, 1, 0}};

        return grid;
    }

}
