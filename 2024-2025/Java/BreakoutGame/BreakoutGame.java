// Author: Tyerone Chen
// Create Date: 5/16/2025
// Update Date: 5/16/2025

/*
   Basic Breakout Game using Java Swing
   Player Controls a Paddle which breaks and bounces against blocks to destroy them   
*/

// Imports
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BreakoutGame extends JPanel implements ActionListener, KeyListener {  
   // Window Settings / Variable
   private static final int WIDTH = 600;
   private static final int HEIGHT = 400;
   
   // Destructible Block Settings
   private static final int BLOCK_WIDTH = 35;
   private static final int BLOCK_HEIGHT = 10;
   private boolean[][] blocks = new boolean[7][14];
   
   // Player Stuff
   private static final int PADDLE_WIDTH = 100;
   private static final int PADDLE_HEIGHT = 10;
   private static final int PADDLE_GAP_WIDTH = 40;
   private static final int PADDLE_GAP_HEIGHT = 20;
   private static final int PADDLE_OFFSET_WIDTH = 25;
   private static final int PADDLE_OFFSET_HEIGHT = 60;
   private boolean left_pressed = false;
   private boolean right_pressed = false;

   private int paddle_x = ( WIDTH / 2 ) - 45;
   private int paddle_y = ( HEIGHT / 2 ) + 135;
   private int paddle_d_x = 0;
   
   // Ball Stuff
   private static final int BALL_WIDTH = 15;
   private static final int BALL_HEIGHT = 15;
   private int ball_x = WIDTH / 2;
   private int ball_y = (HEIGHT / 2) + 100; 
   private int ball_d_x = 2;
   private int ball_d_y = -3;
   
   private final double MAX_ANGLE = Math.PI / 3;
   
   // Game State Stuff
   Timer timer;
   private int score = 0;
   
   // Consturctor
   public BreakoutGame () {
      setPreferredSize(new Dimension(WIDTH, HEIGHT));
      setBackground(Color.BLACK);
      setFocusable(true);
      requestFocusInWindow(); 
      // Timer
      timer = new Timer(10, this);
      timer.start();
      // Key Listener
      addKeyListener(this);
      // Block Creator
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
   
   public void updatePaddleDX () {
      if (left_pressed && !right_pressed) { // Moving Left
         paddle_d_x = -4;  
      }
      else if (!left_pressed && right_pressed) { // Moving Right
         paddle_d_x = 4; 
      }
      else { // Not Moving
         paddle_d_x = 0;
      }
   }
   
   public void resetGame () {
      // Reset Paddle Position
      paddle_x = (WIDTH / 2) - 45;
      paddle_y = (HEIGHT / 2) + 135;
      paddle_d_x = 0;
      
      // Reset Ball
      ball_x = WIDTH / 2;
      ball_y = (HEIGHT / 2) + 100;
      
      // ReCreate Blocks
      createBlocks();
      
      // Reset Scoe and Game Timer
      score = 0;
      
      // Restart Timer
      timer.start();
      repaint();
   }
   
   // Overides
   @Override
   public void paint(Graphics g){
      super.paint(g);
      
      // Draw Label
      g.setColor(Color.WHITE);
      g.setFont(new Font("Courier", Font.BOLD, 16));
      // Place Label
      String score_label = "SCORE: " + score;
      FontMetrics ft_mt = g.getFontMetrics();
      int font_x = WIDTH - ft_mt.stringWidth(score_label) - 20;
      int font_y = 30;
      g.drawString(score_label, font_x, font_y);
      
      // Draw Ball
      g.setColor(Color.WHITE);
      g.fillOval(ball_x, ball_y, BALL_WIDTH, BALL_HEIGHT);
      
      // Draw Paddle
      g.setColor(Color.CYAN);
      g.fillRect(paddle_x, paddle_y, PADDLE_WIDTH, PADDLE_HEIGHT);
      
      // Draw Blocks
      for (int row = 0; row < blocks.length; row++) {
         for (int col = 0; col < blocks[0].length; col++) {
            if (!blocks[row][col]) continue; // Only draw a block if it is true
            if (row == 1) {
               g.setColor(Color.RED);
            }
            else if (row == 2) {
               g.setColor(Color.ORANGE);   
            }
            else if (row == 3) {
               g.setColor(Color.YELLOW);   
            }
            else if (row == 4) {
               g.setColor(Color.GREEN);   
            }
            else if (row == 5) {
               g.setColor(Color.BLUE);   
            }
            else if (row == 6) {
               g.setColor(new Color(128, 0, 128));   
            }
            else {
               g.setColor(Color.PINK);
            }
            g.fillRect((col * PADDLE_GAP_WIDTH + PADDLE_OFFSET_WIDTH), (row * PADDLE_GAP_HEIGHT + PADDLE_OFFSET_HEIGHT), BLOCK_WIDTH, BLOCK_HEIGHT);
         }
      }
   }
   
   // Collision and Ball Handeler
   public void actionPerformed (ActionEvent evt) {
      // Move Paddle
      paddle_x += paddle_d_x;
      if (paddle_x < 0) paddle_x = 0; // clamp so it cannot be less than 0
      // Another clamp to ensure the paddle doesn't get out of bounds
      if (paddle_x > WIDTH - PADDLE_WIDTH) paddle_x = WIDTH - PADDLE_WIDTH;
      
      // Ball Movement
      ball_x += ball_d_x;
      ball_y += ball_d_y;
      
      // Ball Collision w/Wall
      if (ball_x < 0|| ball_x > WIDTH - BALL_WIDTH) ball_d_x = -ball_d_x; // Flip directions when colliding
      if (ball_y < 0) ball_d_y = -ball_d_y; // Flip directions when colliding
      if (ball_y > getHeight()) { // Ball out of bounds -> Game Over
         timer.stop();
         JOptionPane.showMessageDialog(this, "| Game Over! :[ |"); 
         resetGame();
      }
      
      // Ball Collision w/Paddle
      Rectangle curr_ball = new Rectangle(ball_x, ball_y, BALL_WIDTH, BALL_HEIGHT);
      Rectangle curr_paddle = new Rectangle(paddle_x, paddle_y, PADDLE_WIDTH, PADDLE_HEIGHT);
      if (curr_ball.intersects(curr_paddle)) {
         //ball_d_y = -ball_d_y;
         double hit_pos = ((ball_x + BALL_WIDTH / 2.0) - paddle_x) / PADDLE_WIDTH;
         double curr_angle = (hit_pos - 0.5) * MAX_ANGLE;
         double curr_speed = Math.sqrt((ball_d_x * ball_d_x) + (ball_d_y + ball_d_y)); // Calculus Math woo
         ball_d_x = (int) Math.round(curr_speed * Math.sin(curr_angle));
         ball_d_y = (int) -Math.round(curr_speed * Math.cos(curr_angle));
         if (ball_d_x == 0.0) ball_d_x = (Math.random() > 0.5) ? -2 : 2; // When hit straight up, 50/50 between hitting towards left or rightgithu
      } 
               
      // Ball Collision w/Bricks
      // Labeled Loop for sake of clarity   
      block_loop: for (int row = 0; row < blocks.length; row++) {
         for (int col = 0; col < blocks[0].length; col++) {
            if (!blocks[row][col]) continue; // Only check a block hitbox if it is true
            // Create a hitbox for detection of the currelented check block
            Rectangle curr_block = new Rectangle((col * PADDLE_GAP_WIDTH + PADDLE_OFFSET_WIDTH), (row * PADDLE_GAP_HEIGHT + PADDLE_OFFSET_HEIGHT), BLOCK_WIDTH, BLOCK_HEIGHT);
            if (new Rectangle(ball_x, ball_y, BALL_WIDTH, BALL_HEIGHT).intersects(curr_block)) {
               blocks[row][col] = false;
               ball_d_y = -ball_d_y;
               score += 100;
               break block_loop;
            }
         }
      }
      // Repaint
      repaint();
   }
   
   // Key Action Handeler
   public void keyPressed (KeyEvent evt) {
      if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
         left_pressed = true;
      }
      
      if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
         right_pressed = true;
      }
      updatePaddleDX();
   }
   
   public void keyReleased(KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
          left_pressed = false;
        }
        
        if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
          right_pressed = false;
        }
        updatePaddleDX();
    }
    
    public void keyTyped(KeyEvent evt) {
    // Unused, required by interface for checks
    }
   
   public static void main(String[] args) {
        JFrame frame = new JFrame("Breakout Game");
        BreakoutGame game = new BreakoutGame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(game);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }

}