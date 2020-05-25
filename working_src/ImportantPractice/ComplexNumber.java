package ImportantPractice;
public class ComplexNumber {

    //complex number is a number that can be expressed in the form a + bi, where are and b area
    //both real numbers and i is a solution of the equation x2 = -1. Because no real number satisfies this
    //equation, i is called an imaginary number. For the complex number a + bi, a is called the real part, and
    //b is called the imaginary part.


    //to add or subtract complex numbers, just add the corresponding real and imaginary parts.

    // 2 + 2i summed with 4 + 3i = 6 + 5i.


    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary){

        this.real = real;
        this.imaginary = imaginary;

    }


    public double getReal(){

        return real;

    }

    public double getImaginary(){

        return imaginary;

    }


    public void add(double real, double imaginary){

        this.real += real;
        this.imaginary += imaginary;

    }

    public void subtract(double real, double imaginary){

        this.real -= real;
        this.imaginary -= imaginary;

    }

    public void subtract(ComplexNumber complexNumber){
        subtract(complexNumber.getReal(), complexNumber.getImaginary());
    }





}
