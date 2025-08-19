import java.util.*;

/**
 * A simple mutation strategy that randomly mutates individual bases
 * in the genome according to a specified mutation rate.
 */
public class SimpleMutationStrategy implements MutationStrategy {

    

    /**
     * Applies mutation logic to the given genome.
     * @param genomeSegments list of original genome strings
     * @param mutationRate chance of mutation per base
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
     * Mutates a single genome segment.
     * @param segment the original nucleotide string
     * @param mutationRate chance of mutation per base
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
