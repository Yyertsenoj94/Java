package LinkedList;

public abstract class Node {
    protected String nodeID;
    protected Node nextNode;
    protected Node prevNode;

    protected Node(Object node){
        nodeID = node.toString();
    }

    protected abstract Node getNextNode();

    protected abstract Node getPrevNode();

    protected abstract void setNextNode(Node node);

    protected abstract void setPrevNode(Node node);

    protected abstract boolean addNode(Object Node);

    protected abstract boolean removeNode(Object Node);

    protected abstract int compareTo(Node node);

}
