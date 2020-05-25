package Sudoku;

import java.util.ArrayList;

public class Matrix {
    private ArrayList<Box> boxes = new ArrayList<Box>();
    private int size;

    public Matrix(int[][] array){
        this.size = array.length;
        //start creating boxes (passing the row start(i), and column start (j)
        // and incrementing by 3 each time through the loop.
        for(int i = 0; i < size; i+=3){
            //pass the column start value
            for(int j = 0; j < size; j+=3){
                //creates box, passing rowStart, colStart, and the array.
                boxes.add(new Box(i,j,array));
            }
        }
    }

    //main method that loops through each box, repeatedly until they are all solved.
    public void solveArray(){
        int countLoop = 0;
        while(!(solved(boxes))) {

            for (Box box : boxes) {
                countLoop++;
                //if box only has one available solution, plug for the value missing.
                if(box.getAvailableSolutions().size() == 1){
                    plugBox(box);
                    continue;
                }
                if(box.solved()){
                    continue;//don't evaluate if already solved.
                }
                //Go through each empty cell (noted by "0") and solve based by comparing the same box, row, and column.
                for (Cell cell : box.getCells()) {
                    if (cell.getValue() == 0) {
                        checkBoxRowColumn(cell);
                    }
                }

                //deductive cell solving by comparing available box solutions to sets of solutions for each cell. and finding unique overlap.
                boxSolve(box);
            }
            printBoxes();
            rowSolve();
            columnSolve();

        }

        //once complete and exited the loop.
        System.out.println("Solved!");
        System.out.println("Count of loop was " + countLoop);
    }


    public boolean solved(ArrayList<Box> boxes){
        boolean matrixSolved = true; //assume the matrix is solved until it finds a box that isn't.
        for(Box box: boxes){
            if (!box.solved()){//add break if true to let it just stop evaluating, because not all boxes are solved.
                matrixSolved = false;
            }
        }
        return matrixSolved;
    }

    //function will take in cell to be checked, and then the array list of all boxes to check against.
    //it will then return the cell with updated solutions based on the other cell values it checked against.
    public void checkBoxRowColumn(Cell cell){
        Box updateBox = null; //used for updating the box available solutions if the cell value is updated.

        //go through each box and compare against cells in same box, row, and column.
        for(Box box: this.boxes){
            //checks if same box
            if(box.sameBox(cell)){
                updateBox = box;
                box.updateCell(cell, 0); //update cell based on the contents of the cell's box
            }

            //COMPARE BOXES OF SAME ROW, BUT DIFFERENT COLUMNS
            if(box.sameRow(cell)){
                //create list of comparison box cells to compare against.
                box.updateCell(cell, 1); // update contents based on the contents of the cell's row
            }

            //COMPARE BOXES OF SAME COLUMN, BUT DIFFERENT ROWS
            if(box.sameColumn(cell)) {
                box.updateCell(cell, 2); // update contents based on the contents of the cell's column
            }
        }
            //FIXME think about adding a recursive function until no further updates can be made to cell, before it moves on.
        if(cell.getSolutions().size() == 1){
            cell.setValue(cell.getSolutions().get(0));
            if(updateBox != null) {
                updateBox.removeAvailableSolutions(cell.getValue());
            }
        }
    }

    /*The following method receives a box, goes through each integer that the box still needs to be complete (availableSolutions).
    It then compares against every solution set of each blank cell in the box
    to determine if there is only one cell that has that possible solution. If it has that solution, the function
    will assign that solution to the cell value, as it has deduced that it is the ONLY cell for which that
    solution can exist. It will then remove that value from the "updatedSolutions" set, and at the end of going through
    the current solutions, it will set the box solutions to the updated set of solutions.
     */
    public void boxSolve(Box box){
        //temp list of updated solutions to the box --> otherwise error results when removing a solution and you try to loop through solutions
        //that are supposed to be there.
        ArrayList<Integer> updatedSolutions = new ArrayList<Integer>();

        //create copy of the solutions.
        for(Integer solution: box.getAvailableSolutions()){
            updatedSolutions.add(solution);
        }

        int solutionCount = 0;// variable for determining how many cells have the solution being checked.
        Cell cellToUpdate = null;
        ArrayList<Integer> boxSolutions = box.getAvailableSolutions();
        //go through each available solution in the box

        for(int boxSolution: boxSolutions) {
            int rowNumber = -1; //used for the exclusive row/column solution finder.
            int columnNumber = -1; //used for the exclusive row/column solution finder.
            boolean sameRow = true;
            boolean sameColumn = true;
            solutionCount = 0;
            //reset the cell solution counter for each box solution.
            //go through each cell in the box, and determine how many cells also contain the same solution.
            for (Cell cell : box.getCells()) {
                //only look at cells that are currently blank for their solution sets.
                if (cell.getValue() == 0) {
                    ArrayList<Integer> cellSolutions = cell.getSolutions();

                    for (int cellSolution : cellSolutions) {
                        if (cellSolution == boxSolution) {

                            //Following block used to determine if solutions are confined to a single row XOR column.
                            //if so, we will go through each other cell in that ROW XOR column and remove the solution from those cells.
                            if(rowNumber == -1 && columnNumber == -1){//set initial row and column marker for future evaluation.
                                rowNumber = cell.getRowNumber();
                                columnNumber = cell.getColNumber();
                            }else{
                                if(cell.getRowNumber() != rowNumber){//if the new cell solution does not have same row, as the past solution, set to false
                                    sameRow = false;
                                }
                                if(cell.getColNumber() != columnNumber){//if the new cell solution does not have the same column, as the past solution, set to false.
                                    sameColumn = false;
                                }
                            }
                            solutionCount++;
                            cellToUpdate = cell;
                        }
                    }//end comparing cellSolution to boxSolution
                }//end checking for blank cell
            }//end going through each cell in the box.

            if((solutionCount > 1) && (sameRow || sameColumn)){
                if(sameRow){
                    removeRowSolutions(boxSolution, rowNumber, box);
                }else{
                    removeColumnSolution(boxSolution, columnNumber, box);
                }
            }else if (solutionCount == 1) {
                //if only one cell has the solution, then assign the cell to that solution
                //that was stored in the cellToUpdate variable.
                cellToUpdate.setValue(boxSolution);
                updatedSolutions.remove(updatedSolutions.indexOf(boxSolution));
            }
        }//end going through solutions in the box
        box.setAvailableSolutions(updatedSolutions);
        //final check to see if box can be completely solved now.
        if(box.getAvailableSolutions().size() == 1){
            plugBox(box);
        }
    }

    private void removeRowSolutions(int solution, int row, Box box){
        for(Box otherBox: boxes){
            if (!(otherBox == box && otherBox.hasRow(row))){//FIXME - check to see if this should be adjusted to encapsulate the (otherBox == box)
                for(Cell cell: otherBox.getCells()){
                    if(cell.getRowNumber() == row && cell.getValue() == 0){
                        cell.removeSolutions(solution);
                    }
                }
            }
        }
    }

    private void removeColumnSolution(int solution, int column, Box box){
        for(Box otherBox: boxes){
            if (!(otherBox == box && otherBox.hasColumn(column))){
                for(Cell cell: otherBox.getCells()){
                    if(cell.getColNumber() == column && cell.getValue() == 0){
                        cell.removeSolutions(solution);
                    }
                }
            }
        }
    }

    private void plugBox(Box box){//simple function to plug
        for(Cell cell: box.getCells()){
            if(cell.getValue() == 0){
                cell.setValue(box.getAvailableSolutions().get(0));
                box.removeAvailableSolutions(cell.getValue());
            }
        }
    }

    public void rowSolve(){
        for(int i = 0; i < size; i++){

            //create temporary solutions for the row to evaluate from.
            ArrayList<Cell> tempRow = new ArrayList<>();
            ArrayList<Integer> tempSolutions = new ArrayList<>();
            //solutions can be anything from 1 to the size of the grid.
            for(int j = 1; j <= size; j++){
                tempSolutions.add(j);
            }

            //begin populating the row from each box and evaluating.
            for(Box box: boxes) {
                if(i <= box.getRowEnd() && i >= box.getRowStart()){
                    for (Cell cell : box.getCells()) {
                        if (cell.getRowNumber() == i) {//only add if the cell is part of the row being created.
                            if(cell.getValue() == 0) {//if cell is 0, we add it to the row needing to be solved.
                                tempRow.add(cell);
                            }
                            else{//if not zero, we remove it from the solutions needing to be solved
                                tempSolutions.remove(tempSolutions.indexOf(cell.getValue()));
                            }
                        }
                    }
                }
            }

            for(int k: tempSolutions){//go through each solution in the row, and compare against solutions of each cell in the row.
                int solutionCount = 0;
                Cell updateCell = null; //placeholder for the one cell that has that solution.

                for(Cell cell: tempRow){//loop through each cell in the row.
                    for (int l : cell.getSolutions()) {
                        if (l == k) {
                            solutionCount += 1;
                            updateCell = cell;
                        }
                    }
                }

                if(solutionCount == 1){
                    updateCell.setValue(k);
                    for(Box box: boxes){
                        if(box.sameBox(updateCell)){//look for the box that houses the updated cell
                            box.updateAvailableSolutions(); // update the solutions for this box.
                            break;
                        }
                    }
                }
            }

            if(tempSolutions.size() == 1){
                for(Cell cell: tempRow){
                    if(cell.getValue() == 0){
                        cell.setValue(tempSolutions.indexOf(0));
                        for(Box box: boxes){
                            if(box.sameBox(cell)){//look for the box that houses the updated cell
                                box.updateAvailableSolutions(); // update the solutions for this box.
                                break;
                            }
                        }
                    }
                }
            }
        }

    }


    public void columnSolve(){
        for(int i = 0; i < size; i++){

            //create temporary solutions for the row to evaluate from.
            ArrayList<Cell> tempColumn = new ArrayList<>();
            ArrayList<Integer> tempSolutions = new ArrayList<>();
            //solutions can be anything from 1 to the size of the grid.
            for(int j = 1; j <= size; j++){
                tempSolutions.add(j);
            }

            //begin populating the row from each box and evaluating.
            for(Box box: boxes) {
                if(i <= box.getColEnd() && i >= box.getColStart()){
                    for (Cell cell : box.getCells()) {
                        if (cell.getColNumber() == i) {//only add if the cell is part of the row being created.
                            if(cell.getValue() == 0) {//if cell is 0, we add it to the row needing to be solved.
                                tempColumn.add(cell);
                            }
                            else{//if not zero, we remove it from the solutions needing to be solved
                                tempSolutions.remove(tempSolutions.indexOf(cell.getValue()));
                            }
                        }
                    }
                }
            }

            for(int k: tempSolutions){//go through each solution in the row, and compare against solutions of each cell in the row.
                int solutionCount = 0;
                Cell updateCell = null; //placeholder for the one cell that has that solution.

                for(Cell cell: tempColumn){//loop through each cell in the row.
                    for (int l : cell.getSolutions()) {
                        if (l == k) {
                            solutionCount += 1;
                            updateCell = cell;
                        }
                    }
                }

                if(solutionCount == 1){
                    updateCell.setValue(k);
                    for(Box box: boxes){
                        if(box.sameBox(updateCell)){//look for the box that houses the updated cell
                            box.updateAvailableSolutions(); // update the solutions for this box.
                            break;
                        }
                    }
                }
            }

            if(tempSolutions.size() == 1){
                for(Cell cell: tempColumn){
                    if(cell.getValue() == 0){
                        cell.setValue(tempSolutions.indexOf(0));
                        for(Box box: boxes){
                            if(box.sameBox(cell)){//look for the box that houses the updated cell
                                box.updateAvailableSolutions(); // update the solutions for this box.
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public void printBoxes(){
        for(int i = 0; i < size; i++){

            for(int j = 0; j < size; j++) {
                for (Box box : boxes) {
                    box.printCells(i, box.getRowStart()+2, j, box.getColStart()+2, size-1);
                }
            }
        }
    }

    //for each box, and each cell, print out the solutions for the cells.
    public void printSolutions(){
        int boxCount = 1;

        for(Box box: boxes){
            int cellCount = 1;
            for(Cell cell: box.getCells()){
                System.out.println("Box " + boxCount);
                System.out.println("Cell # " + cellCount + "--> R:" + cell.getRowNumber() + " C:" + cell.getColNumber());
                System.out.println(("Solutions"));
                System.out.print("{");
                for (int i: cell.getSolutions()){
                    System.out.print(i);
                }
                System.out.println("}");
                cellCount++;
            }
            boxCount++;
        }
    }
}
