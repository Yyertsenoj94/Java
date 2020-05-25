package LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        BinarySearchTree binaryTree = new BinarySearchTree();
        binaryTree.add("China");
        binaryTree.add("Brazil");
        binaryTree.add("Denmark");
        binaryTree.add("America");
        binaryTree.add("Chile");
        binaryTree.add("Pakistan");
        binaryTree.add("Zimbabwe");
        binaryTree.add("Peru");
        binaryTree.add("Madagascar");
        binaryTree.add("Sweden");
        binaryTree.add("Israel");
        binaryTree.add("England");
        binaryTree.traverseTree(binaryTree.getRoot());
    }
}
