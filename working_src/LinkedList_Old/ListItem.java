package LinkedList_Old;

public abstract class ListItem {

    protected ListItem leftLink;
    protected ListItem rightLink;
    protected Object value;

    protected ListItem(Object value){

        this.value = value;

    }

    abstract ListItem getLeftLink();
    abstract ListItem getRightLink();

    abstract ListItem setLeftLink(ListItem listItem);
    abstract ListItem setRightLink(ListItem listItem);

    abstract int compareTo(ListItem listItem);

    protected Object getValue(){

        return value;

    }

    protected void setValue(Object value){

        this.value = value;

    }
}
