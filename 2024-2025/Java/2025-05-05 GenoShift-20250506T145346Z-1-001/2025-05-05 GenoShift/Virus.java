import java.util.*;

/**
 * Represents a digital virus with genome data, mutation behavior, 
 * and fitness evaluation. This object evolves over time by mutating its genome 
 * and being scored for "fitness" in a simulated environment.
 */
public class Virus {
    
    // ======== Core Identity and State ========

    private String id; // Unique ID for this virus (auto-generated with each mutation)
    private String studentId; // ID of the student who originally designed this virus
    private String parentId; // ID of the virus who originally created this version
    private List<String> genomeSegments; // The digital "DNA" — multiple short strings that make up this virus
    private double mutationRate; // Probability that each base will mutate during reproduction
    private double fitness; // Score representing how "fit" or strong the virus is
    private int generation; // How many rounds (generations) this virus has survived

    // ======== Behavior Strategies ========

    private FitnessStrategy fitnessStrategy; // Determines how fitness is calculated
    private MutationStrategy mutationStrategy; // Determines how mutation is applied

    // ======== Constructors ========

    /**
     * Basic constructor to create a virus with default fitness value and no strategies assigned.
     * This is often used when loading viruses from a file or creating the original "seed" viruses.
     * 
     * @param id unique identifier
     * @param studentId ID of the student designer
     * @param genomeSegments list of genome segments (digital DNA)
     * @param mutationRate chance of mutation per base
     * @param generation current generation number (0 = original)
     */
    public Virus(String id, String studentId, String parentId, List<String> genomeSegments, double mutationRate, int generation) {
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
     * @param id unique identifier
     * @param studentId student who created the original virus
     * @param genomeSegments the digital genome (list of short strings)
     * @param mutationRate mutation probability
     * @param generation number of times this virus has evolved
     * @param mutationStrategy how it mutates
     * @param fitnessStrategy how it's scored
     */
    public Virus(String id, String studentId, String parentId, List<String> genomeSegments, double mutationRate, int generation,
                 MutationStrategy mutationStrategy, FitnessStrategy fitnessStrategy) {
        // Calls the first constructor to reduce duplication
        this(id, studentId, parentId, genomeSegments, mutationRate, generation);
        this.mutationStrategy = mutationStrategy;
        this.fitnessStrategy = fitnessStrategy;
    }

    // ======== Mutation and Evolution ========

    /**
     * Produces a new Virus by mutating the current genome using the assigned mutation strategy.
     * Creates a new ID, bumps generation, and returns a new Virus object.
     * 
     * @return a new Virus object that is one generation "descended" from this one
     */
    public Virus mutate() {
        // Use strategy to create a new genome from the current one
        List<String> mutatedGenome = mutationStrategy.mutate(genomeSegments, mutationRate);

        // Return a brand new Virus with updated generation and genome
        return new Virus(
            UUID.randomUUID().toString(),     // unique new ID
            this.studentId,                   // keep the same creator
            this.id,                           // The parentID is the this.Id
            mutatedGenome,                    // new, mutated genome
            this.mutationRate,                // inherit mutation rate
            this.generation + 1,              // evolve to next generation
            this.mutationStrategy,            // reuse current strategy
            this.fitnessStrategy              // reuse current strategy
        );
    }

    /**
     * Calculates the virus’s fitness using its assigned fitness strategy,
     * and stores the result internally.
     */
    public void calculateFitness() {
        if (fitnessStrategy != null) {
            this.fitness = fitnessStrategy.evaluateFitness(this);
        }
    }

    /**
     * Optional: checks if the virus contains a pattern that makes it "resistant" to treatment.
     * You can implement this later by scanning genome segments for key sequences.
     * 
     * @return true if the virus is resistant; false by default
     */
    public boolean isResistant() {
        // Placeholder for extra challenge — implement your own logic here
        return false;
    }

    // ======== Strategy Assignment Methods ========

    /**
     * Assigns a fitness strategy to this virus.
     * @param strategy an implementation of FitnessStrategy
     */
    public void setFitnessStrategy(FitnessStrategy strategy) {
        this.fitnessStrategy = strategy;
        this.calculateFitness();
    }

    /**
     * Assigns a mutation strategy to this virus.
     * @param strategy an implementation of MutationStrategy
     */
    public void setMutationStrategy(MutationStrategy strategy) {
        this.mutationStrategy = strategy;
    }

    // ======== Getters and Setters ========

    public String getId() {
        return id;
    }

    public String getStudentId() {
        return studentId;
    }
    
    public String getParentId() {
        return parentId;
    }

    public List<String> getGenomeSegments() {
        return genomeSegments;
    }

    public double getMutationRate() {
        return mutationRate;
    }

    public double getFitness() {
        return fitness;
    }

    public int getGeneration() {
        return generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

    public void setGenomeSegments(List<String> genomeSegments) {
        this.genomeSegments = genomeSegments;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
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
