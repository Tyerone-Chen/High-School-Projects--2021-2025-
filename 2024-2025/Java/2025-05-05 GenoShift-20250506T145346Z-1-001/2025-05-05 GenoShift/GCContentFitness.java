import java.util.List;

/**
 * A simple fitness strategy based on GC content.
 * The more G or C bases a virus has, the higher its fitness — up to a maximum of 1.0.
 * This simulates biological stability often associated with GC-rich genomes.
 */
public class GCContentFitness implements FitnessStrategy {

    /**
     * Evaluates the fitness of the virus by counting the number of
     * G and C bases in its genome. Each GC base contributes +0.01
     * to the fitness score, capped at 1.0.
     *
     * @param virus the virus object whose genome will be evaluated
     * @return a fitness score between 0.0 and 1.0
     */
    @Override
    public double evaluateFitness(Virus virus) {
        // Combine all genome segments into one long string
        List<String> segments = virus.getGenomeSegments();
        String genome = String.join("", segments);

        // Count how many characters are 'G' or 'C'
        int gcCount = 0;
        for (char base : genome.toCharArray()) {
            if (base == 'G' || base == 'C') {
                gcCount++;
            }
        }

        // Each GC base adds 0.01 to the score
        double fitness = gcCount * 0.01;

        // Cap the fitness at 1.0
        return Math.min(1.0, fitness);
    }
}
