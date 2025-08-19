package core;

import java.util.Random;

/**
 * Utility class for working with nucleotide sequences in genome simulation projects.
 * Provides methods for generating random nucleotide bases and creating mutations.
 */
public class GenomeUtils {
    
    /**
     * Valid nucleotide bases used in RNA sequences.
     * In this context, U (Uracil) is used instead of T (Thymine) as we are simulating RNA.
     */
    public static final char[] BASES = {'A', 'C', 'G', 'U'};

    /**
     * Shared Random instance for generating random numbers.
     * Using a single Random instance ensures consistent behavior across methods.
     */
    public static final Random RANDOM = new Random();
   
    /**
     * Returns a random base that is different from the input base.
     * This method is used for introducing point mutations in RNA sequences.
     *
     * Preconditions:
     * - The input character must be a valid base (A, C, G, U).
     *
     * Postconditions:
     * - The returned base will be one of the four possible bases (A, C, G, U), but not the same as the input.
     *
     * @param original the base to mutate (must be one of 'A', 'C', 'G', 'U')
     * @return a different base from the input
     * @throws IllegalArgumentException if the input base is not valid
     */
    public static char randomDifferentBase(char original) {
        if ("ACGU".indexOf(original) == -1) {
            throw new IllegalArgumentException("Invalid base: " + original);
        }
        char newBase;
        do {
            newBase = BASES[RANDOM.nextInt(BASES.length)];
        } while (newBase == original);
        return newBase;
    }
    
    /**
     * Returns a random nucleotide base ('A', 'U', 'G', or 'C').
     * This method is useful for generating random RNA sequences.
     *
     * Postconditions:
     * - The returned character will be one of the four possible bases (A, C, G, U).
     *
     * @return a randomly selected base character
     */
    public static char randomNucleotide() {
        return BASES[RANDOM.nextInt(BASES.length)];
    }
}