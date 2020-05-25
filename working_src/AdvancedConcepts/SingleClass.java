package AdvancedConcepts;

public class SingleClass {
    //Static Class Reference
    private static SingleClass obj=null; // Once this static variable is initiated, no other class instance can be created.

    private SingleClass(){
        /*Private Constructor will prevent
         * the instantiation of this class directly*/
    }

    //only method allowed on the outside to create instance of the class.
    //only if the static variable is null does the method allow the creation of the class.
    public static SingleClass objectCreationMethod(){
        /*This logic will ensure that no more than
         * one object can be created at a time */
        if(obj==null){
            obj= new SingleClass();
        }
        return obj;
    }
    public void display(){
        System.out.println("Singleton class Example");
    }
    public static void main(String args[]){
        //Object cannot be created directly due to private constructor
        //This way it is forced to create object via our method where
        //we have logic for only one object creation
        SingleClass myobject= SingleClass.objectCreationMethod();
        myobject.display();
    }
}
