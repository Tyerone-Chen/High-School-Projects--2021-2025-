import java.util.*;

/**
 * Controls the execution of the virus evolution simulation.
 */
public class SimulationEngine {

    private FitnessStrategy defaultFitnessStrategy;

    /**
     * Constructor that allows assignment of a default fitness strategy.
     * @param strategy the strategy used to evaluate virus fitness
     */
    public SimulationEngine(FitnessStrategy strategy) {
        this.defaultFitnessStrategy = strategy;
    }

    /**
     * Runs the full simulation from initial population through evolution.
     */
    public void runSimulation() {
        // TODO: retrieve generation 0 viruses from the database
        // TODO: assign fitness strategy, calculate fitness
        // TODO: apply reproduction logic and mutation
        // TODO: insert offspring into the database
        // TODO: repeat for multiple generations
    }

    /**
     * Applies an environmental challenge like a drug drop to the virus population.
     * @param population list of viruses to evaluate
     */
    public void applyDrugDrop(List<Virus> population) {
        // TODO: optionally penalize or eliminate viruses without resistance
    }

    /**
     * Summarizes simulation outcomes and updates leaderboard.
     */
    public void summarizeResults() {
        // TODO: update the leaderboard using stats from the database
    }
}
