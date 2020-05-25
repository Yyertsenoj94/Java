package LinkedList_Old;
public class MyLinkedList implements Node {

    private ListItem root = null;

    public MyLinkedList(){

    }

    @Override
    public ListItem root() {
        while(root.getRightLink() != null){
            root = root.getRightLink();
        }
        while(root.getLeftLink() != null){
            root = root.getLeftLink();
        }
        return root;
    }

    @Override
    public boolean add(Item item) {
        int result;
        if(root != null){
            result = root.compareTo(item);
            if(result < 0){
                //current root is greater than the new value. Move down the list until not greater.
                while(result < 0) {
                    if (hasNext(root)) {
                        root = root.getRightLink();
                        result = root.compareTo(item);
                    } else {
                        //item is the last in the list;
                        root.setRightLink(item);
                        item.setLeftLink(root);
                        //go back to the head of the list.
                        this.root = root();
                        //break out of the function, add was successful.
                        return true;
                    }
                }
                //root is no longer greater. belongs on the right side.
                //item sets left = to root's previous left.
                item.setLeftLink(root.getLeftLink());
                root.getLeftLink().setRightLink(item);
                //item's right is the root.
                item.setRightLink(root);
                //root's new left becomes the item
                root.setLeftLink(item);
                this.root = root();
                //break out
                return true;
            }else if (result > 0){
                //item is the new head of the list.
                root.setLeftLink(item);
                item.setRightLink(root);
                this.root = root();
                //break out
                return true;
            }else{
                System.out.println("Value is already in the list");
                return false;
            }
        }
        //if no other condition was met, the list was empty, and the item becomes the root.
        root = item;
        return true;
    }

    private boolean hasNext(ListItem item){
        if(item.getRightLink() == null) {
            return false;
        }
        return true;
    }

    private boolean hasPrevious(ListItem item){
        if(item.getLeftLink() == null) {
            return false;
        }
        return true;
    }

    @Override
    public boolean remove(String string) {
        root = root();
        boolean loop = true;
        while(loop){
            if(string.equals(root.getValue().toString())){
                if(hasPrevious(root)){
                    root.getLeftLink().setRightLink(root.getRightLink());
                }
                if(hasNext(root)){
                    //remove the current reference to root.
                    root.getRightLink().setLeftLink(root.getLeftLink());
                }
                root = root();
                loop = false;
            }else{
                if(hasNext(root)){
                    root = root.getRightLink();
                }else{
                    System.out.println("Value not found in the list");
                    loop = false;
                }
            }
        }
        root = root();
        return true;
    }

    @Override
    public void print() {
        boolean loop = true;
        if(root != null){
            while(loop){
                    System.out.println(root.getValue());
                    if(hasNext(root)){
                        root = root.getRightLink();
                    }else{
                        loop = false;
                    }
            }
        }else{
            System.out.println("List is empty");
        }


    }
}
