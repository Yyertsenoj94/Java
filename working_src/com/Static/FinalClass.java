package com.Static;

final class FinalClass {

    final int finalNumber;

    String name;

    public FinalClass(String name, int number){
        this.name = name;

        finalNumber = number;

    }

    public void printName(){
        System.out.println(name);
    }

}
