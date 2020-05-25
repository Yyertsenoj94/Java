package Sudoku;

import java.util.ArrayList;

public class Cell {

    private int value;
    private int rowNumber;
    private int colNumber;
    private ArrayList<Integer> solutions = new ArrayList<Integer>();

    public Cell(int value, int rowNumber, int colNumber, int size){
        this.value = value;
        this.rowNumber = rowNumber;
        this.colNumber = colNumber;
    }

    //for updating the available solution set for the cell based off the numerous checks performed.
    public void removeSolutions(int digitRemove){
        int index = solutions.indexOf(digitRemove);
        //only remove the value if it exists in the possible solution set.
        if(index!=-1){
            this.solutions.remove(index);
        }
    }

    public void addSolutions(int digitAdd){
        this.solutions.add(digitAdd);
    }

    //for assigning the cell a value.
    public void setValue(int value){
        this.value = value;
        this.solutions.clear(); //removes all solutions
        this.solutions.add(value); //sets only solution equal to the value the cell currently is.
    }

    public int getValue(){
        return value;
    }

    public int getRowNumber(){
        return rowNumber;
    }

    public int getColNumber(){
        return colNumber;
    }

    public ArrayList<Integer> getSolutions(){
        return this.solutions;
    }

}
