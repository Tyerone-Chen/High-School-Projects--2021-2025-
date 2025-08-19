import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

/**
 * Simple Flappy Bird-style game using Java Swing.
 * The player controls a bird that must fly through gaps in moving pipes.
 * The game ends if the bird hits a pipe or the ground.
 */
public class FlappyBirdSwing extends JFrame implements ActionListener {
    // Game settings
    private static final int WIDTH = 400;
    private static final int HEIGHT = 600;
    private static final int PIPE_WIDTH = 75;
    private static final int PIPE_GAP = 200;
    private static final int GRAVITY = 2;
    private static final int FLAP_STRENGTH = -15;
    private static final int PIPE_SPEED = 5;

    // Game state
    private int birdY = HEIGHT / 2;
    private int velocity = 0;
    private int score = 0;
    private boolean running = false;
    private Timer timer;
    private ArrayList<Rectangle> pipes;
    private Random random = new Random();

    /**
     * Constructor to set up the game window and initialize key listeners.
     */
    public FlappyBirdSwing() {
        setTitle("Flappy Bird");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window
        setResizable(false);
        setFocusable(true);

        // Add key listener for bird flapping
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    if (!running) {
                        startGame();
                    } else {
                        velocity = FLAP_STRENGTH;
                    }
                }
            }
        });

        // Initialize pipes
        pipes = new ArrayList<>();
        addPipe();
        addPipe();

        // Start the game loop
        timer = new Timer(20, this);
        timer.start();
    }

    /**
     * Starts or restarts the game by resetting the bird and pipes.
     */
    private void startGame() {
        birdY = HEIGHT / 2;
        velocity = 0;
        score = 0;
        pipes.clear();
        addPipe();
        addPipe();
        running = true;
    }

    /**
     * Adds a new pipe pair to the game.
     */
    private void addPipe() {
        int pipeHeight = random.nextInt(HEIGHT - PIPE_GAP - 100) + 50;
        int x = WIDTH;
        pipes.add(new Rectangle(x, 0, PIPE_WIDTH, pipeHeight)); // Top pipe
        pipes.add(new Rectangle(x, pipeHeight + PIPE_GAP, PIPE_WIDTH, HEIGHT - pipeHeight - PIPE_GAP)); // Bottom pipe
    }

    /**
     * Paints the game elements, including the bird, pipes, and score.
     */
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // Draw background
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        // Draw bird
        g.setColor(Color.YELLOW);
        g.fillOval(100, birdY, 30, 30);

        // Draw pipes
        g.setColor(Color.GREEN);
        for (Rectangle pipe : pipes) {
            g.fillRect(pipe.x, pipe.y, pipe.width, pipe.height);
        }

        // Draw score
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.drawString("Score: " + score, 20, 50);

        // Check for game over
        if (!running) {
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 50));
            g.drawString("Game Over", 50, HEIGHT / 2);
        }
    }

    /**
     * Handles the main game logic, including gravity, pipe movement, and collision detection.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            // Apply gravity to the bird
            velocity += GRAVITY;
            birdY += velocity;

            // Move pipes
            ArrayList<Rectangle> toRemove = new ArrayList<>();
            for (Rectangle pipe : pipes) {
                pipe.x -= PIPE_SPEED;
                if (pipe.x + PIPE_WIDTH < 0) {
                    toRemove.add(pipe);
                    score++;
                }
            }
            pipes.removeAll(toRemove);

            // Add new pipes as needed
            if (pipes.size() < 4) {
                addPipe();
            }

            // Check for collisions
            if (birdY < 0 || birdY > HEIGHT - 30) {
                running = false;
            }
            for (Rectangle pipe : pipes) {
                if (pipe.intersects(new Rectangle(100, birdY, 30, 30))) {
                    running = false;
                }
            }

            repaint();
        }
    }

    /**
     * Main method to start the game.
     * @param args Command-line arguments (unused)
     */
    public static void main(String[] args) {
        FlappyBirdSwing game = new FlappyBirdSwing();
        game.setVisible(true);
    }
}
