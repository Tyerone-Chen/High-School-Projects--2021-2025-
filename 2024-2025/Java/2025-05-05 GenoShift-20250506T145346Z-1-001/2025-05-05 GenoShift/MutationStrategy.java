import java.util.*;

// ================================
// MutationStrategy.java
// ================================
/**
 * Defines mutation behavior for a virus.
 */
public interface MutationStrategy {
    /**
     * Applies mutation logic to the given genome.
     * @param genomeSegments list of original genome strings
     * @param mutationRate chance of mutation per base
     * @return mutated genome segments
     */
    List<String> mutate(List<String> genomeSegments, double mutationRate);
}