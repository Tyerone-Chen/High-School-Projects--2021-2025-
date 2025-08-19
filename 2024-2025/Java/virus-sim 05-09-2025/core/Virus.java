package core;

import java.util.*;
import strategy.FitnessStrategy;
import strategy.MutationStrategy;

/**
 * Represents a digital virus with genome data, mutation behavior, 
 * and fitness evaluation. This object evolves over time by mutating its genome 
 * and being scored for "fitness" in a simulated environment.
 */
public class Virus {
    
    // ======== Core Identity and State ========

    /** Unique ID for this virus (auto-generated with each mutation). */
    private long id;
    /** ID of the student who originally designed this virus. */
    private long studentId;
    /** ID of the virus that originally created this version. */
    private long parentId;
    /** The digital "DNA" — multiple short strings that make up this virus. */
    private List<String> genomeSegments;
    /** Probability that each base will mutate during reproduction. */
    private double mutationRate;
    /** Score representing how "fit" or strong the virus is. */
    private double fitness;
    /** How many rounds (generations) this virus has survived. */
    private int generation;

    // ======== Behavior Strategies ========

    /** Determines how fitness is calculated. */
    private FitnessStrategy fitnessStrategy;
    /** Determines how mutation is applied. */
    private MutationStrategy mutationStrategy;

    // ======== Constructors ========

    /**
     * Basic constructor to create a virus with default fitness value and no strategies assigned.
     * This is often used when loading viruses from a file or creating the original "seed" viruses.
     * 
     * Preconditions:
     * - Genome segments list should not be null.
     * - Mutation rate should be between 0.0 and 1.0.
     *
     * Postconditions:
     * - A Virus object is created with the specified attributes.
     * - The fitness score is initialized to 0.0.
     *
     * @param id unique identifier
     * @param studentId ID of the student designer
     * @param parentId ID of the parent virus (or 0 if original)
     * @param genomeSegments list of genome segments (digital DNA)
     * @param mutationRate chance of mutation per base (0.0 to 1.0)
     * @param generation current generation number (0 = original)
     */
    public Virus(long id, long studentId, long parentId, List<String> genomeSegments, double mutationRate, int generation) {
        this.id = id;
        this.studentId = studentId;
        this.parentId = parentId;
        this.genomeSegments = genomeSegments;
        this.mutationRate = mutationRate;
        this.generation = generation;
        this.fitness = 0.0; // default, will be updated later
    }

    /**
     * Full constructor that also assigns mutation and fitness behavior.
     * Use this when you want the virus to be ready for simulation immediately.
     * 
     * Preconditions:
     * - Genome segments list should not be null.
     * - Mutation rate should be between 0.0 and 1.0.
     * - Mutation and fitness strategies should not be null.
     *
     * Postconditions:
     * - A Virus object is created with the specified attributes and assigned strategies.
     *
     * @param id unique identifier
     * @param studentId student who created the original virus
     * @param parentId ID of the parent virus (or 0 if original)
     * @param genomeSegments the digital genome (list of short strings)
     * @param mutationRate mutation probability (0.0 to 1.0)
     * @param generation number of times this virus has evolved
     * @param mutationStrategy how it mutates
     * @param fitnessStrategy how it's scored
     */
    public Virus(long id, long studentId, long parentId, List<String> genomeSegments, double mutationRate, int generation,
                 MutationStrategy mutationStrategy, FitnessStrategy fitnessStrategy) {
        this(id, studentId, parentId, genomeSegments, mutationRate, generation);
        this.mutationStrategy = mutationStrategy;
        this.fitnessStrategy = fitnessStrategy;
    }

    // ======== Mutation and Evolution ========

    /**
     * Produces a new Virus by mutating the current genome using the assigned mutation strategy.
     * Creates a new ID, bumps generation, and returns a new Virus object.
     * 
     * Preconditions:
     * - A mutation strategy must be assigned.
     * - The genome must contain at least one segment.
     *
     * Postconditions:
     * - Returns a new Virus object with a unique ID, incremented generation, and potentially mutated genome.
     *
     * @return a new Virus object that is one generation "descended" from this one
     */
    public Virus mutate() {
        List<String> mutatedGenome = mutationStrategy.mutate(genomeSegments, mutationRate);
        Virus offspring = new Virus(
            SerialNumberGenerator.getNextID(),     // unique new ID
            this.studentId,                   // keep the same creator
            this.id,                           // The parentID is the this.Id
            mutatedGenome,                    // new, mutated genome
            this.mutationRate,                // inherit mutation rate
            this.generation + 1,              // evolve to next generation
            this.mutationStrategy,            // reuse current strategy
            this.fitnessStrategy              // reuse current strategy
        );
        offspring.calculateFitness();
        return offspring;
    }

    /**
     * Returns the genome segments that make up this virus.
     *
     * @return a list of genome segments
     */
    public List<String> getGenomeSegments() {
        return genomeSegments;
    }

    /**
     * Returns the current fitness score of this virus.
     *
     * @return the current fitness score
     */
    public double getFitness() {
        return fitness;
    }

    /**
     * Checks if the virus is resistant to an environmental challenge.
     *
     * @return true if the virus is resistant, false otherwise
     */
    public boolean isResistant() {
        // Placeholder logic; implement custom resistance checks here
        return fitness > 0.8;
    }

    /**
     * Calculates the virus’s fitness using its assigned fitness strategy,
     * and stores the result internally.
     *
     * Preconditions:
     * - A fitness strategy must be assigned.
     *
     * Postconditions:
     * - The internal fitness score is updated.
     */
    public void calculateFitness() {
        if (fitnessStrategy != null) {
            this.fitness = fitnessStrategy.evaluateFitness(this);
        }
    }

    // ======== Strategy Assignment Methods ========

    /**
     * Assigns a fitness strategy to this virus and recalculates its fitness.
     *
     * @param strategy an implementation of FitnessStrategy
     */
    public void setFitnessStrategy(FitnessStrategy strategy) {
        this.fitnessStrategy = strategy;
        this.calculateFitness();
    }

    /**
     * Assigns a mutation strategy to this virus.
     *
     * @param strategy an implementation of MutationStrategy
     */
    public void setMutationStrategy(MutationStrategy strategy) {
        this.mutationStrategy = strategy;
    }

    @Override
    public String toString() {
        return "Virus{" +
               "id='" + id + '\'' +
               ", studentId='" + studentId + '\'' +
               ", generation=" + generation +
               ", fitness=" + String.format("%.3f", fitness) +
               ", genome=" + String.join("|", genomeSegments) +
               '}';
    }
}
