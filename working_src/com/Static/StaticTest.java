package com.Static;

public class StaticTest {

    private static final int STATIC_VARIABLE;
    private final String name;

    //this will be called first before the constructor, thus allowing you to initialize any static variables
    //you want to use.
    static{
        STATIC_VARIABLE = 4;
    }

    public StaticTest(String newName){
            this.name = newName;
    }

    public int getStaticVariable(){
        return STATIC_VARIABLE;
    }

    public String getName(){
        return name;
    }




}
