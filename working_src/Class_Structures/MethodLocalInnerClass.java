package Class_Structures;
public class MethodLocalInnerClass {

    public static void main(String[] args) {


        OuterClass1 outerClass = new OuterClass1();

        //will set off a chain of reactions with the outer method calling, which initializes
        // the inner class and calls the inner class method.
        outerClass.methodOuterLocal();




    }


}



class OuterClass1{


    public void methodOuterLocal(){
        System.out.println("Calling method local...");

        class InnerClassOfMethodOuterLocal{

            public void innerMethodOfInnerClass() {

                System.out.println("Callling method within inner class of local method...");

            }

        }

        //this class can only be called within the local method of the outer class.
        InnerClassOfMethodOuterLocal innerClass = new InnerClassOfMethodOuterLocal();
        innerClass.innerMethodOfInnerClass();

    }


}
