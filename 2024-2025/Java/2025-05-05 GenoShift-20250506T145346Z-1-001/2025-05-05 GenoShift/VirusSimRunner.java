import java.util.*;

/**
 * Main entry point for running the Virus Evolution Simulation.
 */
public class VirusSimRunner {

    public static void main(String[] args) {
        System.out.println("Starting Virus Evolution Simulation...");

        // Step 1: Build student virus using a custom VirusBuilder
        VirusBuilder builder = new Student42Virus(); // replace with actual student class
        Virus initialVirus = builder.buildInitialVirus();

        // Step 2: Insert the initial virus into the database
        DatabaseManager db = DatabaseManager.getInstance();
        db.insertInitialVirus(initialVirus);

        // Step 3: Create the simulation engine with a default fitness strategy
        FitnessStrategy defaultStrategy = new GCContentFitness(); // can be swapped later
        SimulationEngine engine = new SimulationEngine(defaultStrategy);

        // Step 4: Run the simulation
        engine.runSimulation();

        // Step 5: Display final leaderboard
        List<String> leaderboard = db.getLeaderboard();
        System.out.println("\n=== Final Leaderboard ===");
        for (String entry : leaderboard) {
            System.out.println(entry);
        }
    }
}
