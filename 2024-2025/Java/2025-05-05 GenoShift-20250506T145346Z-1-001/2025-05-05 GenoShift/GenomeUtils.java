import java.util.Random;

public class GenomeUtils {
    
    public static final char[] BASES = {'A', 'C', 'G', 'U'};

    public static final Random RANDOM = new Random();
   
    /**
     * Returns a random base that is different from the input.
     * @param original the base to mutate
     * @param rand Random object
     * @return a different base
     */
    public static char randomDifferentBase(char original) {
        char newBase;
        do {
            newBase = BASES[RANDOM.nextInt(BASES.length)];
        } while (newBase == original);
        return newBase;
    }
    
     /**
     * Returns a random nucleotide base ('A', 'U', 'G', or 'C').
     *
     * @return a randomly selected base character
     */
    public static char randomNucleotide() {
        return BASES[RANDOM.nextInt(BASES.length)];
    }
}
