package simmulation;

import java.util.*;
import builder.VirusBuilder;
import builder.RandomVirusBuilder;
import core.Virus;
import strategy.FitnessStrategy;
import strategy.GCContentFitness;
import strategy.MutationStrategy;
import strategy.SimpleMutationStrategy;

/**
 * Test runner for the in-memory virus simulation.
 * This class sets up a basic simulation environment, generates an initial
 * population of viruses, and runs the simulation to test the evolutionary logic.
 */
public class VirusSimRunner {

    public static void main(String[] args) {
        // Step 1: Set up simulation components
        FitnessStrategy fitnessStrategy = new GCContentFitness();
        MutationStrategy mutationStrategy = new SimpleMutationStrategy();
        
        VirusSimNoDataBase simulation = new VirusSimNoDataBase();

        // Step 2: Generate initial population (customizable size)
        List<Virus> initialPopulation = new ArrayList<>();
        VirusBuilder builder = new RandomVirusBuilder();

        for (int i = 0; i < 10; i++) {
            Virus virus = builder.buildInitialVirus();
            virus.setFitnessStrategy(fitnessStrategy);
            virus.setMutationStrategy(mutationStrategy);
            initialPopulation.add(virus);
        }

        // Step 3: Load and run the simulation
        simulation.loadInitialPopulation(initialPopulation);
        simulation.runSimulation();

        // Step 4: Done! Summary printed automatically
    }
}
