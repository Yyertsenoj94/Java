package LinkedList_Old;
//NEED TO WORK ON THIS SOME, THE REMOVAL FUNCTION IS NOT 100% WORKING.
public class BinarySearchTree implements Node {

    private ListItem root = null;

    @Override
    public ListItem root() {
        return root;
    }

    @Override
    public boolean add(Item item) {
        int result;
        if (root == null) {
            root = item;
        }else{
            move(item, root);
        }
        return true;
    }

    private void move(ListItem item, ListItem root){
        ListItem tempRoot = root;
        int result;
        result = tempRoot.compareTo(item);

        if(result < 0){
            if(hasNext(tempRoot)){
                tempRoot = tempRoot.getRightLink();
                move(item, tempRoot);
            }else{
                tempRoot.setRightLink(item);
            }
        }else if (result > 0){
            if(hasPrevious(tempRoot)){
                tempRoot = tempRoot.getLeftLink();
                move(item, tempRoot);
            }else{
                tempRoot.setLeftLink(item);
            }
        }else{
            System.out.println(item.getValue().toString() + " is already in the list. Add was not successful");
        }

    }

    private boolean hasNext(ListItem item){
        if(item.getRightLink() != null){
            return true;
        }else{
            return false;
        }
    }

    private boolean hasPrevious(ListItem item){
        if(item.getLeftLink() != null){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean remove(String string) {
        searchRemove(string, root);
        return true;
    }

    @Override
    public void print() {
        ListItem tempRoot = root;
        search(tempRoot);

    }

    private boolean searchRemove(String value, ListItem root){
        ListItem tempRoot = root;
        //move left for this node
        if(hasPrevious(tempRoot)){
            if(tempRoot.getLeftLink().getValue().toString().equals(value)){
                collectChildren(tempRoot, tempRoot.getLeftLink(), false);
            }else{
                searchRemove(value, tempRoot.getLeftLink());
            }
        }

        if(hasNext(tempRoot)){
            if(tempRoot.getRightLink().getValue().toString().equals(value)){
                collectChildren(tempRoot, tempRoot.getRightLink(), true);
                return true;
            }else{
                searchRemove(value, tempRoot.getRightLink());
            }

        }

        return true;
    }

    private void collectChildren(ListItem newParent, ListItem oldParent, boolean direction){

        if(direction){
            if(oldParent.getLeftLink() != null){
                newParent.setRightLink(oldParent.getLeftLink());
            }
            if(oldParent.getRightLink() != null){
                newParent.getRightLink().setRightLink(oldParent.getRightLink());
            }

            if(oldParent.getLeftLink() == null && oldParent.getRightLink() == null){
                newParent.setRightLink(null);
            }

        }else{
            if(oldParent.getLeftLink() != null){
                newParent.setLeftLink(oldParent.getLeftLink());
            }
            if(oldParent.getRightLink() != null){
                newParent.getLeftLink().setRightLink(oldParent.getRightLink());
            }

            if(oldParent.getLeftLink() == null && oldParent.getRightLink() == null){
                newParent.setLeftLink(null);
            }
        }

        System.out.println(oldParent.getValue().toString() + " was successfully removed");

    }


    private void search(ListItem item){

        if(hasPrevious(item)){
            search(item.getLeftLink());
        }

        System.out.println(item.getValue().toString());
        checkRight(item);
    }

    private void checkRight(ListItem item){
        if(hasNext(item)){
            search(item.getRightLink());
        }
    }


}