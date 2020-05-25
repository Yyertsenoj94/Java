package Sudoku;

import java.util.ArrayList;

public class Box {
    private ArrayList<Cell> cells = new ArrayList<Cell>();
    private int rowStart;
    private int colStart;
    private int rowEnd;
    private int colEnd;
    private int size;

    private ArrayList<Integer> availableSolutions = new ArrayList<Integer>();

    public Box(int rowStart, int colStart, int array[][]) {
        this.rowStart = rowStart;
        this.colStart = colStart;
        this.colEnd = colStart + 2;
        this.rowEnd = rowStart + 2;

        this.size = array.length;

        for(int i = 1; i <= size; i++){
            availableSolutions.add(i);
        }

        //assign each cell in the box the value of the array.
        for (int i = rowStart; i <= rowEnd; i++) {

            for(int j = colStart; j <= colEnd; j++){
                int value = array[i][j]; //store value from array to put into the cell, and to remove from the available solutions of the box.
                int index = availableSolutions.indexOf(value); //index for the availableSolutions.remove();
                if(index != -1){
                    //removes the current array value from the list of available solutions in the box.
                    availableSolutions.remove(index);
                }

                cells.add(new Cell(value,i, j, size));
            }

        }
        //after cell has been initialized, need to add the values that are in the box solution set.
        for(Cell cell: cells){
            if(cell.getValue() == 0){
                //if the value is blank, add all box solutions possible to the cell set of solutions.
                for(int i = 0; i < availableSolutions.size(); i++){
                    cell.addSolutions(availableSolutions.get(i));
                }
            }else{
                //if it only has one solution, just add that as the solution.
                cell.addSolutions(cell.getValue());
            }
        }
    }

    public boolean sameRow(Cell cell){
        //method returns true if the box contains the same row as the cell, but is not the containing box of the cell (different column)
        if(cell.getRowNumber()<= this.rowEnd && cell.getRowNumber() >= this.rowStart && (cell.getColNumber() > this.colEnd || cell.getColNumber() < this.colStart)){
            return true;
        }else{
            return false;
        }
    }
    public boolean sameColumn(Cell cell){
        //method returns true if the box contains the same column as the cell, but is not the containing box of the cell (different row)
        if((cell.getRowNumber() > this.rowEnd || cell.getRowNumber() < this.rowStart) && cell.getColNumber() <= this.colEnd && cell.getColNumber() >= this.colStart){
            return true;
        }else{
            return false;
        }
    }
    public boolean sameBox(Cell cell){
        //method returns true if the box contains the cell being compared.
        if(cell.getRowNumber() <= this.rowEnd && cell.getRowNumber() >= this.rowStart && cell.getColNumber() <= this.colEnd && cell.getColNumber() >= this.colStart){
            return true;
        }else{
            return false;
        }
    }


    public void updateCell(Cell cell, int decision){
        //Decision value is as follows:
        /*
        0 - updateBox
        1 - updateRow
        2 - updateColumn
         */
        switch(decision){

            case 0:
                for(Cell comparisonCell: this.cells){
                    if((comparisonCell.getColNumber() != cell.getColNumber() || comparisonCell.getRowNumber() != cell.getRowNumber()) && comparisonCell.getValue() != 0){
                        cell.removeSolutions(comparisonCell.getValue());
                    }
                }
                break;
            case 1:
                for(Cell comparisonCell: this.cells){
                    if(cell.getRowNumber() == comparisonCell.getRowNumber() && comparisonCell.getValue() != 0){
                        cell.removeSolutions(comparisonCell.getValue());
                    }
                }
                break;

            case 2:
                for (Cell comparisonCell: this.cells) {
                    //if comparison cell is the same column and not 0, remove that value from the cell solutions
                    if (comparisonCell.getColNumber() == cell.getColNumber() && comparisonCell.getValue() != 0) {
                        cell.removeSolutions(comparisonCell.getValue());
                    }
                }
                break;
        }
    }

    public void setAvailableSolutions(ArrayList<Integer> availableSolutions){
        this.availableSolutions = availableSolutions;
    }

    public int getRowStart(){
        return this.rowStart;
    }

    public boolean hasRow(int row){
        if(row <= this.getRowEnd() && row >= this.getRowStart()){
            return true;
        }else{
            return false;
        }
    }
    public boolean hasColumn (int column){
        if(column <= this.getColEnd() && column >= this.getColStart()){
            return true;
        }else{
            return false;
        }
    }

    public int getColStart(){
        return this.colStart;
    }

    public int getRowEnd() { return this.rowEnd;}

    public int getColEnd() { return this.colEnd;}

    public ArrayList<Cell> getCells() {
        return this.cells;
    }

    public ArrayList<Integer> getAvailableSolutions(){
        return this.availableSolutions;
    }

    public void removeAvailableSolutions(int value){
        int index = availableSolutions.indexOf(value);
        if(index != -1){
            availableSolutions.remove(index);
        }
    }

    public void updateAvailableSolutions(){
        for(Cell cell: cells){
            if(cell.getValue() != 0){
                removeAvailableSolutions(cell.getValue());
            }
        }
    }

    public boolean solved(){
        if(this.availableSolutions.size() == 0){
            return true;
        }else{
            return false;
        }
    }

    public void printCells(int row, int rowEnd, int col, int colEnd, int matrixEnd){

        for(Cell cell: cells){
            if(cell.getRowNumber() == row && cell.getColNumber() == col){
                System.out.print("[" + cell.getValue() + "]");
            }
            if(cell.getRowNumber() == row && cell.getColNumber() == col && cell.getColNumber() == colEnd && cell.getColNumber() != matrixEnd){
                System.out.print(" | ");
            }else if (cell.getRowNumber() == row && cell.getColNumber() == col && cell.getColNumber() == colEnd && cell.getColNumber() == matrixEnd){
                System.out.println("");
                if(cell.getRowNumber() == row && cell.getRowNumber() == rowEnd && cell.getColNumber() == col && cell.getColNumber() == colEnd && cell.getColNumber() == matrixEnd){
                    System.out.println("---------------------------------");
                }
            }
        }
    }
}
