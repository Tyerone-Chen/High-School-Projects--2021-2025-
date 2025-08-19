import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.Random;

/**
 * Simple Snake Game using Java Swing.
 * This game features a snake that moves around the screen, eating food and growing longer.
 * The game ends if the snake collides with itself or the game boundaries.
 */
public class SwingSnakeGame extends JFrame implements ActionListener {
    // Game settings
    private static final int TILE_SIZE = 25; // Size of each tile in pixels
    private static final int WIDTH = 20; // Number of horizontal tiles
    private static final int HEIGHT = 20; // Number of vertical tiles
    private static final int GAME_SPEED = 150; // Game speed in milliseconds per tick
    private static final Color SNAKE_COLOR = new Color(34, 139, 34); // Green snake color
    private static final Color FOOD_COLOR = new Color(220, 20, 60); // Red food color

    // Game state
    private LinkedList<Point> snake; // List of points representing the snake body
    private Point food; // Current food location
    private char direction = 'R'; // Initial snake direction (Right)
    private boolean running = false; // Game running state
    private Timer timer; // Timer to control game speed

    /**
     * Constructor to set up the game window and initialize key listeners.
     * This method sets up the main game window, including title, size, and key listeners for movement.
     * The window is designed to be fixed in size to avoid resizing issues with the game grid.
     */
    public SwingSnakeGame() {
        setTitle("Snake Game");
        setSize(WIDTH * TILE_SIZE, HEIGHT * TILE_SIZE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window
        setResizable(false); // Prevent resizing to maintain consistent tile alignment
        setBackground(Color.BLACK);
        setFocusable(true);

        // Add key listener for snake movement
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // Change direction only if it doesn't cause immediate self-collision
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP: if (direction != 'D') direction = 'U'; break;
                    case KeyEvent.VK_DOWN: if (direction != 'U') direction = 'D'; break;
                    case KeyEvent.VK_LEFT: if (direction != 'R') direction = 'L'; break;
                    case KeyEvent.VK_RIGHT: if (direction != 'L') direction = 'R'; break;
                }
            }
        });

        // Start the game
        startGame();
    }

    /**
     * Initializes the game state, including the snake and the first food item.
     * This method resets the game, placing the snake in the center of the grid and spawning the first food item.
     * It also starts the game timer, which triggers periodic updates.
     */
    private void startGame() {
        snake = new LinkedList<>();
        snake.add(new Point(WIDTH / 2, HEIGHT / 2)); // Start snake in the center
        spawnFood(); // Generate the first food item
        running = true; // Set game state to running
        timer = new Timer(GAME_SPEED, this);
        timer.start(); // Start the game timer
    }

    /**
     * Spawns a new food item at a random location, ensuring it doesn't overlap the snake.
     * The while loop ensures the food is not placed on top of the snake, which would make it instantly 'eaten'.
     */
    private void spawnFood() {
        Random random = new Random();
        do {
            food = new Point(random.nextInt(WIDTH), random.nextInt(HEIGHT));
        } while (snake.contains(food)); // Ensure food isn't placed on the snake
    }

    /**
     * Paints the game screen, including the snake and the food.
     * The paint method is responsible for rendering the current game state each frame.
     * It uses the Graphics context to draw each part of the snake and the food on the grid.
     * @param g Graphics context for drawing
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (running) {
            // Draw each snake segment
            for (Point segment : snake) {
                g.setColor(SNAKE_COLOR);
                g.fillRect(segment.x * TILE_SIZE, segment.y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
            }

            // Draw the food
            g.setColor(FOOD_COLOR);
            g.fillRect(food.x * TILE_SIZE, food.y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
        } else {
            // Display Game Over message
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 50));
            g.drawString("Game Over", 50, HEIGHT * TILE_SIZE / 2);
        }
    }

    /**
     * Handles each game tick, including moving the snake and checking for collisions.
     * This method is called by the Timer at regular intervals to update the game state.
     * It triggers a repaint to reflect any changes to the snake or food locations.
     * @param e ActionEvent triggered by the timer
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            move(); // Update snake position
            checkCollision(); // Check for collisions
            repaint(); // Repaint the game window to reflect changes
        } else {
            timer.stop(); // Stop the game if no longer running
        }
    }

    /**
     * Moves the snake in the current direction and checks if it has eaten the food.
     * This method creates a new head based on the current direction, adds it to the front of the snake,
     * and removes the tail if no food was eaten, effectively moving the snake one tile.
     */
    private void move() {
        Point head = snake.getFirst();
        Point newHead = new Point(head);

        // Update head position based on direction
        switch (direction) {
            case 'U': newHead.y--; break; // Move up
            case 'D': newHead.y++; break; // Move down
            case 'L': newHead.x--; break; // Move left
            case 'R': newHead.x++; break; // Move right
        }

        // Add new head to the snake
        snake.addFirst(newHead);

        // Check if the snake has eaten the food
        if (newHead.equals(food)) {
            spawnFood(); // Generate new food
        } else {
            snake.removeLast(); // Remove tail if no food was eaten
        }
    }

    /**
     * Checks for collisions with the wall or the snake itself, ending the game if detected.
     * This method checks if the snake's head has moved out of bounds or collided with its own body,
     * which are both game-ending conditions.
     */
    private void checkCollision() {
        Point head = snake.getFirst();

        // Check wall collisions
        if (head.x < 0 || head.y < 0 || head.x >= WIDTH || head.y >= HEIGHT) {
            running = false;
        }

        // Check self-collision
        if (snake.size() > 1 && snake.subList(1, snake.size()).contains(head)) {
            running = false;
        }
    }

    /**
     * Main method to start the game.
     * @param args Command-line arguments (unused)
     */
    public static void main(String[] args) {
        SwingSnakeGame game = new SwingSnakeGame();
        game.setVisible(true);
    }
}
