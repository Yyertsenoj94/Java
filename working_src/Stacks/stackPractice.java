package Stacks;

import java.util.Stack; // necessary to use stacks.
public class stackPractice {

    public static void main(String[] args) {
        Stack<Integer> intStack = new Stack<Integer>();

        int[] intArry = {1, 2, 3, 4, 5, 6};

        for(int i = 0; i < intArry.length; i++){
            intStack.push(intArry[i]);
            printStack(intStack);
        }
        for(int i = intStack.size() - 1; i >= 0; i--){
            intStack.pop();
            printStack(intStack);
        }
    }

    public static void printStack(Stack<Integer> stack){
        System.out.println(String.format("%s", stack));
    }

}

