import javax.swing.*;
import java.awt.event.*;

public class ClickCounterApp {

   private int count;
   
   private JFrame frame;
   private JLabel label;
   private JButton button;
   
   public ClickCounterApp(){
      
      count = 0;
      
      frame = new JFrame("Click Counter");
      label = new JLabel("Clicks: " + count);
      button = new JButton("Click Me!");
      
      //set up the layout of our app
      frame.setLayout(new java.awt.FlowLayout());
      frame.add(label);
      frame.add(button);
      
      frame.setSize(300, 200);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      frame.setVisible(true);
      
      // Add a click listener
      button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            count++;
            label.setText("Clicks: " + count);
         }
      });
   
   }
   

   public static void main(String[] args){
      System.out.println("Hello World");
      
      new ClickCounterApp();
      
   
   }


}