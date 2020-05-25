package com.Static;

public class main {

    public static void main(String[] args) {

        String name;
        int variable;

        StaticTest test = new StaticTest("This test");

        name = test.getName();
        variable = test.getStaticVariable();

        System.out.println(name);
        System.out.println(variable);

        FinalClass finalClass = new FinalClass("First Final Class", 2);

        finalClass.printName();


    }

}
