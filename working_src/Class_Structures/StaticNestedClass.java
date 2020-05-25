package Class_Structures;
public class StaticNestedClass {

    public static void main(String[] args) {

        //static method - does not need to initialize the outer class to run the outer method.
        //simply call the class name and ".method".
        //then can initialize another STATIC innerclass that is within the outerclass and then call a method within.

        //even thought the inner class is static, it is able to be initialized into an object below.
        OuterClass3.InnerClass innerClass = new OuterClass3.InnerClass();

        innerClass.innerMethod();


    }



}

class OuterClass3{

    public static void outerMethod(){
        System.out.println("Outer Method Called");
        InnerClass innerClass = new InnerClass();

        //causes loop to be everlasting because it calls itself again.
//        innerClass.innerMethod();
    }

    public static class InnerClass{

        public void innerMethod(){

            System.out.println("Hello");
            outerMethod();
        }


    }

}
