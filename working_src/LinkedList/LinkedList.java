package LinkedList;

public class LinkedList {
    String name;
    ListItem listItem;
    public LinkedList(){
        listItem = new ListItem();
    }

    public void add(Object name){
        listItem.addNode(name);
    }

    public void remove(Object name){
        listItem.removeNode(name);
    }

    public void printList(){
        listItem.print();
    }

}
