package LinkedList_Old;
public class Item extends ListItem {

    public Item(Object value){

        super(value);

    }

    @Override
    ListItem getLeftLink() {

        return this.leftLink;

    }

    @Override
    ListItem getRightLink() {

        return this.rightLink;

    }

    //does this actually work even if you don't store the value being returned?
    @Override
    ListItem setLeftLink(ListItem listItem) {

        return this.leftLink = listItem;

    }

    @Override
    ListItem setRightLink(ListItem listItem) {

        return this.rightLink = listItem;

    }

    @Override
    int compareTo(ListItem listItem) {

        //if first (left) string is greater, returns negative
        //if second (right) string is greater, returns positive,
        //if equal, returns 0;
        if(listItem != null) {
            return ((String) super.getValue()).compareTo((String) listItem.getValue());
        }else{
            //not sure why we are doing this.
            return -1;
        }

    }
}
