package simmulation;

import core.Virus;
import java.util.*;

/**
 * VirusSimNoDataBase
 *
 * A simplified in-memory virus evolution simulation.
 * Stores all viruses in a single list and simulates forward evolution
 * without preserving generation boundaries.
 * This simulation is suitable for smaller-scale tests without database integration.
 */
public class VirusSimNoDataBase {

    /** Stores all viruses, including offspring. */
    private List<Virus> allViruses;
    /** Maximum number of generations to simulate. */
    private int maxGenerations = 18;

    /**
     * Constructs the simulation with a default empty population.
     */
    public VirusSimNoDataBase() {
        this.allViruses = new ArrayList<>();
    }

    /**
     * Adds the seed viruses to the simulation (generation 0).
     *
     * Preconditions:
     * - The initial population must not be null.
     *
     * Postconditions:
     * - The initial population is added to the simulation.
     *
     * @param initialPopulation the starting viruses
     */
    public void loadInitialPopulation(List<Virus> initialPopulation) {
        allViruses.addAll(initialPopulation);
    }

    /**
     * Runs the simulation across multiple generations.
     *
     * Preconditions:
     * - The initial population should contain at least one virus.
     *
     * Postconditions:
     * - The simulation runs for the configured number of generations.
     * - New viruses are added to the population based on mutation.
     */
    public void runSimulation() {
        for (int gen = 0; gen < maxGenerations; gen++) {
            List<Virus> newOffspring = new ArrayList<>();

            for (Virus virus : allViruses) {
                virus.calculateFitness();
                if (virus.getFitness() >= 0.2) {
                    Virus child = virus.mutate();
                    newOffspring.add(child);
                }
            }

            //applyDrugDrop(newOffspring); // Uncomment to simulate environmental events
            allViruses.addAll(newOffspring);
        }

        summarizeResults();
    }

    /**
     * Applies an environmental event such as a drug drop.
     * Viruses that are not resistant are culled from the population.
     *
     * Preconditions:
     * - The virus list should not be null.
     *
     * Postconditions:
     * - Non-resistant viruses are removed from the input list.
     *
     * @param viruses newly generated viruses to test
     */
    public void applyDrugDrop(List<Virus> viruses) {
        viruses.removeIf(v -> !v.isResistant());
    }

    /**
     * Summarizes key simulation outcomes, including total virus count
     * and the top 200 fittest viruses.
     *
     * Postconditions:
     * - Prints a summary of the simulation results to the console.
     */
    public void summarizeResults() {
        System.out.println("\n=== Simulation Summary ===");
        System.out.println("Total viruses generated: " + allViruses.size());

        allViruses.stream()
            .sorted(Comparator.comparingDouble(Virus::getFitness).reversed())
            .limit(10)
            .forEach(v -> System.out.println("Top Virus: " + v));
    }
}
