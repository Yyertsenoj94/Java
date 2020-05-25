package ArrayLists;

import java.util.ArrayList;

public class GroceryList {

    ArrayList<String> groceryList = new ArrayList<>();


    public void printList() {

        for (int i = 0; i < groceryList.size(); i++) {

            System.out.println("Item " + (i+1) + ": " + groceryList.get(i));

        }

    }

    private int findIndex(String value){
        int index = groceryList.indexOf(value);

        return index;
    }

    public void addItem(String value){
        groceryList.add(value);
        System.out.println(value + " added to list");
    }

    public void removeItem(String value){
        int removeIndex = findIndex(value);
        groceryList.remove(removeIndex);
        System.out.println(value + " removed from list.");
    }

    public void modifyItem(String value, String newValue){
        int modifyIndex = findIndex(value);
        groceryList.set(modifyIndex, newValue);
        System.out.println(value + " changed to " + newValue);

    }
}