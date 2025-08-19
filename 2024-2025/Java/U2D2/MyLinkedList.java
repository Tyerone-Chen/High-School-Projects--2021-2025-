// Author: Tyerone Chen
// Create Date: 4/15/2025

public class MyLinkedList<T>{
   public Node<T> head;
   
   private static class Node<T>{
      T data;
      Node<T> next;
      Node(T data){
         this.data = data;
         this.next = null;
      }
   }
   
   // Constructor
   public MyLinkedList(){
      head = null;
   }
   
   // Methods
   public void add(T value){
      Node<T> new_node = new Node<T>(value);
      
      // Case 1: Empty LinkedList, set head as the value
      if (head == null){
         head = new_node;
         return;
      }
     
      // Case 2: Filled LinkedList, goes to find the next null position then adds the value there
      Node<T> current_node = head;
      while (current_node.next != null){
         current_node = current_node.next;
      }
      
      current_node.next = new_node;
      return;
   }
   
   public void add(int index, T value){
      if (index < 0 || index > size()) throw new IndexOutOfBoundsException();
      
      Node<T> new_node = new Node<T>(value);
      
      // Case 1:
      if (index == 0){
         new_node.next = head;
         head = new_node;
         return;
      } 
      
      // Case 2:
      Node<T> current_node = head;
      
      for (int i = 0; i < index - 1; i++){
         current_node = current_node.next;
      }
      
      new_node.next = current_node.next;
      current_node.next = new_node;
   }
   
   public int size(){
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
      MyLinkedList mll = new MyLinkedList();
      mll.add(1);
      mll.add(2);
      mll.add(3);
      System.out.println(mll.toString());
      mll.add(0, -33);
      System.out.println(mll.toString());
      mll.add(2, 99);
      System.out.println(mll.toString());
      
      try {
         mll.add(35, 5);
         System.out.println(mll.toString());
      }
      catch (IndexOutOfBoundsException err){
         System.out.println("[ERROR] | Attempted to add value out of LinkedList Bounds");
      }
   }

}