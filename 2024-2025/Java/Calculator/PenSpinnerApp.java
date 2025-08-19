// Author: Tyerone Chen

import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class PenSpinnerApp {
   
   private Random random = new Random();
   private int max_spin = 15;
   private int min_spin = 0;
   private int spins;
   
   private JFrame frame;
   private JLabel label;
   private JButton button;
   
   public PenSpinnerApp(){
      
      spins = 0;
      
      frame = new JFrame("Spins Counter");
      label = new JLabel("Spins: " + spins);
      button = new JButton("Spin Pen");
      
      //set up the layout of our app
      frame.setLayout(new java.awt.CardLayout());
      frame.add(label);
      frame.add(button);
      
      frame.setSize(400, 400);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      frame.setVisible(true);
      
      // Add a click listener
      button.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            spins = random.nextInt(max_spin - min_spin + 1) + min_spin;
            label.setText("Spins: " + spins);
         }
      });
   
   }
   

   public static void main(String[] args){
      System.out.println("Started Up App");
      
      new PenSpinnerApp();
   }


}