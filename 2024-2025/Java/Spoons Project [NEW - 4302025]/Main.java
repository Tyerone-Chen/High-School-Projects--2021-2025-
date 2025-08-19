import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

/**
 * Entry point for starting and testing the Spoons card game simulation.
 * <p>
 * Initializes a set of players (currently all {@code RandomBotPlayer}s),
 * shuffles their seating order, sets up the Spoons table, and launches the game.
 * </p>
 */
public class Main {
    /**
     * Main method to launch the Spoons simulation.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("🃏 Welcome to the Spoons Simulation 🥄🍴");

        // Step 1: Create a list of players
        List<PlayerThread> players = new ArrayList<>();

        // Add players (currently all RandomBotPlayers, but can mix in other bot types)
        players.add(new PlayerThread("Player 1", new TyeroneBiasedBotPlayer("Barney")));
        players.add(new PlayerThread("Player 2", new TyeroneBiasedBotPlayer("Benrey")));
        
        players.add(new PlayerThread("Player 3", new TyeroneOddToddBotPlayer("Todd")));
        players.add(new PlayerThread("Player 4", new TyeroneOddToddBotPlayer("Rodd")));
        
        players.add(new PlayerThread("Player 5", new TyeroneEvenStevenPlayer("Steven")));
        players.add(new PlayerThread("Player 6", new TyeroneEvenStevenPlayer("Stephan")));

        // Shuffle player seating order randomly
        Collections.shuffle(players);

        System.out.println("[Setup] " + players.size() + " players created.");

        // Step 2: Set up the table with the players
        SpoonsTable table = new SpoonsTable(players);

        // Step 3: Start the game
        table.startGame();

        System.out.println("🏁 Game simulation launched. Watch the console for race results!");
    }
}
