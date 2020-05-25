package LinkedList;


public class BinarySearchTree {

    private ListItem root;
    private BinarySearchTree previous;
    private BinarySearchTree next;

    private BinarySearchTree(Object name){
        root = new ListItem(name);
    }

    public BinarySearchTree(){
        this("");
    }

    public boolean add(Object name){
        ListItem newItem = ListItem.copyListItem(name);
        if(root.nodeID == ""){
            root = new ListItem(name);
            return true;
        }
        int comparison = root.compareTo(newItem);
        if(comparison == 1){
            if(previous == null){
                previous = new BinarySearchTree(name);
            }else{
                previous.add(name);
            }
        }else if(comparison == -1){
            if(next == null){
                next = new BinarySearchTree(name);
            }else{
                next.add(name);
            }
        }else{
            System.out.println("Duplicate item found, cannot add to search tree.");
        }
        return true;
    }

    public BinarySearchTree getRoot(){
        return this;
    }

    public BinarySearchTree getNext(){
        return next;
    }

    public BinarySearchTree getPrevious(){
        return previous;
    }

    public void traverseTree(BinarySearchTree tree){

        if(tree != null){
            traverseTree(tree.getPrevious());
            System.out.println(tree.root.nodeID);
            traverseTree(tree.getNext());
        }

        //NOTE: use this code if you don't want a parameter in the traverse function!
//        if(getPrevious() != null){
//            getPrevious().traverseTree();
//        }
//        System.out.println(root.nodeID);
//        if(getNext() != null){
//            getNext().traverseTree();
//        }
    }

}
