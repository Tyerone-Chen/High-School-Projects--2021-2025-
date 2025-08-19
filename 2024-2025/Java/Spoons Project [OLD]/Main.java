// Main.java
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

/**
 * Main driver to start and test the Spoons Simulation.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("🃏 Welcome to the Spoons Simulation 🥄🍴");

        // Step 1: Create a list of players
        List<PlayerThread> players = new ArrayList<>();

        // Add players (SimpleBotPlayer for now, but could add other types later)
        players.add(new BiasedBotPlayer("Biased Player 1"));
        players.add(new BiasedBotPlayer("Baised Player 2"));
        players.add(new BiasedBotPlayer("Biased Player 3"));
        players.add(new BiasedBotPlayer("Biased Player 4"));
        players.add(new BiasedBotPlayer("Biased Player 5"));
        players.add(new BiasedBotPlayer("Biased Player 6"));
        players.add(new BiasedBotPlayer("Biased Player 7"));
                        
        Collections.shuffle(players);
        
        // (Optional) Add mixed bot types later
        // players.add(new SmartBotPlayer("Player 5"));
        // players.add(new RandomBotPlayer("Player 6"));

        System.out.println("[Setup] " + players.size() + " players created.");

        // Step 2: Set up the table with the players
        SpoonsTable table = new SpoonsTable(players);

        // Step 3: Start the game
        table.startGame();

        System.out.println("🏁 Game simulation launched. Watch the console for race results!");
    }
}
