package LinkedList;

public class ListItem extends Node{

    protected ListItem(Object node){
        super(node);
    }

    protected ListItem(){
        this("");
    }

    protected static ListItem copyListItem(Object node){
        return new ListItem(node);
    }

    private void setNodeID(Object nodeID){
        super.nodeID = nodeID.toString();
    }

    @Override
    protected Node getNextNode() {
        return super.nextNode;
    }

    @Override
    protected Node getPrevNode() {
        return super.prevNode;
    }

    @Override
    protected void setNextNode(Node node) {
        super.nextNode = node;
    }

    @Override
    protected void setPrevNode(Node node) {
        super.prevNode = node;
    }

    @Override
    protected boolean addNode(Object node) {
        if(super.nodeID.equals("")){
            setNodeID(node.toString());
            return true;
        }
        Node traverse = getRoot(); //start traverse from the beginning
        Node newNode = copyListItem(node);
        int comparison = traverse.compareTo(newNode);
        switch (comparison){
            case 1: //new node should go before the traverse node (which is currently the root)
                //new node becomes the root
                newNode.setNextNode(traverse);
                traverse.setPrevNode(newNode);
                break;
            case -1: //new node comes after the traverse node
                do{
                    if(traverse.getNextNode() == null)//check to make sure it's not at the end
                        break;
                    traverse = traverse.getNextNode(); //set to next node.
                    comparison = traverse.compareTo(newNode); //compare again.

                }while(comparison == -1); //keep sorting forward

                if(comparison == 1){//In the middle of two nodes.
                    newNode.setNextNode(traverse);
                    newNode.setPrevNode(traverse.getPrevNode());
                    traverse.getPrevNode().setNextNode(newNode);
                    traverse.setPrevNode(newNode);
                }else if(traverse.getNextNode() == null){//reached end of the list
                    traverse.setNextNode(newNode);
                    newNode.setPrevNode(traverse);
                }else if(comparison == 0){
                    System.out.println("Duplicate error - node already exists");
                    return false;
                }
                break;
            default:
                System.out.println("Duplicate error - node already exists");
                return false;
        }
        return true;
    }

    @Override
    protected boolean removeNode(Object node) {
        if(!nodeExists(node)){
            System.out.println("Node could not be found, please try again");
            return false;
        }

        Node removeNode = returnNode(node);
        Node temp;
        if(removeNode.getPrevNode() == null){//node is the root
            if(removeNode.getNextNode() == null){//node is the only node left in list
                this.setNodeID("");
                removeNode = null;
            }else{//there is another node that will become the root after this.
                temp = removeNode.getNextNode();
                temp.setPrevNode(null);
            }
        }else if(removeNode.getNextNode() == null){//node is the last node in the list
            if(removeNode.getPrevNode() == null){//node is the only node left in list
                this.setNodeID("");
                removeNode = null;

            }else {//there is another node that will become the last node after this.
                temp = removeNode.getPrevNode();
                temp.setNextNode(null);
            }
        }else{//node is in between nodes, remove all references to this node.
            Node previous = removeNode.getPrevNode();
            Node next = removeNode.getNextNode();
            previous.setNextNode(next);
            next.setPrevNode(previous);
        }
        return true;
    }

    @Override
    protected int compareTo(Node node) {
        int comparisonLength;
        String parameterNode = node.nodeID;
        String thisNode = this.nodeID;
        int defaultInt = 0;
        if(parameterNode.length() < thisNode.length()){
            comparisonLength = parameterNode.length();
            defaultInt = 1; //shorter one is the parameter, it will go first if all else is equal
        }else if(parameterNode.length() > thisNode.length()){
            comparisonLength = thisNode.length();
            defaultInt = -1; //shorter one is the thisNode, it will go first if all else is equal
        }else{
            comparisonLength = thisNode.length(); //the lengths are the same, it doesn't matter which one we use
        }

        for(int i = 0; i < comparisonLength; i++){
            if(parameterNode.charAt(i) < thisNode.charAt(i)){
                return 1; //parameter node should go before the current node.
            }else if(parameterNode.charAt(i) > thisNode.charAt(i)){
                return -1; //current node should go before the parameter node.
            }
        }
        return defaultInt; //the one with the shorter length will go first
    }

    public Node getRoot(){
        Node tempRoot = this;
        while(tempRoot.getPrevNode() != null){
            tempRoot = tempRoot.getPrevNode();
        }
        return tempRoot;
    }

    public void print(){
        Node node = getRoot();
        if (node.nodeID.equals("")) {
            System.out.println("No nodes to print out");
        }else{
            System.out.println(node.nodeID);
            while(node.getNextNode() != null){
                node = node.getNextNode();
                System.out.println(node.nodeID);
            }
        }
    }

    private Node returnNode(Object node){
        Node traverse = getRoot();
        if(!traverse.nodeID.equals(node)){
            while(traverse.getNextNode() != null){
                traverse = traverse.getNextNode();
                if(traverse.nodeID.equals(node)){
                    return traverse;
                }
            }
        }else{
            return traverse;
        }
        return null;
    }

    private boolean nodeExists(Object node){
        Node traverse = getRoot();
        if(!traverse.nodeID.equals(node)){
            while(traverse.getNextNode() != null){
                traverse = traverse.getNextNode();
                if(traverse.nodeID.equals(node)){
                    return true;
                }
            }
        }else{
            return true;
        }
        return false;
    }

}
