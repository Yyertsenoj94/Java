package LinkedList_Old;

public class MainLinkedList {

    public static void main(String[] args) {

            BinarySearchTree binarySearchTree = new BinarySearchTree();

            binarySearchTree.add(new Item("8"));

            binarySearchTree.add(new Item("7"));

            binarySearchTree.add(new Item("9"));

            binarySearchTree.add(new Item("1"));

            binarySearchTree.add(new Item("2"));

            binarySearchTree.add(new Item("3"));

            binarySearchTree.add(new Item("4"));

            binarySearchTree.add(new Item("5"));

            binarySearchTree.add(new Item("6"));

        binarySearchTree.print();
        System.out.println("------------------------------");
        binarySearchTree.remove("1");
        System.out.println("------------------------------");
        binarySearchTree.print();
        System.out.println("------------------------------");
        binarySearchTree.remove("8");
        System.out.println("------------------------------");
        binarySearchTree.print();
        System.out.println("------------------------------");
        binarySearchTree.remove("7");
        System.out.println("------------------------------");
        binarySearchTree.print();
        System.out.println("------------------------------");
//        MyLinkedList newList = new MyLinkedList();
//        String[] array = {"America", "New Zealand", "Topo", "Taiwan", "Zimbabwe","Brazil", "Chile"};
//
//        for(int i = 0; i < array.length; i++){
//            newList.add(new Item(array[i]));
//        }
//
//        newList.print();
//        System.out.println("------------------------------");
//        newList.remove("America");
//        newList.print();
//        System.out.println("------------------------------");
//        newList.remove("Chile");
//        newList.print();
//        System.out.println("------------------------------");
//        newList.remove("Taiwan");
//        newList.print();
//        System.out.println("------------------------------");
//        newList.remove("New Zealand");
//        newList.print();
//        System.out.println("------------------------------");
//        newList.remove("Zimbabwe");
//        newList.print();
    }

}
