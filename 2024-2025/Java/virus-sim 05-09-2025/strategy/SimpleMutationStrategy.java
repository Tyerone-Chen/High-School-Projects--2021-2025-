package strategy;

import core.GenomeUtils;
import java.util.*;

/**
 * A simple mutation strategy that randomly mutates individual bases
 * in the genome according to a specified mutation rate.
 * This strategy introduces point mutations to each base independently,
 * resulting in a potentially high degree of genetic variation.
 */
public class SimpleMutationStrategy implements MutationStrategy {
    
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
    @Override
    public List<String> mutate(List<String> genomeSegments, double mutationRate) {
        List<String> mutatedSegments = new ArrayList<>();

        for (String segment : genomeSegments) {
            mutatedSegments.add(mutateSegment(segment, mutationRate));
        }

        return mutatedSegments;
    }

    /**
     * Mutates a single genome segment by independently changing each base
     * with a probability equal to the specified mutation rate.
     *
     * Preconditions:
     * - The segment should not be null.
     * - The mutation rate should be between 0.0 and 1.0.
     * - The segment should contain only valid bases (A, U, G, C).
     *
     * Postconditions:
     * - Returns a string of the same length as the input segment, potentially containing one or more mutated bases.
     *
     * @param segment the original nucleotide string
     * @param mutationRate chance of mutation per base (0.0 to 1.0)
     * @return mutated segment string
     */
    private String mutateSegment(String segment, double mutationRate) {
        StringBuilder result = new StringBuilder();

        for (char nucleotide : segment.toCharArray()) {
            if (GenomeUtils.RANDOM.nextDouble() < mutationRate) {
                result.append(GenomeUtils.randomDifferentBase(nucleotide));
            } else {
                result.append(nucleotide);
            }
        }

        return result.toString();
    }
}
