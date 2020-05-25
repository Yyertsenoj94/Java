
package Class_Structures;
public class InnerClassExample {


    public static void main(String[] args) {
            //initialize the outerClass method.
            OuterClass originalOuterclass = new OuterClass();

            //call outer class method.
            originalOuterclass.outerMethod();

            //initialize the innerClass object based on the initialization of the outer class object.
            OuterClass.InnerClass innerClass = originalOuterclass.new InnerClass();

            //OR create a brand new outer class from which to create the new inner class object.
            OuterClass.InnerClass newInnerClass = new OuterClass().new InnerClass();

            innerClass.innerMethod("Inner method of OriginalOuterClass");

            newInnerClass.innerMethod("Inner method of new Outer Class");


    }



}



class OuterClass{

    public void outerMethod(){
        System.out.println("Calling outer method...");
    }

    class InnerClass{
        //if you make this private, nothing but the innerClass will be able to see them.
        public void innerMethod(String string){
            System.out.println(string);
        }

    }



}