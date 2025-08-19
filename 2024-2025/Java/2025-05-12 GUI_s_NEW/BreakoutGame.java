// Author: Tyerone Chen
// Create Date: 5/16/2025
// Update Date: 5/16/2025

/**
   Basic Breakout Game using Java Swing
   Player Controls a Paddle which breaks and bounces against blocks to destroy them   
*/

// Imports
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BreakoutGame extends JFrame { // implements ActionListener, KeyListener 
   // Window Settings / Variable
   private static final int WIDTH = 600;
   private static final int HEIGHT = 400;
   
   // Destructible Block Settings
   private static final int BLOCK_WIDTH = 35;
   private static final int BLOCK_HEIGHT = 10;
   private boolean[][] blocks = new boolean[6][12];
   
   // Player Stuff
   private static final int PADDLE_WIDTH = 100;
   private static final int PADDLE_HEIGHT = 10;
   private static final int PADDLE_GAP_WIDTH = 40;
   private static final int PADDLE_GAP_HEIGHT = 20;
   private static final int PADDLE_OFFSET_WIDTH = 20;
   private static final int PADDLE_OFFSET_HEIGHT = 60;

   private int paddle_x = ( WIDTH / 2 ) - 45;
   private int paddle_y = ( HEIGHT / 2 ) + 135;
   
   // Ball Stuff
   private static final int BALL_WIDTH = 10;
   private static final int BALL_HEIGHT= 10;
   private int ball_x = WIDTH / 2;
   private int ball_y = (HEIGHT / 2) + 100; 
   
   // Game State Stuff
   Timer timer;
   private boolean is_running = false;
   private int score = 0;
   
   // Consturctor
   public BreakoutGame () {
      setTitle("Breakout");
      setSize(WIDTH, HEIGHT);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setResizable(false);
      setFocusable(true);
      
      createBlocks();
   }
   
   // Functions 
   
   public void createBlocks() {
      for (int row = 0; row < blocks.length; row++) {
         for ( int col = 0; col < blocks[0].length; col++){
            blocks[row][col] = true;
         }
      }
      System.out.println("| [SUCCESS] | Set all Blocks as True |");
   }
   
   // Overides
   @Override
   public void paint(Graphics g){
      super.paint(g);
      
      // Draw Background
      g.setColor(Color.BLACK);
      g.fillRect(0, 0, WIDTH, HEIGHT);
      System.out.println("| [PAINT] | Drew the Background |");
      
      // Draw Ball
      g.setColor(Color.WHITE);
      g.fillOval(ball_x, ball_y, BALL_WIDTH, BALL_HEIGHT);
      System.out.println("| [PAINT] | Drew the Ball |");
      
      // Draw Paddle
      g.setColor(Color.CYAN);
      g.fillRect(paddle_x, paddle_y, PADDLE_WIDTH, PADDLE_HEIGHT);
      System.out.println("| [PAINT] | Drew the Paddle |");
      
      // Draw Blocks
      g.setColor(Color.RED);
      for (int row = 0; row < blocks.length; row++) {
         for (int col = 0; col < blocks[0].length; col++) {
            g.fillRect((col * PADDLE_GAP_WIDTH + PADDLE_OFFSET_WIDTH), (row * PADDLE_GAP_HEIGHT + PADDLE_OFFSET_HEIGHT), BLOCK_WIDTH, BLOCK_HEIGHT);
         }
      }
      System.out.println("| [PAINT] | Drew the Blocks |");
   }
   
   public static void main(String[] args) {
        BreakoutGame game = new BreakoutGame();
        game.setVisible(true);
    }

}