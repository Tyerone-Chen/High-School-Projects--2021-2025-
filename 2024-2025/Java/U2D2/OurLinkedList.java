// Author: Tyerone Chen
// Create Date: 4/15/2025

import java.util.AbstractList;

/**
 * A generic singly linked list that extends Java's AbstractList<T>.
 * This version supports dynamic sizing and allows the user to:
 * - Add, remove, and access elements at any index
 * - Use this class anywhere a List<T> would be accepted
 */
public class OurLinkedList<T> extends AbstractList<T> {

    /**
     * Private inner Node class to represent each item in the list.
     * Each node holds data and a reference to the next node.
     */
    private static class Node<T> {
        T data;           // The value stored in this node
        Node<T> next;     // A reference to the next node in the list

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> head;  // Points to the first node in the list

    /**
     * Default constructor. Creates an empty list.
     */
    public OurLinkedList() {
        head = null;
    }

    /**
     * Returns the element at the specified index.
     * Must walk the list from the head until the target index is reached.
     */
    @Override
    public T get(int index) {
        if (index < 0 || index > size()) throw new IndexOutOfBoundsException();
        
        Node<T> current_node = head;
        
        for (int i = 0; i < index; i++){
            current_node = current_node.next;
        }
        
        return current_node.data;
    }

    /**
     * Replaces the element at the specified index with the given element.
     * Returns the old value that was replaced.
     */
    @Override
    public T set(int index, T element) {
        if (index < 0 || index > size()) throw new IndexOutOfBoundsException();
        
        Node<T> current_node = head;
        
        for (int i = 0; i < index; i++){
            current_node = current_node.next;
        }
        
        T old_data = current_node.data;
        current_node.data = element;
        
        return old_data;
    }

    /**
     * Inserts an element at the specified index.
     * Shifts the current node at that index (and everything after) forward.
     */
    @Override
    public void add(int index, T element) {
      if (index < 0 || index > size()) throw new IndexOutOfBoundsException();
      
      Node<T> new_node = new Node<T>(element);
      
      // Case 1: The LinkedList is empty or we are adding at 0, were we will add the value to the beggining and push any head value up one
      if (index == 0){
         new_node.next = head;
         head = new_node;
         return;
      } 
      
      // Case 2: The LinkedList is filled with data, there we will place the value ther and push other value up
      Node<T> current_node = head;
      
      for (int i = 0; i < index - 1; i++){
         current_node = current_node.next;
      }
      
      new_node.next = current_node.next;
      current_node.next = new_node;
    }

    /**
     * Removes and returns the element at the specified index.
     * Relinks the list so the removed node is skipped over.
     */
    @Override
    public T remove(int index) {
      if (index < 0 || index > size()) throw new IndexOutOfBoundsException();
      Node<T> removed_node;
      
      // Case 1:
      if (index == 0){
         removed_node = head;
         head = head.next;
         return removed_node.data;
      } 
      
      // Case 2:
      Node<T> current_node = head;
      
      for (int i = 0; i < index - 1; i++){
         current_node = current_node.next;
      }
      
      removed_node = current_node.next;
      current_node.next = removed_node.next;
      
      return removed_node.data;
    }

    /**
     * Returns the number of elements in the list.
     * Walks through the list and counts nodes.
     * This is calculated dynamically — no size variable is stored.
     */
    @Override
    public int size() {
        Node<T> current_node = head;
        int count = 0;
        
        while (current_node != null){
            count++;
            current_node = current_node.next;
        }
        
        return count;
    }
    
    public String toString(){
      String temp_str = "";
      Node<T> current_node = head;
      
      while (current_node != null){
         temp_str += current_node.data + " -> ";
         current_node = current_node.next;
      }
      
      temp_str += "null";
      
      return temp_str;
   }

   public static void main(String[] args){
      OurLinkedList oll = new OurLinkedList();
      oll.add(1);
      oll.add(2);
      System.out.println(oll.toString());
      oll.add(0, -33);
      System.out.println(oll.toString());
      oll.add(2, 99);
      System.out.println(oll.toString());
      oll.remove(0);
      System.out.println(oll.toString());      
      System.out.println(oll.get(0));
      oll.set(0, 5);
      System.out.println(oll.toString());
      
      try {
         oll.add(35, 5);
         System.out.println(oll.toString());
      }
      catch (IndexOutOfBoundsException err){
         System.out.println("[ERROR] | Attempted to add value out of LinkedList Bounds");
      }

   }

}