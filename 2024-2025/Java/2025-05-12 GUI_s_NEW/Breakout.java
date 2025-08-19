import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Breakout extends JPanel implements KeyListener, ActionListener {
    int ballX = 160, ballY = 200, ballDX = 2, ballDY = -3;
    int paddleX = 150, paddleWidth = 60, paddleDX = 0;
    boolean[][] bricks = new boolean[5][10];
    Timer timer;

    public Breakout() {
        setPreferredSize(new Dimension(400, 300));
        setBackground(Color.BLACK);
        addKeyListener(this);
        setFocusable(true);
        timer = new Timer(10, this);
        timer.start();
        // Initialize all bricks as true (not broken)
        for (int i = 0; i < bricks.length; i++)
            for (int j = 0; j < bricks[0].length; j++)
                bricks[i][j] = true;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw ball
        g.setColor(Color.WHITE);
        g.fillOval(ballX, ballY, 10, 10);
        // Draw paddle
        g.setColor(Color.GREEN);
        g.fillRect(paddleX, 260, paddleWidth, 10);
        // Draw bricks
        g.setColor(Color.RED);
        for (int i = 0; i < bricks.length; i++)
            for (int j = 0; j < bricks[0].length; j++)
                if (bricks[i][j])
                    g.fillRect(j * 40 + 20, i * 15 + 30, 35, 10);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Move paddle
        paddleX += paddleDX;
        if (paddleX < 0) paddleX = 0;
        if (paddleX > getWidth() - paddleWidth) paddleX = getWidth() - paddleWidth;

        // Move ball
        ballX += ballDX;
        ballY += ballDY;

        // Ball collision with walls
        if (ballX < 0 || ballX > getWidth() - 10) ballDX = -ballDX;
        if (ballY < 0) ballDY = -ballDY;
        if (ballY > getHeight()) {
            timer.stop();
            JOptionPane.showMessageDialog(this, "Game Over!");
        }

        // Ball collision with paddle
        if (new Rectangle(ballX, ballY, 10, 10).intersects(new Rectangle(paddleX, 260, paddleWidth, 10)))
            ballDY = -ballDY;

        // Ball collision with bricks
        A: for (int i = 0; i < bricks.length; i++)
            for (int j = 0; j < bricks[0].length; j++)
                if (bricks[i][j]) {
                    Rectangle brick = new Rectangle(j * 40 + 20, i * 15 + 30, 35, 10);
                    if (new Rectangle(ballX, ballY, 10, 10).intersects(brick)) {
                        bricks[i][j] = false;
                        ballDY = -ballDY;
                        break A;
                    }
                }
        repaint();
    }

    @Override public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) paddleDX = -4;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) paddleDX = 4;
    }
    @Override public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT) paddleDX = 0;
    }
    @Override public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Breakout");
        Breakout game = new Breakout();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(game);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }
}