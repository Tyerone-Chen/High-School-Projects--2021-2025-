package builder;

import core.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * A basic implementation of the VirusBuilder interface that generates
 * random, fully initialized Virus objects with default genome settings.
 * This builder creates viruses with a fixed number of genome segments
 * and a default mutation rate, suitable for testing or initial population seeding.
 */
public class RandomVirusBuilder implements VirusBuilder {

    // Configurable defaults (can be made dynamic later)
    private static final int DEFAULT_SEGMENTS = 7;
    private static final int SEGMENT_LENGTH = 10;
    private static final double DEFAULT_MUTATION_RATE = 0.5;
   
    /**
     * Builds an initial Virus with a randomized genome, default mutation rate,
     * and generation 0. This method uses the SerialNumberGenerator to assign
     * unique IDs to the virus and its student creator.
     *
     * Preconditions:
     * - The genome segments will be randomly generated and should contain only valid bases (A, U, G, C).
     * - The mutation rate is fixed at 0.5 but can be adjusted for custom builders.
     *
     * Postconditions:
     * - Returns a fully initialized Virus object with a randomized genome.
     * - The virus is assigned a unique ID and is considered a generation 0 ancestor.
     *
     * @return an initialized Virus object with generation 0 and a randomized genome
     */
    @Override
    public Virus buildInitialVirus() {
        List<String> genome = new ArrayList<>();

        for (int i = 0; i < DEFAULT_SEGMENTS; i++) {
            StringBuilder segment = new StringBuilder();
            for (int j = 0; j < SEGMENT_LENGTH; j++) {
                segment.append(GenomeUtils.randomNucleotide());
            }
            genome.add(segment.toString());
        }

        Virus virus = new Virus(
            SerialNumberGenerator.getNextID(),  // unique virus ID
            SerialNumberGenerator.getNextID(), // unique student ID (fallback)
            0,                                // no parent, generation 0
            genome,                           // randomized genome
            DEFAULT_MUTATION_RATE,            // default mutation rate
            0                                 // generation 0
        );

        return virus;
    }
}
