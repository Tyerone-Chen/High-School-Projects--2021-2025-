// Imports
import javax.swing.*;
import java.awt.event.*;

public class TyeroneClickClounter {
   //  JFrame Variables   
   private JFrame frame;
   private JLabel label;
   private JButton button;
   
   // Counter Variable
   private int count = 0;
   
   public TyeroneClickClounter(){
      // Variable setup
      count = 0;
      frame = new JFrame("Click Counter Thing");
      label = new JLabel("Total Clicks: " + count);
      button = new JButton("Click Button");
      
      //Frame Setup
      frame.setLayout(new java.awt.FlowLayout());
      frame.add(label);
      frame.add(button);
      frame.setSize(300, 300);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
      
      // Click Listener
      button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            count++;
            label.setText("Total Clicks: " + count);
         }
      });
   }

   public static void main(String[] args){      
      new TyeroneClickClounter();
   }
}