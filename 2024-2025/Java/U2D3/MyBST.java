/**
 * MyBST.java
 * A basic structure for a Binary Search Tree (BST).
 * 
 * Students will implement the insert, search, and traversal methods
 * for storing and retrieving integer data in a sorted, efficient structure.
 * 
 * Key operations:
 * - insert(int value): adds a new value in order
 * - contains(int value): checks if a value exists
 * - inOrderPrint(): prints all values in sorted order
 * 
 * This class does not support deletion.
 */
public class MyBST <T extends Comparable>{

    /**
     * Node represents a single element in the BST.
     * Each node may have a left and/or right child.
     */
    private static class Node<T> {
        T data;
        Node<T> left, right;

        public Node(T data) {
            this.data = data;
        }
    }

    // The root node of the tree
    private Node<T> root;

    /**
     * Public method to insert a value into the BST.
     * Uses a recursive helper method to place the value
     * in the correct position based on BST rules.
     * 
     * @param value the integer to be inserted
     */
    public void insert(T value) {
        // TODO: Call insertHelper with root and value
        root = insertHelper(root, value);
    }

    /**
     * Recursive helper method for inserting a value into the tree.
     * If the current node is null, this is the correct insertion point.
     * If the value is less than the current node's data, recurse left.
     * If the value is greater, recurse right.
     * 
     * @param node the current node in the traversal
     * @param value the value to insert
     * @return the updated node after insertion
     */
    private Node<T> insertHelper(Node<T> node, T value) {
        // TODO: Implement insert logic
        if (node == null){
            return new Node(value);
        }
        if (value.compareTo(node.data) < 0){
            node.left = insertHelper(node.left, value);
        }
        else {
            node.right = insertHelper(node.right, value);
        }
        return node;
    }

    /**
     * Determines whether the BST contains the specified value.
     * Traverses the tree using a while loop, comparing at each step.
     * 
     * @param value the value to search for
     * @return true if the value exists in the tree, false otherwise
     */
    public boolean contains(T value) {
        // TODO: Implement a while-loop search starting from root
        Node<T> current_node = root;
        
        while (current_node != null){
            if (value.compareTo(current_node.data) == 0){
               return true;
            }
            else if (value.compareTo(current_node.data) < 0){
               current_node = current_node.left;
            }
            
            else {
               current_node = current_node.right;
            }
        }
        
        return false;
    }

    /**
     * Initiates an in-order traversal of the BST.
     * Values will be printed from smallest to largest.
     */
    public void inOrderPrint() {
        // TODO: Call inOrderHelper with root
        inOrderHelper(root);
    }

    /**
     * Performs in-order traversal of the BST.
     * Visit order: left subtree, current node, right subtree.
     * 
     * @param node the current node being visited
     */
    private void inOrderHelper(Node<T> node) {
        // TODO: Implement in-order traversal
        if (node == null){
            return;
        }
        
        inOrderHelper(node.left);
        System.out.print(node.data + " ");
        inOrderHelper(node.right);
    }
    
    private void printTree(){
         printTreeHelper(root, 0);
    }
    
    private void printTreeHelper(Node<T> node, int depth){
         if (node == null){
            return;
         }
    
         printTreeHelper(node.right, depth + 1);
         
         for (int i = 0; i < depth; i++){
            System.out.print("    ");
         }
         
         System.out.println(node.data);
         printTreeHelper(node.left, depth + 1);
    }
    
    public static void main(String[] args){
         MyBST<Integer> mBST = new MyBST<Integer>();
         mBST.insert(5);
         mBST.insert(7);
         mBST.insert(3);
         mBST.insert(2);
         mBST.insert(1);
         mBST.insert(8);
         mBST.insert(6);
         mBST.insert(4);
         mBST.insert(10);
         
         //mBST.inOrderPrint();
         mBST.printTree();
         System.out.println(mBST.contains(1));
    }
}