package CodeWarriors;

import java.util.*;

public class Directions {

    public static void main(String[] args) {
        //String[] array = {"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST" };
        String[] array = {"North", "South", "East", "West", "North"};
        directionReduction(array);
    }

    public static String[] directionReduction(String[] arrList){
        List<String> directions = new LinkedList<>();
        boolean notSimple = true;
        String[] newArray;
        String current = null;
        for(String str: arrList) {
            directions.add(str.toUpperCase());
        }
        ListIterator<String> iter = directions.listIterator();
        if(iter.hasNext()){
            current = iter.next();
        }
        while(iter.hasNext()){
               String next = iter.next();

            if(current.equals(opposite(next))){
                iter.remove();
                iter.previous();
                iter.remove();
                while(iter.hasPrevious()){
                    iter.previous();
                }
                if(iter.hasNext()){
                    current = iter.next();
                }else{
                    break;
                }
            }else{
                current = next;
            }
        }

        newArray = new String[directions.size()];
        int i = 0;
        for(String str: directions){
            newArray[i] = str;
            i++;
        }
        return newArray;
    }

    public static String opposite(String str){
        switch (str){
            case "SOUTH":
                return "NORTH";
            case "NORTH":
                return "SOUTH";
            case "EAST":
                return "WEST";
            case "WEST":
                return "EAST";
        }
        return null;
    }

}
