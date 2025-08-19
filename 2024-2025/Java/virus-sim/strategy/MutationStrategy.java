package strategy;

import java.util.*;

// ================================
// MutationStrategy.java
// ================================
/**
 * Defines mutation behavior for a virus in a digital genome simulation.
 * Implementing classes should define how genome segments are mutated
 * based on a given mutation rate.
 */
public interface MutationStrategy {
    /**
     * Applies mutation logic to the given genome.
     *
     * Preconditions:
     * - The genome segments list should not be null.
     * - The mutation rate should be between 0.0 and 1.0.
     * - Each genome segment should contain only valid bases (A, U, G, C).
     *
     * Postconditions:
     * - Returns a list of genome segments with potential mutations based on the specified rate.
     * - The length and structure of the genome segments should remain unchanged.
     *
     * @param genomeSegments list of original genome strings
     * @param mutationRate chance of mutation per base (0.0 to 1.0)
     * @return mutated genome segments
     */
    List<String> mutate(List<String> genomeSegments, double mutationRate);
}