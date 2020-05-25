package ImportantPractice;
public class Floor {

    private double width = 0;
    private double height = 0;


    public Floor(double width, double height){

        this.width = width;
        this.height = height;

        if(width < 0){
            this.width = 0;
        }
        if(height  < 0){
            this.height = 0;
        }
    }

    public double getArea(){

        return width * height;

    }



}
