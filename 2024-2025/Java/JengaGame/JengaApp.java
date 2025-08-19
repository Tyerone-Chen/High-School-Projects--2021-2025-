// Author: Tyerone Chen
// Create Data: 5/14/2025
// Last Update: 5/14/2025

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Random;

public class JengaApp {

   private Random random = new Random();
   
   public JengaApp () {
      createGUI();
   }
   
   private void createGUI(){
      // Frame Setup
      JFrame frame = new JFrame("Jenga App");
      frame.setLayout(new BorderLayout());
      frame.setSize(800, 500);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
   
      
      JPanel panel = setupPanel("TOP Label", "TOP Button");
      panel.setPreferredSize(new Dimension(100, 75));
      panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
      frame.add(panel, BorderLayout.PAGE_START);
      
      panel = setupPanel("CENTER Label", "CENTER Button");
      panel.setPreferredSize(new Dimension(100, 200));
      panel.setBorder(BorderFactory.createLineBorder(Color.GREEN, 1));
      frame.add(panel, BorderLayout.CENTER);
      
      panel = setupPanel("LEFT Label", "LEFT Button");
      panel.setPreferredSize(new Dimension(200, 200));
      panel.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
      frame.add(panel, BorderLayout.LINE_START);
      
      panel = setupPanel("RIGHT Label", "RIGHT Button");
      panel.setPreferredSize(new Dimension(200, 200));
      panel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 1));
      frame.add(panel, BorderLayout.LINE_END);
      
      panel = setupPanel("BOTTOM Label", "BOTTOM Button");
      panel.setPreferredSize(new Dimension(100, 75));
      panel.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 1));
      frame.add(panel, BorderLayout.PAGE_END);
      
      // Make Frame Visible
      frame.setVisible(true);
   }
   
   private static JPanel setupPanel(String label_txt, String btn_txt) {
      JPanel panel = new JPanel();
      panel.setLayout(new FlowLayout());
      
      JLabel label = new JLabel(label_txt);
      JButton button = new JButton(btn_txt);
      
      panel.add(label);
      panel.add(button);
      
      return panel;
   }

   
   public static void main(String[] args) {
      System.out.println("| Program Started Up |");
      new JengaApp();
   }
}