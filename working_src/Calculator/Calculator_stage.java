package Calculator;
public class Calculator_stage {

    //state of the class
    private double firstNumber = 0;

    private double secondNumber = 0;


    //behavior of the class (methods)
    public void setFirstNumber(double number){
        this.firstNumber = number;

    }

    public void setSecondNumber(double number){
        this.secondNumber = number;

    }

    public double getFirstNumber(){
        return this.firstNumber;
    }

    public double getSecondNumber(){
        return this.secondNumber;
    }

    public double getAdditionResult(){
        double result = firstNumber + secondNumber;


        return  result;

    }

    public double getSubtractionResult(){
        double result = firstNumber - secondNumber;

        return  result;

    }

    public double getMultiplicationResult(){
        double result = firstNumber * secondNumber;

        return  result;

    }

    public double getDivisionResult(){

        if(secondNumber == 0){
            return 0;
        }
        double result = firstNumber / secondNumber;

        return  result;

    }

}
